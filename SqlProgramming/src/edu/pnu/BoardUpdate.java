package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class BoardUpdate {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("제목을 입력해주세요 : ");
		String st = sc.next();
		System.out.print("내용을 입력해주세요 : ");
		String str = sc.next();
		System.out.print("숫자를 입력해주세요 : ");
		int number = sc.nextInt();
		
		try(Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/.h2/sqlprg", "sa", "abcd")) {
			PreparedStatement ps = null;
			ps = con.prepareStatement("update Board set title=?, content=? where num=?");
			ps.setString(1, st);
			ps.setString(2, str);
			ps.setInt(3, number);
			
			int result = ps.executeUpdate();
			System.out.println("Board 테이블에서 " + result + "개가 업데이트 되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Done");
		sc.close();
	}

}
