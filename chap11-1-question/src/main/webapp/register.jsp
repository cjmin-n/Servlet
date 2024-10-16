<%--
  Created by IntelliJ IDEA.
  User: 803-01
  Date: 2024-10-16
  Time: 오후 2:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
    <h2>회원가입</h2>
    <form action="register" method="post">
        <input type="text" name="userId" placeholder="User ID" required>
        <input type="password" name="password" placeholder="Password" required>
        <input type="email" name="email" placeholder="Email" required>
        <button type="submit">가입하기</button>
    </form>
    <a href="login.jsp">로그인화면</a>
</body>
</html>
