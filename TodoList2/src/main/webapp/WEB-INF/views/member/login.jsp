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
    <form action="/member/login" method="post">
        <div>
            <input type="text" name="id">
        </div>
        <div>
            <input type="password" name="password">
        </div>
        <div>
            <input type="submit">
        </div>
    </form>
</div>
<div class="join-box">
    <a href="/member/join"><span>회원가입</span></a>
</div>
</body>
</html>
