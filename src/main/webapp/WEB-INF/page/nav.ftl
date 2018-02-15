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
                <p class="navbar-text navbar-right">欢迎你，卖家。<a id="logoutLink" href="#" class="navbar-link">[退出]</a></p>
            </div><!-- /.navbar-collapse -->
        <#-- 买家登录 -->
        <#elseif Session["user-session-identity"] == 2>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="/finance">财务</a></li>
                    <li><a href="/cart">购物车</a></li>
                </ul>
                <p class="navbar-text navbar-right">欢迎你，买家。<a id="logoutLink" href="#" class="navbar-link">[退出]</a></p>
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
