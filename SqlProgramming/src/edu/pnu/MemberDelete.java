package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class MemberDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("id를 입력해주세요 : ");
		int num = sc.nextInt();
		try(Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/.h2/sqlprg", "sa", "abcd")) {
			PreparedStatement ps = null;
			ps = con.prepareStatement("Delete from Member where id=?");
			ps.setInt(1, num);
			
			int result = ps.executeUpdate();
			System.out.println("Member 테이블에서 " + result + "개가 삭제되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Done");
		sc.close();
	}

}
