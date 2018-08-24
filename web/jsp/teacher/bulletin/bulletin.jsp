<%--
  Created by IntelliJ IDEA.
  User: QiangweiLuo
  Date: 8/24/2018
  Time: 9:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>公告发布</title>
    <jsp:include page="/jsp/templete/setting.html"></jsp:include>
    <link rel="stylesheet" href="/css/teacher/bulletin/bulletin.css">
</head>
<body>
<jsp:include page="/jsp/templete/top.jsp"></jsp:include>
<div class="center">
    <h3>编写公告</h3><p class="perr">${msg}</p>
    <div class="form form-control">
        <form action="/Bulletin" method="post">
            <input type="hidden" name="method" value="add">
            <div class="form-group">
                <label>标题</label>
                <input type="text" class="form-control" name="title" value="${title}" placeholder="Enter title please">
            </div>
            <div class="form-group">
                <label>内容</label>
                <textarea class="form-control area" name="content" placeholder="Enter content please">${content}</textarea>
            </div>
            <div class="form-group">
                <input type="submit" value="提交" class="btn btn-primary">
            </div>
        </form>
    </div>
</div>
<jsp:include page="/jsp/templete/foot.html"></jsp:include>
</body>
</html>
