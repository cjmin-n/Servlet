<%--
  Created by IntelliJ IDEA.
  User: 803-01
  Date: 2024-10-16
  Time: 오후 5:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HttpSession httpSession = request.getSession();
    String id = (String)httpSession.getAttribute("userId");
    String pwd = (String)httpSession.getAttribute("password");

    if(id == null || pwd == null) {
        response.sendRedirect("login.jsp");

    }
%>


<html>
<head>
    <title>결과</title>
</head>
<body>
    <h1>환영합니다. <%=id %>님.</h1>
    <a href="login.jsp">로그아웃</a>
</body>
</html>
