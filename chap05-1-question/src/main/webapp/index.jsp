<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>회원 가입 프로그램</title>
</head>
<body>
<h1>간단한 회원 가입 로직 연습해보기
</h1>
<br/>

<p>이름은 2글자 이상이어야 합니다.</p>
<p>전화번호는 11자리로 입력되어야 합니다.</p>
<p>비밀번호는 8자 이상이며 비밀번호 확인과 일치해야 합니다.</p>
<p>가입 성공 시 환영합니다 @@님 / 실패 시 입력 정보를 확인해주세요 화면에 띄우기</p>

<p>일찍 끝난 사람 ? - 이름은 한글 혹은 영문만 가능, 전화번호는 숫자만 가능</p>
<br/>
<br/>
<form action="signUp" method="POST">
    <label for="name">이름</label><input type="text" id="name" name="name"><br/>
    <label for="tel">전화번호</label><input type="text" id="tel" name="tel"><br/>
    <label for="password">비밀번호</label><input type="password" id="password" name="password"><br/>
    <label for="passwordCheck">비밀번호 확인</label><input type="password" id="passwordCheck" name="passwordCheck"><br/>
    <button type="submit">회원 가입</button>
</form>
</body>
</html>