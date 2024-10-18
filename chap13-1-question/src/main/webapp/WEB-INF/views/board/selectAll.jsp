<%@ page import="java.util.List" %>
<%@ page import="com.ohgiraffers.mvc.model.dto.BoardDTO" %><%--
  Created by IntelliJ IDEA.
  User: 803-01
  Date: 2024-10-18
  Time: 오후 1:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>게시판 목록</title>
</head>
<body>
    <h1>게시판</h1>
    <a href="newBoard">새 게시글 작성</a>
    <h2>
        게시글 목록
    </h2>
    <%
        List<BoardDTO> list = (List) request.getAttribute("list");
        if (list != null && !list.isEmpty()) {
    %>
    <table style="width: 100%; text-align:center;">
        <tr>
            <th>ID</th>
            <th>제목</th>
            <th>작업</th>
        </tr>

        <c:forEach items="${requestScope.list}" var="item">
            <tr>
                <td>${item.id}</td>
                <td><a href="detail?id=${item.id}">${item.subject}</a></td>
                <td>
                    <a href="edit?id=${item.id}">수정</a>
                    <a href="delete?id=${item.id}">삭제</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <%
    } else {
    %>
    <p>게시글이 없습니다.</p>
    <%
        }
    %>


</body>
</html>
