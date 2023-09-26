<%--
  Created by IntelliJ IDEA.
  User: gmlwls
  Date: 2023/09/20
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        table{
            margin : 0 auto;
            text-align: center;
        }
        .textbox{
            background-color: black;
            width: 200px;
        }

    </style>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>

</head>

<body>
<% pageContext.include("header.jsp"); %>

<h1> 계좌조회 </h1>
<div class="box" type="text-align:center">
    <form action="accountInfo" method="Get">
    <table >
        <tr>
            <th>계좌번호</th>
            <td><input type="text" name="id" disabled value="${acc.id}"></td>
        </tr>
        <tr>
            <th>이름</th>
            <td> <input type="text" name = "name" disabled value="${acc.name}"></td>
        </tr>
        <tr>
            <th>입금액</th>
            <td> <input type="text" name="money" disabled value="${acc.balance}"></td>
        </tr>
        <tr>
            <th>종류</th>
            <td> <input type="text" disabled value="${acc.type}"></td>
        </tr>
        <tr>
            <th>등급</th>
            <td> <input type="text" disabled value="${acc.grade}"></td>
        </tr>
    </table>
    </form>
</div>
</body>

</html>