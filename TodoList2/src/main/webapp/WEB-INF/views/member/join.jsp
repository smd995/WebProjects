<%--
  Created by IntelliJ IDEA.
  User: smd99
  Date: 24. 11. 5.
  Time: 오전 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>로그인</h1>
<div class="login-box">
    <form action="/member/join" method="post">
        <div>
            ID:<input type="text" name="id">
        </div>
        <div>
            Password:<input type="password" name="password">
        </div>
        <div>
            Email:<input type="text" name="email1">@<input type="text" name="email2">
        </div>
        <div>
            <input type="submit">
        </div>
    </form>
</div>
</body>
</html>
