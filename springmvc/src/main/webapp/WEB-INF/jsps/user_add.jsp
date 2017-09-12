<%--<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: liyingsong
  Date: 16-6-13
  Time: 上午11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%--<sf:form action="" method="post" modelAttribute="user">--%>
<form method="post">
    <table border="1" align="center">
        <caption>新增用户</caption>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <input type="radio" name="sex" value="1">男</input>
                <input type="radio" name="sex" value="0">女</input>
            </td>
        </tr>
        <tr>
            <td>年龄</td>
            <td>
                <%--<sf:input path="age" type="text" name="age"/>--%>
                <input type="text" name="age">
            </td>
        </tr>
        <tr>
            <td>备注</td>
            <td><input type="text" name="comment"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit"></td>
            <td><input type="reset"></td>
        </tr>
    </table>
<%--</sf:form>--%>
</form>
</body>
</html>
