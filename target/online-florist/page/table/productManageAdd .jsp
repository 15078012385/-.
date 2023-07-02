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
        <div class="layui-form-item">
            <label class="layui-form-label required">产品名称</label>
            <div class="layui-input-block">
                <input type="text" name="productName" lay-verify="required" lay-reqtext="产品名称不能为空" placeholder="请输入产品名称"
                    value="" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label required">价格</label>
            <div class="layui-input-block">
                <input type="text" name="price" lay-verify="required|number" lay-reqtext="价格不能为空" placeholder="请输入价格"
                    value="" class="layui-input">
            </div>
        </div>
        <!-- <div class="layui-form-item">
            <label class="layui-form-label required">分类ID</label>
            <div class="layui-input-block">
                <input type="text" name="categoryId" lay-verify="required|number" lay-reqtext="分类ID不能为空"
                    placeholder="请输入分类ID" value="" class="layui-input">
            </div>
        </div> -->
        <div class="layui-form-item">
            <label class="layui-form-label">产品分类</label>
            <div class="layui-input-block">
                <select name="productCategory" lay-verify="required" id="productCategory">
                    <option value="">请选择分类</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">源产地</label>
            <div class="layui-input-block">
                <select name="origin" lay-verify="required" id="origin">
                    <option value="">请选择源产地</option>
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
        layui.use(['form'], function () {
            var form = layui.form,
                layer = layui.layer,
                $ = layui.$;

            //监听提交
            form.on('submit(saveBtn)', function (data) {
                $.ajax({
                    type: "post",
                    url: "http://localhost:8080/api/product?operation=add" + "&productName=" + data.field.productName + "&price=" + data.field.price + "&categoryId=" + data.field.categoryId + "&productCategory=" + data.field.productCategory + "&origin=" + data.field.origin,
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
                url: "http://localhost:8080/api/product-category?operation=selectByPage&page=1&limit=9999999",
                type: "get",
                success: function (resp) {
                    var test = resp.data; // 替换为你的数组名称和实际值
                    console.log(test, "5555")
                    var select = document.getElementById("productCategory");
                    console.log(select, "5555")
                    for (var i = 0; i < test.length; i++) {
                        var opt = new Option(test[i].categoryName, test[i].categoryName);//第一个代表标签内的内容，第二个代表value
                        select.options.add(opt);
                    }
                    // 更新全部select标签
                    form.render('select');

                }
            });    //各种基于事件的操作，下面会有进一步介绍

            $.ajax({
                url: "http://localhost:8080/api/origin?operation=selectByPage&page=1&limit=9999999",
                type: "get",
                success: function (resp) {
                    var test = resp.data; // 替换为你的数组名称和实际值
                    console.log(test, "5555")
                    var select = document.getElementById("origin");
                    console.log(select, "5555")
                    for (var i = 0; i < test.length; i++) {
                        var opt = new Option(test[i].originName, test[i].originName);//第一个代表标签内的内容，第二个代表value
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