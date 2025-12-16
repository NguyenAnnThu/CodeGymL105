async function sendMessage() {
    const input = document.getElementById("user-input");
    const message = input.value.trim();
    if (!message) return;

    addMessage("user", message);
    input.value = "";

    // Gửi sang API FastAPI
    const response = await fetch("http://127.0.0.1:8000/chat", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ message })
    });

    const data = await response.json();

    let botText = `
        🏨 <b>Phản hồi:</b> ${data.reply}<br>
        ⭐ <b>Sentiment:</b> ${data.sentiment}<br>
        🎯 <b>Intent:</b> ${data.intent}
    `;

    addMessage("bot", botText);
}

function addMessage(sender, text) {
    const box = document.getElementById("chat-box");
    let div = document.createElement("div");

    div.className = "message " + sender;

    if (sender === "user") {
        // Icon người ở bên phải
        div.innerHTML = `
            <span class="text">${text}</span>
            <span class="avatar">👤</span>
        `;
    } else {
        // Tin nhắn bot bình thường
        div.innerHTML = text;
    }

    box.appendChild(div);
    box.scrollTop = box.scrollHeight;
}
