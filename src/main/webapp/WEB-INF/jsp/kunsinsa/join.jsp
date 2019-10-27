<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>회원가입</title>

    <style>
        /* .help-block 을 일단 보이지 않게 설정 */
        #myForm .help-block{
            display: none;
        }
        /* glyphicon 을 일단 보이지 않게 설정 */
        #myForm .glyphicon{
            display: none;
        }
    </style>
</head>
<body>
<div class="main-content-wrapper d-flex clearfix">
    <%@ include file="navigate.jsp" %>
<div class="container" style="margin-top: 200px">
    <h3>회원가입</h3>
    <form action="/signupcheck" method="post" id="myForm">
        <div class="form-group has-feedback">
            <label class="control-label" for="id">아이디</label>
            <input class="form-control" type="text" name="userId" id="id"/>
            <span id="overlapErr" class="help-block">사용할 수 없는 아이디 입니다.</span>
            <span class="glyphicon glyphicon-ok form-control-feedback"></span>
        </div>
        <div class="form-group has-feedback">
            <label class="control-label" for="name">이름</label>
            <input class="form-control" type="text" name="userName" id="name"/>
            <span id="nameReg" class="help-block">8글자 이상 입력하세요.</span>
            <span class="glyphicon glyphicon-ok form-control-feedback"></span>
        </div>
        <div class="form-group has-feedback">
            <label class="control-label" for="email">이메일</label>
            <input class="form-control" type="text" name="userEmail" id="email"/>
            <span id="emailErr" class="help-block">올바른 이메일 형식이 아닙니다. 다시 입력해 주세요.</span>
            <span class="glyphicon glyphicon-ok form-control-feedback"></span>
        </div>
        <div class="form-group has-feedback">
            <label class="control-label" for="pwd">비밀번호</label>
            <input class="form-control" type="password" name="userPassword" id="pwd"/>
            <span id="pwdRegErr" class="help-block">8글자 이상 입력하세요.</span>
            <span class="glyphicon glyphicon-ok form-control-feedback"></span>
        </div>
        <div class="form-group has-feedback">
            <label class="control-label" for="rePwd">비밀번호 재확인</label>
            <input class="form-control" type="password" name="rePwd" id="rePwd"/>
            <span id="rePwdErr" class="help-block">비밀번호와 일치하지 않습니다. 다시 입력해 주세요.</span>
            <span class="glyphicon glyphicon-ok form-control-feedback"></span>
        </div>

        <a href="join"><button type="button" class="btn btn-success1" alt="로그인버튼"/>로그인</a>
        <button class="btn btn-success" type="submit">회원가입</button>
    </form>
</div>
</div>
<script src="js/jquery/jquery-2.2.4.min.js"></script>
<script>
    //아이디 입력란에 keyup 이벤트가 일어 났을때 실행할 함수 등록
    $("#id").keyup(function(){
        //입력한 문자열을 읽어온다.
        var id=$(this).val();
        //ajax 요청을 해서 서버에 전송한다.
        $.ajax({
            method:"post",
            url:"/idCheck",
            data:{inputId:id},
            success:function(data){
                var obj=JSON.parse(data);
                if(obj.canUse){//사용 가능한 아이디 라면
                    $("#overlapErr").hide();
                    // 성공한 상태로 바꾸는 함수 호출
                    successState("#id");

                }else{//사용 가능한 아이디가 아니라면
                    $("#overlapErr").show();
                    errorState("#id");
                }
            }
        });
    });
    $("#pwd").keyup(function(){
        var pwd=$(this).val();
        // 비밀번호 검증할 정규 표현식
        var reg=/^.{8,}$/;
        if(reg.test(pwd)){//정규표현식을 통과 한다면
            $("#pwdRegErr").hide();
            successState("#pwd");
        }else{//정규표현식을 통과하지 못하면
            $("#pwdRegErr").show();
            errorState("#pwd");
        }
    });
    $("#rePwd").keyup(function(){
        var rePwd=$(this).val();
        var pwd=$("#pwd").val();
        // 비밀번호 같은지 확인
        if(rePwd==pwd){//비밀번호 같다면
            $("#rePwdErr").hide();
            successState("#rePwd");
        }else{//비밀번호 다르다면
            $("#rePwdErr").show();
            errorState("#rePwd");
        }
    });
    $("#email").keyup(function(){
        var email=$(this).val();
        // 이메일 검증할 정규 표현식
        var reg=/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        if(reg.test(email)){//정규표현식을 통과 한다면
            $("#emailErr").hide();
            successState("#email");
        }else{//정규표현식을 통과하지 못하면
            $("#emailErr").show();
            errorState("#email");
        }
    });
    // 성공 상태로 바꾸는 함수
    function successState(sel){
        $(sel)
            .parent()
            .removeClass("has-error")
            .addClass("has-success")
            .find(".glyphicon")
            .removeClass("glyphicon-remove")
            .addClass("glyphicon-ok")
            .show();

        $("#myForm button[type=submit]")
            .removeAttr("disabled");
    };
    // 에러 상태로 바꾸는 함수
    function errorState(sel){
        $(sel)
            .parent()
            .removeClass("has-success")
            .addClass("has-error")
            .find(".glyphicon")
            .removeClass("glyphicon-ok")
            .addClass("glyphicon-remove")
            .show();

        $("#myForm button[type=submit]")
            .attr("disabled","disabled");
    };
</script>
<%@ include file="footer1.jsp" %>
<%@ include file="footer2.jsp" %>
</body>
</html>
