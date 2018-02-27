<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加商品</title>

    <!-- Bootstrap -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <!-- 自定义样式 -->
    <link href="/css/add.css" rel="stylesheet">

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
    <script src="/js/jquery.validate.min.js"></script>
</head>
<body>

<#include "./nav.ftl">

<div class="container">
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="panel panel-default">
                <div class="panel-heading">添加商品</div>
                <div class="panel-form">
                    <form id="goodsAddForm" class="form-horizontal form-login">
                        <div class="form-group">
                            <label for="goodsName" class="col-sm-2 control-label">商品名称</label>
                            <div class="col-sm-10">
                                <input type="text" id="goodsName" name="goodsName" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="goodsSummary" class="col-sm-2 control-label">商品摘要</label>
                            <div class="col-sm-10">
                                <input type="text" id="goodsSummary" name="goodsSummary" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="goodsPrice" class="col-sm-2 control-label">商品价格</label>
                            <div class="col-sm-10">
                                <input type="number" id="goodsPrice" name="goodsPrice" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">商品图片</label>
                            <div class="col-sm-10">
                                <label class="radio-inline">
                                    <input type="radio" name="goodsPictureType" id="inlineRadio1" value="1" checked> 图片链接
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="goodsPictureType" id="inlineRadio2" value="2"> 上传图片
                                </label>
                            </div>
                        </div>
                        <div id="form-group-link" class="form-group">
                            <label for="goodsPictureLink" class="col-sm-2 control-label">图片链接</label>
                            <div class="col-sm-10">
                                <input type="text" id="goodsPictureLink" name="goodsPictureLink" class="form-control">
                            </div>
                        </div>
                        <div id="form-group-file" class="form-group show-hidden">
                            <label for="goodsPictureFile" class="col-sm-2 control-label">图片文件</label>
                            <div class="col-sm-10">
                                <input type="file" class="file" id="goodsPictureFile" name="goodsPictureFile">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="goodsDetail" class="col-sm-2 control-label">商品详情</label>
                            <div class="col-sm-10">
                                <textarea class="form-control" id="goodsDetail" name="goodsDetail" rows="5"></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="button" class="btn btn-success btn-block" data-toggle="modal" data-target="#publishDone">发布</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 确认发布的 modal -->
<div class="modal fade" id="publishDone" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
                确认发布？
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" id="publishButton" class="btn btn-success" data-dismiss="modal">发布</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<script>
$(document).ready(function () {

    // 图片上传方式
    var checkedVal = '1';

    $("input[name='goodsPictureType']").change(function () {
        checkedVal = $("input[name='goodsPictureType']:checked").val();
        console.log('checkedVal', checkedVal);
        if (checkedVal === '1') {
            $('#form-group-link').removeClass('show-hidden');
            $('#form-group-file').addClass('show-hidden');
        } else {
            $('#form-group-file').removeClass('show-hidden');
            $('#form-group-link').addClass('show-hidden');
        }
    });

    $('#publishButton').click(function () {
        if (validateFunc().form()) {
            var data = new FormData(document.getElementById("goodsAddForm"));
//            console.log("name", data.get("goodsName"));
//            console.log("type", data.get("goodsPictureType"));
//            console.log("file", data.get("goodsPictureFile"));
//            console.log("link", data.get("goodsPictureLink"));
            $.ajax({
                url: "/api/add",
                type: "post",
                data: data,
                processData: false,
                contentType: false,
                success: function (data) {
                    if (data.code === -1) {
                        console.log(data.info);
                    } else {
                        console.log("ok");
                    }
                },
                error: function (e) {
                    console.log(e);
                }
            });
        }
    });

    function validateFunc() {

        return $("#goodsAddForm").validate({
            rules: {
                goodsName: {
                    required: true,
                    minlength: 2,
                    maxlength: 80
                },
                goodsSummary: {
                    required: true,
                    minlength: 2,
                    maxlength: 140
                },
                goodsPrice: {
                    required: true,
                    digits: true
                },
                goodsDetail: {
                    required: true,
                    minlength: 2,
                    maxlength: 1000
                },
                goodsPictureLink: {
                    required: function () {
                        return checkedVal === '1';
                    }
                },
                goodsPictureFile: {
                    required: function () {
                        return checkedVal === '2';
                    }
                }
            },
            messages: {
                goodsName: {
                    required: "商品名称不能为空",
                    minlength: "请输入 2~80 个字符",
                    maxlength: "请输入 2~80 个字符"
                },
                goodsSummary: {
                    required: "商品摘要不能为空",
                    minlength: "请输入 2~140 个字符",
                    maxlength: "请输入 2~140 个字符"
                },
                goodsPrice: {
                    required: "商品价格不能为空，单位为分",
                    digits: "请输入正确的价格，单位为分"
                },
                goodsDetail: {
                    required: "商品详情不能为空",
                    minlength: "请输入 2~1000 个字符",
                    maxlength: "请输入 2~1000 个字符"
                },
                goodsPictureLink: {
                    required: "图片链接不能为空"
                },
                goodsPictureFile: {
                    required: "图片文件不能为空"
                }
            }
        });
    }
});
</script>
</body>
</html>