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
    <link href="/css/cart.css" rel="stylesheet">

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
    <!-- 导航栏脚本 -->
    <script src="/js/nav.js"></script>
</head>
<body>

<#include "./nav.ftl">

<#if cart?size == 0>
<#-- 购物车为空的显示 -->
<div class="container">
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="panel panel-default">
                <div class="panel-heading">购物车详情</div>
                <div class="panel-body">
                    <h4>购物车是空的。</h4>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <a href="/" class="btn btn-default">返回</a>
        </div>
    </div>
</div>
<#else>
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
                        <th>单价</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th colspan="2">总计</th>
                        <th colspan="2">￥ <strong id="totalShow">${total?string["0.00"]}</strong></th>
                    </tr>
                    </tfoot>
                    <tbody>
                    <#list cart as item>
                    <tr>
                        <td>${item.title}</td>
                        <td>
                            <span class="minusButton">-</span> <strong class="showCount">${item.count?c}</strong> <span class="plusButton">+</span>
                            <input type="hidden" value="${item_index}">
                        </td>
                        <td><span class="itemTotal">${item.realPrice?string["0.00"]}</span></td>
                        <td>
                            <a class="button is-text deleteButton">删除</a>
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
            <button class="btn btn-danger" data-toggle="modal" data-target="#clearModal">清空</button>
            <button class="btn btn-success" data-toggle="modal" data-target="#buyModal">立即购买</button>
        </div>
    </div>
</div>

<!-- 清空 Modal -->
<div class="modal fade" id="clearModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
                真的要清空吗？
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-danger clearButton" data-dismiss="modal">清空</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<!-- 确认购买 Modal -->
<div class="modal fade" id="buyModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
                确认购买？
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-success buyButton" data-dismiss="modal">确定</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<script>
$(document).ready(function () {

    var data = [];

    <#list cart as item>
    data.push({itemId: '${item.itemId?c}', goodsId: '${item.goodsId?c}', price: '${item.price?c}', count: '${item.count?c}'});
    </#list>

    updateTotal();

    /**
     * 减少商品数量
     */
    $('.minusButton').click(function () {
        var index = $(this).parent().find('input').val();
        var countNode = $(this).parent().find('.showCount');
        var itemData = data[index];
        if (itemData.count > 1) {
            itemData.count--;
        } else {
            return;
        }
        countNode.text(itemData.count);
        updateCount(itemData.itemId, itemData.count);
        updateTotal();
    });

    /**
     * 增加商品数量
     */
    $('.plusButton').click(function () {
        var index = $(this).parent().find('input').val();
        var countNode = $(this).parent().find('.showCount');
        var itemData = data[index];
        itemData.count++;
        countNode.text(itemData.count);
        updateCount(itemData.itemId, itemData.count)
        updateTotal();
    });

    /**
     * 更新商品数量
     */
    function updateCount(itemId, count) {
        $.ajax({
            type: 'post',
            url: '/api/updateCount',
            dataType: 'json',
            data: {itemId: itemId, count: count},
            success: function (data) {
                if (data.code === -1) {
                    console.log(data.info);
                } else {
                    console.log("ok");
                }
            }
        });
    }

    /**
     * 删除一个商品
     */
    $('.deleteButton').click(function () {
        var tdNode = $(this).parent();
        var trNode = tdNode.parent();
        var index = trNode.find('input').val();
        var item = data[index];
        $.ajax({
            type: 'post',
            url: '/api/delete',
            dataType: 'json',
            data: {itemId: item.itemId},
            success: function (data) {
                if (data.code === -1) {
                    console.log(data.info);
                } else {
                    console.log("ok");
                    item.count = 0;
                    trNode.remove();
                    updateTotal();
                }
            }
        });
    });

    /**
     * 清空购物车
     */
    $('.clearButton').click(function () {
        $.ajax({
            type: 'post',
            url: '/api/clear',
            dataType: 'json',
            data: {},
            success: function (data) {
                if (data.code === -1) {
                    console.log(data.info);
                } else {
                    location.reload();
                }
            }
        });
    });

    /**
     * 确认购买
     */
    $('.buyButton').click(function () {
        $.ajax({
            type: 'post',
            url: '/api/order',
            dataType: 'json',
            data: {},
            success: function (data) {
                if (data.code === -1) {
                    console.log(data.info);
                } else {
                    location.reload();
                }
            }
        });
    });

    /**
     * 更新总计价格
     */
    function updateTotal() {
        var total = 0;
        data.forEach(function (t) {
            total += t.count * t.price;
        });
        total = total / 100.0;
        var totalStr = total.toFixed(2);
        $('#totalShow').text(totalStr);
    }
});
</script>
</#if>
</body>
</html>