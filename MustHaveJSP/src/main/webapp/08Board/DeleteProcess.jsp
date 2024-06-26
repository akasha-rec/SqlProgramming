<%@ page import = "model1.board.BoardDAO" %>
<%@ page import = "model1.board.BoardDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./IsLoggedIn.jsp" %>
<%
String num = request.getParameter("num");
BoardDTO dto = new BoardDTO();
BoardDAO dao = new BoardDAO(application);
dto = dao.selectView(num);

//로그인된 사용자 아이디 얻기
String sessionId = session.getAttribute("UserId").toString();

int delResult = 0;

if (sessionId.equals(dto.getId())) {
	dto.setNum(num);
	delResult = dao.deletePost(dto);
	dao.close();
	
	if (delResult == 1) {
		//성공 시 목록 페이지로 이동
		JSFunction.alertLocation("삭제되었습니다.", "List.jsp", out);
	} else {
		//실패 시 이전 페이지로 이동
		JSFunction.alertBack("본인만 삭제할 수 있습니다.", out);
		
		return;
	}
}
%>