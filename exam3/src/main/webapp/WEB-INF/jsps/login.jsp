<%--
  Created by IntelliJ IDEA.
  User: liyingsong
  Date: 16-6-17
  Time: 下午2:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登陆</title>
</head>
<body>
<form action="/user/login" method="post">
    <table align="center" >
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="登陆"></td>
            <td><input type="reset"></td>
        </tr>
    </table>


</form>
</body>
</html>
