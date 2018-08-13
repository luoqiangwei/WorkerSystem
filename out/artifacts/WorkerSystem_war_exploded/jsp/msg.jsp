<%--
  Created by IntelliJ IDEA.
  User: QiangweiLuo
  Date: 2018/8/5
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>奇点工作室 - 消息</title>
    <jsp:include page="templete/setting.html"></jsp:include>
    <meta http-equiv="refresh" content="10; URL=/index.jsp">
</head>
<body>
<jsp:include page="templete/top.jsp"></jsp:include>
<div class="center">
    <h1>${msg}</h1>
</div>
<jsp:include page="templete/foot.html"></jsp:include>
</body>
</html>
