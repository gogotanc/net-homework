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
            <div class="page-header">
                <h1>商品详情</h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-offset-1 col-md-4">
            <a href="#" class="thumbnail">
                <img class="detail-img" src="${goods.pictureUrl}" alt="...">
            </a>
        </div>
        <div class="col-md-6">
            <div class="row">
                <div class="col-md-12">
                    <h2>${goods.title}</h2>
                    <p>${goods.summary}</p>
                    <h3>￥ ${goods.realPrice?string["0.00"]}</h3>
                    <input id="goodsId" type="hidden" value="${goods.id?c}">
                </div>
            </div>
            <#if Session["user-session-identity"]??>
                <#if Session["user-session-identity"] == 2>
                    <#-- 买家的情况 -->
                    <#if goods.flag == 0>
                        <div class="row">
                            <div class="col-md-12">
                                <button id="minusButton" class="btn btn-default myButton">-</button>
                                <strong id="countShow">1</strong>
                                <button id="plusButton" class="btn btn-default myButton">+</button>
                                <button id="addCartButton" type="button" class="btn btn-success">加入购物车</button>
                            </div>
                        </div>
                    <#else>
                        <div class="row">
                            <div class="col-md-12">
                                <button type="button" class="btn btn-success" disabled>已购买</button>
                                <p>当时购买价格：￥ ${order.realPrice?c}</p>
                            </div>
                        </div>
                    </#if>
                <#else>
                    <#-- 卖家情况 -->
                    <#if goods.flag == 0>
                        <div class="row">
                            <div class="col-md-12">
                                <button type="button" id="modifyButton" class="btn btn-success">修改</button>
                                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteGoods">删除</button>
                            </div>
                        </div>
                    <#else>
                        <div class="row">
                            <div class="col-md-12">
                                <button type="button" id="modifyButton" class="btn btn-success">修改</button>
                                <button type="button" class="btn btn-default" disabled>已卖出</button>
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

<!-- 添加购物车成功后弹出的 modal -->
<div class="modal fade" id="addSuccess" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    提示
                </h4>
            </div>
            <div class="modal-body">
                添加成功。
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" id="toCartButton" class="btn btn-success" data-dismiss="modal">去购物车看看</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<!-- 确认删除商品弹出的 modal -->
<div class="modal fade" id="deleteGoods" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    提示
                </h4>
            </div>
            <div class="modal-body">
                确定要删除该商品吗？
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" id="deleteButton" class="btn btn-danger" data-dismiss="modal">确定</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<!-- 删除商品成功后弹出的 modal -->
<div class="modal fade" id="deleteSuccess" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    提示
                </h4>
            </div>
            <div class="modal-body">
                删除成功。
            </div>
            <div class="modal-footer">
                <button type="button" id="backIndex" class="btn btn-danger" data-dismiss="modal">返回首页</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<script>
$(document).ready(function () {
    var data = {};
    data.goodsId = ${goods.id?c};

<#if Session["user-session-identity"]?? && Session["user-session-identity"] == 2>
<#-- 买家登录时加载的脚本 -->
    $('#minusButton').click(function () {
        var show = $('#countShow');
        var count = show.text();
        if (count > 1)
            count--;
        show.text(count);
    });
    $('#plusButton').click(function () {
        var show = $('#countShow');
        var count = show.text();
        count++;
        show.text(count);
    });
    $('#addCartButton').click(function () {
        var goodsId = $('#goodsId').val();
        var count = $('#countShow').text();

        $.ajax({
            type: 'post',
            url: '/api/cart',
            dataType: 'json',
            data: {goodsId: goodsId, count: count},
            success: function (data) {
                if (data.code === -1) {
                    console.log(data.info);
                } else {
                    $('#addSuccess').modal('toggle');
                }
            }
        });
    });
    $('#toCartButton').click(function () {
        window.location.href = ("/cart");
    });
</#if>

<#if Session["user-session-identity"]?? && Session["user-session-identity"] == 1>
<#-- 卖家登录时加载的脚本 -->
    $('#modifyButton').click(function () {
        var goodsId = data.goodsId;
        window.location.href = ("/modify?id=" + goodsId);
    });

    $('#deleteButton').click(function () {
        var goodsId = data.goodsId;
        $.ajax({
            type: 'post',
            url: '/api/deleteGoods',
            dataType: 'json',
            data: {id: goodsId},
            success: function (data) {
                if (data.code === -1) {
                    console.log(data.info);
                } else {
                    $('#deleteSuccess').modal("toggle");
                }
            }
        });
    });

    $('#deleteSuccess').on('hidden.bs.modal', function () {
        window.location.href = ("/");
    });
</#if>
});
</script>
<!-- 导航栏脚本 -->
<script src="/js/nav.js"></script>
</body>
</html>