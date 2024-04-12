package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "scott", "tiger");
			
			PreparedStatement pt = con.prepareStatement("select id, name, countrycode, district, population from city where countrycode = ?");
			pt.setString(1, "kor"); //인덱스 1부터 시작, 값
			ResultSet rs = pt.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getInt("id")+", ");
				System.out.print(rs.getString("name")+", ");
				System.out.print(rs.getString("countrycode")+", ");
				System.out.print(rs.getString("district")+", ");
				System.out.print(rs.getString("population")+"\n");
			}
			rs.close();
			pt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		}
	}

}
