<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Mail Configuration</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>

        body{
            background: linear-gradient(135deg,#5f9cff,#a7c7ff);
            font-family: Arial, Helvetica, sans-serif;
        }

        .config-container{
            width:650px;
            margin:60px auto;
            background:white;
            padding:35px;
            border-radius:10px;
            box-shadow:0 6px 20px rgba(0,0,0,0.2);
        }

        .config-title{
            text-align:center;
            font-weight:bold;
            margin-bottom:30px;
            color:#2c3e50;
        }

        .form-label{
            font-weight:600;
        }

        .btn-update{
            background:#4CAF50;
            color:white;
        }

        .btn-update:hover{
            background:#43a047;
        }

    </style>

</head>

<body>

<div class="config-container">

    <h2 class="config-title">Mail Configuration Settings</h2>

    <form:form action="${pageContext.request.contextPath}/settings"
               method="post"
               modelAttribute="settings">

        <!-- Language -->
        <div class="mb-4">
            <label class="form-label">Language</label>

            <form:select path="language" cssClass="form-select">
                <form:options items="${languages}"/>
            </form:select>

        </div>


        <!-- Page Size -->
        <div class="mb-4">

            <label class="form-label">Page Size</label>

            <div class="input-group">

                <span class="input-group-text">Show</span>

                <form:select path="pageSize" cssClass="form-select">
                    <form:options items="${pageSizes}"/>
                </form:select>

                <span class="input-group-text">emails per page</span>

            </div>

        </div>


        <!-- Spam Filter -->
        <div class="mb-4">

            <div class="form-check">

                <form:checkbox path="spamFilter" cssClass="form-check-input"/>

                <label class="form-check-label">
                    Enable Spam Filter
                </label>

            </div>

        </div>


        <!-- Signature -->
        <div class="mb-4">

            <label class="form-label">Signature</label>

            <form:textarea path="signature"
                           rows="4"
                           cssClass="form-control"/>

        </div>


        <!-- Buttons -->
        <div class="text-center">

            <button type="submit" class="btn btn-update px-4">
                Update Settings
            </button>

            <button type="reset" class="btn btn-outline-secondary px-4 ms-2">
                Cancel
            </button>

        </div>

    </form:form>
    <c:if test="${not empty message}">
        <div class="alert alert-success alert-dismissible fade show">
                ${message}
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        </div>
    </c:if>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>