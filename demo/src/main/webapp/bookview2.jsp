<%@ page import="java.sql.*" contentType="text/html;charset=UTF-8"%>
<%
Class.forName("oracle.jdbc.driver.OracleDriver");
String url = "jdbc:oracle:thin:@localhost:1521:xe";
Connection dbconn = DriverManager.getConnection(url, "c##madang", "c##madang");
Statement stmt = dbconn.createStatement();

request.setCharacterEncoding("UTF-8");
//String bookid = request.getParameter("bookid");
String publisher = request.getParameter("publisher") == null ? "굿스포츠": request.getParameter("publisher").trim(); 

//if(bookid == null)
//  bookid = "1"; 

StringBuilder sb = new StringBuilder();
sb.append("");
sb.append(" SELECT NAME, BOOKNAME, PUBLISHER ");
sb.append("   FROM CUSTOMER A JOIN ORDERS B ON A.CUSTID = B.CUSTID ");
sb.append(" 				  JOIN BOOK C ON B.BOOKID = C.BOOKID ");
sb.append("  WHERE NAME IN (SELECT NAME ");
sb.append("					  FROM CUSTOMER A JOIN ORDERS B ON A.CUSTID = B.CUSTID ");
sb.append("									  JOIN BOOK C ON B.BOOKID = C.BOOKID ");
sb.append("					 WHERE PUBLISHER LIKE '"+publisher+"') ");

String query = sb.toString();
ResultSet rs = stmt.executeQuery(query);

%>
<html>

<head>
<meta http-equiv="content-type" content="text/html; charset=EUC-KR">
<title>** BOOK VIEW **</title>
</head>

<body bgcolor="white" text="black" link="blue" vlink="purple"
	alink="red">
	<table border="1" cellspacing="0" width="350" bordercolor="#9AD2F7"
		bordercolordark="white" bordercolorlight="#B9E0FA">
		<tr>
			<th width="50" height="23">
				<span style="font-size: 9pt;">고객명</span>
			</th>
			<th width="150" height="23">
				<span style="font-size: 9pt;">책이름</span>
			</th>
			<th width="100" height="23">
					<span style="font-size: 9pt;">출판사</span>
			</th>
		</tr>
		<%
		if (rs != null) {
			String name = "";
			while(rs.next()){
		%>
		<tr>
			<td >
			<%
				if(!name.equals(rs.getString("name"))){
					name = rs.getString("name");
			%>
				<span style="font-size: 9pt;"> <%=name%></span>
			<%
				}
				else{
			%>
					&nbsp;
			<%
				}
					
			%>
			</td>
			<td >
				<span style="font-size: 9pt;"> <%=rs.getString("bookname")%></span>
			</td>
			<td>
				<span style="font-size: 9pt;"> <%=rs.getString("publisher")%></span>
			</td>
		</tr>
		<%
			}
		}
		stmt.close();
		dbconn.close();
		%>
	</table>
	<table cellpadding="0" cellspacing="0" width="350" height="23">
		<tr>
			<td width="350">
				<p align="right">
					<span style="font-size: 9pt;"> <a href="booklist.jsp?">
							<font color="black">목록</font>
					</a></span>
				</p>
			</td>
		</tr>
	</table>

</body>
</html>