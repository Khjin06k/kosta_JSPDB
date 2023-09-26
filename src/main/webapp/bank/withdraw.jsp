<%--
  Created by IntelliJ IDEA.
  User: gmlwls
  Date: 2023/09/20
  Time: 10:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width-device-width, initial-scale=1.0">
  <title>출금</title>
  <style>
    h1{text-align: center;}

    .box{
      margin: 0 auto;
      padding : 20px;
      width: 50%;
      border : 2px solid black;
      text-align: center;
      vertical-align: center;
    }

    button{
      background-color: silver;
      border:2px solid black;
      width: 200px;
      height: 30px;
    }
    .in{
      padding:5px;
    }
    table{
      margin : 0 auto;
      text-align: center;
    }

  </style>
  <script src="https://code.jquery.com/jquery-3.7.1.js"></script>

</head>

<body>
<% pageContext.include("header.jsp"); %>

<h1> 출금 </h1>
<form id="form" action="withdraw" method="post">
  <div class="box" type="text-align:center">
  <table >
    <tr>
      <th>계좌번호</th>
      <td> <input type="text" name="id"></td>
    </tr>
    <tr>
      <th>출금액</th>
      <td> <input type="text" name="money"></td>
    </tr>
  </table>

  <button type="submit" class="in" type="width:100px">출금</button>
</div>
</form>
</body>

</html>
