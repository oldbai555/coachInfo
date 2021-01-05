<%--
  Created by IntelliJ IDEA.
  User: 老白
  Date: 2021/1/5
  Time: 8:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>车辆信息页</title>
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
                location.href = "/carType?page=" + page;
            })

            $("#previous").click(function () {
                var page = parseInt($("#currentPage").html());
                if (page == 1) {
                    return;
                }
                page--;
                location.href = "/carType?page=" + page;
            })

            $("#first").click(function () {
                location.href = "/carType?page=1";
            })

            $("#last").click(function () {
                var pages = parseInt($("#pages").html());
                location.href = "/carType?page=" + pages;
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
    <%--首页开始--%>
    <div class="container">
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
                                <a class="nav-link text-secondary" href="#">首页 <span
                                        class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link text-secondary" href="/carTicketTab?page=1">购票信息页 <span
                                        class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link text-secondary" href="/sellTicketInfo?page=1">购票记录表 <span
                                        class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link text-secondary" href="/carType?page=1">车辆信息页 <span class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link text-secondary" href="/carTicketInfo?page=1">车票信息页 <span
                                        class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-secondary" href="/carStartTab?page=1">发车记录表 <span
                                        class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item active">
                                <a class="nav-link disabled" href="#">尊敬的xxx用户 <span
                                        class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link text-primary" href="#">退出登录 <span
                                        class="sr-only">(current)</span></a>
                            </li>
                        </ul>

                    </div>
                </nav>
            </div>
        </div>
        <%--主体开始--%>
        <div class="row border rounded">

            <table class="table table-hover ">
                <thead>
                <tr>
                    <th>汽车名称</th>
                    <th>最大承载量(人)</th>
                    <th>车牌号</th>
                    <th>始发地</th>
                    <th>目的地</th>
                    <th>发车时间</th>
                    <th>预计行驶时间</th>
                    <th>修改</th>
                    <th>删除</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${sessionScope.list}" var="CarInfo">
                    <tr>
                        <td>${CarInfo.carType.carName}</td>
                        <td>${CarInfo.carType.peopleNum}</td>
                        <td>${CarInfo.carType.licensePlate}</td>
                        <td>${CarInfo.routeStart}</td>
                        <td>${CarInfo.routeEnd}</td>
                        <td>${CarInfo.car_start_time}</td>
                        <td>${CarInfo.probably_time}</td>
                        <td>
                            <!-- Button trigger modal -->
                            <a class="text-secondary" data-toggle="modal"
                               data-target="#exampleModal${CarInfo.id}" href="#">
                                修改
                            </a>
                            <!-- Modal -->
                            <!-- 模态框外部 -->
                            <div class="modal fade" id="exampleModal${CarInfo.id}" tabindex="-1" role="dialog"
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
                                                ${CarInfo.id}
                                        </div>
                                        <!-- 模态框主体部分结束 -->
                                        <!-- 脚部开始 -->
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">取消
                                            </button>
                                            <button type="button" class="btn btn-primary">确定</button>
                                        </div>
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
    <%--首页结束--%>

</div>

</body>
</html>
