# Module 2 – Java Basic & MVC – Case Study

## Mô tả module
Module 2 tại CodeGym tập trung vào **Java cơ bản** và **Mô hình MVC (Model – View – Controller)**.  
Học viên sẽ được thực hành qua các bài tập và case study, học cách:  

- Sử dụng **Java cơ bản**: biến, kiểu dữ liệu, vòng lặp, điều kiện.  
- Áp dụng **OOP**: class, object, kế thừa, interface.  
- Xử lý **Exception**: try-catch, custom exception.  
- Làm việc với **file IO**: đọc/ghi dữ liệu sản phẩm.  
- Thiết kế hệ thống theo **MVC chuẩn**.

---
## Nội dung học
- **Java Basic**: biến, mảng, vòng lặp, điều kiện, phương thức.  
- **OOP & MVC**:  
  - Model: mô tả dữ liệu (Product, Category).  
  - Repository: xử lý nghiệp vụ, kiểm tra trùng lặp, validate, đọc/ghi file.  
  - Service: trả về true/false để Controller xử lý tiếp.  
  - Controller: điều hướng giao diện console, nhận input và gọi Service.  
- **Exception Handling**: xử lý lỗi trong quá trình nhập dữ liệu, ghi file.  
- **File IO**: đọc/ghi dữ liệu sản phẩm, quản lý file expired.

---

## Kiến trúc thư mục
-------------------------------------------------------------------------------
── CaseStudy/                                                                
      ├── common/      → CheckInput, hàm đọc/ghi file, tiện ích dùng chung    
      ├── entity/      → Product, Category                                    
      ├── repository/  → Xử lý nghiệp vụ, validate, file IO                   
      ├── service/     → Trung gian, trả về boolean kết quả                   
      └── controller/  → SellerController, BuyerController                    
-------------------------------------------------------------------------------

---

## Bài tập & Case Study nổi bật
- 🛍️ **Product Management System**: quản lý sản phẩm bán lẻ theo MVC.  
  - Chức năng **Seller**: Xem, thêm, cập nhật, tìm kiếm, xử lý sản phẩm hết hạn.  
  - Chức năng **Customer**: Tìm kiếm, xem chi tiết, mua hàng.  
- Các bài tập nhỏ: validate input, custom exception, đọc/ghi file, thao tác mảng/object.

---

## Kết quả sau module
- Nắm vững **Java cơ bản và OOP**.  
- Hiểu và thực hành **MVC** trong dự án thực tế.  
- Xử lý **Exception & File IO** hiệu quả.  
- Chuẩn bị cho các module Full-stack nâng cao.

---

