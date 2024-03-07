package ch20.oracle.sec05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
/**
 * 간단하게 update 만 확인
 * */
public class ConnectionExample02 {
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
			
			PreparedStatement stmt = conn.prepareStatement("UPDATE users SET username=?, userpassword=?, userage=? WHERE userid=?");
			Scanner scanner = new Scanner(System.in);
			
			while(true) {
				System.out.print("변경 자료를 찾기 위한 아이디 입력 : ");
				String userid = scanner.nextLine();
				if (userid.equals("q")) break;
				
				System.out.print("이름 : ");
				String username = scanner.nextLine();
				System.out.print("비밀번호 : ");
				String userpassword = scanner.nextLine();
				System.out.print("나이 : ");
				int userage = scanner.nextInt();
				//enter 키를 무시하기 위함.
				scanner.nextLine();
				
				//입력 값을 설정 한다.
				stmt.setString(1, username);
				stmt.setString(2, userpassword);
				stmt.setInt(3, userage);
				stmt.setString(4, userid);

				System.out.println("입력된 아이디 : " + userid);
				int updated = stmt.executeUpdate();
				System.out.println("변경 건수 : " +updated);
			}
			stmt.close();
			scanner.close();
			
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