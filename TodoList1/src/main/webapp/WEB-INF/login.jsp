<%--
  Created by IntelliJ IDEA.
  User: smd99
  Date: 24. 10. 22.
  Time: 오후 4:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

    <c:if test="${param.result == 'error'}">
        <h1>로그인 에러</h1>
    </c:if>

    <form action="/login" method="post">
        <input type="text" name="mid">
        <input type="text" name="mpw">
        <input type="checkbox" name="auto">
        <button type="submit">LOGIN</button>
    </form>

</body>
</html>
