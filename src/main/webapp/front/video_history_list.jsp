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
                当前位置：用户界面>>历史观看记录
            </div>
            <div style="margin-top: 10px">
<%--                <c:forEach var="video" items="${videoList}" varStatus="status">--%>
<%--                    <div class="col-sm-6 col-md-4">--%>
<%--                        <div class="thumbnail">--%>
<%--                            <img src="/images/${video.imagePath}" width="100px" height="100px">--%>
<%--                            <div class="caption">--%>
<%--                                <h3>${video.name}</h3>--%>
<%--                                <p>导演:${video.director}</p>--%>
<%--                                <p>主演:${video.roles}</p>--%>
<%--                                <p>时长（分钟）:${video.minuteLength}</p>--%>
<%--                                <p>上线时间:${video.productDate}</p>--%>
<%--                                <p>--%>
<%--                                    <a href="/front/video?method=toDetail&id=${video.id}" class="btn btn-info">明细</a>--%>
<%--                                    <a href="/front/video?method=toShow&id=${video.id}" class="btn btn-info">播放</a>--%>
<%--                                </p>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </c:forEach>--%>
                <table class="table table-striped table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>视频</th>
                        <th>名称</th>
                        <th>删除</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="history" items="${historyList}" varStatus="status">
                            <tr>
                                <td>${status.count}</td>
                                <td>
                                    <video width="240" height="160" controls="controls" poster="/images/${history.imagePath}">
                                        <source src="/videos/${history.videoPath}" type="video/mp4">
                                    </video>
                                </td>
                                <td>${history.videoName}</td>
                                <td>
                                    <a href="/front/history?method=remove&id=${history.id}" class="btn btn-danger" onclick="return confirm('确定删除吗？')">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </div>
            <div class="form-group">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <input class="btn btn-info" type="button" value="返回" onclick="history.back()">
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
