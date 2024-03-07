package ch06.sec10.exam03;

public class Car {
	//인스턴스 필드 선언
	int speed;
	static int cnt = 0;

	//인스턴스 메소드 선언(멤버 메소드)
	void run() {
		System.out.println(speed + "으로 달립니다.");
	}

	//정적 메소드 선언
	static void simulate() {
		System.out.println(cnt); //static 끼리는 static 함수에서도 사용 가능.
		//객체 생성
		Car myCar = new Car(); //인자로 Car myCar을 받으면 생략 가능.
		//인스턴스 멤버 사용
		myCar.speed = 200;
		myCar.run();
	}
	
	static void simulate(Car myCar) {
		//인스턴스 멤버 사용
		myCar.speed = 200;
		myCar.run();
		simulate(); //static 끼리는 static 함수에서도 호출 가능.
		//run(); //static 함수가 아니여서 호출 불가능.
	}

	public static void main(String[] args) {
		//정적 메소드 호출
		simulate(); //static 메소드 간에 클래스 명 생략가능. Car.simulate();도 맞음.
		
		//객체 생성
		Car myCar = new Car();
		//인스턴스 멤버 사용
		myCar.speed = 60;
		myCar.run();
	}
}