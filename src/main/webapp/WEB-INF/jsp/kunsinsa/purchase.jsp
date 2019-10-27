<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019-05-05
  Time: 오후 3:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% if (session.getAttribute("productName") != null) {%>
<script>
    console.log('있어');
</script>

<%}%>

<html>
<head>
    <title>구매 페이지</title>
    <h1>제품 페이지</h1>


</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>종류</th>
        <th>이름</th>
        <th>가격</th>
        <th>상세내용</th>
    </tr>
    </thead>

    <tbody>
    <tr>
        <td>${productCategory}</td>
        <td>${productName}</td>
        <td>${productPrice}</td>
        <td>${productDetail}</td>
    </tr>
    </tbody>
</table>
<p><input type="button" value="구매하기" onclick='buy();'/></p>
</body>

<script>
    function buy() {
        alert("구매완료");
    }
</script>
</html>
