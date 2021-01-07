<%--
  Created by IntelliJ IDEA.
  User: 老白
  Date: 2021/1/5
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="shortcut icon" href="img/favicon.ico" >
    <title>车票页(已售多少还剩多少)</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" type="text/css" href="./css/main.css"/>
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="./css/index.css">
    <script src="./js/jquery-3.4.1.js" type="text/javascript" charset="utf-8"></script>
    <script src="./js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="./js/bootstrap.bundle.js" type="text/javascript" charset="utf-8"></script>
    <style type="text/css">
        .carbg {
            background-image: url(./img/bg1.jpg);
            background-repeat: no-repeat;
            background-size: cover;
            color: black;
        }
    </style>
    <script type="text/javascript">
        $(function () {
            $("#next").click(function () {
                var pages = parseInt($("#pages").html());
                var page = parseInt($("#currentPage").html());
                if (page == pages) {
                    return;
                }
                page++;
                location.href = "/carTicketTab?page=" + page;
            })

            $("#previous").click(function () {
                var page = parseInt($("#currentPage").html());
                if (page == 1) {
                    return;
                }
                page--;
                location.href = "/carTicketTab?page=" + page;
            })

            $("#first").click(function () {
                location.href = "/carTicketTab?page=1";
            })

            $("#last").click(function () {
                var pages = parseInt($("#pages").html());
                location.href = "/carTicketTab?page=" + pages;
            })
        })
    </script>
</head>
<body>
<%--最外层开始--%>
<div class=" .container-fluid">
    <%--巨幕开始--%>
    <div class="jumbotron carbg">
        <h1 class="display-4">Neusoft车站管理系统</h1>
        <p class="lead">javaweb项目实战</p>
        <hr class="my-4">
        <p>小组成员：叶秋妤，刘真成，张建军，郭佳顺，陆昌豪</p>
    </div>
    <%--巨幕结束--%>
    <%--主体开始--%>
    <div class="container  mb-5">
        <%--首页开始--%>
        <div class="row bg-light rounded">
            <div class="col-sm-12">
                <nav class="navbar navbar-expand-lg navbar-light bg-light">

                    <a class="navbar-brand disabled" href="#">Neusoft车站管理系统</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse"
                            data-target="#navbarSupportedContent"
                            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item active">
                                <a class="nav-link text-secondary" href="index.jsp">首页 <span
                                        class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link text-secondary" href="/carTicketTab?page=1">购票信息页 <span
                                        class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link text-secondary" href="/sellTicketInfo?page=1">乘客购票表 <span
                                        class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-secondary" href="/carStartTab?page=1">发车记录表 <span
                                        class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link text-secondary" href="/carType?page=1">车辆信息页 <span class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link text-secondary" href="/carTicketInfo?page=1">车票信息页 <span
                                        class="sr-only">(current)</span></a>
                            </li>

                            <li class="nav-item ">
                                <a class="nav-link text-primary" href="/login" id="out" onclick="fun()">退出登录 <span
                                        class="sr-only">(current)</span></a>
                            </li>
                        </ul>

                    </div>
                </nav>
            </div>
        </div>
        <%--首页结束--%>
        <%--    搜索框--%>
        <div class="d-flex flex-row-reverse bd-highlight row">
            <div class="p-2 bd-highlight">
                <form class="form-inline my-2 my-lg-0" action="/carType" method="get">
                    <input type="hidden" name="method" value="like">
                    <input class="form-control mr-sm-2" type="search" placeholder="搜索车辆信息" aria-label="Search" name="likeName">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">搜索</button>
                </form>
            </div>
            <div class="p-2 bd-highlight">
                <ul class="nav">
                    <li class="nav-item active">
                        <a class="nav-link disabled" href="#">尊敬的${admin.username}用户<span
                                class="sr-only">(current)</span></a>
                    </li>
                </ul>
            </div>
        </div>

        <%--    搜索框--%>
        <%--主体开始--%>
        <div class="row border rounded">

            <table class="table table-hover ">
                <thead>
                <tr>
                    <th>车牌号</th>
                    <th>车票名</th>
                    <th>总数</th>
                    <th>已售</th>
                    <th>购买</th>
                    <th>删除</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${sessionScope.list}" var="list">
                    <tr>
                        <td>${list.ticketInfo.carInfo.carType.licensePlate}</td>
                        <td>${list.ticketInfo.ticketName}</td>
                        <td>${list.ticketNum}</td>
                        <td>${list.ticketSum}</td>
                        <td>
                            <!-- Button trigger modal -->
                            <a class="text-secondary" data-toggle="modal"
                               data-target="#exampleModal${list.id}" href="#">
                                购买
                            </a>
                            <!-- Modal -->
                            <!-- 模态框外部 -->
                            <div class="modal fade" id="exampleModal${list.id}" tabindex="-1" role="dialog"
                                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <!-- 模态框面板 -->
                                <div class="modal-dialog" role="document">
                                    <!-- 模态框中心 -->
                                    <div class="modal-content">
                                        <!-- 模态框头部 -->
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">修改信息</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <!-- 头部结束 -->
                                        <!-- 模态框主体部分 -->
                                        <div class="modal-body">
                                                <%--                                            表单开始--%>
                                            <div class="container text-left">
                                                <h2 class="text-left">购票表</h2>
                                                <form class="text-left" action="/carTicketTab" method="post">
                                                    <input type="hidden" name="method" value="add" />
                                                    <input type="hidden" name="id" value="${list.id}" />
                                                    <div class="form-group">
                                                        <p for="car_id" class="text-left">车号:</p>
                                                        <input type="text" class="form-control text-left" id="car_id"
                                                               placeholder="1" required="required" value="${list.ticketInfo.id}" name="ticketInfoId">
                                                    </div>

                                                    <div class="form-group">
                                                        <p for="mane" class="text-left">姓名:</p>
                                                        <input type="text" class="form-control text-left disabled" id="mane" name="peopleName"
                                                               placeholder="" required="required" value="">
                                                    </div>

                                                    <div class="form-group">
                                                        <p for="idCard" class="text-left">身份证号码:</p>
                                                        <input type="text" class="form-control text-left" id="idCard"
                                                               placeholder="" required="required" value="" name="peopleIdCard">
                                                        <label id="warning"></label>
                                                    </div>

                                                    <button type="submit" class="btn btn-primary">提交</button>
                                                </form>
                                            </div>

                                            <script>
                                                $("#idCard").blur(function () {
                                                    var a = $("#idCard").val();
                                                    var textIDNumber = /^[1-9]{1}[0-9]{14}$|^[1-9]{1}[0-9]{16}([0-9]|[xX])$/;
                                                    if (textIDNumber.test(a)) {
                                                        return true;
                                                    } else {
                                                        $('#warning').text('身份证证件号格式有误！');
                                                        $('#warning').css('color', 'red');
                                                        return false;
                                                    }
                                                })
                                            </script>
                                                <%--                                            表单结束--%>

                                        </div>
                                        <!-- 模态框主体部分结束 -->
                                        <!-- 脚部开始 -->
