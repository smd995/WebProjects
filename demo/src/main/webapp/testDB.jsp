<%--
  Created by IntelliJ IDEA.
  User: smd99
  Date: 24. 10. 28.
  Time: 오후 4:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="org.zerock.demo.db.beans.*, java.util.*, java.sql.*, java.io.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);

    request.setCharacterEncoding("UTF-8");

    QueryBean.getConnection();

    ArrayList resArr = new ArrayList();


    try {
        resArr = QueryBean.getUserInfo();
    } catch (SQLException e) {
        out.print(e.toString());
    } finally {
        QueryBean.closeConnection();
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
