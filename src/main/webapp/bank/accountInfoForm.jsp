<%--
  Created by IntelliJ IDEA.
  User: gmlwls
  Date: 2023/09/20
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width-device-width, initial-scale=1.0">
  <title>계좌조회</title>
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

  </style>
  <script src="https://code.jquery.com/jquery-3.7.1.js"></script>

</head>

<body>
<% pageContext.include("header.jsp"); %>

<h1> 계좌조회 </h1>
<div class="box" type="text-align:center">
  <form action="accountInfo" method="post" id="form">
  <div class="in">계좌번호 <input type="text" size="30" name="id"></div>
  <button type="submit" class="in" type="width:100px">조회</button>
  </form>
</div>
</body>

</html>