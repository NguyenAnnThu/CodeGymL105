<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP-Ung dung Calculator</title>
</head>
<body>
    <h1> Simple Calculator</h1>
    <c:if test="${error!=null}">
        <p style="color: red">Xảy ra lỗi: ${error}</p>
    </c:if>
    <c:if test="${error ==null}">
        <p> Kết quả: ${ketqua}</p>
    </c:if>
    <a href="index.jsp">Quay lại</a>
</body>
</html>
