<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <title>视频类型列表页面</title>
    <script src="/js/jquery-3.6.0.js"></script>
    <script src="/js/bootstrap.min.js"></script>
</head>
    <body>
        <div class = "container">
            <jsp:include page="/admin/top.jsp"></jsp:include>
            <jsp:include page="/admin/top2.jsp"></jsp:include>
            <div class="row" style="margin-top: 10px">
                <div class="col-md-3">
                    <jsp:include page="/admin/menu.jsp"></jsp:include>
                </div>
                <div class="col-md-9">
                    <div>
                        当前位置：视频类型管理>>视频列表
                    </div>
                    <div style="margin-top: 10px">
                        <a href="/admin/videoType?method=toAdd" type="button" class="btn btn-info" >添加视频类型</a>
                    </div>
                    <div style="margin-top: 10px">
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>视频类型名称</th>
                                <th>视频类型描述</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="videoType" items="${videoTypeList}" varStatus="status">
                                    <tr>
                                        <td>${status.count}</td>
                                        <td>${videoType.name}</td>
                                        <td>${videoType.desc}</td>
                                        <td>
                                            <a href="/admin/videoType?method=toDetail&id=${videoType.id}" class="btn btn-info btn-xs">明细</a>
                                            <a href="/admin/videoType?method=toModify&id=${videoType.id}" class="btn btn-success btn-xs">修改</a>
                                            <a href="/admin/videoType?method=remove&id=${videoType.id}" class="btn btn-danger btn-xs" onclick="return confirm('确定删除吗？')">删除</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
