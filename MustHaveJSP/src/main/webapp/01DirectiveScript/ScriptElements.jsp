<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
public int add(int num1, int num2) {
	return num1 + num2;
}
%>
<%
int num3;
int num4;
try {
	num3 = Integer.parseInt(request.getParameter("num1"));
	num4 = Integer.parseInt(request.getParameter("num2"));
} catch (NumberFormatException e) {
	num3 = 30;
	num4 = 40;
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트 요소</title>
</head>
<body>
<%
int result = add(10, 20);
%>
덧셈 결과 1 : <%= result %> <br />
덧셈 결과 2 : <%= add(30, 40) %> <br />
덧셈 결과 3 : <%= add(num3, num4) %>
</body>
</html>