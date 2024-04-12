package edu.pnu;

public class DriverLoading {

	public static void main(String[] args){
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");//인스턴스 생성
		
		System.out.println("Success to Loading");
		
		} catch (ClassNotFoundException e) {
			System.out.println("Fail to Loading");
			System.out.println(e.getMessage());
		}

	}

}
