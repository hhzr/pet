<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>添加饲养宠物</title>
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
        <div id="left"></div>
        <!-- 主体内容 -->
        <div class="layui-body" id="LAY_app_body">
            <div class="layui-fluid">
                <div class="layui-card">
                    <div class="layui-card-header">添加饲养宠物</div>
                    <div class="layui-card-body" style="padding: 15px;">
                        <form class="layui-form" action="/modifyRearingPet?id=${rearingPet.id}" content="json"
                              method="post" lay-filter="component-form-group">

                            <div class="layui-form-item">
                                <label class="layui-form-label">父亲</label>
                                <div class="layui-input-block">
                                    <input type="text" name="petFather" lay-verify="required"
                                           value="${rearingPet.petFather}"
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label class="layui-form-label">母亲</label>
                                <div class="layui-input-block">
                                    <input type="text" name="petMother" lay-verify="required"
                                           value="${rearingPet.petMother}"
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label class="layui-form-label">名字</label>
                                <div class="layui-input-block">
                                    <input type="text" name="petName" lay-verify="required"
                                           value="${rearingPet.petName}"
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <div class="layui-inline">
                                    <label class="layui-form-label">出生日期</label>
                                    <div class="layui-input-inline">
                                        <input type="text" name="petBirthday" id="LAY-component-form-group-date"
                                               lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off"
                                               class="layui-input" value="${rearingPet.petBirthday}">
                                    </div>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label class="layui-form-label">颜色</label>
                                <div class="layui-input-block">
                                    <input type="text" name="petColour" lay-verify="required"
                                           value="${rearingPet.petColour}"
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <div class="layui-inline">
                                    <label class="layui-form-label">体重</label>
                                    <div class="layui-input-inline">
                                        <input type="text" name="petWeight" lay-verify="required|number"
                                               value="${rearingPet.petWeight}" autocomplete="off" class="layui-input">
                                    </div>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label class="layui-form-label">配偶</label>
                                <div class="layui-input-block">
                                    <input type="text" name="petSpouse" value="${rearingPet.petSpouse}"
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>

                            <div class="layui-form-item layui-form-text">
                                <label class="layui-form-label">性格</label>
                                <div class="layui-input-block">
                                    <textarea name="petCharacter"
                                              class="layui-textarea">${rearingPet.petCharacter!}</textarea>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <div class="layui-inline">
                                    <label class="layui-form-label">公母</label>
                                    <div class="layui-input-inline">
                                        <select name="petGender" lay-verify="required">
                                            <option value="">请选择公母</option>
                                            <#if rearingPet.petGender == 1>
                                                <option value="1" selected>公</option>
                                                <option value="2">母</option>
                                            <#else>
                                                <option value="1">公</option>
                                                <option value="2" selected>母</option>
                                            </#if>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">健康状况</label>
                                <div class="layui-input-block">
                                    <#if rearingPet.petHealth == 1>
                                        <input type="checkbox" name="qc" title="驱虫" value="1" checked>
                                        <input type="checkbox" name="kq" title="打狂犬疫苗" value="1" checked>
                                    </#if>
                                    <#if rearingPet.petHealth == 2>
                                        <input type="checkbox" name="qc" title="驱虫" value="1" checked>
                                        <input type="checkbox" name="kq" title="打狂犬疫苗" value="1">
                                    </#if>
                                    <#if rearingPet.petHealth == 3>
                                        <input type="checkbox" name="qc" title="驱虫" value="1">
                                        <input type="checkbox" name="kq" title="打狂犬疫苗" value="1" checked>
                                    </#if>
                                    <#if rearingPet.petHealth == 4>
                                        <input type="checkbox" name="qc" title="驱虫" value="1">
                                        <input type="checkbox" name="kq" title="打狂犬疫苗" value="1">
                                    </#if>
                                </div>
                            </div>

                            <div class="layui-form-item layui-form-text">
                                <label class="layui-form-label">备注</label>
                                <div class="layui-input-block">
                                    <textarea name="petPs" class="layui-textarea">${rearingPet.petPs!}</textarea>
                                </div>
                            </div>

                            <div class="layui-form-item layui-layout-admin">
                                <div class="layui-input-block">
                                    <button class="layui-btn" lay-submit="" lay-filter="sub">
                                        保存
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="layui/layui.js"></script>
<script src="layui/layui.all.js"></script>
<script src="jquery.min.js"></script>
<script>
    layui.config({
        base: '/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'form', 'laydate'], function () {
        var $ = layui.$
            , admin = layui.admin
            , element = layui.element
            , layer = layui.layer
            , laydate = layui.laydate
            , form = layui.form;

        form.render(null, 'component-form-group');

        laydate.render({
            elem: '#LAY-component-form-group-date'
        });

        /* 自定义验证规则 */
        form.verify({});

        /* 监听提交 */
        form.on('submit(sub)');
    });
</script>
</body>
</html>
