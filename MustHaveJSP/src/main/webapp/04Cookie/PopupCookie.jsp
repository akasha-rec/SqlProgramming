<!-- 오늘 하루 동안 열지 않음 check > 1 전달 > 팝업이 하루 동안 뜨지 않도록 설정 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String chkVal = request.getParameter("inactiveToday");

if (chkVal != null && chkVal.equals("1")) {
	Cookie cookie = new Cookie("PopupClose", "off"); //쿠키 생성
	cookie.setPath(request.getContextPath());
	cookie.setMaxAge(60*60*24);
	response.addCookie(cookie);
	out.println("쿠키 : 하루 동안 열지 않음");
}
/* System.out.println("check" + chkVal); 호출이 되는지 안 되는지 확인*/
%>