<%--
  Created by IntelliJ IDEA.
  User: mikan
  Date: 2020/10/7
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="UserInfo.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<style>
    #u{
        padding-top: 120px;
        margin-left: 40%;
        font-size: 20px;
        line-height: 80px;
    }
    #p{
        margin-left: 48%;
        font-size: 20px;
    }
    li{
        line-height: 30px;
    }
    #a{background-color: cadetblue}
</style>
<body>
<ul id="u">
    <c:forEach items="${pageInfo.list}" var="data">
        <li><span>作品名称:</span><a id="a" href="<c:url value='data.jsp'/>">${data.name}</a></li>
        <li><span>发布时间:</span>${data.dataDate}</li>
        <li>-------------------------------------------------------</li>
    </c:forEach>
</ul>

<c:choose>
    <c:when test="${pageInfo.pages <= 10}">
        <c:set var = "begin" value = "1"></c:set>
        <c:set var = "end" value = "${pageInfo.pages}"></c:set>
    </c:when>
    <c:otherwise>
        <c:set var = "begin" value ="${pageInfo.pageNum-5}"></c:set>
        <c:set var = "end" value ="${pageInfo.pageNum+4}"></c:set>
        <c:if test="${begin<=1}">
            <c:set var = "begin" value = "1"></c:set>
            <c:set var = "end" value = "10"></c:set>
        </c:if>
        <c:if test="${end>=pageInfo.pages}">
            <c:set var = "begin" value = "${pageInfo.pages-9}"></c:set>
            <c:set var = "end" value = "${pageInfo.pages}"></c:set>
        </c:if>
    </c:otherwise>
</c:choose>

<p id="p">
    <c:forEach var="index" begin="${begin}" end="${end}">
        <c:choose>
            <c:when test="${index ==  pageInfo.pageNum}">
                [${index}]&nbsp;&nbsp;
            </c:when>
            <c:otherwise>
                <a href="<c:url value='/user/${method}?pageNum=${index}'/>">${index}</a>&nbsp;&nbsp;
            </c:otherwise>
        </c:choose>
    </c:forEach>
</p>
</body>
</html>
