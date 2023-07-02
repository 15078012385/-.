<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="utf-8">
    <title>主页一</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../lib/layui-v2.6.3/css/layui.css" media="all">
    <link rel="stylesheet" href="../lib/font-awesome-4.7.0/css/font-awesome.min.css" media="all">
    <link rel="stylesheet" href="../css/public.css" media="all">
</head>
<style>
    .layui-top-box {
        padding: 40px 20px 20px 20px;
        color: #fff
    }

    .panel {
        margin-bottom: 17px;
        background-color: #fff;
        border: 1px solid transparent;
        border-radius: 3px;
        -webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
        box-shadow: 0 1px 1px rgba(0, 0, 0, .05)
    }

    .panel-body {
        padding: 15px
    }

    .panel-title {
        margin-top: 0;
        margin-bottom: 0;
        font-size: 14px;
        color: inherit
    }

    .label {
        display: inline;
        padding: .2em .6em .3em;
        font-size: 75%;
        font-weight: 700;
        line-height: 1;
        color: #fff;
        text-align: center;
        white-space: nowrap;
        vertical-align: baseline;
        border-radius: .25em;
        margin-top: .3em;
    }

    .layui-red {
        color: red
    }

    .main_btn>p {
        height: 40px;
    }
</style>

<body>
    <div class="layuimini-container">
        <div class="layuimini-main layui-top-box">
            <div class="layui-row layui-col-space10">

                <div class="layui-col-md3">
                    <div class="col-xs-6 col-md-3">
                        <div class="panel layui-bg-cyan">
                            <div class="panel-body">
                                <div class="panel-title">
                                    <span class="label pull-right layui-bg-blue">实时</span>
                                    <h5>用户统计</h5>
                                </div>
                                <div class="panel-content">
                                    <h1 class="no-margins" id="userCount">1234</h1>
                                    <small>当前分类总记录数</small>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="layui-col-md3">
                    <div class="col-xs-6 col-md-3">
                        <div class="panel layui-bg-blue">
                            <div class="panel-body">
                                <div class="panel-title">
                                    <span class="label pull-right layui-bg-cyan">实时</span>
                                    <h5>商品统计</h5>
                                </div>
                                <div class="panel-content">
                                    <h1 class="no-margins" id="product">1234</h1>
                                    <small>当前分类总记录数</small>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="layui-col-md3">
                    <div class="col-xs-6 col-md-3">
                        <div class="panel layui-bg-orange">
                            <div class="panel-body">
                                <div class="panel-title">
                                    <span class="label pull-right layui-bg-green">实时</span>
                                    <h5>订单统计</h5>
                                </div>
                                <div class="panel-content">
                                    <h1 class="no-margins" id="order">1234</h1>
                                    <small>当前分类总记录数</small>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <script src="../lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
                <script>
                    layui.use(['layer'], function () {
                        var $ = layui.jquery;
                        $.ajax({
                            url: "http://localhost:8080/api/user?operation=getRecords",
                            type: "get",
                            success: function (res) {
                                console.log(res.data);
                                $("#userCount").html(res.data);
                            }   
                        })

                        $.ajax({
                            url: "http://localhost:8080/api/product?operation=getRecords",
                            type: "get",
                            success: function (res) {
                                console.log(res.data);
                                $("#product").html(res.data);
                            }   
                        })

                        $.ajax({
                            url: "http://localhost:8080/api/order?operation=getRecords",
                            type: "get",
                            success: function (res) {
                                console.log(res.data);
                                $("#order").html(res.data);
                            }   
                        })



                    });
                </script>

            </div>
        </div>


    </div>
    <script src="../lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
</body>

</html>