package com.num5268.food.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContract {
	
	private static Connection dbConn = null;
	
	static {
		
		String jdbcDriver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "food";
		String password = "food";
		
		try {
			Class.forName(jdbcDriver);
			
			if(dbConn == null) {
				dbConn 
				= DriverManager.getConnection(url,username,password);
			}
			System.out.println("오라클 접속 OK!!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("오라클 Driver를 찾을 수 없음");
			System.out.println("오라클 Ojdbc6.jar 를 확인해주세요");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("=".repeat(30));
			System.out.println("오라클 DBMS연결 실패!!");
			System.out.println("접속정보를 확인하세요!!");
			System.out.println("-".repeat(30));
			System.out.println("URL : " + url);
			System.out.println("User : " + username);
			System.out.println("PW : " + password);
			System.out.println("=".repeat(30));
		}
		
	}

	public static Connection getDbConn() {
		return dbConn;
	}
}
