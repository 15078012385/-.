<!DOCTYPE html><%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>

<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../../lib/layui-v2.6.3/css/layui.css" media="all">
    <link rel="stylesheet" href="../../css/public.css" media="all">
    <style>
        body {
            background-color: #ffffff;
        }
    </style>
</head>

<body>
        <div class="layui-form layuimini-form">
            <div class="layui-form-item">
                <label class="layui-form-label required">用户名</label>
                <div class="layui-input-block">
                    <input type="text" name="username" lay-verify="required" lay-reqtext="用户名不能为空" placeholder="请输入用户名"
                        value="" class="layui-input">
                    <tip>填写自己管理账号的名称。</tip>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label required">密码</label>
                <div class="layui-input-block">
                    <input type="password" name="password" lay-verify="required" lay-reqtext="密码不能为空"
                        placeholder="请输入密码" value="" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label required">姓名</label>
                <div class="layui-input-block">
                    <input type="text" name="nickname" lay-verify="required" lay-reqtext="姓名不能为空" placeholder="请输入姓名"
                        value="" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label required">手机号</label>
                <div class="layui-input-block">
                    <input type="number" name="phone" lay-verify="required" lay-reqtext="手机不能为空" placeholder="请输入手机"
                        value="" class="layui-input">
                </div>
            </div>

            <!-- <div class="layui-form-item">
            <label class="layui-form-label">身份</label>
            <div class="layui-input-block">
                <input type="text" name="identity" placeholder="请输入身份" value="" class="layui-input">
            </div>
        </div> -->

            <div class="layui-form-item">
                <label class="layui-form-label">身份</label>
                <div class="layui-input-block">
                    <select name="identity" lay-verify="required" id="identity">
                        <option value="">请选择身份</option>
                    </select>
                </div>
            </div>



            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认保存</button>
                </div>
            </div>
        </div>

    <script src="../../lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
    <script>



    </script>
    <script>


        layui.use(['form'], function () {
            var form = layui.form,
                layer = layui.layer,
                $ = layui.$;

            //监听提交
            form.on('submit(saveBtn)', function (data) {
                console.log(data.field)
                $.ajax({
                    type: "post",
                    url: "http://localhost:8080/api/user?operation=add&id=" + data.field.id + "&username=" + data.field.username + "&password=" + data.field.password + "&nickname=" + data.field.nickname + "&phone=" + data.field.phone + "&identity=" + data.field.identity,
                    success: function (data) {
                        console.log(data)
                    }
                })
                window.parent.location.reload();
                var iframeIndex = parent.layer.getFrameIndex(window.name);
                parent.layer.close(iframeIndex);
                return false;
            });


            $.ajax({
                url: "http://localhost:8080/api/user-category?operation=selectByPage&page=1&limit=9999999",
                type: "get",
                success: function (resp) {
                    var test = resp.data; // 替换为你的数组名称和实际值
                    var select = document.getElementById("identity");
                    console.log(select, "5555")
                    for (var i = 0; i < test.length; i++) {
                        var opt = new Option(test[i].categoryName, test[i].categoryName);//第一个代表标签内的内容，第二个代表value
                        select.options.add(opt);
                    }
                    // 更新全部select标签
                    form.render('select');

                }
            });    //各种基于事件的操作，下面会有进一步介绍
        });
    </script>
</body>

</html>