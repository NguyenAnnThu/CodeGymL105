<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Website hoat hinh moi</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }
        .col-md-4{
            margin-top: 10%;
        }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body class="min-vh-100 d-flex flex-column">

<!-- Navbar -->
<div class="container-fluid px-0">
    <c:import url="./layout/navbar.jsp"/>
</div>

<!-- Nội dung chính -->
<main class="flex-fill container mt-3">
    <div class="row">
        <div class="col-md-4 ">
            <div class="row mb-3">
                <div class="card pt-3" style="width: 18rem;">
                    <img src="./layout/pic1.jpg" class="card-img-top" alt="...">
                    <div class="card-body">
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card’s content.</p>
                    </div>
                </div>
            </div>
            <div class="row mb-3">
                <div class="card pt-3" style="width: 18rem;">
                    <img src="./layout/pic2.jpg" class="card-img-top" alt="...">
                    <div class="card-body">
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card’s content.</p>
                    </div>
                </div>
            </div>
            <div class="row mb-3">
                <div class="card pt-3" style="width: 18rem;">
                    <img src="./layout/pic3.jpg" class="card-img-top" alt="...">
                    <div class="card-body">
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card’s content.</p>
                    </div>
                </div>
            </div>
            <div class="row mb-3">
                <div class="card pt-3" style="width: 18rem;">
                    <img src="./layout/pic4.jpg" class="card-img-top" alt="...">
                    <div class="card-body">
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card’s content.</p>
                    </div>
                </div>
            </div>
            <div class="row mb-3">
                <div class="card pt-3" style="width: 18rem;">
                    <img src="./layout/pic5.jpg" class="card-img-top" alt="...">
                    <div class="card-body">
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card’s content.</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-8">
            <div class="row">
                <iframe
                        width="100%"
                        height="400"
                        src="https://www.youtube.com/embed/JzeBrDhaE20"
                        frameborder="0"
                        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                        allowfullscreen>
                </iframe>
                <p class="nd pt-3">Bộ phim hoạt hình này mang đến cho người xem một câu chuyện hấp dẫn xoay quanh những nhân vật quen thuộc với tính cách sinh động và gần gũi. Nội dung phim được xây dựng xoay quanh cuộc sống hằng ngày cùng những chuyến phiêu lưu thú vị, nơi các nhân vật phải đối mặt với nhiều tình huống bất ngờ và thử thách khác nhau. Thông qua mỗi tập phim, người xem không chỉ được giải trí bằng những tình tiết hài hước, vui nhộn mà còn cảm nhận được các giá trị nhân văn sâu sắc về tình bạn, tình cảm gia đình và tinh thần đoàn kết.

                    Bên cạnh nội dung ý nghĩa, bộ phim còn gây ấn tượng mạnh mẽ nhờ phần hình ảnh được thiết kế tươi sáng, màu sắc hài hòa và chuyển động mượt mà, phù hợp với nhiều lứa tuổi, đặc biệt là trẻ em. Âm thanh sống động kết hợp cùng phần lồng tiếng tự nhiên giúp các nhân vật trở nên chân thật và dễ dàng ghi dấu ấn trong lòng khán giả. Mỗi chi tiết nhỏ trong phim đều được chăm chút kỹ lưỡng, góp phần tạo nên một tổng thể hài hòa và cuốn hút.

                    Không chỉ dừng lại ở việc mang tính giải trí đơn thuần, bộ phim còn truyền tải những thông điệp tích cực về cách đối nhân xử thế trong cuộc sống, khuyến khích người xem biết quan tâm, chia sẻ và giúp đỡ người khác. Chính sự kết hợp hài hòa giữa nội dung sâu sắc, hình ảnh đẹp mắt và thông điệp ý nghĩa đã giúp bộ phim trở thành lựa chọn lý tưởng cho những phút giây thư giãn bên gia đình và bạn bè.</p>
            </div>

        </div>

        <div class="row"></div>
        </div>
    </div>
</main>

<!-- Footer -->
<footer class="bg-light text-center py-3">
    © 2026 - Website hoạt hình
</footer>

</body>
</html>
