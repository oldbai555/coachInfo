<%--
  Created by IntelliJ IDEA.
  User: 老白
  Date: 2021/1/5
  Time: 8:47
  To change this template use File | Settings | File Templates.
  陆昌豪 - 车辆信息表   郭佳顺-乘客购票表 - 发车记录表
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
        #eorro1 {
            color: green;
        }

        #eorro2 {
            color: green;
        }

        #eorro3 {
            color: green;
        }

        #eorro4 {
            color: green;
        }

        #eorro5 {
            color: green;
        }

        #eorro6 {
            color: green;
        }

        #eorro7 {
            color: green;
        }

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
    <script>
        window.onload = function () {


            // document.getElementById("form").onsubmit = function () {
            //
            //
            //     return checkcar_name() && checkpeople_num() && checklicense_plate() && checkroute_start() && checkroute_end() && checkcar_start_time() && checkprobably_time();
            //
            // }
            document.getElementById("car_name").onblur = checkcar_name;
            document.getElementById("people_num").onblur = checkpeople_num;
            document.getElementById("license_plate").onblur = checklicense_plate;
            document.getElementById("route_start").onblur = checkroute_start;
            document.getElementById("route_end").onblur = checkroute_end;
            document.getElementById("car_start_time").onblur = checkcar_start_time;
            document.getElementById("probably_time").onblur = checkprobably_time;


        }

        function checkcar_name() {

            var car_name = document.getElementById("car_name").value;
            var reg_car_name = /^[A-Za-z0-9\u4e00-\u9fa5]+$/gi;
            var flag = reg_car_name.test(car_name);
            var eorr1 = document.getElementById("eorro1");
            // var eorr2 = document.getElementById("eorro2");
            if (flag) {
                eorr1.innerHTML = "输入正确"

            } else {
                eorr1.innerHTML = '<span style="color:#FF0000">请输入正确的汽车名</span>'
            }
            return flag;

        }

        function checkpeople_num() {

            var people_num = document.getElementById("people_num").value;
            var reg_people_num = /^\w{2,}$/;
            var flag = reg_people_num.test(people_num);
            var eorr1 = document.getElementById("eorro2");
// var eorr2 = document.getElementById("eorro2");
            if (flag) {
                eorr1.innerHTML = "载客人数输入正确"

            } else {
                eorr1.innerHTML = '<span style="color:#FF0000">载客人数输入错误</span>'
            }
            return flag;

        }

        function checklicense_plate() {

            var license_plate = document.getElementById("license_plate").value;
            var reg_license_plate = /^[A-Za-z0-9\u4e00-\u9fa5]+$/gi;
            var flag = reg_license_plate.test(license_plate);
            var eorr1 = document.getElementById("eorro3");
            if (true) {
                eorr1.innerHTML = "车牌号格式输入正确"

            } else {
                eorr1.innerHTML = '<span style="color:#FF0000">车牌号格式输入错误</span>'
            }
            return flag;

        }

        function checkroute_start() {

            var route_start = document.getElementById("route_start").value;
            var reg_route_start = /^[A-Za-z0-9\u4e00-\u9fa5]+$/gi;
            var flag = reg_route_start.test(route_start);
            var eorr1 = document.getElementById("eorro4");
// var eorr2 = document.getElementById("eorro2");
            if (flag) {
                eorr1.innerHTML = "起始地输入正确"

            } else {
                eorr1.innerHTML = '<span style="color:#FF0000">起始地输入错误</span>'
            }
            return flag;

        }

        function checkroute_end() {

            var route_end = document.getElementById("route_end").value;
            var reg_route_end = /^[A-Za-z0-9\u4e00-\u9fa5]+$/gi;
            var flag = reg_route_end.test(route_end);
            var eorr1 = document.getElementById("eorro5");
// var eorr2 = document.getElementById("eorro2");
            if (flag) {
                eorr1.innerHTML = "终点输入正确"

            } else {
                eorr1.innerHTML = '<span style="color:#FF0000">终点输入错误</span>'
            }
            return flag;

        }


        function checkcar_start_time() {

            var car_start_time = document.getElementById("car_start_time").value;
            var reg_car_start_time = /^\w{1,}$/;
            var flag = reg_car_start_time.test(car_start_time);
            var eorr1 = document.getElementById("eorro6");
// var eorr2 = document.getElementById("eorro2");
            if (true) {
                eorr1.innerHTML = "发车时间输入正确"

            } else {
                eorr1.innerHTML = '<span style="color:#FF0000">发车时间输入错误</span>'
            }
            return flag;

        }

        function checkprobably_time() {

            var probably_time = document.getElementById("probably_time").value;
            var reg_probably_time = /^\w{1,}$/;
            var flag = reg_probably_time.test(probably_time);
            var eorr1 = document.getElementById("eorro7");
            if (flag) {
                eorr1.innerHTML = "格式输入正确"

            } else {
                eorr1.innerHTML = '<span style="color:#FF0000">格式输入错误</span>'
            }
            return flag;

        }
    </script>
