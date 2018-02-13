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

<nav class="navbar navbar-default">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">首页</a>
        </div>

    <#-- 是否登录 -->
    <#if Session["user-session-identity"]??>
    <#-- 卖家登录 -->
        <#if Session["user-session-identity"] == 1>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="/add">发布</a></li>
                </ul>
                <p class="navbar-text navbar-right">欢迎你，<a id="logoutLink" href="#" class="navbar-link">卖家</a></p>
            </div><!-- /.navbar-collapse -->
        <#-- 买家登录 -->
        <#elseif Session["user-session-identity"] == 2>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="/finance">财务</a></li>
                    <li><a href="/cart">购物车</a></li>
                </ul>
                <p class="navbar-text navbar-right">欢迎你，<a id="logoutLink" href="#" class="navbar-link">买家</a></p>
            </div><!-- /.navbar-collapse -->
        </#if>
    <#else>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/login">登录</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </#if>
    </div><!-- /.container-fluid -->
</nav>

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
                    <h3>￥ ${goods.price}</h3>
                </div>
            </div>
            <#if goods.flag == 0>
            <div class="row">
                <div class="col-md-12">
                    <button class="btn btn-default">-</button>
                    <strong>0</strong>
                    <button class="btn btn-default">+</button>
                    <button type="button" class="btn btn-success">立即购买</button>
                </div>
            </div>
            <#else>
            <div class="row">
                <div class="col-md-12">
                    <button type="button" class="btn btn-success" disabled>已购买</button>
                    <p>当时购买价格：￥1000.00</p>
                </div>
            </div>
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
</body>
</html>