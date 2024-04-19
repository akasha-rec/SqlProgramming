<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String sel = request.getParameter("type");
String num = request.getParameter("column");

if (sel != null && num != null) {
	if (sel.equals("type1")) {
		response.sendRedirect("gugudan1.jsp?dan=" + num);
	} else {
		response.sendRedirect("gugudan2.jsp?col=" + num);
	}
}
%>
</body>
</html>