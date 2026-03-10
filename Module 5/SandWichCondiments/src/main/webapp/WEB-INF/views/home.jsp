<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/10/2026
  Time: 1:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Sandwich Shop</title>

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>

<!-- Navbar -->
<nav class="navbar navbar-dark bg-dark">
  <div class="container-fluid">
    <span class="navbar-brand mb-0 h1">🥪 Sandwich Shop</span>
  </div>
</nav>

<div class="container mt-4">

  <h3 class="text-center mb-4">Choose your Sandwich</h3>

  <div class="row">

    <div class="col-md-4">
      <div class="card shadow">
        <img src="${pageContext.request.contextPath}/image/pic2.jpg" class="card-img-top">
        <div class="card-body text-center">
          <h5 class="card-title">Classic Sandwich</h5>

          <a href="${pageContext.request.contextPath}/sandwich/detail?name=Classic Sandwich&img=pic2.jpg"
             class="btn btn-primary">
            Choose Condiments
          </a>

        </div>
      </div>
    </div>

    <div class="col-md-4">
      <div class="card shadow">
        <img src="${pageContext.request.contextPath}/image/pic3.jpg" class="card-img-top">
        <div class="card-body text-center">
          <h5 class="card-title">Chicken Sandwich</h5>

          <a href="${pageContext.request.contextPath}/sandwich/detail?name=Chicken Sandwich&img=pic3.jpg"
             class="btn btn-primary">
            Choose Condiments
          </a>

        </div>
      </div>
    </div>

    <div class="col-md-4">
      <div class="card shadow">
        <img src="${pageContext.request.contextPath}/image/pic1.jpg" class="card-img-top">
        <div class="card-body text-center">
          <h5 class="card-title">Beef Sandwich</h5>

          <a href="${pageContext.request.contextPath}/sandwich/detail?name=Beef Sandwich&img=pic1.jpg"
             class="btn btn-primary">
            Choose Condiments
          </a>

        </div>
      </div>
    </div>

  </div>
</div>




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>


</body>
</html>
