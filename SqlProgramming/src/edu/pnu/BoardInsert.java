package edu.pnu;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class BoardInsert {
	public static void main(String[] args) {
		Random rnd = new Random();

		try(Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/.h2/sqlprg", "sa", "abcd")) {
			if(!createTable(con)) return;

			PreparedStatement psmt = null;
			psmt = con.prepareStatement("insert into Board(title, content, id, visitcount) values(?, ?, ?, ?)");
			for (int i = 1; i <= 10; i++) {
				for (int j = 1; j <= 5; j++) {					
					psmt.setString(1, "title"+i);
					psmt.setString(2, "content"+i);
					psmt.setInt(3, j);
					psmt.setInt(4, rnd.nextInt(101));
					int result = psmt.executeUpdate();
					System.out.println("Board 테이블에 " + result + "개가 입력되었습니다.");	
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Done");
	}

	private static boolean createTable(Connection con) {
		// TODO Auto-generated method stub
		Statement st = null;
		try {
			st = con.createStatement();
			st.execute("DROP TABLE Board IF EXISTS");
			st.execute("CREATE TABLE Board ("
					+ "num int NOT NULL AUTO_INCREMENT PRIMARY KEY,"
					+ "title varchar(200) NOT NULL,"
					+ "content varchar(2000) NOT NULL,"
					+ "id int NOT NULL,"
					+ "postdate date NOT NULL DEFAULT(curdate()),"
					+ "visitcount int DEFAULT 0)");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (st != null) st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
}

