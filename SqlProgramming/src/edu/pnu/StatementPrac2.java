package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class StatementPrac2 {

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
			ResultSet rs = st.executeQuery("select * from country");
			ResultSetMetaData meta = rs.getMetaData();
			int count = meta.getColumnCount();
			
			while(rs.next()) {
				for (int i = 1; i <= count; i++) {
					System.out.print(rs.getString(i) + ((i==count)? "\n" : ", "));
//				System.out.print(rs.getString("code") + " ");
//				System.out.print(rs.getString("name") + " ");
//				System.out.print(rs.getString("continent") + " ");
//				System.out.print(rs.getString("region") + " ");
//				System.out.print(rs.getString("surfacearea") + " ");
//				System.out.print(rs.getString("indepyear") + " ");
//				System.out.print(rs.getString("population") + " ");
//				System.out.print(rs.getString("lifeexpectancy") + " ");
//				System.out.print(rs.getString("gnp") + " ");
//				System.out.print(rs.getString("gnpold") + " ");
//				System.out.print(rs.getString("localname") + " ");
//				System.out.print(rs.getString("governmentform") + " ");
//				System.out.print(rs.getString("headofstate") + " ");
//				System.out.print(rs.getString("capital") + "\n");
				}
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			System.out.println("연결 실패 " + e.getMessage());
		}

	}

}
