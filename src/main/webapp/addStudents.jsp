<%--
  Created by IntelliJ IDEA.
  User: 阿劼
  Date: 2018/12/12
  Time: 0:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>增加新学生</title>

    <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
</head>
<body>
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/main">主页</a></li>
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/studentlist">学生列表</a></li>
        <li class="breadcrumb-item active" aria-current="page">增加学生</li>
    </ol>
</nav>
<div class="container" style="margin-top: 100px;">
    <div class="row justify-content-center">
        <div class="col-5">
            <%--http://www.tulun.com/login jsp页面发起action或者请求资源，一定要携带context上下文路径--%>
            <form id="001" role="form" method="post" action="${pageContext.request.contextPath}/studentlist">
                <input type="hidden" name="action" value="addStudents">
                <div class="form-group">
                    <label>学号</label>
                    <input id="id01" type="text" name="sid" class="form-control" placeholder="输入学号">
                </div>
                <div class="form-group">
                    <label>姓名</label>
                    <input id = "name01" type="text" name="name" class="form-control" placeholder="输入姓名">
                </div>
                <div class="form-group">
                    <label>性别</label>
                    <input id = "sex01" type="text" name="sex" class="form-control" placeholder="输入性别">
                </div>
                <div class="form-group">
                    <label>年龄</label>
                    <input id = "age01" type="text" name="age" class="form-control" placeholder="输入年龄">
                </div>
                <div class="form-group">
                    <label>班级</label>
                    <input id = "class01" type="text" name="c_id" class="form-control" placeholder="输入班级">
                </div>
                <div class="form-group">
                    <label>备注</label>
                    <input type="text" name="s_extra" class="form-control" placeholder="备注信息，可为空">
                </div>
                <button id = "button01" type="submit" class="btn btn-primary btn-block">添加</button>
            </form>
        </div>
    </div>
</div>
<script src="assets/js/jquery-1.12.0.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery-1.12.0.min.js"></script>
</body>
</html>
