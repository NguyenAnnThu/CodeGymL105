<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</head>
<body class="min-vh-100 d-flex flex-column">
    <div class="container-fluid px-0">
        <c:import url="/layout/navbar.jsp"/>
    </div>
    <main class="flex-fill container mt-3">
        <div class="row">
            <div class="col-lg-4 mt-3">
                <c:import url="/layout/mainleft.jsp"/>
            </div>
            <div class="col-lg-8">
                <div class="row">
                    <div class="col-md-10 ">
                        <h1> List of products in stock</h1>
                    </div>
                    <div class="col-md-2">
                        <a href="/product?action=add">
                            <i class="fa-solid fa-plus" ></i><span style="color:black">Add Product</span>
                        </a>
                    </div>
                </div>
                <div class="row">
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Name Product</th>
                            <th scope="col">Quantity</th>
                            <th scope="col">Expiration Date</th>
                            <th scope="col"></th>
                            <th scope="col"></th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach var="p" items="${productList}">
                            <tr>
                                <th scope="row">${p.id}</th>
                                <td>${p.name}</td>
                                <td>${p.quantity}</td>
                                <td>${p.expirationDate}</td>
                                <td>
                                    <a href="/product?action=edit&id=${p.id}">
                                        <i class="fa-solid fa-pen-to-square"></i>
                                    </a>
                                </td>
                                <td>
                                    <a href="/product?action=delete&id=${p.id}"
                                       onclick="return confirm('Are you sure you want to delete this product?')">
                                        <i class="fa-solid fa-trash"></i>
                                    </a>

                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </main>
    <footer class="bg-light text-center py-3">
        @ - Website for product
    </footer>

</body>
</html>
