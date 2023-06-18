<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <title>视频列表页面</title>
    <script src="/js/jquery-3.6.0.js"></script>
    <script src="/js/bootstrap.min.js"></script>
</head>
    <body>
        <div class = "container">
            <jsp:include page="/front/top3.jsp"></jsp:include>
            <jsp:include page="/front/top2.jsp"></jsp:include>

            <div class="row" style="margin-top: 10px">
                <div class="col-md-3">
                    <jsp:include page="/front/menu.jsp"></jsp:include>
                </div>

                <div class="col-md-9">
                    <div>
                        当前位置：用户界面>>视频列表
                    </div>
                    <div style="margin-top: 10px">
                    <c:forEach var="video" items="${videoList}" varStatus="status">
                        <div class="col-sm-6 col-md-4">
                            <div class="thumbnail">
                                <img src="/images/${video.imagePath}" width="100px" height="100px">
                                <div class="caption">
                                    <h3>${video.name}</h3>
                                    <p>导演:${video.director}</p>
                                    <p>主演:${video.roles}</p>
                                    <p>时长（分钟）:${video.minuteLength}</p>
                                    <p>上线时间:${video.productDate}</p>
                                    <p>
                                        <a href="/front/video?method=toDetail&id=${video.id}" class="btn btn-info">明细</a>
                                        <a href="/front/video?method=toShow&id=${video.id}" class="btn btn-info">播放</a>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                        <%--
                        <table class="table table-striped table-bordered table-hover">

                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>图片</th>
                                <th>型名称</th>
                                <th>导演</th>
                                <th>主演</th>
                                <th>时长(分钟)</th>
                                <th>上线日期</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>

                                <c:forEach var="video" items="${videoList}" varStatus="status">
                                    <tr>
                                        <td>${status.count}</td>
                                        <td>
                                            <img src="/images/${video.imagePath}" width="50px" height="50px">
                                        </td>
                                        <td>${video.name}</td>
                                        <td>${video.director}</td>
                                        <td>${video.roles}</td>
                                        <td>${video.minuteLength}</td>
                                        <td>${video.productDate}</td>
                                        <td>
                                            <a href="/admin/video?method=toDetail&id=${video.id}" class="btn btn-info btn-xs">明细</a>
                                            <a href="/admin/video?method=toModify&id=${video.id}" class="btn btn-success btn-xs">修改</a>
                                            <a href="/admin/video?method=remove&id=${video.id}" class="btn btn-danger btn-xs" onclick="return confirm('确定删除吗？')">删除</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        --%>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
