package edu.pnu; //모든 데이터 읽어오기. 완성본

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StatementPrac1 {
	public static void main(String[] args) {
	try(Scanner sc = new Scanner(System.in)) {//try with resource 자동으로 닫아줘. try X > sc.close() 해줘야 하는데
		System.out.print("Table Name : ");
		String tblname = sc.next();
		test(tblname);
	}
}
	public static void test(String tblname){
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null; //객체 안에 아무것도 없어. 실제 데이터는 서버 세션에 있어서 rs.method를 사용해서 데이터를 가져온다.
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "scott", "tiger");
			
			st = con.createStatement();
			rs = st.executeQuery("select id, name, countrycode, district, population from city");
			ResultSetMetaData meta = rs.getMetaData();//ResultSet이 가져온 데이터의 데이터(table에 대한 정보를 아무것도 모르는데 그 정보를 갖고 있다)
			int count = meta.getColumnCount();
			while(rs.next()) {
				for (int i = 1; i <= count; i++) {
					System.out.print(rs.getString(i) + ((i==count)? "\n":", ")); //인덱스를 이용해서 출력 > 몇 개인지 몰라
//					System.out.print(rs.getString("id") + " ");
//					System.out.print(rs.getString("name") + " ");
//					System.out.print(rs.getString("countrycode") + " ");
//					System.out.print(rs.getString("district") + " ");
//					System.out.print(rs.getString("population") + "\n");
				}
					System.out.println();
				}
		} catch (Exception e) {
			System.out.println("실행 실패 " + e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(st != null) st.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
