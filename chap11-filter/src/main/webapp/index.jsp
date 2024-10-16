<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Filter</title>
</head>
<body>
    <h1>필터의 라이프 사이클</h1>
    <br/>
    <a href="first/filter">Filter 사용하기</a>

    <hr/>

    <h1>필터의 활용</h1>
    <form action="member/regist" method="post">
        <label for="userId">아이디 : </label>
        <input type="text" name="userId" id="userId">
        <br/>
        <label for="password">비밀번호 : </label>
        <input type="password" name="password" id="password">
        <br/>
        <label for="name">이름 : </label>
        <input type="text" name="name" id="name">
        <button type="submit">가입하기</button>
    </form>
</body>
</html>