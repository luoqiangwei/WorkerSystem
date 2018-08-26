<%--
  Created by IntelliJ IDEA.
  User: QiangweiLuo
  Date: 2018/8/10
  Time: 0:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>打卡管理</title>
    <jsp:include page="../templete/setting.html"></jsp:include>
</head>
<body>
<jsp:include page="../templete/top.jsp"></jsp:include>
<div class="center">
    <div class="show">
        <c:forEach var="item" items="${punList}">
            <div class="form-control">
                <label>打卡IP:${item.punch_ip}</label><br>
                <label>打卡地点:${item.punch_location}</label><br>
                <label>打卡备注:${item.remarks}</label><br>
                <label>打卡日期:${item.punch_date}</label>
                <a href="/PunchManage?method=delete&id=${item.punch_id}"><button class="btn btn-primary form-control">删除</button></a>
            </div><br>
        </c:forEach>
    </div>
</div>
<jsp:include page="../templete/foot.html"></jsp:include>
</body>
</html>
