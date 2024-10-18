<%--
  Created by IntelliJ IDEA.
  User: 803-01
  Date: 2024-10-18
  Time: 오후 2:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시물 작성</title>
</head>
<body>
    <h1>새 게시글 작성</h1>
    <form action="selectAll" method="post">
        <div><label for="subject">제목 : </label><input type="text" name="subject" id="subject"></div>
        <div><label for="content">내용 : </label><textarea name="content" id="content"></textarea></div>
        <button type="submit">작성하기</button>
    </form>
</body>
</html>
