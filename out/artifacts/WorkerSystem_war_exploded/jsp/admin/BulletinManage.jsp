<%--
  Created by IntelliJ IDEA.
  User: QiangweiLuo
  Date: 2018/8/10
  Time: 0:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>公告管理</title>
    <jsp:include page="../templete/setting.html"></jsp:include>
</head>
<body>
<jsp:include page="../templete/top.jsp"></jsp:include>
<div class="center">
    <div class="show">
        <c:forEach items="${bullList}" var="item">
            <div class="form-control">
                <h3>${item.title}</h3><time>${item.release_time}</time><br><br>
                <p>${item.content}</p>
                <a href="/BulletinManage?method=delete&id=${item.notice_id}"><button class="btn btn-primary form-control">删除</button></a>
            </div>
            <br>
        </c:forEach>
    </div>
</div>
<jsp:include page="../templete/foot.html"></jsp:include>
</body>
</html>
