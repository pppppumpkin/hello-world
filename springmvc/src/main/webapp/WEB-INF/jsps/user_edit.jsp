<%--
  Created by IntelliJ IDEA.
  User: liyingsong
  Date: 16-6-12
  Time: 下午2:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="" method="post">
    <table border="1" align="center">
        <caption>编辑用户信息</caption>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="name" value="${user.name}"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <input type="radio" name="sex" value="1" ${user.sex==1?'checked':''}>男</input>
                <input type="radio" name="sex" value="0" ${user.sex==0?'checked':''}>女</input>
            </td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type="text" name="age" value="${user.age}"></td>
        </tr>
        <tr>
            <td>备注</td>
            <td><input type="text" name="comment" value="${user.comment}"></td>
        </tr>
        <tr>
            <td>状态</td>
            <td>
                <input type="radio" name="usable" value=true ${user.isUsable()==true?'checked':''}>可用</input>
                <input type="radio" name="usable" value=false ${user.isUsable()==false?'checked':''}>不可用</input>
            </td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password", name="password"></td>
        </tr>
        <tr>
            <td><input type="submit"></td>
            <td><input type="reset"></td>
        </tr>
    </table>
</form>
</body>
</html>
