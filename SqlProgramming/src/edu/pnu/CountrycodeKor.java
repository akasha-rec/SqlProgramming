package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CountrycodeKor {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Code :");
		String code = sc.next();

		Statement st = null;
		ResultSet rs = null;

		//데이터베이스 연결 객체 만들기
		try {Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "scott", "tiger");

		//질의 객체 만들기
		st = con.createStatement();
		rs = st.executeQuery("select name, population from city where countrycode = 'kor' order by population desc");

		while (rs.next()) {
			System.out.println(rs.getString("Name") + "," + rs.getInt("population"));
		}

		} catch (Exception e) {
			try {
				rs.close();
				st.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}
		sc.close();
	}
}