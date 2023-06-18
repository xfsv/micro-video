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
    <title>视频修改页面</title>
    <script src="/js/jquery-3.6.0.js"></script>
    <!-- 导入Bootstrap的js文件 -->
    <script src="/js/bootstrap.min.js"></script>
</head>
    <body>
        <div class = "container">
            <jsp:include page="/admin/top.jsp"></jsp:include>
            <jsp:include page="/admin/top2.jsp"></jsp:include>
            <div class="row" style="margin-top: 10px">
                <div class="col-md-9">
                    <div>
                        当前位置：视频类型管理>>修改视频
                    </div>
                    <div style="margin-top: 10px">
                        <form class="form-horizontal" action="/admin/video" method="post">
                            <div class="form-group">
                                <label for="name" class="col-md-3 control-label">视频名称:</label>
                                <div class="col-md-6">
                                    <input type="text" class="form-control" id="name" name="name" placeholder="请输入视频名称" value="${video.name}">
                                    <input type="hidden" name="method" value="modify">
                                    <input type="hidden" name="id" value="${video.id}">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-3 control-label">视频类型:</label>
                                <div class="col-md-6">
                                    <select class="form-control" name="typeId">
                                        <c:forEach var="videoType" items="${videoTypeList}">
                                            <option value="${videoType.id}" ${videoType.id==video.typeId?"selected='selected'":""}>${videoType.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="director" class="col-md-3 control-label">导演:</label>
                                <div class="col-md-6">
                                    <input type="text" class="form-control" id="director" name="director" placeholder="请输入导演名称" value="${video.director}"readonly="readonly">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="roles" class="col-md-3 control-label">主演:</label>
                                <div class="col-md-6">
                                    <input type="text" class="form-control" id="roles" name="roles" placeholder="请输入主演名称" value="${video.roles}" readonly="readonly">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-3 control-label">视频:</label>
                                <div class="col-md-6">
                                    <video width="320" height="240" controls="controls" poster="/images/${video.imagePath}">
                                        <source src="/videos/${video.videoPath}" type="video/mp4">
                                    </video>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="minuteLength" class="col-md-3 control-label">时长(分钟):</label>
                                <div class="col-md-6">
                                    <input type="text" class="form-control" id="minuteLength" name="minuteLength" placeholder="请输入时长" value="${video.minuteLength}" readonly="readonly">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="productDate" class="col-md-3 control-label">上线日期:</label>
                                <div class="col-md-6">
                                    <input type="Date" class="form-control" id="productDate" name="productDate" placeholder="请输入上线日期" value="${video.productDate}">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="area" class="col-md-3 control-label">地域:</label>
                                <div class="col-md-6">
                                    <input type="text" class="form-control" id="area" name="area" placeholder="请输入地域" value="${video.area}" readonly="readonly">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="description" class="col-md-3 control-label">视频描述:</label>
                                <div class="col-md-6">
                                    <textarea class="form-control" style="resize: none" id="description" name="description" rows="3" placeholder="留下点什么吧...">${video.description}</textarea>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-3"></div>
                                <div class="col-md-6">
                                    <input class="btn btn-success" type="submit" value="修改">
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
