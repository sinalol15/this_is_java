package ch06.sec08.exam01;

/*
 * 계산기
 *  속성 : 전원 상태
 *  기능 : 전원을 켠다
 *  	  전원을 끈다
 *  	  두수를 더한다
 *  	  두수를 나눈다
 * */

public class Calculator {
	
	private boolean powerStatus = false;
	
	//리턴값이 없는 메소드 선언
	public void powerOn() {
		powerStatus = true;
		System.out.println("전원을 켭니다.");
	}

	//리턴값이 없는 메소드 선언
	public void powerOff() {
		powerStatus = false;
		System.out.println("전원을 끕니다.");
	}

	//호출 시 두 정수 값을 전달받고,
	//호출한 곳으로 결과값 int를 리턴하는 메소드 선언
	public int plus(int x, int y) throws Exception {
		return plus2(x, y);
//		if (false == powerStatus) {
//			throw new Exception("전원을 켜시오.");
//		}
//		int result = x + y;
//		return result; //리턴값 지정;
	}
	
	public int plus(int [] arr) throws Exception {
		if (false == powerStatus) {
			throw new Exception("전원을 켜시오.");
		}
		int result = 0;
		for (int x : arr) {
			result += x;
		}
		return result;
	}
	
	public int plus2(int ... arr) throws Exception {
		if (false == powerStatus) {
			throw new Exception("전원을 켜시오.");
		}
		int result = 0;
		for (int x : arr) {
			result += x;
		}
		return result;
	}

	//호출 시 두 정수 값을 전달받고,
	//호출한 곳으로 결과값 double을 리턴하는 메소드 선언
	public double divide(int x, int y) throws Exception {
		if (false == powerStatus) {
			throw new Exception("전원을 켜시오.");
		}
		double result = (double)x / (double)y;
		return result; //리턴값 지정;
	}
}