<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Product Management</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</head>
<body class="min-vh-100 d-flex flex-column">
    <div class="container-fluid px-0">
        <c:import url="./layout/navbar.jsp"/>
    </div>
    <main class="flex-fill container mt-3">
        <div class="row">
            <div class="col-md-4 mt-3">
                <c:import url="layout/mainleft.jsp"/>
            </div>
            <div class="col-md-6 mt-3">
                <div class="row mb-3">
                    <iframe
                            width="100%"
                            height="400"
                            src="https://www.youtube.com/embed/mE-i14-U-nw?list=PLmgDJqAXfR-8q2XFsBNNWjvX-qEd9V5yH"
                            frameborder="0"
                            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                            allowfullscreen>
                    </iframe>
                    <br>
                    <p class="showmore mt-3">🍬 THIÊN ĐƯỜNG BÁNH KẸO – NGỌT NGÀO TỪNG KHOẢNH KHẮC 🍪<br>

                        Bánh kẹo không chỉ đơn thuần là món ăn vặt, mà còn là hương vị của tuổi thơ, là niềm vui nhỏ bé trong những buổi sum họp gia đình, là món quà tinh tế trao gửi yêu thương. Tại [Tên cửa hàng / thương hiệu], chúng tôi mang đến thế giới bánh kẹo phong phú, đa dạng về chủng loại, màu sắc và hương vị, đáp ứng mọi sở thích từ trẻ em đến người lớn.

                        Từng chiếc bánh được lựa chọn kỹ lưỡng từ nguồn nguyên liệu chất lượng cao, đảm bảo độ tươi ngon, an toàn vệ sinh thực phẩm và giữ trọn hương vị đặc trưng. Từ những chiếc bánh quy giòn tan, bánh bông lan mềm mịn, bánh kem ngọt ngào cho đến các loại kẹo dẻo, kẹo cứng, kẹo chocolate tan chảy nơi đầu lưỡi – tất cả đều mang đến trải nghiệm vị giác khó quên.

                        Không chỉ chú trọng đến chất lượng, chúng tôi còn đầu tư vào mẫu mã bao bì bắt mắt, sang trọng, phù hợp làm quà biếu trong các dịp lễ, Tết, sinh nhật, hay đơn giản là một món quà nhỏ để thể hiện sự quan tâm. Mỗi sản phẩm đều là sự kết hợp hài hòa giữa hương vị truyền thống và phong cách hiện đại, giúp khách hàng vừa thưởng thức sự quen thuộc, vừa khám phá những điều mới mẻ.

                        Với phương châm “Ngon – An toàn – Giá hợp lý”, [Tên cửa hàng / thương hiệu] cam kết mang đến cho khách hàng những sản phẩm bánh kẹo chất lượng nhất cùng dịch vụ tận tâm, chu đáo. Hãy để những chiếc bánh, viên kẹo ngọt ngào của chúng tôi góp phần làm cho cuộc sống của bạn thêm vui tươi, trọn vẹn và đầy ắp tiếng cười.</p>
                </div>
                <div class="row text-align-end">
                    <a href="/product?action=showlist">Show list</a>
                </div>
            </div>
            <div class="col-md-2 mt-3">
                <a href="/product?action=add">
                    <i class="fa-solid fa-plus" ></i><span style="color:black">Add Product</span>
                </a>

            </div>
        </div>
    </main>
    <footer class="bg-light text-center py-3">
        @ - Website for product
    </footer>
</body>
</html>