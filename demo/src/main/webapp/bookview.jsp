<%@ page import="java.sql.*" contentType="text/html;charset=UTF-8"%>
<%
Class.forName("oracle.jdbc.driver.OracleDriver");
String url = "jdbc:oracle:thin:@localhost:1521:xe";
Connection dbconn = DriverManager.getConnection(url, "c##madang", "c##madang");
Statement stmt = dbconn.createStatement();

//String bookid = request.getParameter("bookid");
String bookid = request.getParameter("bookid") == null ? "1": request.getParameter("bookid").trim(); 

//if(bookid == null)
//  bookid = "1"; 

ResultSet myResultSet = stmt.executeQuery("SELECT * FROM BOOK WHERE bookid='" + bookid + "'");
if (myResultSet != null) {
	myResultSet.next();
%>
<html>

<head>
<meta http-equiv="content-type" content="text/html; charset=EUC-KR">
<title>** BOOK VIEW **</title>
</head>

<body bgcolor="white" text="black" link="blue" vlink="purple"
	alink="red">
	<table border="1" cellspacing="0" width="400" bordercolor="#9AD2F7"
		bordercolordark="white" bordercolorlight="#B9E0FA">
		<tr>
			<td width="150" height="23">
				<p align="center">
					<span style="font-size: 9pt;"><b>책 제 목</b></span>
				</p>
			</td>
			<td width="513">
				<p>
					<span style="font-size: 9pt;"> <%=myResultSet.getString("BOOKNAME")%></span>
				</p>
			</td>
		</tr>
		<tr>
			<td width="150" height="23">
				<p align="center">
					<span style="font-size: 9pt;"><b>출 판 사</b></span>
				</p>
			<td width="513">
				<p>
					<span style="font-size: 9pt;"> <%=myResultSet.getString("PUBLISHER")%></span>
				</p>
			</td>
		</tr>
		<tr>
			<td width="150" height="23">
				<p align="center">
					<span style="font-size: 9pt;"><b>가 격</b></span>
				</p>
			<td width="513">
				<p>
					<span style="font-size: 9pt;"> <%=myResultSet.getString("PRICE")%></span>
				</p>
			</td>
		</tr>
	</table>
	<table cellpadding="0" cellspacing="0" width="400" height="23">
		<tr>
			<td width="150">
				<p align="right">
					<span style="font-size: 9pt;"> <a href="booklist.jsp?">
							<font color="black">목록</font>
					</a></span>
				</p>
			</td>
		</tr>
	</table>
	<%
	}
	stmt.close();
	dbconn.close();
	%>
</body>
</html>