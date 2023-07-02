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
            <label class="layui-form-label">用户</label>
            <div class="layui-input-block">
                <select name="nickname" lay-verify="required" id="nickname">
                    <option value="">请选择用户</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">产品</label>
            <div class="layui-input-block">
                <select name="productName" lay-verify="required" id="productName">
                    <option value="">请选择产品</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">收货地址</label>
            <div class="layui-input-block">
                <select name="address" lay-verify="required" id="address">
                    <option value="">请选择收货地址</option>
                </select>
            </div>
        </div>


        <div class="layui-form-item">
            <label class="layui-form-label required">数量</label>
            <div class="layui-input-block">
                <input type="text" name="quantity" lay-verify="required" lay-reqtext="数量不能为空" placeholder="请输入数量"
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
                // console.log(data.field.productName.split("-")[0])
                // console.log(data.field.productName.split("-")[1])
                var totalPrice = data.field.quantity * data.field.productName.split("-")[1]
                console.log(totalPrice)
                $.ajax({
                    type: "post",
                    url: "http://localhost:8080/api/order?operation=add&id=" + data.field.id + "&userId=" + 0 + "&productId=" + 0 + "&quantity=" + data.field.quantity + "&totalPrice=" +totalPrice + "&orderDate=" + data.field.orderDate + "&address=" + data.field.address + "&nickname=" + data.field.nickname + "&productName=" + data.field.productName,
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
                url: "http://localhost:8080/api/user?operation=selectByPage&page=1&limit=9999999",
                type: "get",
                success: function (resp) {
                    var test = resp.data; // 替换为你的数组名称和实际值
                    console.log(test)
                    var select = document.getElementById("nickname");
                    console.log(select, "5555")
                    for (var i = 0; i < test.length; i++) {
                        var opt = new Option(test[i].username, test[i].username);//第一个代表标签内的内容，第二个代表value
                        select.options.add(opt);
                    }
                    // 更新全部select标签
                    form.render('select');

                }
            });    //各种基于事件的操作，下面会有进一步介绍

            $.ajax({
                url: "http://localhost:8080/api/product?operation=selectByPage&page=1&limit=9999999",
                type: "get",
                success: function (resp) {
                    var test = resp.data; // 替换为你的数组名称和实际值
                    console.log(test)
                    var select = document.getElementById("productName");
                    console.log(select, "5555")
                    for (var i = 0; i < test.length; i++) {
                        var opt = new Option(test[i].productName + "-" + test[i].price);//第一个代表标签内的内容，第二个代表value
                        select.options.add(opt);
                    }
                    // 更新全部select标签
                    form.render('select');

                }
            });    //各种基于事件的操作，下面会有进一步介绍


            $.ajax({
                url: "http://localhost:8080/api/address?operation=selectByPage&page=1&limit=9999999",
                type: "get",
                success: function (resp) {
                    var test = resp.data; // 替换为你的数组名称和实际值
                    console.log(test)
                    var select = document.getElementById("address");
                    console.log(select, "5555")
                    for (var i = 0; i < test.length; i++) {
                        var opt = new Option(test[i].address, test[i].address);//第一个代表标签内的内容，第二个代表value
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