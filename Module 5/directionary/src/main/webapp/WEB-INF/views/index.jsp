<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/9/2026
  Time: 9:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            width:100%;
        }

        td{
            padding:10px;
            width:20%;
        }

        input{
            width:100%;
            padding:8px;
            border:1px solid #ccc;
            border-radius:5px;
        }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/directory/search" method="post">
   <table border="1">
       <tr>
           <th colspan="3">Directory for you</th>
       </tr>
       <tr>
           <td><label>English:</label></td>
           <td><input type="text" name="word" value="${word}"required></td>

       </tr>
       <tr>
           <td><label>Viet Nam</label></td>
           <td>${result}</td>
       </tr>
       <tr>
           <td colspan="3">
               <button type="submit">Change</button>
           </td>
       </tr>
   </table>

</form>

</body>
</html>
