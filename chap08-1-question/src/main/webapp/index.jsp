<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String message = (String) request.getAttribute("message"); %>
<% String message2 = (String) request.getAttribute("message2"); %>
<!DOCTYPE html>
<html>
<head>
    <title>게시물 작성</title>
</head>
<body>

<h1>게시글 작성</h1>
<h3 style="color: red;"><%= message != null ? message : "" %></h3>
<h3 style="color: red;"><%= message2 != null ? message2 : "" %></h3>
<br/>
<form action="writepost" method="post">
    <label for="title">제목 : </label>
    <input type="text" id="title" name="title"><br/>
    <label for="cont">내용 : </label>
    <textarea name="cont" id="cont"></textarea><br/>
    <button type="submit">작성하기</button>
</form>
</body>
</html>