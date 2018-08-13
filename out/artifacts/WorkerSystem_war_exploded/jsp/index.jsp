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
    <meta http-equiv="keywords" content="奇点,工作室,江西农业大学">
    <meta http-equiv="description" content="奇点工作室的首页">
</head>
<body>
<jsp:include page="templete/top.jsp"></jsp:include>
    <div class="center">
        <div class="menu">
            <ul>
                <c:if test="${userInfo != null}">
                    <li><a href="/jsp/common/punch/punch.jsp">打卡</a></li>
                    <li><a href="/jsp/common/record/learningRecords.jsp">编写日志</a></li>
                </c:if>
            </ul>
        </div>
    </div>
<jsp:include page="templete/foot.html"></jsp:include>
</body>
</html>
