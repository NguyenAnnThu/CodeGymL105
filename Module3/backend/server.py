import os
from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware
from pydantic import BaseModel

from dotenv import load_dotenv
load_dotenv()  # Load .env

# --------- OPENAI ----------
from openai import OpenAI
client = OpenAI(api_key=os.getenv("OPENAI_API_KEY"))

# --------- LANGCHAIN / VECTOR DB ---------
from langchain_text_splitters import RecursiveCharacterTextSplitter
from langchain_community.vectorstores import FAISS
from langchain_huggingface.embeddings import HuggingFaceEmbeddings
from langchain_community.document_loaders import TextLoader

# Load rulebook
loader = TextLoader("CSKH_RULES.md", encoding="utf-8")
docs = loader.load()

splitter = RecursiveCharacterTextSplitter(chunk_size=600, chunk_overlap=50)
chunks = splitter.split_documents(docs)

emb = HuggingFaceEmbeddings(model_name="sentence-transformers/all-MiniLM-L6-v2")
vectordb = FAISS.from_documents(chunks, emb)

# =====================================
# SENTIMENT MODULE
# =====================================
def predict_sentiment(text):
    t = text.lower()
    negative = ["chậm", "tệ", "không hài lòng", "không ngon", "bực", "thất vọng",
                "quá lửa", "nguội", "mặn", "dở", "khó chịu"]
    positive = ["tốt", "ngon", "hài lòng", "tuyệt", "thích", "vui",
                "tuyệt vời", "chu đáo", "ấm cúng", "chuyên nghiệp"]

    neg = sum(k in t for k in negative)
    pos = sum(k in t for k in positive)

    if neg > pos and neg > 0: return "Negative"
    if pos > neg and pos > 0: return "Positive"
    return "Neutral"


# =====================================
# INTENT MODULE
# =====================================
def predict_intent(text):
    t = text.lower()

    if any(k in t for k in ["ngon", "dở", "khó ăn", "hôi", "cháy", "mặn", "nhạt"]):
        return "FOOD#QUALITY"

    if any(k in t for k in ["nhân viên", "phục vụ", "thái độ", "quên order", "chậm"]):
        return "SERVICE#GENERAL"

    if any(k in t for k in ["đắt", "giá", "combo", "ưu đãi"]):
        return "RESTAURANT#PRICES"

    if any(k in t for k in ["đông", "vắng", "không gian", "ấm cúng", "sạch"]):
        return "RESTAURANT#GENERAL"

    if any(k in t for k in ["cà phê", "trà", "cocktail", "nước"]):
        if "giá" in t:
            return "DRINKS#PRICES"
        return "DRINKS#STYLE&OPTIONS"

    if any(k in t for k in ["giờ mở cửa", "menu", "đặt bàn", "thông tin"]):
        return "INFORMATION"

    return "OTHER"


# =====================================
# GPT REPLY MODULE
# =====================================
def generate_reply(user_text):
    retrieved = vectordb.similarity_search(user_text, k=3)
    rule_text = "\n\n".join([d.page_content for d in retrieved])

    prompt = f"""
Bạn là nhân viên CSKH nhà hàng.
Dưới đây là các quy tắc bạn **phải tuân theo**:

{rule_text}

Khách hàng nói:
"{user_text}"

Nhiệm vụ:
- Trả lời lịch sự, tự nhiên, đúng tone CSKH.
- Không tạo thông tin sai.
- Không chế thêm thông tin ngoài tài liệu.
- Trả lời bằng tiếng Việt.
"""

    res = client.chat.completions.create(
        model="gpt-4o-mini",
        messages=[{"role": "user", "content": prompt}]
    )

    return res.choices[0].message.content


# =====================================
# FASTAPI SERVER
# =====================================
app = FastAPI()

# Cho phép frontend truy cập
app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_methods=["*"],
    allow_headers=["*"],
)


class ChatRequest(BaseModel):
    message: str


@app.post("/chat")
def chat_api(req: ChatRequest):
    user_text = req.message

    sentiment = predict_sentiment(user_text)
    intent = predict_intent(user_text)
    reply = generate_reply(user_text)

    return {
        "sentiment": sentiment,
        "intent": intent,
        "reply": reply
    }


@app.get("/")
def home():
    return {"message": "Chatbot CSKH is running!"}

