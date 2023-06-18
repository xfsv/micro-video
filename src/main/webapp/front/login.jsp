<%--
  Created by IntelliJ IDEA.
  User: xfsv365
  Date: 2023/6/13
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>后台管理员登录</title>
    <!-- 导入Bootstrap的样式文件 -->
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <!-- 导入jQuery的js文件 -->
    <script src="/js/jquery-3.6.0.js"></script>
    <!-- 导入Bootstrap的js文件 -->
    <script src="/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <!-- 引用top -->
    <jsp:include page = "top.jsp"></jsp:include>
    <div style="margin-top: 30px">
        <form class="form-horizontal" action="/front/user" method="post">
            <div class="form-group">
                <label for="account" class="col-md-4 control-label">账号:</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" id="account" name="account" placeholder="请输入账号">
                    <input type="hidden" name="method" value="login">
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-md-4 control-label">密码:</label>
                <div class="col-md-4">
                    <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
                </div>
            </div>

            <div class="form-group" >
                <div class="col-md-4"></div>

                <div class="col-md-3">
                    <a href="/front/user?method=toSignIn" class="btn btn-info">注册</a>
                </div>

                <div class="col-md-5">
                    <input class="btn btn-info" type="submit" value="登录">
                </div>

            </div>


        </form>
    </div>
</div>
</body>
</html>
