# 🛍️ Product Management System – Java MVC Case Study
Giải pháp quản lý sản phẩm hoàn chỉnh cho cửa hàng bán lẻ – xây dựng theo mô hình MVC
## 🧠 1. Giới thiệu ý tưởng dự án
 - Trong bối cảnh kinh doanh hiện đại, mỗi cửa hàng đều cần một hệ thống quản lý sản phẩm dễ dùng, chính xác và linh hoạt.
 - Dự án Product Management System được xây dựng nhằm mô phỏng nghiệp vụ thực tế của một cửa hàng bán lẻ, áp dụng mô hình MVC (Model – View – Controller) chuẩn chỉnh:
 - Model: Chỉ tập trung mô tả dữ liệu (Product, Category).
 - Repository: Xử lý toàn bộ nghiệp vụ, đọc/ghi file, kiểm tra trùng lặp, validate nghiệp vụ.
 - Service: Đóng vai trò trung gian, trả về true/false để Controller xử lý tiếp.
 - Controller: Nơi điều hướng giao diện console, nhận input và gọi service.
 - Hệ thống hỗ trợ hai đối tượng sử dụng:
    ### 👨‍💼 Người bán (Seller)
     - Quản lý kho hàng: xem – thêm – cập nhật – tìm kiếm – xử lý sản phẩm hết hạn.
    ### 🛒 Người mua (Customer)
     - Tìm kiếm sản phẩm – xem thông tin chi tiết – tiến hành mua hàng.

## 🏗️ 2. Kiến trúc hệ thống – MVC chuyên nghiệp
-------------------------------------------------------------------------------
── CaseStudy/                                                                
      ├── common/      → CheckInput, hàm đọc/ghi file, tiện ích dùng chung    
      ├── entity/      → Product, Category                                    
      ├── repository/  → Xử lý nghiệp vụ, validate, file IO                   
      ├── service/     → Trung gian, trả về boolean kết quả                   
      └── controller/  → SellerController, BuyerController                    
-------------------------------------------------------------------------------
## 📦 3. Danh sách thuộc tính sản phẩm
  - Mỗi sản phẩm gồm:
----------------------------------------------------------
| Thuộc tính     | Ý nghĩa                               |
| -------------- | ------------------------------------- |
| `id`           | Mã sản phẩm                           |
| `name`         | Tên sản phẩm (VD: Sữa Milo hộp 180ml) |
| `type`         | Loại: sữa, bánh, kẹo…                 |
| `manufacturer` | Nhà sản xuất                          |
| `quantity`     | Số lượng tồn kho                      |
| `importPrice`  | Giá nhập hàng                         |
| `sellPrice`    | Giá bán                               |
| `importDate`   | Ngày nhập                             |
| `expiredDate`  | Hạn sử dụng                           |
----------------------------------------------------------
## 👨‍💼 4. Chức năng của người bán (Seller)
- 1️⃣ Xem danh sách sản phẩm
  - Đọc toàn bộ từ product file
  - Hiển thị dạng bảng
  - Sử dụng repository để lấy dữ liệu
- 2️⃣ Thêm sản phẩm mới
  - Ghi vào file product
  - Kiểm tra ID có trùng hay không
  - Nếu tên sản phẩm trùng, in ra danh sách các sản phẩm cùng tên và hỏi:
       - "Có cùng nhà sản xuất không?"
       - Nếu YES → sản phẩm đã tồn tại → từ chối thêm
       - Nếu NO → tiếp tục thêm sản phẩm
- 3️⃣ Cập nhật sản phẩm
 Chỉ cho phép 2 lựa chọn:
   - Cập nhật số lượng
   - Cập nhật giá bán

- 4️⃣ Tìm kiếm sản phẩm
Theo 2 cách:
  - Tìm theo tên sản phẩm
  - Tìm theo loại sản phẩm
-> Tính năng này giúp người bán nhanh chóng xem hàng tồn kho.

- 5️⃣ Quản lý sản phẩm hết hạn
Khi seller chọn xem danh sách sản phẩm hết hạn → hệ thống:
 - 🔥 Tự động kiểm tra hạn sử dụng
   Nếu:
     HSD - Ngày hiện tại ≤ 7 ngày
   → Chuyển sản phẩm đó sang file expired
   → Tự động xóa khỏi file product
 - 🔥 Menu xử lý sản phẩm hết hạn
   - Khi xem danh sách sản phẩm hết hạn:
       Thoát → quay về menu chính
   - Xóa sản phẩm theo ID
       Hỏi xác nhận
       Nếu YES → xóa khỏi file expired
       Nếu NO → quay lại menu hết hạn
 ## 🛒 5. Chức năng người mua (Customer)
- 1️⃣ Tìm kiếm sản phẩm
 3 lựa chọn:
   Tìm theo tên
   Tìm theo loại
   Tìm theo khoảng giá (VD: 10k – 30k)

- 2️⃣ Xem chi tiết sản phẩm
 Nhập tên sản phẩm → hiển thị:
     - Tên
     - Giá bán
     - Loại sản phẩm
     - ID
     - Hạn sử dụng
- 3️⃣ Mua hàng
 Quy trình:
   Người mua nhập loại sản phẩm
   Hệ thống hiển thị danh sách sản phẩm cùng loại
   Người mua nhập ID muốn mua
   Repository tự động:
   Trừ số lượng trong file sản phẩm
   Nếu số lượng về 0 vẫn giữ sản phẩm (hoặc implement logic xoá tùy yêu cầu mở rộng)

