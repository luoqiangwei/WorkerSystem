<%--
  Created by IntelliJ IDEA.
  User: QiangweiLuo
  Date: 2018/8/6
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>奇点工作室 - 登录</title>
    <link rel="stylesheet" href="../css/login.css">
    <jsp:include page="templete/setting.html"></jsp:include>
    <script src="../js/login.js" type="text/javascript"></script>
    <script type="text/javascript">
        function reloadCode() {
            var time = new Date().getTime();
            document.getElementById("imageCode").src="<c:url value='/VerifyCodeServlet?t='></c:url>" + time;
        }
    </script>
</head>
<body>
<jsp:include page="templete/top.jsp"></jsp:include>
<div class="center">
    <h1>登录</h1>
    <div class="form0">
        <p class="perr">${form}</p>
        <form action="/Login" method="post" onsubmit="return checkForm()">
            <input type="hidden" name="method" value="login">
            <div class="form-group">
                <label class="control-label" for="lemail">电子邮箱<p>${email}</p></label>
                <input type="email" name="email" class="form-control" placeholder="Enter email" id="lemail" value="${lemail}"><br>
            </div>
            <div class="form-group">
                <label for="lpassword">密码<p class="perr">${password}</p></label>
                <input type="password" name="password" class="form-control" placeholder="Password" id="lpassword" value="${lpassword}"><br>
            </div>
            <c:if test="${loginError != null}">
                <div class="form-group">
                    <label for="lvcode">验证码<p class="perr">${vcode}</p></label>
                    <input type="text" name="vcode" class="form-control" placeholder="Enter Verify Code" id="lvcode">
                    <a href="javascript:reloadCode()" ID="ricode"><img id="imageCode" src="<c:url value='/VerifyCodeServlet'></c:url>" alt="Verify Code"></a><br>
                </div>
            </c:if>
            <div class="form-group">
                <br>
                <input type="submit" class="btn btn-primary" value="提交">
            </div>
        </form>
    </div>
</div>
<jsp:include page="templete/foot.html"></jsp:include>
</body>
</html>
