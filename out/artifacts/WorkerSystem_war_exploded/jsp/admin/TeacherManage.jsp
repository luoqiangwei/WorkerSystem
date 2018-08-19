<%--
  Created by IntelliJ IDEA.
  User: QiangweiLuo
  Date: 2018/8/10
  Time: 0:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>教师信息管理</title>
    <jsp:include page="/jsp/templete/setting.html"></jsp:include>
    <link rel="stylesheet" href="/css/admin/TeacherManage.css">
    <script type="text/javascript" src="/js/admin/TeacherManage.js"></script>
</head>
<body>
<jsp:include page="/jsp/templete/top.jsp"></jsp:include>
<div class="center">
    <div class="TMTitle"><h2>教师信息管理</h2><p class="perr">${msg}</p></div><br>
    <div class="sect">
        <div class="form-group">
            <a href="/TeacherManage?method=findAll"><button class="btn btn-light form-control">查询所有</button></a>
        </div>
        <%--<div class="form-group">--%>
            <%--<a href=""><button class="btn btn-light form-control">添加</button></a>--%>
        <%--</div>--%>
        <%--<div class="form-group">--%>
            <%--<a href=""><button class="btn btn-light form-control">修改</button></a>--%>
        <%--</div>--%>
        <%--<div class="form-group">--%>
            <%--<a href="/TeacherManage?method=remove"><button class="btn btn-light form-control">删除</button></a>--%>
        <%--</div>--%>
        <div class="form-group unfind">
            <button class="btn btn-light form-control" onclick="showFind()">查询</button>
        </div>
        <form action="/TeacherManage" method="post">
            <input type="hidden" name="method" value="find">
            <div class="form-group find">
                <input type="text" class="form-control" name="find" placeholder="Enter key word">
            </div>
            <div class="form-group find">
                <input type="submit" class="btn btn-primary form-control" value="查询">
            </div>
        </form>
    </div>
    <div class="show">
        <table class="table">
            <tr>
                <th>职工号</th>
                <%--<th>姓名</th>--%>
                <th>电子邮箱</th>
                <th>密码</th>
                <%--<th>电话号码</th>--%>
                <%--<th>QQ</th>--%>
                <%--<th>性别</th>--%>
                <th>是否有效</th>
                <th></th>
                <th></th>
            </tr>
            <tr>
                <form action="/TeacherManage" method="post">
                    <input type="hidden" name="method" value="insertItem">
                    <td><input type="text" name="sid" class="form-control" value="${item.staff_id}"></td>
                    <td><input type="text" name="email" class="form-control" value="${item.email}"></td>
                    <td><input type="text" name="passwd" class="form-control"></td>
                    <td><select class="form-control" name="isEff">
                        <option <c:if test="${item.is_effective == 'true'}">selected</c:if> value="true">有效</option>
                        <option <c:if test="${item.is_effective == 'false'}">selected</c:if> value="false">无效</option>
                    </select></td>
                    <td><input type="submit" class="btn btn-danger" value="添加"></td>
                </form>
                <td><button class="form-control btn btn-primary" onclick="showFullAdd()">完整添加</button></td>
            </tr>
        <c:forEach items="${teaList}" var="item">
            <tr>
                <form action="/TeacherManage" method="post">
                    <input type="hidden" name="method" value="updateItem">
                    <input type="hidden" name="id" value="${item.user_id}">
                    <td><input type="text" name="sid" class="form-control" value="${item.staff_id}"></td>
                    <%--<td><input type="text" name="name" class="form-control" value="${item.name}"></td>--%>
                    <td><input type="email" name="email" class="form-control" value="${item.email}" placeholder="Enter email"></td>
                    <td><input type="text" name="passwd" class="form-control" placeholder="Enter modify password"></td>
                    <%--<td><input type="text" name="phone" class="form-control" value="${item.phone_number}"></td>--%>
                    <%--<td><input type="text" name="qq" class="form-control" value="${item.qq}"></td>--%>
                    <%--<td><select class="form-control" name="sex">--%>
                        <%--<option <c:if test="${item.sex == 'true'}">selected</c:if> value="true">男</option>--%>
                        <%--<option <c:if test="${item.sex == 'false'}">selected</c:if> value="false">女</option>--%>
                    <%--</select></td>--%>
                    <td><select class="form-control" name="isEff">
                        <option <c:if test="${item.is_effective == 'true'}">selected</c:if> value="true">有效</option>
                        <option <c:if test="${item.is_effective == 'false'}">selected</c:if> value="false">无效</option>
                    </select></td>
                    <td><input type="submit" class="btn btn-danger" value="修改"></td>
                </form>
                <td><button class="form-control btn btn-primary" onclick="showFullModify('${item.user_id}', '${item.staff_id}', '${item.name}', '${item.email}', '${item.phone_number}', '${item.qq}', '${item.sex}', '${item.is_effective}')">完整修改</button></td>
            </tr>
        </c:forEach>
        </table>
    </div>
    <div class="add">
        <form class="form-control" method="post">
            <input type="hidden" name="method" value="fullAdd">
            <div class="form-group">
                <label style="color: red;">教工号</label>
                <input type="text" class="form-control" name="sid" placeholder="Enter staff id">
            </div>
            <div class="form-group">
                <label>姓名</label>
                <input type="text" class="form-control" name="name" placeholder="Enter teacher's name">
            </div>
            <div class="form-group">
                <label style="color: red;">电子邮箱</label>
                <input type="email" class="form-control" name="email" placeholder="Enter teacher's email">
            </div>
            <div class="form-group">
                <label style="color: red;">密码</label>
                <input type="text" class="form-control" name="password" placeholder="Enter new password">
            </div>
            <div class="form-group">
                <label>电话号码</label>
                <input type="text" class="form-control" name="phone" placeholder="Enter teacher's mobile phone number">
            </div>
            <div class="form-group">
                <label>QQ</label>
                <input type="text" class="form-control" name="qq" placeholder="Enter teacher's qq">
            </div>
            <div class="form-group">
                <label>性别</label>
                <select class="form-control" name="sex">
                    <option value="true">男</option>
                    <option value="false">女</option>
                </select>
            </div>
            <div class="form-group">
                <label>是否有效</label>
                <select class="form-control" name="isEff">
                    <option value="true">true</option>
                    <option value="false">false</option>
                </select>
            </div>
            <div class="form-group">
                <input type="submit" class="btn btn-primary form-control" value="添加">
            </div>
        </form>
    </div>
    <div class="modify">
        <form class="form-control" method="post">
            <input type="hidden" name="method" value="fullModify">
            <input type="hidden" name="id" id="id">
            <div class="form-group">
                <label style="color: purple;">教工号</label>
                <input type="text" class="form-control" name="sid" placeholder="Enter staff id" id="sid">
            </div>
            <div class="form-group">
                <label>姓名</label>
                <input type="text" class="form-control" name="name" placeholder="Enter teacher's name" id="name">
            </div>
            <div class="form-group">
                <label style="color: purple;">电子邮箱</label>
                <input type="email" class="form-control" name="email" placeholder="Enter teacher's email" id="email">
            </div>
            <div class="form-group">
                <label style="color: purple;">密码</label>
                <input type="text" class="form-control" name="password" placeholder="Enter new password">
            </div>
            <div class="form-group">
                <label>电话号码</label>
                <input type="text" class="form-control" name="phone" placeholder="Enter teacher's mobile phone number" id="phone">
            </div>
            <div class="form-group">
                <label>QQ</label>
                <input type="text" class="form-control" name="qq" placeholder="Enter teacher's qq" id="qq">
            </div>
            <div class="form-group">
                <label>性别</label>
                <select class="form-control" name="sex">
                    <option id="sexT" value="true">男</option>
                    <option id="sexF" value="false">女</option>
                </select>
            </div>
            <div class="form-group">
                <label>是否有效</label>
                <select class="form-control" name="isEff">
                    <option id="isET" value="true">有效</option>
                    <option id="isEF" value="false">无效</option>
                </select>
            </div>
            <div class="form-group">
                <input type="submit" class="btn btn-primary form-control" value="修改">
            </div>
        </form>
    </div>
</div>
<jsp:include page="/jsp/templete/foot.html"></jsp:include>
</body>
</html>
