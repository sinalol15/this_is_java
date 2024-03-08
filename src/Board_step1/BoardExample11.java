package Board_step1;

import java.util.List;
import java.util.Scanner;

//수정 중간_2 과정(JAVA, JDBC 분리) -JAVA 작업

/**
 * 최초버전 : 메모리 배열
 * 
 * 목록 : 배열, 게시물 => 클래스 => board, Data(CRUD) => DB
 * 
 * JAVA = 서비스 + DAO
 */
public class BoardExample11 {
	// Field
	private Scanner scanner = new Scanner(System.in);
	BoardDAO boardDAO;

	public BoardExample11(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	// Method
	public void list() {
		System.out.println();
		System.out.println("[게시물 목록]");
		System.out.println("-----------------------------------------------------------------------");
		System.out.printf("%-6s%-12s%-12s%-24s%-40s\n", "no", "title", "writer", "date", "content");
		System.out.println("-----------------------------------------------------------------------");

		List<Board> list = boardDAO.list();
		for (Board board : list) {
			board.print();
		}

		if (list.size() == 0) {
			System.out.println("게시물의 자료가 존재하지 않습니다.");
		}

		mainMenu();
	}

	public void mainMenu() {
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
		System.out.print("메뉴 선택: ");
		int menuNo = scanner.nextInt();

		switch (menuNo) {
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
		if (menuNo.equals("1")) {
			boardDAO.insert(new Board(title, content, writer));
		}

		// 게시물 목록 출력
		list();
	}

	public void read() {
		System.out.println("[게시물 읽기]");

		System.out.print("자료를 찾기 위한 아이디 입력 : ");
		int userid = scanner.nextInt();
		Board board1 = boardDAO.read(userid);

		System.out.println("-------------------------------------------------------------------");
		board1.print();
		// 보조 메뉴 출력
		System.out.println("-------------------------------------------------------------------");
		System.out.println("보조 메뉴: 1.Update | 2.Delete | 3.List");
		System.out.print("메뉴 선택: ");
		int menuNo = scanner.nextInt();
		
		switch (menuNo) {
		case 1 -> update(userid);
		case 2 -> delete(userid);
		case 3 -> list();
		}
	}

	public void update(int userid) {
		// 수정 내용 입력 받기
		scanner.nextLine();
		System.out.println("[수정 내용 입력]");
		System.out.print("제목: ");
		String title = scanner.nextLine();
		System.out.print("내용: ");
		String content = scanner.nextLine();
		System.out.print("작성자: ");
		String writer = scanner.nextLine();

		// 보조 메뉴 출력
		System.out.println("-------------------------------------------------------------------");
		System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = scanner.nextLine();

		if ("1".equals(menuNo)) {
			boardDAO.update(new Board(userid, title, content, writer));
		}
		// 게시물 목록 출력
		list();
	}

	public void delete(int userid) {
		boardDAO.delete(userid);
		// 게시물 목록 출력
		list();
	}

	public void clear() {
		System.out.println("[게시물 전체 삭제]");
		boardDAO.clear();
		// 게시물 목록 출력
		list();
	}

	public void exit() {
		System.exit(0);
	}

	public static void main(String[] args) {
		BoardDAO boardDAO = new BoardDAO();
		BoardExample11 boardExample = new BoardExample11(boardDAO);
		boardExample.list();
	}
}