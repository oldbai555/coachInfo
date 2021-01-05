<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <title></title>
    <link type="text/css" rel="stylesheet" href="./css/style.css"/>
    <script type="text/javascript" src="./js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            var height = $(document).height();
            $('body').css('height', height);
            var mart = height - 500;
            mart = mart / 2;
            $('.loginBox').css('marginTop', mart);
        })
    </script>
</head>

<body>
<div class="loginBox">
    <h1>欢迎登陆</h1>
    <div class="item">
        <div class="icon"><img src="img/icon1.png"/></div>
        <div class="txt"><input name="name" id="name" type="text" placeholder="请输入您的用户名" value="admin"/></div>
    </div>
    <div class="item">
        <div class="icon"><img src="img/icon2.png"/></div>
        <div class="txt"><input name="pwd" id="pwd" type="password" placeholder="请输入您的密码" value="123456"/></div>
    </div>
    <div class="item_2">
        <input name="" type="checkbox" value=""/>
        <span>记住密码</span>
        <a href="psd.jsp">忘记密码？</a>
    </div>
    <div class="item_3">
        <input name="" type="submit" onclick="fun()" id="commit" value="安全登录" class="btn" />
    </div>
    <div class="item_4">
        还没有账号？<a href="register.jsp">立即注册</a>
    </div>
</div>
</body>

</html>
<script type="text/javascript">
    function fun() {
        var name = $("#name").val();
        var pwd = $("#pwd").val();

        $.post("/login",{
            name: name,
            pwd:pwd,
        },function(data,status){
            console.log(data);
            if (data == "OK"){
                location.href = "/carType?page=1";
            }else{
                location.href = "/login.jsp";
            }
        })
    }
</script>