<%--
  Created by IntelliJ IDEA.
  User: L
  Date: 2018/11/27
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录</title>
    <link href="css/login.css" rel="stylesheet" type="text/css">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script>
        $(function () {
            $("#submit").click(function () {
                var username = $("#username").val();
                var password = $("#password").val();
                $.ajax({
                    url: "user/login",
                    type: "POST",
                    data : {
                        "username": username,
                        "password": password
                    },
                    dataType: "json",
                    success: function (data) {
                        if(data){
                            window.location.href = "views/home.html";
                        }else {
                            alert("用户名或密码错误：");
                            window.location.href = "index.jsp";
                        }
                    },
                    error: function (jqXHR) {
                        alert("发生错误："+jqXHR.status);
                        window.location.href = "index.jsp";
                    }
                })
            });
            $("#password").val("");
        })
    </script>
</head>
<body>
<div class="centerMainDiv">
    <div class="makeCenter">
        <form id="loginForm" name="loginForm" action="user/login" method="post">
            <div>
                <input class="formInput" type="text" name="username" id="username" placeholder="用户名..." />
                <input class="formInput" type="password" name="password" id="password" placeholder="密码..." />
            </div>
            <div>
                <input class="formInput1" id="submit" type="submit" value="管理员登录"/>
            </div>
        </form>
    </div>
</div>
</body>
</html>
