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
    <legend>客户添加</legend>
</fieldset>
<form class="layui-form" method="post">
    <div style="padding: 20px; background-color: #F2F2F2;">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md6">
                <div class="layui-card">
                    <div class="layui-card-header">客户添加</div>
                    <div class="layui-card-body">
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">姓名</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="name" lay-verify="required" autocomplete="off"
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
                                    <input type="tel" name="phone" lay-verify="required|phone" autocomplete="off"
                                           placeholder="请输入手机号"
                                           class="layui-input">
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">邮箱</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="email" lay-verify="email" autocomplete="off"
                                           placeholder="请输入邮箱"
                                           class="layui-input">
                                </div>
                            </div>

                            <div class="layui-inline">
                                <label class="layui-form-label">身份证</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="idcard" lay-verify="required" autocomplete="off"
                                           placeholder="请输入身份证"
                                           class="layui-input">
                                </div>
                            </div>

                            <div class="layui-inline">
                                <label class="layui-form-label">联系地址</label>
                                <div class="layui-input-block">
                                    <input type="text" name="address" lay-verify="required" autocomplete="off"
                                           placeholder="请输入联系地址" class="layui-input">
                                </div>
                            </div>

                            <div class="layui-inline">
                                <label class="layui-form-label">联系人姓名</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="namef" lay-verify="required" autocomplete="off"
                                           placeholder="请输入联系人姓名" class="layui-input">
                                    </select>
                                </div>
                            </div>

                            <div class="layui-inline">
                                <label class="layui-form-label">联系方式</label>
                                <div class="layui-input-inline">
                                    <input type="tel" name="phonef" lay-verify="required" autocomplete="off"
                                           placeholder="请输入联系方式" class="layui-input">
                                    </select>
                                </div>
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
                url: '<%=contextPath%>/customer/custAdd',
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
