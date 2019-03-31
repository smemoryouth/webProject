<%--
  Created by IntelliJ IDEA.
  User: 阿劼
  Date: 2018/12/8
  Time: 9:09
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
    <title>修改教师信息</title>

    <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
</head>
<body>
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/main">主页</a></li>
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/teacherlist">教师列表</a></li>
        <li class="breadcrumb-item active" aria-current="page">修改教师信息</li>
    </ol>
</nav>
<div class="container">
    <%--需要一个表单--%>
    <div class="row justify-content-center" >
        <div class="col-5">
            <form role="form" method="post" action="${pageContext.request.contextPath}/teacherlist">
                <input type="hidden" name="tid" value="${teacher.id}">
                <input type="hidden" name="action" value="modifyTeacher">

                <div class="form-group">
                    <label>姓名</label>
                    <input type="text" name="name" class="form-control" value="${teacher.name}">
                </div>
                <div class="form-group">
                    <label>工资</label>
                    <input type="text" name="sal" class="form-control" value="${teacher.sal}">
                </div>
                <div class="form-group">
                    <label>备注</label>
                    <input type="text" name="extra" class="form-control" value="${teacher.extra}">
                </div>
                <div class="form-group">
                    <label>性别</label>
                    <c:choose>
                        <c:when test="${teacher.sex == '男'}">
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