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
    <link rel="shortcut icon" href="img/favicon.ico" >
    <title>首页</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" type="text/css" href="./css/main.css"/>
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="./css/index.css">
    <script src="./js/jquery-3.4.1.js" type="text/javascript" charset="utf-8"></script>
    <script src="./js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="./js/bootstrap.bundle.js" type="text/javascript" charset="utf-8"></script>
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="http://code.highcharts.com/highcharts.js"></script>
    <script src="http://code.highcharts.com/modules/treemap.js"></script>
    <script src="http://code.highcharts.com/modules/heatmap.js"></script>
    <style type="text/css">
        .carbg {
            background-image: url(./img/bg1.jpg);
            background-repeat: no-repeat;
            background-size: cover;
            color: black;
        }
    </style>
    <script language="JavaScript">
        var zzz = [];
        var obj4 = null;
        var obj3 = null;
        $(document).ready(function() {
            var chart1 = {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            };
            var title1 = {
                text: '各类车票剩余票数总占比'
            };
            var tooltip1 = {
                pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
            };
            var plotOptions1 = {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        format: '<b>{point.name}%</b>: {point.percentage:.1f} %',
                        style: {
                            color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                        }
                    }
                }
            };
            var series1 = [{
                type: 'pie',
                name: 'Browser share',
                data: [
                    ['剩余票数为1-5票', 37.5],
                    ['剩余票数为6-10票', 18.75], {
                        name: '剩余票数为11-15票',
                        y: 18.75,
                        sliced: true,
                        selected: true
                    },
                    ['剩余票数为16-20票', 25.0],
                ]
            }];

            var json1 = {};
            json1.chart = chart1;
            json1.title = title1;
            json1.tooltip = tooltip1;
            json1.series = series1;
            json1.plotOptions = plotOptions1;
            $('#container1').highcharts(json1);


            var title2 = {
                text: '各类车型的数量'
            };

            var colorAxis2 = {
                minColor: '#FFFFFF',
                maxColor: Highcharts.getOptions().colors[0]
            };

            var series2 = [{
                type: "treemap",
                layoutAlgorithm: 'squarified',
                data: [{
                    name: '五菱之光',
                    value: 1,
                    colorValue: 1
                }, {
                    name: '五菱神光',
                    value: 1,
                    colorValue: 2
                }, {
                    name: '五菱荣光',
                    value: 1,
                    colorValue: 3
                }, {
                    name: '五菱发光',
                    value: 2,
                    colorValue: 4
                }, {
                    name: '霸龙重卡',
                    value: 2,
                    colorValue: 5
                }, {
                    name: '擎天柱',
                    value: 2,
                    colorValue: 6
                }, {
                    name: '大黄蜂',
                    value: 3,
                    colorValue: 7
                }, {
                    name: '红蜘蛛',
                    value: 2,
                    colorValue: 8
                }, {
                    name: '宝骏630',
                    value: 2,
                    colorValue: 9
                }, {
                    name: '五菱神车',
                    value: 1,
                    colorValue: 10
                }, {
                    name: '五菱魔改',
                    value: 2,
                    colorValue: 11
                }, {
                    name: '霸天虎',
                    value: 3,
                    colorValue: 12
                }, {
                    name: '威震天',
                    value: 2,
                    colorValue: 13
                }, {
                    name: '乘风大运',
                    value: 2,
                    colorValue: 14
                }, {
                    name: '大Q吧',
                    value: 2,
                    colorValue: 15
                }, {
                    name: '奔驰客运',
                    value: 2,
                    colorValue: 16
                }, ]
            }];

            var json2 = {};
            json2.title = title2;
            json2.colorAxis = colorAxis2;
            json2.series = series2;

            $('#container2').highcharts(json2);


            var chart3 = {
                type: 'column'
            };
            var title3 = {
                text: '各车载客信息'
            };
            var subtitle3 = {
                text: 'Source: runoob.com'
            };
            var xAxis3 = {
                categories: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16'],
                crosshair: true
            };
            var yAxis3 = {
                min: 0,
                title: {
                    text: '各车信息'
                }
            };
            var tooltip3 = {
                headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                    '<td style="padding:0"><b>{point.y:.1f} 人次</b></td></tr>',
                footerFormat: '</table>',
                shared: true,
                useHTML: true
            };
            var plotOptions3 = {
                column: {
                    pointPadding: 0.2,
                    borderWidth: 0
                }
            };
            var credits3 = {
                enabled: false
            };

            var series3 = [{
                name: '车型',
                data: []
            }, {
                name: '最大乘坐量',
                data: []
            }, {
                name: '实际乘坐量',
                data: []
            }];

            var json3 = {};
            json3.chart = chart3;
            json3.title = title3;
            json3.subtitle = subtitle3;
            json3.tooltip = tooltip3;
            json3.xAxis = xAxis3;
            json3.yAxis = yAxis3;
            json3.series = series3;
            json3.plotOptions = plotOptions3;
            json3.credits = credits3;
            obj3 = Highcharts.chart('container3',json3)
            //ajax start
            function requestData1(){
                $.ajax({
                    url: '/countNum?method=zhuxing',
                    success: function(point) {
                        var data = JSON.parse(point)
                        var arr_x = []
                        var arr_y = []
                        var arr_z = []
                        for (var i = 0 ; i < data.length ; i++){
                            // console.log(data[i])
                            arr_x[i] = data[i].ticketInfoId
                            arr_y[i] = data[i].ticketNum
                            arr_z[i] = data[i].ticketSum
                        }
                        obj3.series[0].setData(arr_x)
                        obj3.series[1].setData(arr_y)
                        obj3.series[2].setData(arr_z)
                        // 一秒后继续调用本函数
                        setTimeout(requestData1, 10000);
                    },
                    cache: false
                });
            }
            requestData1();
            //ajax end

            obj4 = Highcharts.chart('container4',{
                chart: {
                    type: 'line'
                },
                xAxis: {
                    categories: []
                },

                yAxis: {
                    title: {
                        text: '预计行驶时间'
                    }
                },
                plotOptions: {
                    series: {
                        allowPointSelect: true
                    }
                },
                title: {
                    text: '各行车路线预计行驶时间'
                },
                series: [{
                    data : []
                }]

            });

            /**
             * ajax
             */
            function requestData(){
                $.ajax({
                    url: '/countNum?method=zhexian',
                    success: function(point) {
                        var data = JSON.parse(point)
                        var arr_x = []
                        var arr_y = []
                        for (var i = 0 ; i < data.length ; i++){
                            // console.log(data[i])
                            arr_x[i] = data[i].name
                            arr_y[i] = data[i].num
                        }
                        obj4.xAxis[0].setCategories(arr_x)
                        obj4.series[0].setData(arr_y)
                        // 一秒后继续调用本函数
                        setTimeout(requestData, 10000);
                    },
                    cache: false
                });
            }
            requestData();
            // the button action
            $('#button').click(function() {
                var chart = $('#container').highcharts(),
                    selectedPoints = chart.getSelectedPoints();
                if (chart.lbl) {
                    chart.lbl.destroy();
                }
                chart.lbl = chart.renderer.label('You selected ' + selectedPoints.length + ' points', 100, 60)
                    .attr({
                        padding: 10,
                        r: 5,
                        fill: Highcharts.getOptions().colors[1],
                        zIndex: 5
                    })
                    .css({
                        color: 'white'
                    })
                    .add();
            });


        });
    </script>
