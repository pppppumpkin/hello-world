<%--
  Created by IntelliJ IDEA.
  User: liyingsong
  Date: 16-6-3
  Time: 上午10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.qunar.fresh.dao.impl.AccessCountDaoImpl" %>
<%@ page import="com.qunar.fresh.model.AccessCountInfo" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>页面访问信息统计</title>
</head>
<body>
<table border="1">
    <tr>
        <td>page</td>
        <td>username</td>
        <td>count</td>
    </tr>
    <%
        AccessCountDaoImpl accessCountDao = new AccessCountDaoImpl();
        List<AccessCountInfo> list = accessCountDao.show();
//            List<AccessCountInfo> list = request.getParameter("access_count_info_list");
        for (AccessCountInfo accessCountInfo : list) {
            String s1 = accessCountInfo.getPage();
            String s2 = accessCountInfo.getUsername();
            int i = accessCountInfo.getCount();
    %>
    <tr>
        <td><%=s1%>
        </td>
        <td><%=s2%>
        </td>
        <td><%=i%>
        </td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
