<%--
  Created by IntelliJ IDEA.
  User: gmlwls
  Date: 2023/09/20
  Time: 11:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.List" %>
<%@ page import="com.example.kosta_jspdb.dto.Account" %>
<% List<Account> accs = (List<Account>) request.getAttribute("accs"); %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        h1{text-align: center;}
        body {
            margin: 0 auto;

        }

        .container {
            /* padding:10px; */
            border: 1px solid;
            width: 660px;
        }
        .header {
            height: 40px;
        }

        .row {
            height: 30px;
        }

        .title {
            font-weight: bold;
            background-color: lightgrey;
        }
        .colume {
            padding:5px;
            width: 100px;
            float: left;
        }

        .input {
            float: left;
        }

        input[type='submit'] {
            font-weight: bold;
            width:120px;
            background-color: lightgrey;
        }
    </style>
</head>
<body>
<% pageContext.include("header.jsp"); %>

<div>
    <form action="allAccountInfo">
        <div class="header">
            <h1>전체 계좌 조회</h1>
        </div>
        <div class="container" id="container">
            <div class="row">
                <div class="title colume">순서</div>
                <div class="title colume">계좌번호</div>
                <div class="title colume">이름</div>
                <div class="title colume">잔액</div>
                <div class="title colume">계좌종류</div>
                <div class="title colume">등급</div>
            </div>

            <%
                for(int i=0; i<accs.size(); i++){

            %>
            <c:forEach var="acc" items="${accs }">
                <div class="row">
                    <div class="title colume">${i }></div>
                    <div class="title colume">${acc.id}</div>
                    <div class="title colume">${acc.name}</div>
                    <div class="title colume">${acc.balance}</div>
                    <div class="title colume">${acc.type}</div>
                    <div class="title colume">${acc.grade}&nbsp</div>
                </div></c:forEach>
            <%
                }
            %>
        </div>
    </form>
</div>
</body>
</html>
