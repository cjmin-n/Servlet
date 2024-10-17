<%--
  Created by IntelliJ IDEA.
  User: 803-01
  Date: 2024-10-17
  Time: 오후 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:include page="../common/header.jsp"/>

    <h3>Employee 테이블에서 EMP_ID 를 이용하여 사원 정보 조회해오기</h3>
    <form action="employee/select">
        <label for="empId">조회할 사번 : </label>
        <input type="text" name="empId" id="empId">
        <button type="submit">조회하기</button>
    </form>
</body>
</html>
