
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <div class="item_5">
            <p>-^0^-</p>
            <p>新登录密码重置成功，请重新登录!</p>
        </div>
        <div class="item_3">
            <input name="" type="submit" value="重新登录" class="btn" onclick="location='login.jsp'" />
        </div>
    </div>
</body>

</html>