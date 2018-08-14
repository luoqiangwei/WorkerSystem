<%--
  Created by IntelliJ IDEA.
  User: QiangweiLuo
  Date: 2018/7/18
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>奇点工作室</title>
    <jsp:include page="templete/setting.html"></jsp:include>
    <link rel="stylesheet" href="/css/index.css">
    <meta http-equiv="keywords" content="奇点,工作室,江西农业大学">
    <meta http-equiv="description" content="奇点工作室的首页">
</head>
<body>
<jsp:include page="templete/top.jsp"></jsp:include>
    <div class="center">
        <div class="menu">
            <c:if test="${userInfo != null}">
                <c:if test="${isAdmin != null}">
                    <div class="form-group">
                        <a href="/jsp/admin/index.jsp"><button class="btn btn-light long">管理页面</button></a>
                    </div>
                </c:if>
                <div class="form-group">
                    <a href="/Punch?method=findByUser"><button class="btn btn-light long">打卡</button></a>
                </div>
                <div class="form-group">
                    <a href="/LearningRecords?method=findByUser"><button class="btn btn-light long">编写日志</button></a>
                </div>
            </c:if>
        </div>
    </div>
<jsp:include page="templete/foot.html"></jsp:include>
</body>
</html>
