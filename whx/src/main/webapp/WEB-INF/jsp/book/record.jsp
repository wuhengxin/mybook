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
                <form class="layui-form layui-from-pane" action="" method="post">
                    <div class="layui-card-body">
                        <table id="demo" lay-filter="test"></table>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="layui-row" id="popUpdateBook" style="display:none;">
    <div class="layui-col-md10">
        <form class="layui-form layui-from-pane" action="" style="margin-top:20px">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">图书编号</label>
                    <div class="layui-input-block">
                        <input type="hidden" id="id" name="id" lay-verify="required" autocomplete="off"
                               placeholder="记录编号" class="layui-input" >
                        <input type="text" id="bId" name="bId" lay-verify="required" autocomplete="off"
                               placeholder="请输入图书编号" class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">图书名称</label>
                    <div class="layui-input-block">
                        <input type="text" id="bName" name="bName" lay-verify="required" autocomplete="off"
                               placeholder="请输入名称" class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">图书数量</label>
                    <div class="layui-input-block">
                        <input type="text" id="account" name="account" lay-verify="required" autocomplete="off"
                               placeholder="请输入数量" class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">租借人</label>
                    <div class="layui-input-block">
                        <input type="text" id="eName" name="eName" lay-verify="required" autocomplete="off"
                               placeholder="租借人姓名" class="layui-input">
                        <input type="hidden" id="employee_id" name="employee_id" lay-verify="required" autocomplete="off"
                               placeholder="租借人工号" class="layui-input" >
                    </div>
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">状态</label>
                <div class="layui-input-inline">
                    <select name="state" id="state" lay-verify="required">
                        <option value="0">归还</option>
                    </select>
                </div>
            </div>

            <div class="layui-form-item">
                <button class="layui-btn" lay-submit lay-filter="updateFormBtn"
                        style="margin-left: 120px">确认归还
                </button>
            </div>
        </form>
    </div>
</div>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-sm layui-btn-normal" lay-event="edit">归还</a>
    <a class="layui-btn layui-btn-sm layui-btn-danger" lay-event="del">删除</a>
</script>


<script src="<%=contextPath%>/layui/layui.js"></script>
<script>
    layui.use(['table', 'form'], function () {
        var table = layui.table;
        var form = layui.form;
        //第一个实例
        table.render({
            elem: '#demo'
            , height: 400
            , url: '<%=contextPath%>/record/recordList1/?keyword=1' //数据接口
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
                ,
                {
                    fixed: 'right', title: '操作', toolbar: '#barDemo', width: 160
                }

            ]]
        });

        table.on('tool(test)', function (obj) {
            var data = obj.data;
            if (obj.event == 'edit') {
                layer.open({
                    type: 1,
                    title: "归还图书",
                    area: ['480px', '510px'],
                    content: $("#popUpdateBook"),
                    success: function () {
                        //回显数据
                        $("#id").val(data.id);
                        $("#bId").val(data.books.bId);
                        $("#bName").val(data.books.bName);
                        $("#account").val(data.account);
                        $("#employee_id").val(data.employee.id);
                        $("#eName").val(data.employee.name);
                    },
                });
            }
        });

        //更新操作
        form.on('submit(updateFormBtn)', function (data) {
            //发送ajax请求
            $.ajax({
                url: '<%=contextPath%>/record/updateRecord',
                data: JSON.stringify(data.field),
                type: 'POST',
                contentType: 'application/json',  //数据类型格式
                success: function (result) {
                    if (result == "success") {
                        layer.closeAll();
                        layer.msg('更新成功', {time: 1 * 1000}, function () {
                            location.reload();
                        });
                    } else {
                        layer.closeAll();
                        layer.msg('更新失败', {time: 1 * 1000}, function () {
                            location.reload();
                        });
                    }
                },
                error: function (errorMsg) {
                    alert("数据异常！" + errorMsg);
                    location.reload();
                },
            });
            return false;
        });

        //监听查询点击事件
        form.on('submit(queryForm)', function (data) {
            table.render({
                elem: '#demo'
                , height: 312
                , url: '<%=contextPath%>/record/recordList1?page=1&limit=10&keyword=1'+'&keyword1=' + data.field.bName + '&keyword2=' + data.field.name //后台数据接口
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
                    ,
                    {
                        fixed: 'right', title: '操作', toolbar: '#barDemo', width: 160
                    }
                ]]
            });
            return false;
        });
    });
</script>
</body>
</html>