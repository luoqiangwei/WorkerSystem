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
    <ul>
        <li><a href="TeacherManage.jsp">教师管理</a></li>
        <li><a href="MemberManage.jsp">成员管理</a></li>
        <li><a href="BulletinManage.jsp">公告管理</a></li>
        <li><a href="PunchManage.jsp">打卡管理</a></li>
        <li><a href="MissionManage.jsp">任务管理</a></li>
    </ul>
</div>
<jsp:include page="../templete/foot.html"></jsp:include>
</body>
</html>
