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
                    <h1> Add more product</h1>
                    <form action="/product?action=add" method="post">
                        <div class="mb-3">
                            <label class="form-label">Name product</label>
                            <input type="text" name="name" class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Quantity</label>
                            <input type="number" name="quantity" class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Expiration Date</label>
                            <input type="date" name="expirationDate" class="form-control" required>
                        </div>

                        <button type="submit" class="btn btn-primary">Save</button>
                        <a href="/product" class="btn btn-secondary">Back</a>
                    </form>
                </div>
            </div>
        </div>
    </main>
    <footer class="bg-light text-center py-3">
        @ - Website for product
    </footer>
</body>
</html>
