package HW;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

//수정 전(반복 코드 그대로)
public class BoardExample10_4 {
   //Field
   private Scanner scanner = new Scanner(System.in);
 
   //Method      
   public void list() {
      System.out.println();
      System.out.println("[게시물 목록]");
      System.out.println("-----------------------------------------------------------------------");
      System.out.printf("%-6s%-12s%-16s%-16s%-12s\n", "no", "title", "date", "content", "writer");
      System.out.println("-----------------------------------------------------------------------");

      // 아래 구문이 동작할 수 있게 기능 추가
      // select * from boards
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
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM boards");

			ResultSet rs = stmt.executeQuery();
		
			while (rs.next()) {
				int bno = rs.getInt("bno");
				String bwriter = rs.getString("bwriter");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				LocalDate bdate = LocalDate.now();
				
				System.out.printf("%-6s%-12s%-16s%-16s%-12s \n"
								 , bno
								 , btitle
								 , bdate
								 , bcontent
								 , bwriter
								 );
			}
			rs.close();
			stmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					//연결 끊기
					conn.close();
				} catch (SQLException e) {}
			}
		}
      mainMenu();
   }
   
   public void mainMenu() {
      System.out.println();
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
         //할일 : 입력된 정보를 기준으로 객체를 생성하여 배열에 저장 하는 기능을 구현한다
         // boardList.add(new Board(title, content, writer));
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
  			
  			  PreparedStatement stmt = conn.prepareStatement("INSERT INTO boards(bno, btitle, bcontent, bwriter, bdate) VALUES (seq_bno.nextval, ?, ?, ?, sysdate)");
  			  
  			  //입력 값을 설정 한다.
  			  conn.setAutoCommit(false);

			  stmt.setString(1, title);
			  stmt.setString(2, content);
			  stmt.setString(3, writer);
			  stmt.executeUpdate();

			  conn.commit();
			  stmt.close();

  		  } catch (ClassNotFoundException e) {
  			  e.printStackTrace();
  		  } catch (SQLException e) {
  			  e.printStackTrace();
  		  } finally {
  			  if(conn != null) {
  				  try {
  					  //연결 끊기
  					  conn.close();
  				  } catch (SQLException e) {}
  			  }
  		  }
      }
     
      //게시물 목록 출력
      list();
   }
   
   public void read() {
      System.out.println("[게시물 읽기]");
     
      // 아래 구문이 동작할 수 있게 기능 추가
      //select * from boards where bno = ?
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
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM boards WHERE bno=?");

			
			System.out.print("자료를 찾기 위한 아이디 입력 : ");
			int userid = scanner.nextInt();
			stmt.setInt(1, userid);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				//찾고자 하는 자료가 있음
				int bno = rs.getInt("bno");
				String bwriter = rs.getString("bwriter");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				LocalDate bdate = LocalDate.now();

				 System.out.printf("%-6s%-12s%-16s%-16s%-12s \n"
				 , bno
				 , btitle
				 , bdate
				 , bcontent
				 , bwriter
				 );
			} else {
				//찾고자 하는 자료가 없음
				System.out.println("찾고자 하는 데이터가 없습니다.");
			}
			rs.close();
			stmt.close();
   
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
      } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					//연결 끊기
					conn.close();
				} catch (SQLException e) {}
			}
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
      // 아래 구문이 동작할 수 있게 기능 추가
      // update 구문 완성해서 구현 해주세요
      if ("1".equals(menuNo)) {
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
			
			PreparedStatement stmt = conn.prepareStatement("UPDATE boards SET btitle=?, bcontent=?, bwriter=? WHERE bno=?");
			
			conn.setAutoCommit(false);
			//입력 값을 설정 한다.
			stmt.setString(1, title);
			stmt.setString(2, content);
			stmt.setString(3, writer);
			stmt.setInt(4, userid);
			stmt.executeUpdate();
			
			conn.commit();
			stmt.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					//연결 끊기
					conn.close();
				} catch (SQLException e) {}
			}
		}
      }
      //게시물 목록 출력
      list();
   }
   
   public void delete(int userid) {
      // 아래 구문이 동작할 수 있게 기능 추가
      // delete 구문 완성해서 구현 해주세요

      //할일 : 게시물 정보 삭제
      //boardList.remove(board);
      //boardSet.remove(board);
      //boardMap.remove(board.getBno());
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
						
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM boards WHERE bno=?");
			
			conn.setAutoCommit(false);
			stmt.setInt(1, userid);
			stmt.executeUpdate();
			
			conn.commit();
			stmt.close();			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					//연결 끊기
					conn.close();
				} catch (SQLException e) {}
			}
		}
      //게시물 목록 출력      
      list();
   }
     
   public void clear() {
      System.out.println("[게시물 전체 삭제]");
      // 아래 구문이 동작할 수 있게 기능 추가
      // delete 구문 완성해서 구현 해주세요
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
						
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM boards");
			
			conn.setAutoCommit(false);
			stmt.executeUpdate();
			
			conn.commit();
			stmt.close();			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					//연결 끊기
					conn.close();
				} catch (SQLException e) {}
			}
		}
    //게시물 목록 출력      
    list();
      //할일 : 게시물 전체 삭제 기능 구현
      //boardList.clear();
      //boardSet.clear();
      //boardMap.clear();
     
      //게시물 목록 출력
      list();
   }
   
   public void exit() {
      System.exit(0);
   }
   
   public static void main(String[] args) {
      BoardExample10_4 boardExample = new BoardExample10_4();
      boardExample.list();
   }
}


/*
트렌젝션 동작 할 수 있게 추가 할 것

setAutoCommit(false);

insert, delete, update 구문 실 행 후 commit() 실행 할 것
 
*/
