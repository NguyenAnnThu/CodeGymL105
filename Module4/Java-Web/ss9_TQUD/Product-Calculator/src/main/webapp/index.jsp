<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Product Discount Calculator</title>
    <style>
        *{
            margin:10px;
            line-height-step: 15px;
        }
        .container{
            display: flex;
            justify-content: center;
        }
        .result{
            text-align: center;
            margin-top: 10%;
        }
        table{
            padding: 10px;
        }
        button{
            background-color: bisque;
        }
        button:hover{
            background-color: red;
        }
    </style>
</head>
<body>
    <div class="container">
        <form  action="/discount" method="post">
            <table style="border: 1px solid black">
                <th colspan="2">Discount Product </th>
                <tr>
                    <td>Product Description:</td>
                    <td><input name="name"/></td>
                </tr>
                <tr>
                    <td>List Price: </td>
                    <td><input name="price"/></td>
                </tr>
                <tr>
                    <td>Discount Percent: </td>
                    <td><input name="sale"/></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center">
                        <button>Start</button>
                    </td>
                </tr>
            </table>
        </form>
        <div class="result">
            <div>Discout Amount: ${disA}</div>
            <div>Discount Price: ${kq}</div>
        </div>
    </div>
</body>
</html>