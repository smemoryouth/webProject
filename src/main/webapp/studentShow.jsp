<%--
  Created by IntelliJ IDEA.
  User: 阿劼
  Date: 2018/12/12
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生列表</title>
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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
</head>
<body>
<nav id = "mianbao" aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/main">主页</a></li>
        <li class="breadcrumb-item active" aria-current="page">学生列表</li>
    </ol>
</nav>
<nav id = "daohang" class="navbar navbar-expand-lg navbar-light bg-light">
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
                <a class="nav-link" href="studentlist?action=addStudent">增加 <span class="sr-only">(current)</span></a>
            </li>
        </ul>
    </div>
</nav>

<div id = "list" class="container" pagination="p-new" pagenumber="1" totalnumber="3" paginationmax="1">
    <table class="table table-striped">
        <tr style="background-color:lightgoldenrodyellow">
            <th>学号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>班级</th>
            <th>备注</th>
            <th>操作</th>
        </tr>
        <tr>
            <c:forEach var="student" items="${ students }">
        <tr>
            <td>${student.value.id} </td>
            <td>${student.value.name}</td>
            <td>${student.value.sex}</td>
            <td>${student.value.age}</td>
            <td>${student.value.c_id}</td>
            <td>${student.value.s_extra}</td>
            <td>
                <a href="studentlist?action=modStudent&sid=${student.value.id}">修改</a>
                <a href="studentlist?action=delStudent&sid=${student.value.id}">删除</a>
            </td>
        </tr>
        </c:forEach>
        </tr>
    </table>
</div>
<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-center">
        <li class="page-item disabled">
            <a class="page-link" href="" tabindex="-1">previous</a>
        </li>
        <li class="page-item"><a class="page-link" href="studentlist">1</a></li>
        <li class="page-item"><a class="page-link" href="studentlist">2</a></li>
        <li class="page-item"><a class="page-link" href="studentlist">3</a></li>
        <li class="page-item">
            <a class="page-link" href="">next</a>
        </li>
    </ul>
</nav>
<script src="${pageContext.request.contextPath}/assets/js/jquery-1.12.0.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
</body>
</html>
