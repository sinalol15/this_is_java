package ch07.sec10.exam01;

public abstract class Phone { //객체를 만들 수 없음. 참조변수로만 사용. 자식을 만들 순 있음.
	//필드 선언
	String owner;

	//생성자 선언
	Phone(String owner) {
		this.owner = owner;
	}

	//메소드 선언
	void turnOn() {
		System.out.println("폰 전원을 켭니다.");
	}
	void turnOff() {
		System.out.println("폰 전원을 끕니다.");
	}
}