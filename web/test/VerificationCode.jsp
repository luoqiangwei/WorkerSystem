<%--
  Created by IntelliJ IDEA.
  User: QiangweiLuo
  Date: 2018/7/6
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>验证码测试</title>
</head>
<style type="text/css">
    input[type="button"] {
        padding: 0px;
        margin: 0px;
        border: 0px;
        width: 20px;
        height: 20px;
        background: black;
    }
</style>
<body>
    <form action="<c:url value="/test/VerificationCode.jsp"></c:url>" method="post">
        <input type="button" id="11" style="background: black" onclick="change()"><input type="button" name="12"><input type="button" name="13"><input type="button" name="14"><input type="button" name="15"><input type="button" name="16"><br>
        <input type="button" name="21"><input type="button" name="22"><input type="button" name="23"><input type="button" name="24"><input type="button" name="25"><input type="button" name="26"><br>
        <input type="button" name="31"><input type="button" name="32"><input type="button" name="33"><input type="button" name="34"><input type="button" name="35"><input type="button" name="36"><br>
        <input type="button" name="41"><input type="button" name="42"><input type="button" name="43"><input type="button" name="44"><input type="button" name="45"><input type="button" name="46"><br>
        <input type="button" name="51"><input type="button" name="52"><input type="button" name="53"><input type="button" name="54"><input type="button" name="55"><input type="button" name="56"><br>
        <input type="button" name="61"><input type="button" name="62"><input type="button" name="63"><input type="button" name="64"><input type="button" name="65"><input type="button" name="66"><br>
    </form>
    <div id = "haha"></div>
    <script>
        document.getElementsByName("21").style.cssText = "background: red";;
        // alert(button[0]);
        var change = function () {
            alert("11");
            button.style.cssText = "";

            alert("12");
        }
    </script>
</body>
</html>
