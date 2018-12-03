<%--
  Created by IntelliJ IDEA.
  User: L
  Date: 2018/11/25
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>图书商城服务端管理系统</title>
    <link href="css/bootstrap-combined.min.css" rel="stylesheet" />
    <link href="css/layoutit.css" rel="stylesheet" />
    <!-- 可视化对bootstrap4.0及以上版本兼容性不好 -->
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>主页</title>

    <script type="text/javascript">
        $(function () {
            $("#search").click(function () {
                $.ajax({
                    url: "/user/viewUser?username="+$("#username").val(),
                    type: "GET",
                    dataType: "json",
                    success: function (data) {
                        if(data.id){
                            var html = "";
                            html += "<tr><th>用户id</th><th>用户名</th><th>密码</th><th>电话号码</th><th>手机号码</th><th>邮箱</th><th>地址</th></tr>";
                            html += "<tr><td>"+data.id+"</td><td>"+data.username+"</td><td>"+data.password+"</td><td>"+data.phone+"</td><td>"+data.cellphone+"</td><td>"+data.email+"</td><td>"+data.address+"</td></tr>";
                            $("#searchResult").html(html);
                        }else {
                            $("#searchResult").html("未查询到该用户");
                        }
                    },
                    error: function (jqXHR) {
                        alert("发生错误："+jqXHR.status);
                    }
                })
            })
        })
    </script>
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <h3 class="text-center text-info">
                图书商城服务端管理系统
            </h3>
        </div>
    </div>
    <div class="row-fluid">
        <div class="span2">
            <ul class="nav nav-list">
                <li class="nav-header">
                    <p>
                        用户管理
                    </p>
                </li>
                <li class="active">
                    <a href="#">用户信息查询</a>
                </li>

                <li class="nav-header">
                    书籍管理
                </li>
                <li>
                    <a href="#">书籍查看</a>
                </li>
                <li>
                    <a href="#">书籍录入</a>
                </li>
                <li class="nav-header">
                    订单管理
                </li>
                <li>
                    <a href="#">修改订单状态</a>
                </li>
            </ul>
        </div>
        <div class="span10">
            <form class="form-search">
                <input class="input-medium search-query" type="text"  name="username" id="username" /> <button type="submit" class="btn" id="search">查找</button>
            </form>
            <table class="table table-hover" id="searchResult">
                <thead>
                <tr>
                    <th>
                        用户id
                    </th>
                    <th>
                        用户名
                    </th>
                    <th>
                        密码
                    </th>
                    <th>
                        电话号码
                    </th>
                    <th>
                        手机号码
                    </th>
                    <th>
                        邮箱
                    </th>
                    <th>
                        地址
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                    </td>
                    <td>
                    </td>
                    <td>
                    </td>
                    <td>
                    </td>
                    <td>
                    </td>
                    <td>
                    </td>
                    <td>
                    </td>
                </tr>
                <tr class="success">
                    <td>
                    </td>
                    <td>
                    </td>
                    <td>
                    </td>
                    <td>
                    </td>
                    <td>
                    </td>
                    <td>
                    </td>
                    <td>
                    </td>
                </tr>
                <tr class="error">
                    <td>
                    </td>
                    <td>
                    </td>
                    <td>
                    </td>
                    <td>
                    </td>
                    <td>
                    </td>
                    <td>
                    </td>
                    <td>
                    </td>
                </tr>
                <tr class="warning">
                    <td>
                    </td>
                    <td>
                    </td>
                    <td>
                    </td>
                    <td>
                    </td>
                    <td>
                    </td>
                    <td>
                    </td>
                    <td>
                    </td>
                </tr>
                <tr class="info">
                    <td>
                    </td>
                    <td>
                    </td>
                    <td>
                    </td>
                    <td>
                    </td>
                    <td>
                    </td>
                    <td>
                    </td>
                    <td>
                    </td>
                </tr>
                </tbody>
            </table>
            <div class="pagination">
                <ul>
                    <li>
                        <a href="#">上一页</a>
                    </li>
                    <li>
                        <a href="#">1</a>
                    </li>
                    <li>
                        <a href="#">2</a>
                    </li>
                    <li>
                        <a href="#">3</a>
                    </li>
                    <li>
                        <a href="#">4</a>
                    </li>
                    <li>
                        <a href="#">5</a>
                    </li>
                    <li>
                        <a href="#">下一页</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>
