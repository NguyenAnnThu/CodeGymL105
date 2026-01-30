<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Danh sach khach hang</title>
    <style>
        table {
            border-collapse: collapse;
            width: 80%;
            margin: 5px 20px 5px 20px;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: center;
        }
        img {
            width: 80px;
            height: auto;
        }
        h1{
            text-align: center;
        }
    </style>
</head>
<body>

    <h1 >Danh sách khách hàng</h1>
    <table>
        <tr>
            <th>Tên</th>
            <th>Ngày sinh</th>
            <th>Địa chỉ</th>
            <th>Ảnh</th>
        </tr>
        <c:forEach items="${customers}" var="customer">
            <tr>
                <td>${customer.name}</td>
                <td>${customer.birthday}</td>
                <td>${customer.address}</td>
                <td>
                    <img src="${pageContext.request.contextPath}/${customer.image}" alt="ảnh khách hàng">

                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>