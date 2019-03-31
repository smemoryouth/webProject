<%--
  Created by IntelliJ IDEA.
  User: 阿劼
  Date: 2018/12/11
  Time: 23:28
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
    <title>修改班级信息</title>

    <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
</head>
<body>
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/main">主页</a></li>
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/clazzlist">教师列表</a></li>
        <li class="breadcrumb-item active" aria-current="page">修改班级信息</li>
    </ol>
</nav>
<div class="container">
    <%--需要一个表单--%>
    <div class="row justify-content-center" >
        <div class="col-5">
            <form role="form" method="post" action="${pageContext.request.contextPath}/clazzlist">
                <input type="hidden" name="cid" value="${clazz.id}">
                <input type="hidden" name="action" value="modifyClazz">

                <div class="form-group">
                    <label>名称</label>
                    <input type="text" name="c_name" class="form-control" value="${clazz.c_name}">
                </div>
                <div class="form-group">
                    <label>班主任</label>
                    <input type="text" name="c_teacher" class="form-control" value="${clazz.c_teacher}">
                </div>
                <div class="form-group">
                    <label>学生数量</label>
                    <input type="text" name="c_s_number" class="form-control" value="${clazz.c_s_number}">
                </div>
                <div class="form-group">
                    <label>备注</label>
                    <input type="text" name="c_extra" class="form-control" value="${clazz.c_extra}">
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
