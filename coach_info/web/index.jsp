<%--
  Created by IntelliJ IDEA.
  User: 老白
  Date: 2021/1/4
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <title>首页</title>
  <link rel="stylesheet" type="text/css" href="./css/main.css" />
  <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css" />
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
    $(function(){
      $("#next").click(function(){
        var pages = parseInt($("#pages").html());
        var page = parseInt($("#currentPage").html());
        if(page == pages){
          return;
        }
        page++;
        location.href = "/carType?page="+page;
      })

      $("#previous").click(function () {
        var page = parseInt($("#currentPage").html());
        if(page == 1){
          return;
        }
        page--;
        location.href = "/carType?page="+page;
      })

      $("#first").click(function () {
        location.href = "/carType?page=1";
      })

      $("#last").click(function(){
        var pages = parseInt($("#pages").html());
        location.href = "/carType?page="+pages;
      })
    })
  </script>
</head>
<body>

<div class=" .container-fluid">

  <div class="jumbotron carbg">
    <h1 class="display-4">Neusoft车站管理系统</h1>
    <p class="lead">javaweb项目实战</p>
    <hr class="my-4">
    <p>小组成员：叶秋妤，刘真成，张建军，郭佳顺，陆昌豪</p>
  </div>

  <div class="container">

    <div class="row bg-light rounded">
      <div class="col-sm-12">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">

          <a class="navbar-brand disabled" href="#">Neusoft车站管理系统</a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                  aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>

          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
              <li class="nav-item active">
                <a class="nav-link text-secondary" href="#">首页 <span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item ">
                <a class="nav-link text-secondary" href="#">购票信息页 <span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item ">
                <a class="nav-link text-secondary" href="#">购票记录表 <span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item ">
                <a class="nav-link text-secondary" href="#">车辆信息页 <span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item ">
                <a class="nav-link text-secondary" href="#">车票信息页 <span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item">
                <a class="nav-link text-secondary" href="#">发车记录表 <span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item active">
                <a class="nav-link disabled" href="#">尊敬的xxx用户 <span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item ">
                <a class="nav-link text-primary" href="#">退出登录 <span class="sr-only">(current)</span></a>
              </li>
            </ul>

          </div>
        </nav>
      </div>
    </div>


    <div class="row border rounded">

      <table class="table table-hover ">
        <thead>
        <tr>
          <th>汽车名称</th>
          <th>最大承载量(人)</th>
          <th>车牌号</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${sessionScope.list}" var="CarType">
          <tr>
            <td>${CarType.carName}</td>
            <td>${CarType.peopleNum}</td>
            <td>${CarType.licensePlate}</td>
          </tr>

        </c:forEach>

        </tbody>
      </table>

    </div>

    <div class="row">
      <div id="pageControl">
        <div class="pageControl_item ">每页<font id="dataPrePage">${dataPrePage }</font>条数据</div>
        <div class="pageControl_item " id="last">最后一页</div>
        <div class="pageControl_item " id="next">下一页</div>
        <div class="pageControl_item "><font id="currentPage">${currentPage }</font>/<font id="pages">${pages }</font></div>
        <div class="pageControl_item " id="previous">上一页</div>
        <div class="pageControl_item " id="first">首页</div>
      </div>
    </div>

  </div>
</body>
</html>