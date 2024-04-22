package membership;

import common.JDBConnect;

public class MemberDAO extends JDBConnect {
	public static void main(String[] args) {	
		
		String drv = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/musthave";
		String id = "scott";
		String pwd = "tiger";
		
		MemberDAO dao = new MemberDAO(drv, url, id, pwd);
		
		MemberDTO dto = dao.getMemberDTO("musthave", "1234");
		System.out.println(dto);
	}
	//명시한 데이터베이스로의 연결이 완료된 MemberDAO 객체를 생성
	public MemberDAO(String drv, String url, String id, String pw) {
		super(drv, url, id, pw);
	}
	
	//명시한 아이디/패스워드와 일치하는 회원 정보 반환
	public MemberDTO getMemberDTO(String uid, String upass) {
		MemberDTO dto = new MemberDTO(); //회원 정보 DTO 객체 생성
		String query = "SELECT * FROM member WHERE id=? and pass=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, uid);
			psmt.setString(2, upass);
			rs = psmt.executeQuery();
			
			//결과 처리
			if (rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getString(4));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return dto; //DTO 객체 반환
	}
}
