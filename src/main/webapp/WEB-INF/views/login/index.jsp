<%--
  Created by IntelliJ IDEA.
  User: liuyandong
  Date: 2018/7/17
  Time: 下午9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../libraries/jquery/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        function login() {
            var loginName = "liuyandong";
            var password = "123456";
            $.post("../login/login", {loginName: loginName, password: password}, function (result) {
                window.location.href = "http://localhost:8888/oauth/authorize?response_type=code&client_id=demoApp&redirect_uri=http://www.baidu.com";
            }, "json");
        }
    </script>
</head>
<body>
<div>
    <input type="text" name="loginName">
    <input type="password" name="password">
    <button onclick="login();">登录</button>
</div>
</body>
</html>
