<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="header">
    <header>
        <div class="himage">
            <a href="/index.jsp"><img height="90" width="90" src="/image/all.jpg"></a>
        </div>
        <div class="htitle">
            <h1>奇点工作室</h1>
        </div>
        <div class="hmenu">
            <c:if test="${userInfo != null}">
                <li>${userInfo.email }</li>
                <li><a href="/jsp/common/person/center.jsp">个人中心</a></li>
                <li><a href="/Login?method=cancellation">注销</a></li>
            </c:if>
            <c:if test="${userInfo == null}">
                <li><a href="/jsp/login.jsp" class="mainMenu">登录</a></li>
                <li><a href="/jsp/register.jsp" class="mainMenu">注册</a></li>
            </c:if>
        </div>
    </header>
</div>