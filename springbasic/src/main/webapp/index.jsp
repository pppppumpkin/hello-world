<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="com.qunar.fresh.dao.UserDaoImpl" %>
<%@ page import="com.qunar.fresh.model.User" %>
<html>
<body>
<head>
    <title>用户列表</title>
</head>
<%--<h2>Hello World!</h2>--%>
<form action="addUser" method="post">
    <table border="1" title="user">
        <caption>用户列表</caption>
        <tr>
            <td>用户名</td>
            <td>性别</td>
            <td>年龄</td>
            <td>备注</td>
            <td colspan="3">操作</td>
        </tr>
        <%
            ApplicationContext context = new ClassPathXmlApplicationContext("daoImpl.xml");
            UserDaoImpl userDao = context.getBean(UserDaoImpl.class);
            List<User> list = userDao.show();
            for (User user : list) {
                if (user.isUsable()) {
        %>
        <tr>
            <td><%=user.getName()%></td>
            <td><%=user.getSex()%></td>
            <td><%=user.getAge()%></td>
            <td><%=user.getComment()%></td>
            <td><a href="detail.jsp?name=<%=user.getName()%>">查看</a></td>
            <td><a href="deleteUser?name=<%=user.getName()%>">删除</a></td>
            <td><a href="edit.jsp?id=<%=user.getId()%>">修改</a></td>
        </tr>
        <%
                }
            }
        %>
        <tr>
            <td colspan="6">新增用户</td>
        </tr>
        <tr>
            <td>用户名</td>
            <td>性别</td>
            <td>年龄</td>
            <td>备注</td>
            <td>密码</td>
            <td colspan="2">操作</td>
        </tr>
        <tr>
            <td><input type="text" name="name"></td>
            <%--<td><input type="text" value="请输入文字" onfocus="this.value=''" onblur="if(this.value==''){this.value='请输入文字'}" /></td>--%>
            <td><input type="text" name="sex"></td>
            <td><input type="text" name="age"></td>
            <td><input type="text" name="comment"></td>
            <td><input type="password" name="password"></td>
            <td colspan="2"><input type="submit"></td>
        </tr>

    </table>
</form>
</body>
</html>
