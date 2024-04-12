package edu.pnu;//업데이트 쿼리는 완성했는데 입력 데이터가 null일 때 수정에서 제외하는 조건을 만족하는 코드는 못했다. 그래도 발전은 있었네...
//입력하지 않은 데이터 제외하고 다른 데이터들은 업데이트 되는 게 맞다
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class MemberUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.print("username을 입력해주세요 : ");
		String name = sc.nextLine();
		System.out.print("password를 입력해주세요 : ");
		String password = sc.nextLine();
		System.out.print("생년을 입력해주세요 : ");
		Integer birthyear = sc.nextInt();//int로 하면 null을 인식하지 못한다!!
		System.out.print("id를 입력해주세요 : ");
		int id = sc.nextInt();
		
		try(Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/.h2/sqlprg", "sa", "abcd")) {
			
			String sql1 = "";//null : 아무것도 할당되지 않은 상태
			if (name != null && !name.isEmpty()) {//empty : 문자열의 길이가 0
				sql1 = "username='" + name + "'"; //username='user1'
			}
			if (password != null && !password.isEmpty()) {
				if(!sql1.isEmpty()) sql1 += ",";//username='user1',
				sql1 = sql1 + " password='" + password +"'"; //username='user1', password='pass1'
			}
			if (birthyear != null) {
				if(!sql1.isEmpty()) sql1 += ",";//username='user1', password='pass1',
				sql1 = sql1 + " birthyear=" + birthyear;//username='user1', password='pass1', birthyear=2000
			}
			String sql = "Update Member set " + sql1 + " where id=" + id;//"Update Member set username='user1', password='pass1', birthyear=2000 where id=5;
			Statement st = con.createStatement();
			int result = st.executeUpdate(sql);
			System.out.println("Member 테이블에서 " + result + "개가 업데이트 되었습니다.");
			
//			Member 테이블 그냥 update
//			PreparedStatement ps = null; >> 쿼리문이 완성된 상태 + ?에는 변수의 값을 세팅해줘야만 + 데이터가 들어가는 경우와 아닌 경우 if else문이 어마어마하게 늘어나
//			maintenance X and 동적 쿼리 : 실행 중에 바뀐다 Statement문 사용해야?
//			ps = con.prepareStatement("update Member set username=?, password=?, birthyear=? where id=?");
//
//			ps.setString(1, nm);
//			ps.setString(2, pw);
//			ps.setInt(3, by);
//			ps.setInt(4, num);
//			int result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Done");
		sc.close();
	}
}
