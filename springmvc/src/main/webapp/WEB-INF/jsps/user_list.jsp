<%--
  Created by IntelliJ IDEA.
  User: liyingsong
  Date: 16-6-12
  Time: 下午9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>
<a href="/user/add">新增</a>
<form method="post">
    <table border="1" align="center">
        <caption>用户列表（只显示可用用户，可查找所有用户）</caption>
        <tr>
            <td>用户名</td>
            <td>性别</td>
            <td>年龄</td>
            <td>备注</td>
            <td colspan="3">操作</td>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.name}</td>
                <td>${user.sex==1?"男":"女"}</td>
                <td>${user.age}</td>
                <td>${user.comment}</td>
                <td><a href="/user/detail?name=${user.name}">查看</a></td>
                <td><a href="/user/delete?name=${user.name}">删除</a></td>
                <td><a href="/user/edit?id=${user.id}">编辑</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td><input type="text" name="name"></td>
            <td colspan="3"></td>
            <td colspan="3"><input type="submit" value="查找用户"></td>
        </tr>
    </table>
</form>
</body>
</html>
