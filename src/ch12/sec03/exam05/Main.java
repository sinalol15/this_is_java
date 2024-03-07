package ch12.sec03.exam05;

public class Main {

	public static void main(String[] args) {
		//Member m = new Member("1234", "Sie");
		Member m2 = Member.builder().id("1234").name("홍길동").build();
		System.out.println(m2);
	}

}