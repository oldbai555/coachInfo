
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <title></title>
    <link type="text/css" rel="stylesheet" href="./css/style.css" />
    <script type="text/javascript" src="./js/jquery-1.8.2.min.js"></script>
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

<body>
    <div class="loginBox">
        <h1>找回密码</h1>
        <div class="item">
            <div class="icon"><img src="img/icon1.png" /></div>
            <div class="txt"><input name="" type="text" placeholder="请输入手机号" /></div>
        </div>
        <div class="item">
            <div class="icon"><img src="img/icon3.png" /></div>
            <div class="txt"><input name="" type="text" placeholder="请输入短信验证码" /></div>
            <div class="yzm"><img src="img/yzm.jpg" /></div>
        </div>
        <div class="item">
            <div class="icon"><img src="img/icon1.png" /></div>
            <div class="txt"><input name="" type="password" placeholder="请输入新登录密码" /></div>
        </div>
        <div class="item">
            <div class="icon"><img src="img/icon1.png" /></div>
            <div class="txt"><input name="" type="password" placeholder="请再次输入新密码" /></div>
        </div>
        <div class="item_3">
            <input name="" type="submit" value="确认" class="btn" onclick="location='success.jsp'" />
        </div>
    </div>
</body>

</html>