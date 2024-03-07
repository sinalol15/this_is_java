package Users;

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
public class UserMain {
	// Field
	private Scanner scanner = new Scanner(System.in);
	UserDAO userDAO;

	public UserMain(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	// Method
	public void list() {
		System.out.println();
		System.out.println("[회원 목록]");
		System.out.println("-----------------------------------------------------------------------");
		System.out.printf("%-12s%-12s%-24s%-6s%-40s\n", "id", "name", "password", "age", "email");
		System.out.println("-----------------------------------------------------------------------");

		List<User> list = userDAO.list();
		for (User board : list) {
			board.print();
		}

		if (list.size() == 0) {
			System.out.println("회원의 자료가 존재하지 않습니다.");
		}

		mainMenu();
	}

	public void mainMenu() {
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("메인 메뉴: 1.입사 | 2.상세 정보 | 3.전체 퇴사 처리 | 4.종료");
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
		System.out.println("[입사 사원 정보 입력]");
		System.out.print("아이디: ");
		String id = scanner.nextLine();
		System.out.print("이름: ");
		String name = scanner.nextLine();
		System.out.print("비밀번호: ");
		String password = scanner.nextLine();
		System.out.print("나이: ");
		int age = scanner.nextInt();
		System.out.print("이메일: ");
		String email = scanner.nextLine();
		scanner.nextLine();

		System.out.println("-----------------------------------------------------------------------");
		System.out.println("보조 메뉴: 1.입사 | 2.취소");
		System.out.print("메뉴 선택: ");
		String menuNo = scanner.nextLine();
		if (menuNo.equals("1")) {
			userDAO.insert(new User(id, name, password, age, email));
		}

		// 게시물 목록 출력
		list();
	}

	public void read() {
		System.out.println("[사원 상세 정보 출력]");
		scanner.nextLine();
		System.out.print("사원 정보를 찾기 위한 ID 입력 : ");
		String userid = scanner.nextLine();
		User user1 = userDAO.read(userid);

		System.out.println("-------------------------------------------------------------------");
		user1.print();
		// 보조 메뉴 출력
		System.out.println("-------------------------------------------------------------------");
		System.out.println("보조 메뉴: 1.정보 수정 | 2.퇴사 | 3.사원 리스트");
		System.out.print("메뉴 선택: ");
		int menuNo = scanner.nextInt();

		switch (menuNo) {
		case 1 -> update(userid);
		case 2 -> delete(userid);
		case 3 -> list();
		}
	}

	public void update(String userid) {
		// 수정 내용 입력 받기
		scanner.nextLine();
		System.out.println("[사원 정보 수정 내용 입력]");
		System.out.print("아이디: ");
		String id = scanner.nextLine();
		System.out.print("이름: ");
		String name = scanner.nextLine();
		System.out.print("비밀번호: ");
		String password = scanner.nextLine();
		System.out.print("나이: ");
		int age = scanner.nextInt();
		System.out.print("이메일: ");
		String email = scanner.nextLine();
		scanner.nextLine();

		// 보조 메뉴 출력
		System.out.println("-------------------------------------------------------------------");
		System.out.println("보조 메뉴: 1.수정 | 2.취소");
		System.out.print("메뉴 선택: ");
		String menuNo = scanner.nextLine();

		if ("1".equals(menuNo)) {
			userDAO.update(new User(id, name, password, age, email));
		}
		// 게시물 목록 출력
		list();
	}

	public void delete(String userid) {
		userDAO.delete(userid);
		// 게시물 목록 출력
		list();
	}

	public void clear() {
		System.out.println("[사원 전체 퇴사 처리]");
		userDAO.clear();
		// 게시물 목록 출력
		list();
	}

	public void exit() {
		System.exit(0);
	}

	public static void main(String[] args) {
		UserDAO userDAO = new UserDAO();
		UserMain userExample = new UserMain(userDAO);
		userExample.list();
	}
}