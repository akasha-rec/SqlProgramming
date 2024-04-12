package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryByStatement {

	public static void main(String[] args) {
		
		Connection con = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "scott";
			String password = "tiger";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			
			Statement st = con.createStatement();//질의할 수 있는 객체
			ResultSet rs = st.executeQuery("select id, name, countrycode, district, population from city limit 10");//select한 데이터 결과를 ResultSet으로 받아
			
			while(rs.next()) {//cursor processing : 한 record씩 읽어가는 것
				System.out.print(rs.getString("id") + ",");
				System.out.print(rs.getString("name") + ",");
				System.out.print(rs.getString("countrycode") + ",");
				System.out.print(rs.getString("district") + ",");
				System.out.print(rs.getString("population") + "\n");
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		}

	}

}
