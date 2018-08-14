<%--
  Created by IntelliJ IDEA.
  User: QiangweiLuo
  Date: 2018/8/10
  Time: 0:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>教师信息管理</title>
    <jsp:include page="/jsp/templete/setting.html"></jsp:include>
    <link rel="stylesheet" href="/css/admin/TeacherManage.css">
</head>
<body>
<jsp:include page="/jsp/templete/top.jsp"></jsp:include>
<div class="center">
    <div class="TMTitle"><h2>教师信息管理</h2></div><br>
    <div class="sect">
        <div class="form-group">
            <a href="/TeacherManage?method=findAll"><button class="btn btn-light form-control">查询所有</button></a>
        </div>
        <div class="form-group">
            <a href=""><button class="btn btn-light form-control">添加</button></a>
        </div>
        <%--<div class="form-group">--%>
            <%--<a href=""><button class="btn btn-light form-control">修改</button></a>--%>
        <%--</div>--%>
        <%--<div class="form-group">--%>
            <%--<a href="/TeacherManage?method=remove"><button class="btn btn-light form-control">删除</button></a>--%>
        <%--</div>--%>
        <div class="form-group">
            <a href=""><button class="btn btn-light form-control">查询</button></a>
        </div>
    </div>
    <div class="show">

    </div>
    <div class="add">

    </div>
    <div class="modify">

    </div>
    <div class="find">

    </div>
</div>
<jsp:include page="/jsp/templete/foot.html"></jsp:include>
</body>
</html>
