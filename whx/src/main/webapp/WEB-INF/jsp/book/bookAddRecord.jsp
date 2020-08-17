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
    <legend>图书租借</legend>
</fieldset>
<form class="layui-form" method="post">
    <div style="padding: 20px; background-color: #F2F2F2;">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md6">
                <div class="layui-card">
                    <div class="layui-card-header">租借登记</div>
                    <div class="layui-card-body">
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">图书数量</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="account" lay-verify="required" autocomplete="off"
                                           placeholder="请输入数量"
                                           class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">状态</label>
                                <div class="layui-input-inline">
                                    <select name="state">
                                        <option value="1">租借</option>
                                    </select>
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">图书信息</label>
                                <div class="layui-input-inline">
                                    <select name="bId" lay-filter="required" id="bId">
                                        <option value="">请选择相关图书</option>
                                    </select>
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">租借信息</label>
                                <div class="layui-input-inline">
                                    <select name="employee_id" lay-filter="required" id="employee_id">
                                        <option value="">请选择租借人</option>
                                    </select>
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

        //动态加载图书
        $.ajax({
            url: "<%=contextPath%>/books/bookOption",
            type: 'POST',
            dataType: 'json',
            success: function (result) {
                var list = result; //返回的数据
                for (var i = 0; i < list.length; i++) {
                    //追加option
                    if(list[i].bState == 1){
                        $("#bId").append("<option value=" + list[i].bId + ">" + list[i].bName + "</option>");
                    }

                    //渲染刷新
                    form.render('select');
                }
            },
        });

        //动态加载员工option
        $.ajax({
            url: '<%=contextPath%>/employee/empOption',
            type: 'POST',
            dataType: 'json',
            success: function (result) {
                var list = result;
                for (var i = 0; i < list.length; i++) {
                    //追加option
                    $("#employee_id").append("<option value=" + list[i].id + ">" + list[i].name + "</option>");
                    //渲染刷新
                    form.render('select');
                }
            },
        });

        //监听提交点击事件
        form.on('submit(formBtn)', function (data) {
            console.log(JSON.stringify(data.field));
            //像服务端发送请求
            $.ajax({
                url: '<%=contextPath%>/record/insertRecord',
                data: JSON.stringify(data.field),
                type:'POST',
                contentType: 'application/json',  //数据类型格式
                success: function (result) {
                    console.log("-------------------->"+result);
                   if (result == "success") {
                        layer.msg('添加成功！', {time: 1 * 1000}, function () {
                            location.reload();
                        });
                    } else if(result == "bookNoEnough"){
                        layer.msg('图书库存不足！', {icon: 5});
                    }else{
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
