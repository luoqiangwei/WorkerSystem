<%--
  Created by IntelliJ IDEA.
  User: QiangweiLuo
  Date: 2018/8/10
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>个人中心</title>
    <jsp:include page="/jsp/templete/setting.html"></jsp:include>
    <link rel="stylesheet" href="/css/common/person/center.css">
</head>
<body>
<jsp:include page="/jsp/templete/top.jsp"></jsp:include>
<div class="center">
    <div class="base">
        <h3>基本信息</h3>
        <div class="form-group">
            <p class="perr">${form}</p>
            <form action="/PersonCenter" method="post">
                <input type="hidden" name="method" value="baseInfoChange">
                <div class="form-group">
                    <label for="cemail">电子邮箱</label>
                    <input type="email" name="email" class="form-control" id="cemail" value="${userInfo.email}" disabled="disabled"><br>
                </div>
                <div class="form-group">
                    <label>教工号</label>
                    <input type="text" name="sid" class="form-control" id="csid" value="${userInfo.staff_id}"><br>
                </div>
                <div class="form-group">
                    <label>姓名</label>
                    <input type="text" name="name" class="form-control" id="cname" value="${userInfo.name}"><br>
                </div>
                <div class="form-group">
                    <label>电话号码</label>
                    <input type="text" name="phoneNumber" class="form-control" id="cPhoneNumber" value="${userInfo.phone_number}"><br>
                </div>
                <div class="form-group">
                    <label>QQ</label>
                    <input type="text" name="qq" class="form-control" id="cqq" value="${userInfo.qq}"><br>
                </div>
                <div class="form-group">
                    <label>性别</label>
                    <select class="form-control" name="sex" id="csex">
                        <option <c:if test="${userInfo.sex == 'true'}">selected</c:if> value="true">男</option>
                        <option <c:if var="result" test="${userInfo.sex == 'false'}">selected</c:if> value="false">女</option>
                    </select><br>
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-primary" value="修改">
                </div>
            </form>
        </div>
    </div>
    <div class="passwd">

    </div>
</div>
<jsp:include page="/jsp/templete/foot.html"></jsp:include>
</body>
</html>
