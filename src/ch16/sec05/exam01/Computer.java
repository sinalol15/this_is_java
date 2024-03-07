package ch16.sec05.exam01;

public class Computer {
	public static double staticMethod(double x, double y) { //정적 함수
		return x + y;
	}

	public double instanceMethod(double x, double y) { //멤버 함수
		return x * y;
	}
}