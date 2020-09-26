<%--
  Created by IntelliJ IDEA.
  User: mikan
  Date: 2020/9/28
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://www.layuicdn.com/layui/css/layui.css">
</head>
<style>
    .layui-input-block{
        width: 300px;
    }
    .layui-form{
        margin-top: 10%;
        margin-left: 30%;
    }
</style>
<body>
<form class="layui-form" action="${pageContext.request.contextPath}/userInfo/set" method="post" enctype="multipart/form-data">
    <div class="layui-form-item">
        <label class="layui-form-label">新昵称:</label>
        <div class="layui-input-block">
            <input type="text" name="username1" required  lay-verify="required" placeholder="请输入新昵称" autocomplete="off" class="layui-input">
        </div>
    </div>
        <div class="layui-form-item">
        <label class="layui-form-label">新号码:</label>
        <div class="layui-input-block">
            <input type="text" name="phone" required  lay-verify="required" placeholder="请输入新昵称" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">新头像:</label>
        <div class="layui-input-block">
            <input type="file" name="file" style="border:none" autocomplete="off"/>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <input class="layui-btn" type="submit" value="保存"/>
        </div>
    </div>
</form>
<c:if test="${not empty error}">
    <script>
        <%--layui.use('layer',()=>{--%>
        <%--    //layui.layer.msg('${error}',{icon:5})--%>
        <%--    layui.layer.msg('${error}')--%>
        <%--})--%>
        alert('${error}');
    </script>
<%--    <c:out value="${error}"/>--%>
</c:if>
</body>
<script src="https://www.layuicdn.com/layui/layui.js"></script>
</html>
