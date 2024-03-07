package ch12.sec04;

public class ErrExample {

	public static void main(String[] args) {
		try {
			int value = Integer.parseInt("1oo");
		} catch(NumberFormatException e) {
			System.err.println("[에러 내용]"); // out 은 검정글씨, err 는 빨간글씨
			System.err.println(e.getMessage());
		}
	}
}