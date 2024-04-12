package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class BoardDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요 :");
		int number = sc.nextInt();
		
		try(Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/.h2/sqlprg", "sa", "abcd")) {
			PreparedStatement psmt = null;
			psmt = con.prepareStatement("Delete from Board where num = ?");
			psmt.setInt(1, number);
			
			int result = psmt.executeUpdate();
			System.out.println("Board 테이블에서 " + result + " 개가 삭제되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Done");
		sc.close();
	}

}
