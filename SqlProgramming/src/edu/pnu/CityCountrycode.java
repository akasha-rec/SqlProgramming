package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class CityCountrycode {
	public static void main(String[] args) {
		
		Connection con = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "scott", "tiger");
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select countrycode, population from city order by countrycode asc, population desc");
			
			ResultSetMetaData meta = rs.getMetaData();
			int count = meta.getColumnCount();
			
			while (rs.next()) {
				for (int i = 1; i <= count; i++) {
					System.out.print(rs.getString(i) + ((i == count)? "\n" : " "));
				}
				System.out.println();
			}
			rs.close();
			st.close();
			con.close();
		}
		catch (Exception e) {
			System.out.println("연결 실패" + e.getMessage());
		}
	}
}
