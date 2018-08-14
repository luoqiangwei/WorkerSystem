<%--
  Created by IntelliJ IDEA.
  User: QiangweiLuo
  Date: 2018/8/9
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理员界面</title>
    <jsp:include page="../templete/setting.html"></jsp:include>
</head>
<body>
<jsp:include page="../templete/top.jsp"></jsp:include>
<div class="center">
    <div class="form-group">
        <div class="form-group">
            <a href="TeacherManage.jsp"><button class="btn btn-light form-control">教师管理</button></a>
        </div>
        <div class="form-group">
            <a href="MemberManage.jsp"><button class="btn btn-light form-control">成员管理</button></a>
        </div>
        <div class="form-group">
            <a href="BulletinManage.jsp"><button class="btn btn-light form-control">公告管理</button></a>
        </div>
        <div class="form-group">
            <a href="PunchManage.jsp"><button class="btn btn-light form-control">打卡管理</button></a>
        </div>
        <div class="form-group">
            <a href="MissionManage.jsp"><button class="btn btn-light form-control">任务管理</button></a>
        </div>
    </div>
</div>
<jsp:include page="../templete/foot.html"></jsp:include>
</body>
</html>
