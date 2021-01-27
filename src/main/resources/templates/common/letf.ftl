<div class="layui-side layui-side-menu">
    <div class="layui-side-scroll">
        <div class="layui-logo" lay-href="indexinfo.html">
            <span>宠物管理</span>
        </div>

        <ul class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu"
            lay-filter="layadmin-system-side-menu">
            <li data-name="home" class="layui-nav-item layui-nav-itemed layui-this">
                <a href="/" lay-tips="主页" lay-direction="2">
                    <i class="layui-icon layui-icon-home"></i>
                    主页
                </a>
            </li>


            <li data-name="senior" class="layui-nav-item">
                <a href="javascript:;" lay-tips="高级" lay-direction="2">
                    <i class="layui-icon layui-icon-senior"></i>
                    <cite>饲养宠物</cite>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="/toRearingPet">饲养查询</a></dd>
                    <dd><a href="/toAddRearingPet">饲养录入</a></dd>
                </dl>
            </li>

            <li data-name="senior" class="layui-nav-item">
                <a href="javascript:;" lay-tips="高级" lay-direction="2">
                    <i class="layui-icon layui-icon-senior"></i>
                    <cite>寄养宠物</cite>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="/toFosterCare">寄养查询</a></dd>
                    <dd><a href="/toAddFosterCare">寄养录入</a></dd>
                </dl>
            </li>

            <li data-name="senior" class="layui-nav-item">
                <a href="javascript:;" lay-tips="高级" lay-direction="2">
                    <i class="layui-icon layui-icon-senior"></i>
                    <cite>会员</cite>
                </a>
                <dl class="layui-nav-child">
                    <dd><a lay-href="vip/vipinfo.html">会员查询</a></dd>
                    <dd><a lay-href="vip/addvip.html">会员办理</a></dd>
                </dl>
            </li>
        </ul>
    </div>
</div>