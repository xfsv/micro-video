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
    <!-- 导入Bootstrap的样式文件 -->
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <!-- 导入jQuery的js文件 -->
    <script src="/js/jquery-3.6.0.js"></script>
    <!-- 导入Bootstrap的js文件 -->
    <script src="/js/bootstrap.min.js"></script>
</head>
    <body>
        <div class = "container" style="margin-top:10px">
            <div class="row">
                <div class="col-md-6" style="text-align: left">
                    欢迎你，${sessionScope.admin.nickname}!
                </div>
                <div class="col-md-6" style="text-align: right">
                    <a href="/admin/admin?method=logout" onclick="return confirm('确定注销吗')">注销</a>
                </div>
            </div>
        </div>
    </body>
</html>
