<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=contextPath%>/layui/css/layui.css" media="all">
    <script type="text/javascript" src="<%=contextPath%>/static/jquery-2.1.3.min.js"></script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend style="text-align: center">员工查询界面</legend>
</fieldset>
<div style="padding: 20px; background-color: #F2F2F2;">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">员工信息列表</div>
                <form action="" method="post">
                    <table id="demo" lay-filter="test"></table>
                </form>
            </div>
        </div>
    </div>
</div>


<script src="<%=contextPath%>/layui/layui.js"></script>
<script>
    layui.use(['table', 'form'], function () {
        var table = layui.table;
        var form = layui.form;
        //第一个实例
        table.render({
            elem: '#demo'
            , height: 400
            , url: '<%=contextPath%>/employee/empList' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                , {field: 'name', title: '姓名', width: 90}
                , {field: 'sex', title: '性别', width: 60}
                , {field: 'phone', title: '手机号', width: 120}
                , {field: 'email', title: '邮箱', width: 140}
                , {field: 'positionId', templet: '<div>{{d.positionId.positionname}}</div>', title: '职位', width: 150}
                , {field: 'eduschool', title: '学历', width: 70}
                , {field: 'idcard', title: '身份证', width: 180}
                , {field: 'deptId', templet: '<div>{{d.deptId.deptname}}</div>', title: '部门', width: 80}
                , {field: 'address', title: '坐标地址', width: 150}
                , {field: 'state', title: '状态', width: 180}
                , {field: 'createtime', title: '建档日期', width: 180}
            ]]
        });
        //动态加载职位
        $.ajax({
            url: "<%=contextPath%>/position/positionOption",
            type: 'POST',
            dataType: 'json',
            success: function (result) {
                var list = result; //返回的数据
                for (var i = 0; i < list.length; i++) {
                    //追加option
                    $("#positionId").append("<option value=" + list[i].id + ">" + list[i].positionname + "</option>");
                    //渲染刷新
                    form.render('select');
                }
            },
        });
        //动态加载部门option
        $.ajax({
            url: '<%=contextPath%>/department/deptOption',
            type: 'POST',
            dataType: 'json',
            success: function (result) {
                var list = result;
                for (var i = 0; i < list.length; i++) {
                    //追加option
                    $("#deptId").append("<option value=" + list[i].id + ">" + list[i].deptname + "</option>");
                    //渲染刷新
                    form.render('select');
                }
            },
        });
        });
</script>
</body>
</html>