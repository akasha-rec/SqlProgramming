<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 출력</title>
</head>
<body>
<%
	int num = Integer.parseInt(request.getParameter("dan"));
		for (int i = 1; i < 10; i++) {
			out.println(num + " * " + i + " = " +  num*i + "<br />");
}
%>
</body>
</html>