
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="shortcut icon" href="img/favicon.ico" >
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <title></title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            var height = $(document).height();
            $('body').css('height', height);
            var mart = height - 500;
            mart = mart / 2;
            $('.loginBox').css('marginTop', mart);
        })
    </script>
</head>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="renderer" content="webkit" />
    <meta name="force-rendering" content="webkit" />

</head>

<body>
    <div class="loginBox">
        <h1>注册</h1>
        <div class="item">
            <div class="icon"><img src="img/icon1.png" /></div>
            <div class="txt"><input name="name" id="name" type="text" placeholder="请输入您的用户名" /></div>
        </div>
        <div class="item">
            <div class="icon"><img src="img/icon2.png" /></div>
            <div class="txt"><input name="pwd" id="pwd" type="password" placeholder="请输入您的密码" /></div>
        </div>
        <div class="item">
            <div class="icon"><img src="img/icon3.png" /></div>
            <div class="txt"><input name="" type="text" placeholder="请输入验证码" /></div>
            <div class="yzm"><img src="img/yzm.jpg" /></div>
        </div>
        <div class="item_3">
            <input name="" type="submit" onclick="fun()" value="注册" class="btn" />
        </div>
        <div class="item_4">
            已注册<a href="login.jsp">我要登录</a>
        </div>
    </div>
</body>

</html>

<script type="text/javascript">
    function fun() {
        var name = $("#name").val();
        var pwd = $("#pwd").val();

        $.post("/register",{
            name: name,
            pwd:pwd,
        },function(data,status){
            console.log(data);
            if (data == "OK"){
                location.href = "/login";
            }else{
                alert("注册失败，用户名已存在");
                location.href = "/register.jsp";
            }
        })
    }
</script>