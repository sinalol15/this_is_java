package ch11.sec02.exam01;

public class ExceptionHandlingExample2 {
	public static void printLength(String data) {
		try {
			int result = data.length();
			System.out.println("문자 수: " + result);
		} catch(NullPointerException e) {
			System.out.println(e.getMessage()); //① 메세지만 출력.
			//System.out.println(e.toString()); //② 메세지에 클래스명까지 출력.
			//e.printStackTrace(); //③ 빨간색으로 나왔던 예외 메세지 전체 출력.
		} finally {
			System.out.println("[마무리 실행]\n");
		}
	}

	public static void main(String[] args) {
		System.out.println("[프로그램 시작]\n");
		printLength("ThisIsJava");
		printLength(null);
		System.out.println("[프로그램 종료]");
	}
}