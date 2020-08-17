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
    <legend style="text-align: center">归还信息受理界面</legend>
</fieldset>
<div style="padding: 20px; background-color: #F2F2F2;">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">租借信息列表</div>
                <hr class="layui-bg-blue">
                <hr class="layui-bg-black">
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
            , url: '<%=contextPath%>/record/recordList1/?keyword=0' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                , {field: 'books', templet: '<div>{{d.books.bName}}</div>', title: '书名', width: 180}
                , {field: 'employee', templet: '<div>{{d.employee.name}}</div>', title: '租借人', width: 150}
                , {field: 'account', title: '租借数量', width: 100}
                , {field: 'state', title: '状态', width: 100,templet: function (item){
                        if (item.state == '1') {
                            return "租借中";
                        }else{
                            return "已归还";
                        }
                    }}
                , {field: 'createTime', title: '租借日期', width: 180}
                , {field: 'completionTime', title: '归还日期', width: 180}
            ]]
        });
    });
</script>
</body>
</html>