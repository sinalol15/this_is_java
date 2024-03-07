package ch20.oracle.sec05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
/**
 * 간단하게 ResultSet으로 데이터 정보 확인
 * */
public class ConnectionExample04 {
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
			System.out.println();

//----------------------------------------------------------------------------------------------------------------------------------------------
			
			//입력값에 대한 데이터 1개 추출
			
//			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE userid=?");
//
//			Scanner scanner = new Scanner(System.in);
//			
//			while(true) {
//				System.out.print("자료를 찾기 위한 아이디 입력 : ");
//				String userid = scanner.nextLine();
//				System.out.println();
//				if (userid.equals("q")) break;
//				
//				//입력 값을 설정 한다.
//				stmt.setString(1, userid);
//
//				ResultSet rs = stmt.executeQuery();
//				if (rs.next()) {
//					//찾고자 하는 자료가 있음
//					userid = rs.getString("userid");
//					String username = rs.getString("username");
//					String userpassword = rs.getString("userpassword");
//					int userage = rs.getInt("userage");
//					String usermail = rs.getString("usermail");
//					
//					System.out.println("userid : " + userid);
//					System.out.println("username : " + username);					
//					System.out.println("userpassword : " + userpassword);
//					System.out.println("userage : " + userage);
//					System.out.println("usermail : " + usermail);
//					System.out.println();
//				} else {
//					//찾고자 하는 자료가 없음
//					System.out.println("찾고자 하는 데이터가 없습니다.");
//				}
//				rs.close();
//			}
//			scanner.close();
//			stmt.close();
			
//----------------------------------------------------------------------------------------------------------------------------------------------

			//데이터 정보 전체 추출
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users");

			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				String userid = rs.getString("userid");
				String username = rs.getString("username");
				String userpassword = rs.getString("userpassword");
				int userage = rs.getInt("userage");
				String usermail = rs.getString("usermail");
				
				System.out.println("==============================");
				System.out.println();
				System.out.println("userid : " + userid);
				System.out.println("username : " + username);					
				System.out.println("userpassword : " + userpassword);
				System.out.println("userage : " + userage);
				System.out.println("usermail : " + usermail);
				System.out.println();
			}
			
			System.out.println("==============================");
			System.out.println();
			System.out.println("데이터 추출을 완료했습니다.");
			System.out.println();
			rs.close();
			stmt.close();
			
//----------------------------------------------------------------------------------------------------------------------------------------------

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