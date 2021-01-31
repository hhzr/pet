<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<html>
<head>
    <meta charset="utf-8">
    <title>主页</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="layui/css/layui.css" media="all">
    <link rel="stylesheet" href="style/admin.css" media="all">
</head>
<body class="layui-layout-body">

<div id="LAY_app">
    <div class="layui-layout layui-layout-admin">
        <!-- 头 -->
        <#include "common/head.ftl"/>
        <!-- 侧边菜单 -->
        <#include "common/letf.ftl"/>
        <div id="left"></div>
        <!-- 主体内容 -->
        <div class="layui-body" id="LAY_app_body">
            <div class="layadmin-tabsbody-item layui-show">
                <div class="layui-fluid">
                    <div class="layui-row layui-col-space15">
                        <div class="layui-col-md12">
                            <div class="layui-row layui-col-space15">
                                <div class="layui-col-md12">
                                    <div class="layui-card">
                                        <div class="layui-card-header">信息总览</div>
                                        <div class="layui-card-body">
                                            <div class="layui-carousel layadmin-carousel layadmin-backlog">
                                                <div carousel-item>
                                                    <ul class="layui-row layui-col-space10">
                                                        <li class="layui-col-xs6">
                                                            <div class="layadmin-backlog-body">
                                                                <h3>会员数</h3>
                                                                <p><cite id="vip"></cite></p>
                                                            </div>
                                                        </li>
                                                        <li class="layui-col-xs6">
                                                            <div class="layadmin-backlog-body">
                                                                <h3>宠物总数</h3>
                                                                <p><cite id="petNum"></cite></p>
                                                            </div>
                                                        </li>
                                                        <li class="layui-col-xs6">
                                                            <div class="layadmin-backlog-body">
                                                                <h3>饲养总数</h3>
                                                                <p><cite id="rearing"></cite></p>
                                                            </div>
                                                        </li>
                                                        <li class="layui-col-xs6">
                                                            <div class="layadmin-backlog-body">
                                                                <h3>寄养总数</h3>
                                                                <p><cite id="fostercare"></cite></p>
                                                            </div>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="jquery.min.js"></script>
<script src="layui/layui.js"></script>
<script>
    layui.config({
        base: '/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'console']);
</script>
<script>
    var url = '';
    $.getJSON("json/package.json", function (data) {
        url = data.ipaddr
    })


    $.ajax({
        url: url + "/indexInfo",
        type: 'get',
        dataType: 'json',
        success: function (response) {
            // console.log(response.data.vipCount)
            $("#vip").html(response.data.vipCount)
            $("#rearing").html(response.data.rearingCount)
            $("#fostercare").html(response.data.fosterCareCount)
            $("#petNum").html(response.data.rearingCount + response.data.fosterCareCount)
        }
    })
</script>
</body>
</html>


