package ch07.sec03.exam02;

public class SmartPhone extends Phone {
	//자식 생성자 선언
	public SmartPhone(String model, String color) {
		//부모의 기본생성자
		super(model, color); // super 코드는 변수 선언보다 앞에 한번만 선언 가능.
		System.out.println("SmartPhone(String model, String color) 생성자 실행됨");
	}
}