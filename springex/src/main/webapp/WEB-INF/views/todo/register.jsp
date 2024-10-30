<%--
  Created by IntelliJ IDEA.
  User: smd99
  Date: 24. 10. 21.
  Time: 오후 4:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo Register</title>
</head>
<body>
<form action="/todo/register" method="post">
    <div>
        Title: <input type="text" name="title" placeholder="INSERT TITLE">
    </div>
    <div>
        DueDate: <input type="date" name="dueDate">
    </div>
    <div>
        Writer: <input type="text" name="writer" placeholder="INSERT WRITER">
    </div>
    <div>
        Done: <input type="checkbox" name="done">
    </div>
    <div>
        <button type="submit">REGISTER</button>
    </div>
</form>
</body>
</html>
