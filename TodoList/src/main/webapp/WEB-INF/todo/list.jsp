<%--
  Created by IntelliJ IDEA.
  User: smd99
  Date: 24. 10. 21.
  Time: 오후 4:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Todo List</title>
</head>
<body>
    <h1>ListPage</h1>

    <ul>
        <c:forEach var="dto" items="${dtoList}">
            <li>
                <span><a href="/todo/read?tno=${dto.tno}">${dto.tno}</a></span>
                <span>${dto.title}</span>
                <span>${dto.dueDate}</span>
                <span>${dto.writer}</span>
                <span>${dto.done? "DONE":"NOT YET"}</span>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
