<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>购物车</title>

    <!-- Bootstrap -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <!-- 自定义样式 -->

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<#include "./nav.ftl">

<div class="container">
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="panel panel-default">
                <div class="panel-heading">购物车详情</div>
                <table class="table table-hover table-bordered">
                    <thead>
                    <tr>
                        <th>商品名称</th>
                        <th>数量</th>
                        <th>金额</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th colspan="2">总计</th>
                        <th colspan="2">￥ ${total?string["0.00"]}</th>
                    </tr>
                    </tfoot>
                    <tbody>
                    <#list cart as item>
                    <tr>
                        <td>${item.title}</td>
                        <td>
                            <span>-</span> ${item.count?c} <span>+</span>
                        </td>
                        <td>${item.realPrice?string["0.00"]}</td>
                        <td>
                            <a class="button is-text">删除</a>
                            <input type="hidden" value="${item.itemId?c}">
                            <input type="hidden" value="${item.goodsId?c}">
                        </td>
                    </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <a href="/" class="btn btn-default">返回</a>
            <button class="btn btn-danger">清空</button>
            <button class="btn btn-success">立即购买</button>
        </div>
    </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/js/bootstrap.min.js"></script>
<!-- 导航栏脚本 -->
<script src="/js/nav.js"></script>
</body>
</html>