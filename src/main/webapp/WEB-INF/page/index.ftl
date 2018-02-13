<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>首页</title>

    <!-- Bootstrap -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <!-- 自定义商品列表样式 -->
    <link href="/css/goods.css" rel="stylesheet">

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
    <#if Session["user-session-identity"]??>
        <div class="row">
            <div class="col-md-offset-1 col-md-10">
                <ul class="nav nav-tabs">
                    <li role="presentation" <#if tag != 2>class="active"</#if>><a href="/">所有商品</a></li>
                    <li role="presentation" <#if tag == 2>class="active"</#if>><a href="/?tag=2">未购买</a></li>
                </ul>
            </div>
        </div>
    </#if>
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <ul class="goods-list">
                <#list goodsList as item>
                <li class="goods-list-item">
                    <div class="thumbnail">
                        <img class="goods-img" src="${item.picture}" alt="...">
                        <div class="caption">
                            <p>${item.title}</p>
                            <p>￥ <strong style="color: red;">${item.price}</strong></p>
                            <input type="hidden" name="goodsId" value="${item.id?c}">
                        </div>
                    </div>
                </li>
                </#list>
            </ul>
        </div>
    </div>
</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/js/bootstrap.min.js"></script>
<script>
    // 用户退出登录
    $('#logoutLink').click(function () {
        $.ajax({
            type: 'post',
            url: '/api/logout',
            dataType: 'json',
            success: function (data) {
                if (data.code === -1) {
                    console.log(data.info);
                } else {
                    window.location.href = ("/");
                }
            }
        });
    });
    // 商品详情页面
    $('.goods-list-item').click(function () {
        var goodsId = $(this).find('input').val();
        console.log(goodsId);
        window.location.href = ("/detail?id=" + goodsId);
    });
</script>
</body>
</html>