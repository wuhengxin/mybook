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
    <legend style="text-align: center">客户列表界面</legend>
</fieldset>
<div style="padding: 20px; background-color: #F2F2F2;">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">客户信息列表</div>
                <hr class="layui-bg-blue">
                <hr class="layui-bg-black">
                <form action="" method="post">
                    <table id="demo" lay-filter="test"></table>
                </form>
            </div>
        </div>
    </div>
</div>

<%--隐藏编辑弹窗表单--%>
<div class="layui-row" id="popUpdateEmp" style="display:none;">
    <div class="layui-col-md10">
        <form class="layui-form layui-from-pane" action="" style="margin-top:20px">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">姓名</label>
                    <div class="layui-input-inline">
                        <input id="name" type="text" name="name" lay-verify="required" autocomplete="off"
                               placeholder="请输入姓名"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">性别</label>
                    <div class="layui-input-inline">
                        <input type="radio" name="sex" value="男" title="男" checked="">
                        <input type="radio" name="sex" value="女" title="女">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">手机号</label>
                    <div class="layui-input-inline">
                        <input type="tel" id="phone" name="phone" lay-verify="required|phone" autocomplete="off"
                               placeholder="请输入手机号"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">邮箱</label>
                    <div class="layui-input-inline">
                        <input type="text" id="email" name="email" lay-verify="email" autocomplete="off"
                               placeholder="请输入邮箱"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">身份证</label>
                    <div class="layui-input-inline">
                        <input type="text" id="idcard" name="idcard" lay-verify="required" autocomplete="off"
                               placeholder="请输入身份证"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">联系地址</label>
                    <div class="layui-input-block">
                        <input type="text" id="address" name="address" lay-verify="required" autocomplete="off"
                               placeholder="请输入联系地址" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                <label class="layui-form-label">家属联系人系人姓名</label>
                <div class="layui-input-block">
                    <input type="text" id="namef" name="namef" lay-verify="required" autocomplete="off"
                           placeholder="请输入联系人姓名" class="layui-input">
                </div>
                </div>

                <div class="layui-inline">
                    <label class="layui-form-label">家属联系人号码</label>
                    <div class="layui-input-block">
                        <input type="text" id="phonef" name="phonef" lay-verify="required" autocomplete="off"
                               placeholder="请输入联系号码" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">状态</label>
                    <div class="layui-input-inline">
                        <select name="custstate">
                            <option value="">请选择状态</option>
                            <option value="已放弃">已放弃</option>
                            <option value="已签约">已签约</option>
                            <option value="待联系">待联系</option>
                            <option value="洽谈中">洽谈中</option>
                        </select>
                    </div>
                </div>

                <div class="layui-inline">
                    <label class="layui-form-label">联系记录</label>
                    <div class="layui-input-inline">
                        <input type="text" id="record" name="record" lay-verify="required" autocomplete="off"
                               placeholder="请输入联系记录"
                               class="layui-input">
                    </div>
                </div>

            </div>
            <button class="layui-btn" lay-submit lay-filter="updateFormBtn"
                    style="margin-left: 120px">立即更新
            </button>
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
        //第一个实例
        table.render({
            elem: '#demo'
            , height: 400
            , url: '<%=contextPath%>/customer/custList' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                , {field: 'name', title: '姓名', width: 90}
                , {field: 'sex', title: '性别', width: 60}
                , {field: 'phone', title: '手机号', width: 120}
                , {field: 'email', title: '邮箱', width: 140}
                , {field: 'idcard', title: '身份证', width: 180}
                , {field: 'address', title: '坐标地址', width: 150}
                , {field: 'namef', title: '联系人姓名', width: 180}
                , {field: 'phonef', title: '家属联系人电话', width: 180}
                , {field: 'loginname', title: '创建人', width: 180}
                , {field: 'custstate', title: '状态', width: 180}
                , {field: 'createtime', title: '建档日期', width: 180}
                ,
                {
                    fixed: 'right', title: '操作', toolbar: '#barDemo', width:160
                }
            ]]
        });

        //监听行工具事件
        table.on('tool(test)', function (obj) {
            var data = obj.data;
            if (obj.event == 'del') {
                layer.confirm('确认删除客户\t' + data.name + "\t吗！", function (index) {

                    //异步向服务器发送删除请求
                    $.ajax({
                        url: '<%=contextPath%>/customer/custDel',
                        type: 'GET',
                        data: {'id': data.id},
                        success: function (result) {
                            if (result == "success") {
                                layer.msg("删除成功!" + result, {icon: 6});
                                obj.del();
                                layer.close(index);
                            } else {
                                layer.msg("客户为其他用户所有，无法删除!" + result, {icon: 5});
                                layer.close(index);
                            }
                        },
                        error: function (errorMsg) {
                            layer.msg("数据异常!" + errorMsg, {icon: 5});
                            layer.close(index);
                            location.reload();
                        },
                    });
                });
                //更新用户
            } else if (obj.event == 'edit') {
                layer.open({
                    type: 1,
                    title: "更新用户",
                    area: ['480px', '510px'],
                    content: $("#popUpdateEmp"),
                    success: function () {
                        //回显数据
                        $("#name").val(data.name);
                        $("#sex").val(data.sex);
                        $("#phone").val(data.phone);
                        $("#email").val(data.email);
                        $("#idcard").val(data.idcard);
                        $("#state").val(data.state);
                        $("#address").val(data.address);
                        $("#record").val(data.record);
                        $("#namef").val(data.namef);
                        $("#phonef").val(data.phonef);

                    },
                });
            }
        });
        //更新操作
        form.on('submit(updateFormBtn)', function (data) {
            //发送ajax请求
            $.ajax({
                url: '<%=contextPath%>/customer/custUpdate',
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
                        layer.msg('客户为其他用户所有，无法修改', {time: 1 * 1000}, function () {
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