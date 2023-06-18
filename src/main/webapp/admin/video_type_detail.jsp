<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <title>视频类型明细页面</title>
    <script src="/js/jquery-3.6.0.js"></script>
    <script src="/js/bootstrap.min.js"></script>
</head>
    <body>
        <div class = "container">
            <jsp:include page="/admin/top.jsp"></jsp:include>
            <jsp:include page="/admin/top2.jsp"></jsp:include>
            <div class="row" style="margin-top: 10px">
                <div class="col-md-9">
                    <div>
                        当前位置：视频类型管理>>添加视频类型明细
                    </div>
                    <div style="margin-top: 10px">
                        <form class="form-horizontal" >
                            <div class="form-group">
                                <label class="col-md-3 control-label">视频类型名称:</label>
                                <div class="col-md-6">
                                    <input type="text" class="form-control" value="${videoType.name}" readonly="readonly">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">视频类型描述:</label>
                                <div class="col-md-6">
                                    <textarea class="form-control" style="resize: none" rows="3" readonly="readonly">${videoType.description}</textarea>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-3"></div>
                                <div class="col-md-6">
                                    <input class="btn btn-info" type="button" value="返回" onclick="history.back()">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
