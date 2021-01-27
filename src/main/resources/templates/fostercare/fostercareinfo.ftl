<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>饲养宠物查询</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="layui/css/layui.css" media="all">
    <link rel="stylesheet" href="style/admin.css" media="all">
</head>

<body>
<div id="LAY_app">
    <div class="layui-layout layui-layout-admin">
        <!-- 头 -->
        <#include "../common/head.ftl"/>
        <!-- 侧边菜单 -->
        <#include "../common/letf.ftl"/>
        <div class="layui-body" id="LAY_app_body">
            <div class="layui-fluid">
                <div class="layui-row layui-col-space15">
                    <div class="layui-col-md12">
                        <div class="layui-card">
                            <div class="layui-card-header">寄养信息</div>
                            <div class="layui-card-body">
                                <table class="layui-hide" id="test-table-page" lay-filter="reportTable"></table>
                                <script type="text/html" id="delivery-table-operate">
                                    <a class="layui-btn layui-btn-xs"
                                       href="/toModifyFosterCarePet?id={{d.id}}">修改</a>
                                    <buttron class="layui-btn layui-btn-xs layui-btn-danger"
                                             onclick="del({{d.id}})">删除
                                    </buttron>
                                </script>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<input hidden id="addCode" value="${addCode!}">
<input hidden id="modifyCode" value="${modifyCode!}">
<script src="layui/layui.js"></script>
<script src="jquery.min.js"></script>
<script>
    var url = '';
    $.getJSON("json/package.json", function (data) {
        url = data.ipaddr
    })


    layui.use('layer', function () {
        var layer = layui.layer;
        let addCode = $("#addCode").val();
        if (addCode != null && addCode != '' && addCode == 200) {
            layer.msg("添加成功");
        }
        let modifyCode = $("#modifyCode").val();
        if (modifyCode != null && modifyCode != '' && modifyCode == 200) {
            layer.msg("修改成功");
        }
    });

    function del(id) {
        layer.alert(id);
        layer.confirm('删除当前宠物？', {
            btn: ['确定', '取消'] //按钮
        }, function () {
            $.ajax({
                url: url + "/delRearingPet?id=" + id,
                success: function (result) {
                    if (result.code == 200) {
                        // layer.msg(result.message);
                        window.location.href = "/toRearingPet"
                    }
                }
            });
        }, function () {
            layer.msg('取消删除')
        });
    }
</script>
<script>
    layui.config({
        base: '' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'table'], function () {
        var admin = layui.admin
            , table = layui.table;
        table.render({
            elem: '#test-table-page'
            , url: "/fosterCarePet"
            , cols: [[
                {align: 'center', field: 'id', width: 50, title: 'ID'}
                , {align: 'center', field: 'theHostName', width: 100, title: '主人'}
                , {align: 'center', field: 'phone', width: 150, title: '手机号'}
                , {align: 'center', field: 'petName', width: 100, title: '宠物名'}
                , {align: 'center', field: 'petAge', width: 100, title: '年龄'}
                , {align: 'center', field: 'petVariety', width: 100, title: '品种'}
                , {align: 'center', field: 'petWeight', width: 100, title: '体重(KG)'}
                , {align: 'center', field: 'petColour', width: 100, title: '颜色'}
                , {align: 'center', field: 'petLike', width: 200, title: '喜好'}
                , {align: 'center', field: 'gender', width: 100, title: '性别'}
                , {align: 'center', field: 'health', width: 180, title: '是否驱虫打疫苗'}
                , {align: 'center', field: 'petCharacter', width: 180, title: '性格'}
                , {align: 'center', field: 'stareTime', width: 180, title: '寄养时间'}
                , {align: 'center', field: 'petFosterCareTime', width: 180, title: '寄养时长'}
                , {align: 'center', toolbar: '#delivery-table-operate', width: 177, title: '操作'}
            ]]
            , page: true
            , text: {none: "暂无数据，请添加"}
        });
    });
</script>
</body>

</html>