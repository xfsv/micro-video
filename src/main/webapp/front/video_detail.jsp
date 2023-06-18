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
    <title>视频明细页面</title>
    <script src="/js/jquery-3.6.0.js"></script>
    <!-- 导入Bootstrap的js文件 -->
    <script src="/js/bootstrap.min.js"></script>
</head>
    <body>
        <div class = "container">
            <jsp:include page="/front/top3.jsp"></jsp:include>
            <jsp:include page="/front/top2.jsp"></jsp:include>
            <div class="row" style="margin-top: 10px">
                <div class="col-md-9">
                    <div>
                        当前位置：用户界面>>视频明细
                    </div>
                    <div style="margin-top: 10px">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label class="col-md-3 control-label">视频名称:</label>
                                <div class="col-md-6">
                                    <input type="text" class="form-control" value="${video.name}" readonly="readonly">
                                </div>
                            </div>

                            <div class="form-group">
                                <label  class="col-md-3 control-label">视频类型:</label>
                                <div class="col-md-6">
                                    <input type="text" class="form-control" value="${videoType.name}" readonly="readonly">
                                </div>
                            </div>

                            <div class="form-group">
                                <label  class="col-md-3 control-label">导演:</label>
                                <div class="col-md-6">
                                    <input type="text" class="form-control"value="${video.director}" readonly="readonly">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-3 control-label">主演:</label>
                                <div class="col-md-6">
                                    <input type="text" class="form-control" value="${video.roles}" readonly="readonly">
                                </div>
                            </div>
                            <%--
                            <div class="form-group">
                                <label class="col-md-3 control-label">视频封面:</label>
                                <div class="col-md-6">
                                    <img src="/images/${video.imagePath}" width="200px" height="200px">
                                </div>
                            </div>
                            --%>
                            <div class="form-group">
                                <label class="col-md-3 control-label">视频:</label>
                                <div class="col-md-6">
                                    <video width="320" height="240" controls="controls" poster="/images/${video.imagePath}">
                                        <source src="/videos/${video.videoPath}" type="video/mp4">
                                    </video>
                                </div>
                            </div>

                            <div class="form-group">
                                <label  class="col-md-3 control-label">时长(分钟):</label>
                                <div class="col-md-6">
                                    <input type="text" class="form-control" value="${video.minuteLength}" readonly="readonly">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-3 control-label">上线日期:</label>
                                <div class="col-md-6">
                                    <input type="Date" class="form-control" value="${video.productDate}">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-3 control-label">地域:</label>
                                <div class="col-md-6">
                                    <input type="text" class="form-control" value="${video.area}">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-3 control-label">视频描述:</label>
                                <div class="col-md-6">
                                    <textarea class="form-control" style="resize: none" rows="3" readonly="readonly">${video.description}</textarea>
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
