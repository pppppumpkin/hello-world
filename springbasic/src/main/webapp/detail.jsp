<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="com.qunar.fresh.dao.UserDaoImpl" %>
<%@ page import="com.qunar.fresh.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="org.joda.time.format.DateTimeFormatter" %>
<%@ page import="org.joda.time.format.DateTimeFormat" %>
<%--
  Created by IntelliJ IDEA.
  User: liyingsong
  Date: 16-6-11
  Time: 下午7:30
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title></title>
</head>
<body>
<table border="1">
    <caption>用户详情</caption>
    <tr>
        <td>用户名</td>
        <td>性别</td>
        <td>年龄</td>
        <td>备注</td>
        <td>创建时间</td>
        <td>最后编辑时间</td>
        <td>是否可用</td>
        <td>用户组</td>
        <td>操作</td>
    </tr>
    <%
        ApplicationContext context = new ClassPathXmlApplicationContext("daoImpl.xml");
        UserDaoImpl userDao = context.getBean(UserDaoImpl.class);
        request.setCharacterEncoding("utf-8");
        String name = new String(request.getParameter("name").getBytes("iso8859-1"),"utf-8");
        List<User> list = userDao.queryByName(name);
        for (User user : list) {
            if (user.isUsable()) {
    %>
    <tr>
        <td><%=user.getName()%></td>
        <td><%=user.getSex()%></td>
        <td><%=user.getAge()%></td>
        <td><%=user.getComment()%></td>
        <td><%=user.getCreateTime()%></td>
        <td><%=user.getLastEditTime()%></td>
        <td><%=user.isUsable()%></td>
        <td><%=user.getGroupId()%></td>
        <td><a href="index.jsp" >返回</a></td>
    </tr>
    <%
            }
        }
    %>
</table>

</body>
</html>
