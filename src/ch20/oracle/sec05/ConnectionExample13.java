package ch20.oracle.sec05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
/**
 * account 테이블을 통해 출입 관리
 * */
public class ConnectionExample13 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			//JDBC Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");

			//연결하기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe",
					"bituser", //계정 이름
					"1004" //계정 비밀번호
					);
			
			System.out.println("연결 성공");
			
			PreparedStatement stmt1 = conn.prepareStatement("UPDATE ACCOUNT SET BALANCE=BALANCE-? WHERE ano='111-11-1111'");
			PreparedStatement stmt2 = conn.prepareStatement("UPDATE ACCOUNT SET BALANCE=BALANCE+? WHERE ano='111-11-1112'");
			
			conn.setAutoCommit(false);
			//출금 값을 설정 한다.
			stmt1.setInt(1, 1000);
			//SQL 구문 실행
			stmt1.executeUpdate();
			//이 부분 오류 발생시
//			if(true) {
//				System.exit(0);
//			}
			
			//입력 값을 설정 한다.
			stmt2.setInt(1, 1000);
			//SQL 구문 실행
			stmt2.executeUpdate();
			
			//작업을 완료한다.
			conn.commit();
			
			stmt1.close();
			stmt2.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					//연결 끊기
					conn.close();
					System.out.println("연결 끊기");
				} catch (SQLException e) {}
			}
		}
	}
}