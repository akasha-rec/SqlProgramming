package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class KoreaDesc {

	public static void main(String[] args) {
		Connection con = null;
		
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "scott";
			String password = "tiger";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select name, population from city where countrycode='kor' order by population desc");
			
			while (rs.next()) {
				System.out.print(rs.getString("name") + " ");
				System.out.print(rs.getString("population") + "\n");
			}
			rs.close();
			con.close();
			st.close();
		} catch (Exception e) {
			System.out.println("연결 실패 " + e.getMessage());
		}

	}

}
