<%@ page import = "model1.board.BoardDAO" %>
<%@ page import = "model1.board.BoardDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./IsLoggedIn.jsp" %>
<%
//폼 값 받기
String title = request.getParameter("title");
String content = request.getParameter("content");

//폼 값을 DTO 객체에 저장
BoardDTO dto = new BoardDTO();
dto.setTitle(title);
dto.setContent(content);
//session 영역에 저장돼있는 사용자 아이디까지 담는 이유는 board 테이블의 id가 member 테이블의 id를 참조하고 있기 때문에
//id가 빈 값이면 insert 시 제약조건에 위배
dto.setId(session.getAttribute("UserId").toString());

//DAO 객체를 통해 DB에 DTO 저장
BoardDAO dao = new BoardDAO(application);
int iResult = dao.insertWrite(dto);
dao.close();

//성공 혹은 실패
if (iResult == 1) {
	response.sendRedirect("List.jsp");
} else {
	JSFunction.alertBack("글쓰기에 실패하였습니다.", out);
}
%>