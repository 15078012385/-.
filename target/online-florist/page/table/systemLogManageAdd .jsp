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
            <label class="layui-form-label required">访问URL</label>
            <div class="layui-input-block">
                <input type="text" name="accessUrl" lay-verify="required" lay-reqtext="访问URL不能为空" placeholder="请输入访问URL" value="" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">访问时间</label>
            <div class="layui-input-block">
                <input type="text" name="accessTime" placeholder="请输入访问时间" value="" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">创建时间</label>
            <div class="layui-input-block">
                <input type="text" name="createdAt" placeholder="请输入创建时间" value="" class="layui-input">
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
            var index = layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            }, function () {

                // 关闭弹出层
                layer.close(index);

                var iframeIndex = parent.layer.getFrameIndex(window.name);
                parent.layer.close(iframeIndex);

            });

            return false;
        });

    });
</script>
</body>
</html>