</head>
<body>

<div class=" .container-fluid">

    <div class="jumbotron carbg">
        <h1 class="display-4">Neusoft车站管理系统</h1>
        <p class="lead">javaweb项目实战</p>
        <hr class="my-4">
        <p>指导老师：曾理国</p>
        <p>小组成员：叶秋妤，刘真成，张建军，郭佳顺，陆昌豪</p>
    </div>

    <div class="container mb-5">
        <%-- 导航栏--%>
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
                                <a class="nav-link disabled" href="#">尊敬的${admin.username}用户<span
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


        <%--        数据报表--%>
        <div class="row">
            <div class="col-sm-12 col-md-12 col-lg-6">
                <div id="container3" class="row" style="width: 600px;height:400px;margin: 0 auto"></div>
            </div>
            <div class="col-sm-12 col-md-12 col-lg-6">
                <div id="container4" class="row" style="width: 600px;height:400px;margin: 0 auto"></div>
            </div>
            <div class="col-sm-12 col-md-12 col-lg-6">
                <div id="container1" class="row" style="width: 550px; height: 400px; margin: 0 auto"></div>
            </div>
            <div class="col-sm-12 col-md-12 col-lg-6">
                <div id="container2" class="row" style="width: 600px; height: 550px; margin: 0 auto"></div>
            </div>




        </div>

    </div>
    <div class="fixed-bottom text-dark bg-light">桂公网安备
        000000000001号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>网站浏览量：${applicationScope.countPeo}次</span>
    </div>

</div>
</body>
</html>