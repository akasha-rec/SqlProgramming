<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 horizontal</title>
</head>
<body>
<%
	String snum = request.getParameter("col");
	int num = 3;
	if (snum != null)
		num = Integer.parseInt(request.getParameter("col"));
		for (int i = 2; i < 10; i+=num) {
			for (int j = 1; j < 10; j++) {
				for (int k = i; k < i+num && k <= 9; k++) {
					out.print(k + " * " + j + " = " + (k*j) + "&nbsp".repeat(5));	
				}
				out.print("<br />");
			}
			out.print("<br />");
}
%>
</body>
</html>