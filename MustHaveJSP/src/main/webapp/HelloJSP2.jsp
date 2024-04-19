<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%!
// String str1 = "JSP";
String str2 = "안녕하세요!! ";
String getMessage(String str1) {
	if (str1 == null) {
		return " 널널하네요.";
	} else if (str1.equals("JSP")) {
		return " 쉬운 것 같아요.";
	} else {
		return " 노력합시다.";
	}
}
%>

<%!
String getScore(String str3) {
	if (str3 == null) {
		return " 시작해볼까요?";
	} else if (str3.equals("100")) {
		return " 멋져요.";
	} else {
		return " 노력하셨네요";
	}
}
%>

<%
String str1 = request.getParameter("lang");
String str3 = request.getParameter("score");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HelloJSP</title>
</head>
<body>
	<h2>처음 만들어보는 <%=str1%></h2>
	<p>
		<%
			out.println(str2 + str1 + "입니다." + getMessage(str1) + getScore(str3));
		%>
	</p>
</body>
</html>