<%--
  Created by IntelliJ IDEA.
  User: mikan
  Date: 2020/9/28
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="UserInfo.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<style>
    #ul{
        margin-left: 45%;
        font-size: 20px;
    }
    li{
        line-height: 50px;
    }
    #a{background-color: cadetblue}
</style>
<body>
    <ul id="ul">
        <li>头像:</li>
        <li><img src="/images/${user.portrait}" width="100px" height="100px"/></li>
        <li>昵称:&nbsp;${user.username}</li>
        <li>电话:&nbsp;${user.phone}</li>
        <li><a id="a" href="${pageContext.request.contextPath}/userInfo/sets" style="text-decoration:none">修改</a></li>
    </ul>
</body>
</html>
