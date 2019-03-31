<%--
  Created by IntelliJ IDEA.
  User: 阿劼
  Date: 2018/12/12
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师列表</title>
    <style>
        #mianbao{
            max-height: 25px !important;
        }
        #daohang{
            margin-top: 2px;
            background-color: #71dd8a !important;
        }

        #list{
            margin-top: 10px;
        }
    </style>
    <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
</head>
<body>
<script src="assets/js/jquery-1.12.0.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<nav id="mianbao" aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/main">主页</a></li>
        <li class="breadcrumb-item active" aria-current="page">教师列表</li>
    </ol>
</nav>
<nav id="daohang" class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="">导航</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/main">主页 <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="teacherlist?action=addTeacher">增加 <span class="sr-only">(current)</span></a>
            </li>
        </ul>
    </div>
</nav>
<div id="list" class="container">
    <table class="table table-striped">
        <tr style="background-color:lightgoldenrodyellow">
            <th>工号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>工资</th>
            <th>备注</th>
            <th>操作</th>
        </tr>
        <tr>
            <c:forEach var="teacher" items="${ teachers }">
        <tr>
            <td>${teacher.value.id} </td>
            <td>${teacher.value.name}</td>
            <td>${teacher.value.sex}</td>
            <td>${teacher.value.sal}</td>
            <td>${teacher.value.extra}</td>
            <td>
                <a href="teacherlist?action=modTeacher&tid=${teacher.value.id}">修改</a>
                <a href="teacherlist?action=delTeacher&tid=${teacher.value.id}">删除</a>
            </td>
        </tr>
        </c:forEach>
        </tr>
    </table>
</div>
</body>
</html>
