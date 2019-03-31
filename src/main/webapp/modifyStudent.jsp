<%--
  Created by IntelliJ IDEA.
  User: 阿劼
  Date: 2018/12/11
  Time: 23:23
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
    <title>修改学生信息</title>

    <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
</head>
<body>
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/main">主页</a></li>
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/studentlist">学生列表</a></li>
        <li class="breadcrumb-item active" aria-current="page">修改学生信息学生</li>
    </ol>
</nav>
<div class="container">
    <%--需要一个表单--%>
    <div class="row justify-content-center" >
        <div class="col-5">
            <form role="form" method="post" action="${pageContext.request.contextPath}/studentlist">
                <input type="hidden" name="sid" value="${student.id}">
                <input type="hidden" name="action" value="modifyStudent">

                <div class="form-group">
                    <label>姓名</label>
                    <input type="text" name="name" class="form-control" value="${student.name}">
                </div>
                <div class="form-group">
                    <label>年龄</label>
                    <input type="text" name="age" class="form-control" value="${student.age}">
                </div>
                <div class="form-group">
                    <label>班级</label>
                    <input type="text" name="c_id" class="form-control" value="${student.c_id}">
                </div>
                <div class="form-group">
                    <label>备注</label>
                    <input type="text" name="s_extra" class="form-control" value="${student.s_extra}">
                </div>

                <div class="form-group">
                    <label>性别</label>
                    <c:choose>
                        <c:when test="${student.sex == '男'}">
                            <input type="radio" name="sex" class="form-control" value="男" checked>男
                            <input type="radio" name="sex" class="form-control" value="女">女
                        </c:when>
                        <c:otherwise>
                            <input type="radio" name="sex" class="form-control" value="男">男
                            <input type="radio" name="sex" class="form-control" value="女" checked>女
                        </c:otherwise>
                    </c:choose>
                </div>
                <button type="submit" class="btn btn-primary btn-block">确定修改</button>
            </form>
        </div>
    </div>
</div>

<script src="assets/js/jquery-1.12.0.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
</body>
</html>