<%--                                        <div class="modal-footer">--%>
<%--                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">取消--%>
<%--                                            </button>--%>
<%--                                            <button type="button" class="btn btn-primary">确定</button>--%>
<%--                                        </div>--%>
                                        <!-- 脚部结束 -->
                                    </div>
                                    <!-- 模态框中心结束 -->
                                </div>
                                <!-- 面板结束 -->
                            </div>
                            <!-- 外部结束 -->
                        </td>
                        <td>
                            <a href="#" class="text-danger">删除</a>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>

        </div>

        <%--主体结束--%>
        <%--分页开始--%>
        <div class="row">
            <div id="pageControl">
                <div class="pageControl_item " id="first">首页</div>
                <div class="pageControl_item " id="previous">上一页</div>
                <div class="pageControl_item "><font id="currentPage">${sessionScope.currentPage }</font>/<font
                        id="pages">${sessionScope.pages }</font></div>
                <div class="pageControl_item " id="next">下一页</div>
                <div class="pageControl_item ">每页<font id="dataPrePage">${sessionScope.dataPrePage }</font>条数据</div>
                <div class="pageControl_item " id="last">最后一页</div>
            </div>
        </div>
        <%--分页结束--%>

    </div>
    <%--主体结束--%>
    <div class="fixed-bottom text-dark bg-light">桂公网安备
        000000000001号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>网站浏览量：${applicationScope.countPeo}次</span>
    </div>
</div>
<%--最外层结束--%>

</body>
</html>
