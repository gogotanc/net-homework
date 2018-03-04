<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>财务页面</title>

    <!-- Bootstrap -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <!-- 自定义样式 -->
    <link href="/css/finance.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="/js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/js/bootstrap.min.js"></script>
</head>
<body>

<#include "./nav.ftl">

<div class="container">
    <div class="row">
        <div class="col-md-offset-1 col-md-10">
            <div class="panel panel-default">
                <div class="panel-heading">财务详情</div>
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>图片</th>
                        <th>名称</th>
                        <th>购买时间</th>
                        <th>数量</th>
                        <th>价格</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th colspan="4">总计</th>
                        <th>￥ ${total?string["0.00"]}</th>
                    </tr>
                    </tfoot>
                    <tbody>
                    <#list list as item>
                    <tr>
                        <td>
                            <figure class="img-rounded">
                                <img class="finance-img" src="${item.pictureUrl}">
                            </figure>
                        </td>
                        <td>${item.title}</td>
                        <td>${item.createTime?date}</td>
                        <td>${item.count}</td>
                        <td>￥ ${item.realPrice?string["0.00"]}</td>
                    </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<!-- 导航栏脚本 -->
<script src="/js/nav.js"></script>
</body>
</html>