<%--
  Created by IntelliJ IDEA.
  User: liyingsong
  Date: 16-6-12
  Time: 上午10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="editUser" method="post">
    <table>
        <tr>
            <td>id</td>
            <td><input type="text" name="id" value="<%=request.getParameter("id")%>"></td>
        </tr>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td><input type="text" name="sex"></td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type="text" name="age"></td>
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
</form>


</body>
</html>
