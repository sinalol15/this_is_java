package ch07.sec10.exam01;

public class PhoneExample {
	public static void main(String[] args) {
		//Phone phone = new Phone(); //추상클래스라 객체로 만들 수 없다.

		SmartPhone smartPhone = new SmartPhone("홍길동");
		Phone smartPhone2 = new SmartPhone("홍길동"); //자식클래스로 자동변환 후 객체 생성은 가능.

		smartPhone.turnOn();
		smartPhone.internetSearch();
		smartPhone.turnOff();
	}
}