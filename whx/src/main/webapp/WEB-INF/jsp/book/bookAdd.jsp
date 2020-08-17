<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String contextPath = request.getContextPath();
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<%=contextPath%>/layui/css/layui.css" media="all">
    <script type="text/javascript" src="<%=contextPath%>/static/jquery-2.1.3.min.js"></script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>图书新增</legend>
</fieldset>
<form class="layui-form" method="post">
    <div style="padding: 20px; background-color: #F2F2F2;">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md6">
                <div class="layui-card">
                    <div class="layui-card-header">图书添加</div>
                    <div class="layui-card-body">
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">图书编号</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="bId" lay-verify="required" autocomplete="off"
                                           placeholder="请输入图书编号"
                                           class="layui-input">
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">图书名称</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="bName" lay-verify="required" autocomplete="off"
                                           placeholder="请输入图书名称"
                                           class="layui-input">
                                </div>
                            </div>

                            <div class="layui-inline">
                                <label class="layui-form-label">图书数量</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="bAccount" lay-verify="required" autocomplete="off"
                                           placeholder="请输入图书数量"
                                           class="layui-input">
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">图书描述</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="bDescribe" lay-verify="required" autocomplete="off"
                                           placeholder="请输入图书描述"
                                           class="layui-input">
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">图书状态</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="bState" lay-verify="required" autocomplete="off"
                                           placeholder="请输入图书状态"
                                           class="layui-input">
                                </div>
                            </div>
                        </div>

                        <button class="layui-btn" lay-submit lay-filter="formBtn"
                                style="margin-left: 120px">立即添加
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
<script src="<%=contextPath%>/layui/layui.js"></script>

<script>
    layui.use('form', function () {
        var form = layui.form;
        //渲染控件
        form.render();

        //监听提交点击事件
        form.on('submit(formBtn)', function (data) {
            console.log(JSON.stringify(data.field));
            //像服务端发送请求
            $.ajax({
                url: '<%=contextPath%>/books/bookInsert',
                data: JSON.stringify(data.field),
                type:'POST',
                contentType: 'application/json',  //数据类型格式
                success: function (result) {
                    console.log("-------------------->"+result);
                    if (result == "success") {
                        layer.msg('添加成功！', {time: 1 * 1000}, function () {
                            location.reload();
                        });
                    } else {
                        layer.msg('添加失败！', {icon: 5});
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
