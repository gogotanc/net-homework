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
    <!-- 自定义样式 -->
    <link href="/css/login.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<#-- 导航栏 -->
<#include "./nav.ftl">

<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form class="form-horizontal form-login" onsubmit="return false;">
                <div class="form-group">
                    <label for="inputName" class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-10">
                        <input type="text" id="inputName" class="form-control">
                        <p id="errorMessage"></p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword" class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-10">
                        <input type="password" id="inputPassword" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" id="submitButton" class="btn btn-success btn-block">Login</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/js/bootstrap.min.js"></script>
<script src="/js/md5.min.js"></script>
<script>
    // 消除错误信息
    $('#inputName').focus(function () {
        $('#errorMessage').text("");
    });
    $('#inputPassword').focus(function () {
        $('#errorMessage').text("");
    });
    // 提交登录
    $('#submitButton').click(function () {
        var username = $('#inputName').val();
        var pass = $('#inputPassword').val();
        var password = md5(pass);
        $.ajax({
            type: 'post',
            url: '/api/login',
            dataType: 'json',
            data: {username: username, password: password},
            success: function (data) {
                if (data.code === -1) {
                    console.log(data.info);
                    $('#errorMessage').text("用户名或者密码错误，请重试。");
                } else {
                    window.location.href = ("/");
                }
            }
        });
    });
</script>
</body>
</html>