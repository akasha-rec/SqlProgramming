<%@ page import = "common.Person" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
pageContext.setAttribute("pageInteger", 1000);
pageContext.setAttribute("pageString", "페이지 영역의 문자열");
pageContext.setAttribute("pagePerson", new Person("한석봉", 99));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page 영역</title>
</head>
<body>
	<h2>page 영역의 속성값 읽기</h2>
	<%
	int pInteger = (Integer)(pageContext.getAttribute("pageInteger"));
	String pString = pageContext.getAttribute("pageString").toString();
	Person pPerson = (Person)(pageContext.getAttribute("pagePerson"));
	%>
	<ul>
	<li>Integer 객체 : <%= pInteger %></li>
	<li>String 객체 : <%= pString %></li>
	<li>Person 객체 : <%= pPerson.getName() %>, <%= pPerson.getAge() %></li>
	</ul>
	
	<h2>include된 파일에서 page 영역 읽어오기</h2>
	<!-- include는 문서 안에 또 다른 문서를 포함하는 형태 > 포함시킬 파일을 생성할 때는 page 지시어 외에 나머지 HTML 코드는 삭제 후 작성해야 -->
	<%@ include file = "PageInclude.jsp" %>
	
	<h2>페이지 이동 후 page 영역 읽어오기</h2>
	<!-- sendRedirect와 같은 효과, page 객체가 새로 생성되서 값 없음이 출력됨-->
	<a href="PageLocation.jsp">PageLocation.jsp 바로가기</a>
</body>
</html>