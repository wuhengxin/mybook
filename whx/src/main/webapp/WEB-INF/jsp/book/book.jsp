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
    <legend style="text-align: center">图书查询界面</legend>
</fieldset>
<div style="padding: 20px; background-color: #F2F2F2;">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">图书信息列表</div>
                <form class="layui-form layui-from-pane" action="" method="post">
                    <div class="layui-card-body">
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">书名:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="books" placeholder="请输入需要查询的书名"
                                           class="layui-input">
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">图书状态:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="name" placeholder="《1为上架 0为下架》"
                                           class="layui-input">
                                </div>
                            </div>
                            <button class="layui-btn" lay-submit lay-filter="selectBook"
                                    style="margin-left: 120px">立即查询
                            </button>
                        </div>
                        <table id="book" lay-filter="test"></table>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<%--
这里是弹出层的表单信息
表单的id用于表单的选择，style是在本页隐藏，只有点击编辑才会弹出
--%>
<div class="layui-row" id="popUpdateBook" style="display:none;">
    <div class="layui-col-md10">
        <form class="layui-form layui-from-pane" action="" style="margin-top:20px">
            <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">图书编号</label>
                        <div class="layui-input-block">
                            <input type="text" id="bId" name="bId" lay-verify="required" autocomplete="off"
                                   placeholder="请输入联系地址" class="layui-input">
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
                        <input type="text" id="bAccount" name="bAccount" lay-verify="required" autocomplete="off"
                               placeholder="请输入数量" class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">图书描述</label>
                    <div class="layui-input-block">
                        <input type="text" id="bDescribe" name="bDescribe" lay-verify="required" autocomplete="off"
                               placeholder="请输入相关描述" class="layui-input">
                    </div>
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">状态</label>
                <div class="layui-input-inline">
                    <select name="bState" id="bState" lay-verify="required">
                        <option value="">请选择状态</option>
                        <option value="1">上架</option>
                        <option value="0">下架</option>
                    </select>
                </div>
            </div>

            <div class="layui-form-item">
                <button class="layui-btn" lay-submit lay-filter="updateFormBtn"
                        style="margin-left: 120px">立即更新
                </button>
            </div>
        </form>
    </div>
</div>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-sm layui-btn-normal" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-sm layui-btn-danger" lay-event="del">删除</a>
</script>

<script src="<%=contextPath%>/layui/layui.js"></script>
<script>

    layui.use(['table', 'form'], function () {
        var table = layui.table;
        var form = layui.form;

        table.render({
            elem: '#book'
            , height: 312
            , url: '<%=contextPath%>/books/bookList' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                , {field: 'bId', title: '图书编号', width: 200}
                , {field: 'bName', title: '图书名称', width: 200}
                ,{field: 'bAccount', title: '图书数量', width: 200}
                ,{field: 'bDescribe', title: '相关描述', width: 300}
                ,{field: 'bState', title: '图书状态', width: 100,templet: function (item){
                        if (item.bState == '1') {
                            return "已上架";
                        }else{
                            return "未上架";
                        }
                    }}
                ,{
                    fixed: 'right', title: '操作', toolbar: '#barDemo', width: 180
                }
            ]]
        });

        //监听职位查询按钮
        form.on('submit(selectBook)', function (data) {
            console.log("----->" + data.field.books);
            table.render({
                elem: '#book'
                , height: 312
                , url: '<%=contextPath%>/books/bookList1?page=1&limit=10'+'&keyword1=' + data.field.books + '&keyword2=' + data.field.name //数据接口
                , page: true //开启分页
                , cols: [[ //表头
                    {type: 'checkbox', fixed: 'left'}
                    , {field: 'bId', title: '图书编号', width: 200}
                    , {field: 'bName', title: '图书名称', width: 200}
                    ,{field: 'bAccount', title: '图书数量', width: 200}
                    ,{field: 'bDescribe', title: '相关描述', width: 300}
                    ,{field: 'bState', title: '图书状态', width: 100,templet: function (item){
                            if (item.bState == '1') {
                                return "已上架";
                            }else{
                                return "未上架";
                            }
                        }
                    }
                    ,{
                        fixed: 'right', title: '操作', toolbar: '#barDemo', width: 180
                    }
                ]]

            });
            return false;
        });


        // 监听行工具事件
        table.on('tool(test)', function (obj) {
            var data = obj.data;
            if (obj.event === 'del') {
                layer.confirm('真的删除图书：\t' + data.bName + "\t吗！", function (index) {
                    $.ajax({
                        url: '<%=contextPath%>/books/bookDelete',
                        type: 'GET',
                        data: {'id': data.bId},
                        success: function (result) {
                            if (result == "success") {
                                obj.del();
                                layer.msg("删除成功!" + result, {icon: 6});
                                layer.close(index);
                            } else {
                                layer.msg("删除失败!" + result, {icon: 5});
                            }
                        },
                        error: function (errorMsg) {
                            alert("数据异常！" + errorMsg);
                            location.reload();
                        },
                    });
                });
            }else if (obj.event == 'edit') {
                layer.open({
                    type: 1,
                    title: "更新用户",
                    area: ['480px', '510px'],
                    content: $("#popUpdateBook"),
                    success: function () {
                        //回显数据
                        $("#bId").val(data.bId);
                        $("#bName").val(data.bName);
                        $("#bAccount").val(data.bAccount);
                        $("#bDescribe").val(data.bDescribe);
                        $("#bState").val(data.bState);
                    },
                });
            }
        });

        //更新操作
        form.on('submit(updateFormBtn)', function (data) {
            //发送ajax请求
            $.ajax({
                url: '<%=contextPath%>/books/bookUpdate',
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
    });
</script>
</body>
</html>
