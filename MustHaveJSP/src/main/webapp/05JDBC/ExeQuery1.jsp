<%@ page import = "java.sql.ResultSet" %>
<%@ page import = "java.sql.Statement" %>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "common.JDBConnect" %>
<%@ page import = "java.sql.PreparedStatement" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC</title>
</head>
<body>
	<h2>회원 목록 조회 테스트(executeQuery() 사용)</h2>

	<table border="1">
		<tr>
			<th>num</th>
			<th>title</th>
			<th>content</th>
			<th>name</th>
			<th>postdate</th>
			<th>visitcount</th>
		</tr>
	<%
/* 	String sql = "SELECT b.num, b.title, b.content, m.name, b.postdate, b.visitcount From board b, member m where b.id = m.id and b.id = 'musthave'";
	Statement stmt = jdbc.con.createStatement();
	ResultSet rs = stmt.executeQuery(sql); */
	JDBConnect jdbc = new JDBConnect();
	String id = request.getParameter("id");
	PreparedStatement ps = jdbc.con.prepareStatement("SELECT b.num, b.title, b.content, m.name, b.postdate, b.visitcount From board b, member m where b.id = m.id and b.id =?");
	ps.setString(1, id);
	
	ResultSet rs = ps.executeQuery();
	
	while (rs.next()) {
		int num = rs.getInt("num");
		String title = rs.getNString("title");
		String content = rs.getString("content");
		String name = rs.getString("name");
		java.sql.Date postdate = rs.getDate("postdate");
		int visitcount = rs.getInt("visitcount");
		/* out.println(String.format("%d %s %s %s %s %d", num, title, content, name, postdate, visitcount) + "<br/>" ); */
	%>
	<tr>
		<td><%= num %></td>
		<td><%= title %></td>
		<td><%= content %></td>
		<td><%= name %></td>
		<td><%= postdate %></td>
		<td><%= visitcount %></td>
	</tr>
	<%	
	}

	jdbc.close();
	%>
		</table>
</body>
</html>