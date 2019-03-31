<%--
  Created by IntelliJ IDEA.
  User: 阿劼
  Date: 2018/11/25
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>登录页面</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">

</head>
<body>
<div class="container" style="margin-top: 100px;">
    <div class="row justify-content-center">
        <div class="col-5">
            <%--http://www.tulun.com/login jsp页面发起action或者请求资源，一定要携带context上下文路径--%>
            <form id="001" role="form" method="post" action="${pageContext.request.contextPath}/login">
                <div class="form-group">
                    <label>用户名</label>
                    <input id="username" type="text" name="name" class="form-control" placeholder="输入用户名/手机/邮箱">
                </div>
                <div class="form-group" id = "divpsw">
                    <label>密码</label>
                    <input id="userpwd" type="password" name="password" class="form-control" placeholder="输入密码">
                </div>

                <input type="hidden" name="action" value="login">
                <button id = "button01" type="button" class="btn btn-primary btn-block">登录</button>
            </form>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/assets/js/jquery-1.12.0.min.js"></script>
<script>

    $(document).ready(function(){
        $("#username").focus(function () {
            $("#username").css("border-color", "");
        });

        $("#userpwd").focus(function () {
            $("#userpwd").css("border-color", "");

        });

        $("#button01").click(function(){

            var name = $("#username").val();
            var pwd = $("#userpwd").val();
            // 用户没有输入
            if(name.trim() === ""){
                $("#username").css("border-color", "red");
                return;
            }
            if(pwd.trim() === ""){
                $("#userpwd").css("border-color", "red");
                return;
            }
            $.ajax({
                //
                type: "post",
                url: "${pageContext.request.contextPath}/login",
                data: {
                    name:name,
                    pwd:pwd,
                    action:"login"
                },
                dataType:"json",
                // true表示异步，默认是true
                async: true,
                success: function(data){
                    if(data.code === 100){
                        var errdiv = "<div class=\"form-group\" id=\"errinfo\">\n" +
                            "  <label style=\"color: red;\">用户名或者密码错误</label>\n" +
                            "  </div>";
                        $("#divpsw").after(errdiv);
                    }else {
                        var url = "${pageContext.request.contextPath}" + data.url;
                        $(location).attr("href", url);
                    }
                }
            });
        });

    });
</script>
</body>
</html>



