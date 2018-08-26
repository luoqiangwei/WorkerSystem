<%--
  Created by IntelliJ IDEA.
  User: QiangweiLuo
  Date: 8/26/2018
  Time: 12:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加管理员</title>
    <jsp:include page="../templete/setting.html"></jsp:include>
</head>
<body>
<jsp:include page="../templete/top.jsp"></jsp:include>
<div class="center">
    <div class="show">
        <c:forEach var="item" items="${list}">
            <div class="form-control">
                <h2>${item.email}</h2>
                <a href="/AdminManage?method=add&id=${item.user_id}"><button class="btn btn-primary form-control">添加</button></a>
            </div>
        </c:forEach>
    </div>
</div>
<jsp:include page="../templete/foot.html"></jsp:include>
</body>
</html>
