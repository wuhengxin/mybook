<%@ page import="com.crm.context.UserContext" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String contextPath = request.getContextPath();

%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>图书后台管理</title>
    <link rel="stylesheet" href="<%=contextPath%>/layui/css/layui.css">
</head>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">图书管理系统</div>

        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="<%=contextPath%>/images/ic_sys.png" class="layui-nav-img">
                    <%=UserContext.getCurrentUser().getLoginname()%>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;" target="iframe">基本资料</a></dd>
                    <dd><a href="javascript:;" target="iframe">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="<%=contextPath%>/loginOut">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;">用户管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=contextPath%>/admin/userView" target="iframe">用户查询</a></dd>
                        <dd><a href="<%=contextPath%>/admin/addView" target="iframe">添加用户</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">职位管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=contextPath%>/position/positionView" target="iframe">职位查询</a></dd>
                        <dd><a href="<%=contextPath%>/position/addView" target="iframe">添加职位</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">部门管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=contextPath%>/department/deptView" target="iframe">部门查询</a></dd>
                        <dd><a href="<%=contextPath%>/department/deptAddView" target="iframe">添加部门</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">员工管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=contextPath%>/employee/empView" target="iframe">员工查询</a></dd>
                        <dd><a href="<%=contextPath%>/employee/empAddView" target="iframe">添加员工</a></dd>
                    </dl>
                </li>

                <li class="layui-nav-item">
                    <a href="javascript:;">图书管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=contextPath%>/books/bookView" target="iframe">图书查询</a></dd>
                        <dd><a href="<%=contextPath%>/books/bookAddView" target="iframe">添加图书</a></dd>
                        <dd><a href="<%=contextPath%>/books/bookAddRecord" target="iframe">图书租借</a></dd>
                        <dd><a href="<%=contextPath%>/books/bookSearchRecord" target="iframe">图书归还</a></dd>
                        <dd><a href="<%=contextPath%>/books/recordHistory" target="iframe">租借记录</a></dd>
                        <dd><a href="<%=contextPath%>/books/recordAllHistory" target="iframe">记录查询</a></dd>
                    </dl>
                </li>

                <li class="layui-nav-item">
                    <a href="javascript:;">系统设置</a>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=contextPath%>/loginOut">退出系统</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 2px;">
            <iframe name="iframe" width="100%" height="650px" frameborder="0"
                    class="xiframe" scrolling="no" src="<%=contextPath%>/hello"></iframe>
        </div>

    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        <span style="margin-left: 500px">
              © 2020 Fixed star-图书管理系统-VVVVV
        </span>

    </div>
</div>
<script src="<%=contextPath%>/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });

</script>
</body>
</html>