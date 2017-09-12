<%@ page import="java.net.URLDecoder" %>
<%--
  Created by IntelliJ IDEA.
  User: liyingsong
  Date: 16-6-17
  Time: 下午2:37
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<script type="text/javascript">
    function check(form) {
        if(form.source.value=='') {
            alert("请输入源文件");
            form.source.focus();
            return false;
        }
        if(form.target.value==''){
            alert("请输入目标文件");
            form.target.focus();
            return false;
        }
        return true;
    }

//    function logout() {
//
//    }
</script>

<head>
    <title>文件对比系统</title>
</head>
<body>
<%
//    String username = (String) session.getAttribute("username");
    String username = null;
    username = (String)request.getAttribute("username");
    int pageIndex = Integer.parseInt(request.getAttribute("page").toString());
    int size = Integer.parseInt(request.getAttribute("size").toString());
%>
<% if (username!=null){%>
<h4>Welcome!<%=username%></h4>
<%} else {%>
<h4>未登录用户</h4>
<%}%>

<%if (username==null) {%>
<a href="/user/login">登陆</a>
<%}%>
<%--else {%>--%>
<%--<a href="/user/login">注销</a>--%>
<%--<%} %>--%>
<br>
<br>
<br>

<form action="/file/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="source">
    <input type="file" name="target">
    <input type="submit" onclick="return check(this.form)">
</form>
<h3>历史对比记录</h3>
<table border="1">
    <tr>
        <td>用户名</td>
        <td>对比时间</td>
        <td>源文件内容</td>
        <td>目标文件内容</td>
        <td>差异</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${diffResultModelList}" var="diffResultModel">
        <tr>
            <td>${diffResultModel.userName}</td>
            <td>${diffResultModel.diffTime}</td>
            <td>${diffResultModel.sourceFile.replaceAll(";", "<br>")}</td>
            <td>${diffResultModel.targetFile.replaceAll(";", "<br>")}</td>
            <td>${diffResultModel.resultFile.replaceAll(";", "<br>")}</td>
            <%if (username!=null) {%>
            <td><a href="/file/delete?id=${diffResultModel.id}&username=<%=username%>">删除</a></td>
            <%} %>
        </tr>
    </c:forEach>
</table>

<%if (pageIndex > 1) {%>
<a href="/file/diff?page=${page-1}">上一页</a>
<%}%>
第${page}页

（${(page-1)*5+1}～<%= pageIndex*5<size?pageIndex*5:size%>条/
共${size}条）
<%if (pageIndex*5 < size) {%>
<a href="/file/diff?page=${page+1}">下一页</a>
<% }%>
<br>
<br>
<br>
<br>

</body>
</html>
