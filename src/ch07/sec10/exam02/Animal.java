package ch07.sec10.exam02;

public abstract class Animal {
	//메소드 선언
	public void breathe() {
		System.out.println("숨을 쉽니다.");
	}

	//추상 메소드 선언
	//추상 메소드 목적: 부모의 참조변수를 사용하여 자식에서 재정의된 함수를 호출
	public abstract void sound();
}