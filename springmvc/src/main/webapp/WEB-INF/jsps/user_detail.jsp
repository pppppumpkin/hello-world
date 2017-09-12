<%@ page import="org.joda.time.format.DateTimeFormatter" %>
<%@ page import="org.joda.time.format.DateTimeFormat" %>
<%--
  Created by IntelliJ IDEA.
  User: liyingsong
  Date: 16-6-12
  Time: 下午4:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title></title>
</head>
<body>
<a href="/user/edit?id=${user.id}">编辑</a>
<table border="1" align="center">
    <caption>用户详情</caption>
    <tr>
        <td>用户编号</td>
        <td>${user.id}</td>
    </tr>
    <tr>
        <td>用户名</td>
        <td>${user.name}</td>
    </tr>
    <tr>
        <td>性别</td>
        <td>${user.sex==1?"男":"女"}</td>
    </tr>
    <tr>
        <td>年龄</td>
        <td>${user.age}</td>
    </tr>
    <tr>
        <td>备注</td>
        <td>${user.comment}</td>
    </tr>
    <tr>
        <td>状态</td>
        <td>${user.usable==true?"可用":"不可用"}</td>
    </tr>
    <tr>
        <td>注册时间</td>
        <td>${user.createTime.toString("yyyy-MM-dd HH:mm:ss")}</td>
        <%--<td><fmt:formatDate value="<%${user.createTime.toString()}%>" pattern="yyyy-MM-dd HH:mm:ss.SSS" /></td>--%>
    </tr>
    <tr>
        <td>最后编辑时间</td>
        <td>${user.lastEditTime.toString("yyyy-MM-dd HH:mm:ss")}</td>
    </tr>
    <tr>
        <td>用户组</td>
        <td>${user.groupId}</td>
    </tr>
</table>

</body>
</html>
