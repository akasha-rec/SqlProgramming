<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 - response</title>
</head>
<body>
<!-- 	아이디/비번을 파라미터로 받음. 단순 문자열 비교로 검증. 인증 성공인 경우 페이지 이동 or 실패 시 포워드 -->
<%
String id = request.getParameter("user_id");
String pwd = request.getParameter("user_pwd");
if (id.equalsIgnoreCase("must") && pwd.equalsIgnoreCase("1234")) {
	response.sendRedirect("ResponseWelcome.jsp");
}
else {
	request.getRequestDispatcher("ResponseMain.jsp?loginErr=1")
		.forward(request, response);
/* 	서버가 request를 그대로 가져와서 어쩌고 저쩌고.. ResponseMain.jsp 호출해서 browser에게 띄우라고 한다? */
}
%>
</body>
</html>