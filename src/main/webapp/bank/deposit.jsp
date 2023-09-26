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
    <title>입금</title>
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
            margin:0 auto;
        }

    </style>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>

</head>

<body>
<% pageContext.include("header.jsp"); %>

<h1> 입금 </h1>
<div class="box" type="text-align:center">
    <form id="form" action="deposit" method="post">
    <table >
        <tr>
            <th>계좌번호</th>
            <td> <input type="text" name="id"></td>
        </tr>
        <tr>
            <th>입금액</th>
            <td> <input type="text" name="money"></td>
        </tr>
    </table>
    <button type="submit" class="in" tyoe="width:100px">입금</button>
    </form>
</div>
</body>

</html>
