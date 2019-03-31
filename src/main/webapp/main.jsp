<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 阿劼
  Date: 2018/12/7
  Time: 0:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教务管理系统</title>
    <style>
        #mianbao{
            max-height: 25px !important;
        }
        #daohang{
            margin-top: 2px;
            background-color: #71dd8a !important;
        }

    </style>
    <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
</head>
<body>
<script src="assets/js/jquery-1.12.0.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item active" aria-current="page">主页</li>
    </ol>
</nav>
<nav id = "mianbao" class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">导航</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div id ="daohang" class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/main">主页 <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/teacherlist">教师管理</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/studentlist">学生管理</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/clazzlist">班级管理</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/gradelist">成绩管理</a>
            </li>
        </ul>
    </div>
</nav>
</body>
</html>