</head>
<body>
<%--最外层开始--%>
<div class=" .container-fluid ">
    <%--巨幕开始--%>
    <div class="jumbotron carbg">
        <h1 class="display-4">Neusoft车站管理系统</h1>
        <p class="lead">javaweb项目实战</p>
        <hr class="my-4">
        <p>小组成员：叶秋妤，刘真成，张建军，郭佳顺，陆昌豪</p>
    </div>
    <%--巨幕结束--%>
    <%--首页开始--%>
    <div class="container  mb-5">
        <%--        导航栏--%>
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
        <%--    导航栏--%>
        <%--    搜索框--%>
        <div class="d-flex flex-row-reverse bd-highlight row">
            <div class="p-2 bd-highlight">
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">搜索</button>
                </form>
            </div>
            <div class="p-2 bd-highlight">
                <ul class="nav">
                    <li class="nav-item active">
                        <a class="nav-link disabled" href="#">尊敬的${admin.username}用户<span
                                class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-outline-secondary my-2 my-sm-0" href="#" data-toggle="modal"
                           data-target="#exampleModal">添加</a>
                    </li>
                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
                         aria-labelledby="exampleModalLabeladd" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabeladd">添加</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <div class="container">
                                        <h2>添加车辆信息</h2>
                                        <form action="/carType" method="post" id="form">
                                            <input type="hidden" value="add" name="method">
                                            <div class="form-group">
                                                <label for="car_name">汽车:</label>
                                                <input type="text" class="form-control" id="car_name"
                                                       placeholder="输入汽车名" name="carName" value="">
                                                <span id="eorro1"></span>
                                            </div>
                                            <div class="form-group">
                                                <label for="people_num">载客量:</label>
                                                <input type="text" class="form-control" id="people_num"
                                                       placeholder="输入载客量" name="peopleNum" value="">
                                                <span id="eorro2"></span>
                                            </div>
                                            <div class="form-group">
                                                <label for="license_plate">车牌号:</label>
                                                <input type="text" class="form-control" id="license_plate"
                                                       placeholder="输入车牌号" name="licensePlate" value="">
                                                <span id="eorro3"></span>
                                            </div>
                                            <div class="form-group">
                                                <label for="route_start">起始地:</label>
                                                <input type="text" class="form-control" id="route_start"
                                                       placeholder="输入起始地" name="routeStart" value="">
                                                <span id="eorro4"></span>
                                            </div>
                                            <div class="form-group">
                                                <label for="route_end">终点:</label>
                                                <input type="text" class="form-control" id="route_end"
                                                       placeholder="输入终点" name="routeEnd" value="">
                                                <span id="eorro5"></span>
                                            </div>
                                            <div class="form-group">
                                                <label for="car_start_time">起始时间:</label>
                                                <input type="text" class="form-control" id="car_start_time"
                                                       placeholder="输入起始时间" name="car_start_time" value="">
                                                <span id="eorro6"></span>
                                            </div>
                                            <div class="form-group">
                                                <label for="probably_time">probably_time:</label>
                                                <input type="text" class="form-control" id="probably_time"
                                                       placeholder="耗时" name="probably_time" value="">
                                                <span id="eorro7"></span>
                                            </div>
                                            <button type="submit" class="btn btn-primary">提交添加</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </ul>
            </div>
        </div>

        <%--    搜索框--%>
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
                                            <div class="container">
                                                <h2>堆叠表单</h2>
                                                <form action="/carType" method="post" id="form1">
                                                    <input type="hidden" name="method" value="update">
                                                    <div class="form-group">
                                                        <label for="car_name">汽车:</label>
                                                        <input type="text" class="form-control" id="car_name1"
                                                               placeholder="输入汽车名" name="carName" value="${CarInfo.carType.carName}">
                                                        <span id="eorro11"></span>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="people_num">载客量:</label>
                                                        <input type="text" class="form-control" id="people_num1"
                                                               placeholder="输入载客量" name="peopleNum" value="${CarInfo.carType.peopleNum}">
                                                        <span id="eorro21"></span>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="license_plate">车牌号:</label>
                                                        <input type="text" class="form-control" id="license_plate1"
                                                               placeholder="输入车牌号" name="licensePlate" value="${CarInfo.carType.licensePlate}">
                                                        <span id="eorro31"></span>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="route_start">起始地:</label>
                                                        <input type="text" class="form-control" id="route_start1"
                                                               placeholder="输入起始地" name="routeStart" value="${CarInfo.routeStart}">
                                                        <span id="eorro41"></span>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="route_end">终点:</label>
                                                        <input type="text" class="form-control" id="route_end1"
                                                               placeholder="输入终点" name="routeEnd" value="${CarInfo.routeEnd}">
                                                        <span id="eorro51"></span>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="car_start_time">起始时间:</label>
                                                        <input type="text" class="form-control" id="car_start_time1"
                                                               placeholder="输入起始时间" name="car_start_time" value="${CarInfo.car_start_time}">
                                                        <span id="eorro61"></span>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="probably_time">probably_time:</label>
                                                        <input type="text" class="form-control" id="probably_time1"
                                                               placeholder="耗时" name="probably_time" value="${CarInfo.probably_time}">
                                                        <span id="eorro71"></span>
                                                    </div>

                                                    <button type="submit" class="btn btn-primary">提交添加</button>
                                                </form>
                                            </div>
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
                            <a href="/carType?method=delete&id=${CarInfo.id}&licensePlate=${CarInfo.carType.licensePlate}"
                               class="text-danger">删除</a>
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
    <div class="fixed-bottom text-dark bg-light">桂公网安备
        000000000001号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>网站浏览量：${applicationScope.countPeo}次</span>
    </div>

</div>

</body>
</html>
