<%--
  Created by IntelliJ IDEA.
  User: QiangweiLuo
  Date: 2018/8/10
  Time: 0:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>成员信息管理</title>
    <jsp:include page="../templete/setting.html"></jsp:include>
</head>
<body>
<jsp:include page="../templete/top.jsp"></jsp:include>
<div class="center">
    <div class="MMTitle"><h2>教师信息管理</h2><p class="perr">${msg}</p></div><br>
    <div class="sect">
        <div class="form-group">
            <a href="/TeacherManage?method=findAll"><button class="btn btn-light form-control">查询所有</button></a>
        </div>
        <div class="form-group unfind">
            <button class="btn btn-light form-control" onclick="showFind()">查询</button>
        </div>
        <form action="/TeacherManage" method="post">
            <input type="hidden" name="method" value="find">
            <div class="form-group find">
                <input type="text" class="form-control" name="find" placeholder="Enter key word">
            </div>
            <div class="form-group find">
                <input type="submit" class="btn btn-primary form-control" value="查询">
            </div>
        </form>
    </div>
</div>
<jsp:include page="../templete/foot.html"></jsp:include>
</body>
</html>
