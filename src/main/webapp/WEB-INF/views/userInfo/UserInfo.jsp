<%--
  Created by IntelliJ IDEA.
  User: mikan
  Date: 2020/9/28
  Time: 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://www.layuicdn.com/layui/css/layui.css">
</head>
<style>
    .layui-nav-tree{
        margin: 0px;
        float: left;
    }
</style>
<body>
<ul class="layui-nav layui-nav-tree" lay-filter="test">
    <!-- 侧边导航: <ul class="layui-nav layui-nav-tree layui-nav-side"> -->
    <li class="layui-nav-item layui-nav-itemed">
        <a style=”opacity:0.2”>用户主页</a>
        <dl class="layui-nav-child">
            <dd><a href="${pageContext.request.contextPath}/userInfo/find">用户详情</a></dd>
            <dd><a href="${pageContext.request.contextPath}/userInfo/collect">我的收藏</a></dd>
            <dd><a href="${pageContext.request.contextPath}/userInfo/myData">已发布</a></dd>
            <dd><a href="">发布</a></dd>
        </dl>
    </li>
</ul>
</body>
<script src="https://www.layuicdn.com/layui/layui.js"></script>
</html>
