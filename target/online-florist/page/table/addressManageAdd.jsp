<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        <!-- <div class="layui-form-item">
            <label class="layui-form-label required">用户ID</label>
            <div class="layui-input-block">
                <input type="number" name="userId" lay-verify="required" lay-reqtext="用户ID不能为空" placeholder="请输入用户ID" value="" class="layui-input">
            </div>
        </div> -->
        <!-- <div class="layui-form-item">
            <label class="layui-form-label required">收件人姓名</label>
            <div class="layui-input-block">
                <input type="text" name="recipientName" lay-verify="required" lay-reqtext="收件人姓名不能为空" placeholder="请输入收件人姓名" value="" class="layui-input">
            </div>
        </div> -->
        <div class="layui-form-item">
            <label class="layui-form-label required">地址</label>
            <div class="layui-input-block">
                <input type="text" name="address" lay-verify="required" lay-reqtext="地址不能为空" placeholder="请输入地址"
                    value="" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label required">手机号</label>
            <div class="layui-input-block">
                <input type="text" name="phone" lay-verify="required" lay-reqtext="手机号不能为空" placeholder="请输入手机号"
                    value="" class="layui-input">
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
        layui.use(['form'], function () {
            var form = layui.form,
                layer = layui.layer,
                $ = layui.$;

            //监听提交
            form.on('submit(saveBtn)', function (data) {
                $.ajax({
                    type: "post",
                    url: "http://localhost:8080/api/address?operation=add&recipientName=***" + "&address=" + data.field.address + "&phone=" + data.field.phone + "&userId=0  ",
                    success: function (data) {
                        console.log(data)
                    }
                })
                window.parent.location.reload();
                var iframeIndex = parent.layer.getFrameIndex(window.name);
                parent.layer.close(iframeIndex);

                return false;
            });

        });
    </script>
</body>

</html>