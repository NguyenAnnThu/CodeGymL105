<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/10/2026
  Time: 1:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Sandwich Detail</title>

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>

<!-- Navbar -->
<nav class="navbar navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/sandwich">
      🥪 Sandwich Shop
    </a>
  </div>
</nav>

<div class="container mt-4">

  <div class="card mx-auto shadow" style="width:400px">

    <img src="${pageContext.request.contextPath}/image/${image}"
         class="card-img-top">

    <div class="card-body">

      <h4 class="text-center">${sandwichName}</h4>

      <form action="${pageContext.request.contextPath}/sandwich/save" method="post">

        <input type="hidden" name="name" value="${sandwichName}">
        <input type="hidden" name="img" value="${image}">

        <h5>Choose Condiments</h5>

        <div>
          <input type="checkbox" name="condiment" value="Lettuce"> Lettuce
        </div>

        <div>
          <input type="checkbox" name="condiment" value="Tomato"> Tomato
        </div>

        <div>
          <input type="checkbox" name="condiment" value="Mustard"> Mustard
        </div>

        <div>
          <input type="checkbox" name="condiment" value="Sprouts"> Sprouts
        </div>

        <br>

        <button class="btn btn-success w-100">Save</button>

      </form>

      <c:if test="${condiments != null}">
        <hr>

        <h5>Selected Condiments</h5>

        <c:forEach items="${condiments}" var="c">
          <div>• ${c}</div>
        </c:forEach>

      </c:if>

    </div>
  </div>

</div>

</body>
</html>
