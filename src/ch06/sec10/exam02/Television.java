package ch06.sec10.exam02;

public class Television {
	static String company = "MyCompany";
	static String model = "LCD";
	static String info;

	static { // class 가 메모리에 올라갈 때 자동으로 실행되는 코드
		info = company + "-" + model;
		System.out.println("클래스 로딩시 동작");
	}
}