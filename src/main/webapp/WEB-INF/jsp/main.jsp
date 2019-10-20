<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019-05-02
  Time: 오전 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>메인 페이지</title>
    <h1>메인 페이지</h1>

    <p><h3>상품</h3></p>

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
        <c:forEach var="result" items="${selectProduct}">
        <tr>
                <%--result.DB 칼럼 명--%>
            <td>${result.product_category}</td>
            <td>
                <a href="/FakeSinsa/view/purchase.do?productName=${result.product_name}&productCategory=${result.product_category}&productPrice=${result.product_price}&productDetail=${result.product_detail}">${result.product_name}</a>
            </td>
            <td>${result.product_price}</td>
            <td>${result.product_detail}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/logout"> LogOut</a>-
</head>
<body>

</body>
</html>

