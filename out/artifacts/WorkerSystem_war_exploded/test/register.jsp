<%--
  Created by IntelliJ IDEA.
  User: QiangweiLuo
  Date: 2018/7/17
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>注册</title>
    <script type="text/javascript">
        function reloadCode() {
            var time = new Date().getTime();
            document.getElementById("imageCode").src="<c:url value='/VerifyCodeServlet?t='></c:url>" + time;
        }
    </script>
</head>
<body>
    ${form}
    <form action="/RegisterTestServlet" method="post">
        <input type="hidden" name="method" value="register">
        电子邮箱<input type="email" name="email" >${email}<br>
        员工号<input type="text" name="staffid" >${staffid}<br>
        密码<input type="text" name="password" >${password}<br>
        再输入一次密码<input type="password" name="repassword" ><br>
        验证码<input type="text" name="vcode" ><a href="javascript:reloadCode()"><img id="imageCode" src="<c:url value='/VerifyCodeServlet'></c:url>" alt="Verify Code"></a>${vcode}<br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
