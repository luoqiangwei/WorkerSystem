<%--
  Created by IntelliJ IDEA.
  User: QiangweiLuo
  Date: 8/20/2018
  Time: 8:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理员设置</title>
    <jsp:include page="../templete/setting.html"></jsp:include>
</head>
<body>
<jsp:include page="../templete/top.jsp"></jsp:include>
<div class="center">
    <div class="show">
        <c:forEach items="${admList}" var="item">
            <div class="form-group">
                <div class="form-control">
                    <h2>${item.email}</h2>
                    <a href="/AdminManage?method=delete&id=${item.user_id}"><button class="btn btn-primary form-control">移除</button></a>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="add">
        <%--<a href="/jsp/admin/AdminManageAdd.jsp"><button class="btn btn-primary form-control">添加</button></a>--%>
            <a href="/AdminManage?method=perAdd"><button class="btn btn-primary form-control">添加</button></a>
    </div>
</div>
<jsp:include page="../templete/foot.html"></jsp:include>
</body>
</html>
