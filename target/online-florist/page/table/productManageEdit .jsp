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
    <div class="layui-form layuimini-form" lay-filter="editForm">
        <div class="layui-form-item" style="display: none;">
            <label class="layui-form-label required">ID</label>
            <div class="layui-input-block">
                <input type="text" name="id" lay-verify="required" lay-reqtext="ID不能为空" placeholder="请输入ID" value=""
                    class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label required">产品名称</label>
            <div class="layui-input-block">
                <input type="text" name="productName" lay-verify="required" lay-reqtext="产品名称不能为空" placeholder="请输入产品名称" value="" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label required">价格</label>
            <div class="layui-input-block">
                <input type="text" name="price"  lay-reqtext="价格不能为空" placeholder="请输入价格" value="" class="layui-input">
            </div>
        </div>


        <div class="layui-form-item" style="display: none;">
            <label class="layui-form-label required">产品分类</label>
            <div class="layui-input-block">
                <input type="text" name="productCategory" lay-verify="required" lay-reqtext="产品名称不能为空" placeholder="请输入产品名称" value="" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" style="display: none;">
            <label class="layui-form-label required">源产地</label>
            <div class="layui-input-block">
                <input type="text" name="origin"  lay-reqtext="价格不能为空" placeholder="请输入价格" value="" class="layui-input">
            </div>
        </div>
        <!-- <div class="layui-form-item">
            <label class="layui-form-label required">分类ID</label>
            <div class="layui-input-block">
                <input type="text" name="categoryId" lay-verify="required|number" lay-reqtext="分类ID不能为空" placeholder="请输入分类ID" value="" class="layui-input">
            </div>
        </div> -->
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
                
            //接参，加载数据
            form.getFormVal = function (rowdata) {
                //可以写其他业务请求。
                var data1 = JSON.parse(rowdata);
                // console.log(data1);
                // 数据回填
                form.val("editForm", data1);
            }


            //监听提交
            form.on('submit(saveBtn)', function (data) {
                $.ajax({
                    type: "post",
                    url: "http://localhost:8080/api/product?operation=update&id=" + data.field.id + "&productName=" + data.field.productName + "&price=" + data.field.price + "&categoryId=" + data.field.categoryId+"&productCategory="+data.field.productCategory+"&origin="+data.field.origin,
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