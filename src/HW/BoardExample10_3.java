package HW;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

//수정 중간_1 과정(반복 코드 정리)
/*
 * Java, SQL, jdbc, b/l 모두 하나의 클래스에서 구현됨.
 * */
public class BoardExample10_3 {
   //Field
   private Scanner scanner = new Scanner(System.in);
   private static Connection conn = null;
   private static PreparedStatement stmt1 = null;
   private static PreparedStatement stmt2 = null;
   private static PreparedStatement stmt3 = null;
   private static PreparedStatement stmt4 = null;
   private static PreparedStatement stmt5 = null;
   private static PreparedStatement stmt6 = null;

   static {
	   try {
			//JDBC Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");

			//연결하기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe",
					"bituser", //계정 이름
					"1004" //계정 비밀번호
					);
			
			stmt1 = conn.prepareStatement("SELECT * FROM boards");
			stmt2 = conn.prepareStatement("INSERT INTO boards(bno, btitle, bcontent, bwriter, bdate) VALUES (seq_bno.nextval, ?, ?, ?, sysdate)");
			stmt3 = conn.prepareStatement("UPDATE boards SET btitle=?, bcontent=?, bwriter=? WHERE bno=?");
			stmt4 = conn.prepareStatement("DELETE FROM boards WHERE bno=?");
			stmt5 = conn.prepareStatement("DELETE FROM boards");
			stmt6 = conn.prepareStatement("SELECT * FROM boards WHERE bno=?");
			
	   } catch(SQLException e) {
			e.printStackTrace();
	   } catch(ClassNotFoundException e) {
			e.printStackTrace();
	   }
   }
   
   //Method      
   public void list() {
      System.out.println();
      System.out.println("[게시물 목록]");
      System.out.println("-----------------------------------------------------------------------");
      System.out.printf("%-6s%-12s%-12s%-16s%-40s\n", "no", "title", "writer", "date", "content");
      System.out.println("-----------------------------------------------------------------------");
		try {
			ResultSet rs = stmt1.executeQuery();
			boolean bExistDate = false;
		
			while (rs.next()) {
				bExistDate = true;
				
				int bno = rs.getInt("bno");
				String bwriter = rs.getString("bwriter");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				LocalDate bdate = LocalDate.now();
				
				System.out.printf("%-6s%-12s%-12s%-16s%-40s\n"
								 , bno
								 , btitle
								 , bwriter
								 , bdate
								 , bcontent
								 );
				
				if (!bExistDate) {
					System.out.println("게시물의 자료가 존재하지 않습니다.");
				}
			}
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
      mainMenu();
   }
   
   public void mainMenu() {
      System.out.println("-----------------------------------------------------------------------");
      System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
      System.out.print("메뉴 선택: ");
      int menuNo = scanner.nextInt();
      
      switch(menuNo) {
         case 1 -> create();
         case 2 -> read();
         case 3 -> clear();
         case 4 -> exit();
      }
   }   
   
   public void create() {
	  scanner.nextLine();
      System.out.println("[새 게시물 입력]");
      System.out.print("제목: ");
      String title = scanner.nextLine();
      System.out.print("내용: ");    
      String content = scanner.nextLine();
      System.out.print("작성자: ");    
      String writer = scanner.nextLine();
      
      System.out.println("-----------------------------------------------------------------------");
      System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
      System.out.print("메뉴 선택: ");
      String menuNo = scanner.nextLine();
      if(menuNo.equals("1")) {
    	  try {  			  
  			  //입력 값을 설정 한다.
  			  conn.setAutoCommit(false);

			  stmt2.setString(1, title);
			  stmt2.setString(2, content);
			  stmt2.setString(3, writer);
			  stmt2.executeUpdate();

			  conn.commit();

  		  } catch (SQLException e) {
  			  e.printStackTrace();
  		  }
      }
      
      //게시물 목록 출력
      list();
   }
   
   public void read() {
      System.out.println("[게시물 읽기]");

		try {			
			System.out.print("자료를 찾기 위한 아이디 입력 : ");
			int userid = scanner.nextInt();
			stmt6.setInt(1, userid);

			ResultSet rs = stmt6.executeQuery();
			if (rs.next()) {
				//찾고자 하는 자료가 있음
				int bno = rs.getInt("bno");
				String bwriter = rs.getString("bwriter");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				LocalDate bdate = LocalDate.now();

				System.out.println("-------------------------------------------------------------------");
				System.out.printf("%-6s%-12s%-12s%-16s%-40s\n"
						 , bno
						 , btitle
						 , bwriter
						 , bdate
						 , bcontent
						 );
			} else {
				//찾고자 하는 자료가 없음
				System.out.println("찾고자 하는 데이터가 없습니다.");
			}
			rs.close();
   
         //보조 메뉴 출력
         System.out.println("-------------------------------------------------------------------");
         System.out.println("보조 메뉴: 1.Update | 2.Delete | 3.List");
         System.out.print("메뉴 선택: ");
         int menuNo = scanner.nextInt();
         
         switch(menuNo) {
         case 1 -> update(userid);
         case 2 -> delete(userid);
         case 3 -> list(); 
         }
      } catch (SQLException e) {
			e.printStackTrace();
		}
   }
   
   public void update(int userid) {
      //수정 내용 입력 받기
	  scanner.nextLine();
      System.out.println("[수정 내용 입력]");
      System.out.print("제목: ");    
      String title = scanner.nextLine();
      System.out.print("내용: ");    
      String content = scanner.nextLine();
      System.out.print("작성자: ");    
      String writer = scanner.nextLine();
      
      //보조 메뉴 출력
      System.out.println("-------------------------------------------------------------------");
      System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
      System.out.print("메뉴 선택: ");
      String menuNo = scanner.nextLine();
      
      if ("1".equals(menuNo)) {
		try {			
			conn.setAutoCommit(false);
			//입력 값을 설정 한다.
			stmt3.setString(1, title);
			stmt3.setString(2, content);
			stmt3.setString(3, writer);
			stmt3.setInt(4, userid);
			stmt3.executeUpdate();
			
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
      }
      //게시물 목록 출력
      list();
   }
   
   public void delete(int userid) {
		try {			
			conn.setAutoCommit(false);
			stmt4.setInt(1, userid);
			stmt4.executeUpdate();
			
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
      //게시물 목록 출력      
      list();
   }
      
   public void clear() {
      System.out.println("[게시물 전체 삭제]");
		try {						
			conn.setAutoCommit(false);
			stmt5.executeUpdate();
			
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
    //게시물 목록 출력      
    list();
   }
   
   public void exit() {
	   System.exit(0);
   }
   
   public static void main(String[] args) {
      BoardExample10_3 boardExample = new BoardExample10_3();
      boardExample.list();
   }
}