<%--
  Created by IntelliJ IDEA.
  User: xfsv365
  Date: 2023/6/13
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <!-- 导入Bootstrap的样式文件 -->
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <!-- 导入jQuery的js文件 -->
    <title>用户注册</title>
    <script src="/js/jquery-3.6.0.js"></script>
    <!-- 导入Bootstrap的js文件 -->
    <script src="/js/bootstrap.min.js"></script>
    <script>
        function check() {
            if (password.value != password2.value) {
                alert("两次输入密码不一致")
                password.value = "";
                password2.value = "";
            }
        }
    </script>

</head>
<body>
<div class = "container">
    <jsp:include page="/front/top4.jsp"></jsp:include>
    <div class="row" style="margin-top: 10px">
        <div class="col-md-9">
            <div>
                当前位置：用户登录界面>>用户注册
            </div>
            <div style="margin-top: 10px">
                <form class="form-horizontal" action="/front/user" method="post">
                    <div class="form-group">
                        <label for="name" class="col-md-3 control-label">用户名:</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="name" name="name" placeholder="请输入用户名">
                            <input type="hidden" name="method" value="signIn">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="account" class="col-md-3 control-label">账号:</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="account" name="account" placeholder="请输入账号">
<%--                            <input type="hidden" name="method" value="signIn">--%>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="password" class="col-md-3 control-label">密码:</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="password" name="password" placeholder="请输入密码">
<%--                            <input type="hidden" name="method" value="add">--%>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-3"></div>
                        <div class="col-md-6">
                            <input class="btn btn-success" type="submit" value="注册" οnblur=“check()”>
                            <a href="/front/login.jsp" class="btn btn-success">返回</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<%--<script type="text/javascript">--%>
<%--    $(function () {--%>
<%--        $("#password").blur(function(){--%>
<%--            $("#password").empty();--%>
<%--            var password = $(this).val();--%>
<%--            if(password==""|| password==null){--%>
<%--                $("#password").after("<span id='password' style='color: red'>密码不能为空</span>");--%>
<%--            }--%>
<%--        });--%>
<%--        $("#rePassword").blur(function(){--%>
<%--            $("#rePassword").empty();--%>
<%--            var rePassword = $(this).val();--%>
<%--            var password=$("#password").val();--%>
<%--            if(rePassword==""|| rePassword==null){--%>
<%--                $("#rePassword").after("<span id='password' style='color: red'>请确认密码</span>");--%>
<%--            }--%>
<%--            if(rePassword!=password){--%>
<%--                $("#rePassword").after("<span id='password2' style='color: red'>两次密码不匹配,请重新输入!</span>");--%>
<%--            }--%>
<%--        });--%>
<%--    });--%>
<%--</script>--%>
</html>
