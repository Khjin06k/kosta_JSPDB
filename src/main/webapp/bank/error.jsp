<%--
  Created by IntelliJ IDEA.
  User: gmlwls
  Date: 2023/09/21
  Time: 10:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>error</title>
</head>
<body>
<% pageContext.include("header.jsp"); %>

<h2><%=request.getAttribute("err")%></h2> <%-- Account.java에서 setAttribute로 저장한 err를 키로 갖는 에러 메세지를 출력하도록 함<--%>
</body>
</html>
