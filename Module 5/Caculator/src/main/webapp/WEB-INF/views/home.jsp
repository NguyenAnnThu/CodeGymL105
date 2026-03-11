<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
  <title>Simple Calculator</title>

  <!-- Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

  <style>
    body{
      background: linear-gradient(135deg,#4facfe,#00f2fe);
      height:100vh;
      display:flex;
      align-items:center;
      justify-content:center;
    }

    .card{
      border-radius:20px;
      border:none;
    }

    .card-header{
      border-radius:20px 20px 0 0 !important;
      background:linear-gradient(90deg,#667eea,#764ba2);
    }

    .btn-calc{
      background:linear-gradient(90deg,#11998e,#38ef7d);
      border:none;
      font-weight:bold;
    }

    .btn-calc:hover{
      opacity:0.9;
      transform:scale(1.02);
    }
  </style>
</head>

<body>

<div class="container">

  <div class="row justify-content-center">

    <div class="col-md-5">

      <div class="card shadow-lg">

        <div class="card-header text-white text-center">
          <h3>🧮 Simple Calculator</h3>
        </div>

        <div class="card-body p-4">

          <form action="/calculator" method="post">

            <div class="mb-3">
              <label class="form-label">First Number</label>
              <input type="number" step="any" name="num1" class="form-control form-control-lg" required>
            </div>

            <div class="mb-3">
              <label class="form-label">Second Number</label>
              <input type="number" step="any" name="num2" class="form-control form-control-lg" required>
            </div>

            <div class="mb-3">
              <label class="form-label">Operator</label>
              <select name="operator" class="form-select form-select-lg">
                <option value="add">Addition (+)</option>
                <option value="sub">Subtraction (-)</option>
                <option value="mul">Multiplication (*)</option>
                <option value="div">Division (/)</option>
              </select>
            </div>

            <div class="d-grid">
              <button class="btn btn-calc btn-lg text-white">
                Calculate
              </button>
            </div>

          </form>

          <hr>

          <c:if test="${error != null}">
            <div class="alert alert-danger text-center">
                ${error}
            </div>
          </c:if>

          <c:if test="${result != null}">
            <div class="alert alert-success text-center">
              <h4>Result: ${result}</h4>
            </div>
          </c:if>

        </div>

      </div>

    </div>

  </div>

</div>

</body>
</html>