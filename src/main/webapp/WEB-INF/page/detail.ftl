<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>商品详情</title>

    <!-- Bootstrap -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <!-- 自定义样式 -->
    <link href="/css/detail.css" rel="stylesheet">

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
        <div class="col-md-offset-1 col-md-10">
            <div class="page-header">
                <h1>商品详情</h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-offset-1 col-md-4">
            <a href="#" class="thumbnail">
                <img class="detail-img" src="${goods.picture}" alt="...">
            </a>
        </div>
        <div class="col-md-6">
            <div class="row">
                <div class="col-md-12">
                    <h2>${goods.title}</h2>
                    <p>${goods.summary}</p>
                    <h3>￥ ${goods.price?c}</h3>
                </div>
            </div>
            <#if Session["user-session-identity"]??>
                <#if Session["user-session-identity"] == 2>
                    <#-- 买家的情况 -->
                    <#if goods.flag == 0>
                        <div class="row">
                            <div class="col-md-12">
                                <button class="btn btn-default">-</button>
                                <strong>0</strong>
                                <button class="btn btn-default">+</button>
                                <button type="button" class="btn btn-success">加入购物车</button>
                            </div>
                        </div>
                    <#else>
                        <div class="row">
                            <div class="col-md-12">
                                <button type="button" class="btn btn-success" disabled>已购买</button>
                                <p>当时购买价格：￥ ${order.price?c}</p>
                            </div>
                        </div>
                    </#if>
                <#else>
                    <#-- 卖家情况 -->
                    <#if goods.flag == 0>
                        <div class="row">
                            <div class="col-md-12">
                                <button type="button" class="btn btn-success">修改</button>
                            </div>
                        </div>
                    <#else>
                        <div class="row">
                            <div class="col-md-12">
                                <button type="button" class="btn btn-success" disabled>已卖出</button>
                            </div>
                        </div>
                    </#if>
                </#if>
            </#if>
        </div>
    </div>
    <div class="row">
        <div class="col-md-offset-1 col-md-10">
            <h3>商品详情</h3>
            <p>${goods.content}</p>
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