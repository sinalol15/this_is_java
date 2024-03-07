package ch12.sec05;

public class StringBuilderExample {
	public static void main(String[] args) {
		String str = "";
		long time1 = System.nanoTime();
		for (int i = 0; i < str.length(); ++i) {
			str += "Hello World";
		}
		long time2 = System.nanoTime();
		System.out.println("수행 시간: " + (time2 - time1));
		
		time1 = System.nanoTime();
		StringBuilder str2 = new StringBuilder(); // 단일 스레드
		for (int i = 0; i < str.length(); ++i) {
			str2.append("Hello World");
		}
		time2 = System.nanoTime();
		System.out.println("수행 시간: " + (time2 - time1));
		
		time1 = System.nanoTime();
		StringBuffer str3 = new StringBuffer(); // 다중 스레드
		for (int i = 0; i < str.length(); ++i) {
			str3.append("Hello World");
		}
		time2 = System.nanoTime();
		System.out.println("수행 시간: " + (time2 - time1));
		
		String data = new StringBuilder()
				.append("DEF")
				.insert(0, "ABC")
				.delete(3, 4) //3번째인 D지우고 4번째 전까지 삭제라 D만 삭제
				.toString();
		System.out.println(data);
	}
}