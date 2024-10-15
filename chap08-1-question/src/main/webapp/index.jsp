<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>게시물</title>
</head>
<body>

<h1>게시글 작성</h1>
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