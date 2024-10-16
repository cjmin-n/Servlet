<%--
  Created by IntelliJ IDEA.
  User: 803-01
  Date: 2024-10-16
  Time: 오후 2:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
    <h2>로그인 페이지</h2>
    <form action="login" method="post">
        <input type="text" name="userId" placeholder="User ID" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">로그인</button>
    </form>
    <a href="register.jsp">가입하기</a>
</body>
</html>
