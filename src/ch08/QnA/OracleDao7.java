package ch08.QnA;

public class OracleDao7 implements DataAccessObject7{
	public void select() {
		System.out.println("Oracle DB에서 검색");
	}
	public void insert() {
		System.out.println("Oracle DB에 삽입");
	}
	public void update() {
		System.out.println("Oracle DB를 수정");
	}
	public void delete() {
		System.out.println("Oracle DB에서 삭제");
	}
}