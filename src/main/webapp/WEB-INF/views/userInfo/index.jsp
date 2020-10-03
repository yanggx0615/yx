<%--
  Created by IntelliJ IDEA.
  User: mikan
  Date: 2020/9/26
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://www.layuicdn.com/layui/css/layui.css">
</head>
<body>
<table class="layui-hide" id="test"></table>
<script src="https://www.layuicdn.com/layui/layui.js"></script>
<script>
    layui.use('table',function (){
        var table = layui.table;

        table.render({
            elem:'#test'
            ,url:'${pageContext.request.contextPath}/user/find'
            ,cellMinWidth:80
            ,cols:[[
                {field:'username',width:80,title:'用户名'}
                ,{field:'phone',width:80,title:'电话'}
                ,{field:'portrait',width:80,title:'图片'}
            ]]
        })
    })
</script>
</body>
</html>