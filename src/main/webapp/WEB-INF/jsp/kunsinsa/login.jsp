<%@ taglib prefix="onclick" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019-04-28
  Time: 오후 5:05
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>로그인 페이지</title>

</head>
<body>
<div class="main-content-wrapper d-flex clearfix">
    <%@ include file="navigate.jsp" %>
    <div class="container" style="margin-top: 200px">

        <h3>로그인</h3>
        <form action="/logincheck" method="post" id="myForm">
            <div class="form-group has-feedback">
                <label class="control-label" for="id">아이디</label>
                <input class="form-control" type="text" name="userId" id="id"/>
                <span id="overlapErr" class="help-block">사용할 수 없는 아이디 입니다.</span>
                <span class="glyphicon glyphicon-ok form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <label class="control-label" for="pwd">비밀번호</label>
                <input class="form-control" type="password" name="userPassword" id="pwd"/>
                <span id="pwdRegErr" class="help-block">8글자 이상 입력하세요.</span>
                <span class="glyphicon glyphicon-ok form-control-feedback"></span>
            </div>


            <button class="btn btn-success" type="submit">로그인</button>
            <a href="join"><button type="button" class="btn btn-success1" alt="회원가입버튼"/>회원가입</a>
        </form>
    </div>
</div>

<%--action="/FakeSinsa/user"--%>
<%--<form method="post" action="/logincheck">
    <p>이메일 : <input type="email" name="userEmail"></p>
    <p>비밀번호 : <input type="password" name="userPassword"></p>
    <p>
        <input type="submit" value="로그인"/>
        <input type="button" value="회원가입" onclick="location.href='/signup'" ;/>
    </p>

</form>--%>
<%@ include file="footer1.jsp" %>
<%@ include file="footer2.jsp" %>
<!-- ##### jQuery (Necessary for All JavaScript Plugins) ##### -->


</body>
</html>
