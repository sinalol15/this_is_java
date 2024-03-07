package ch06.sec08.exam01;

public class CalculatorExample {
	public static void main(String[] args) throws Exception {
		//Calculator 객체 생성
		Calculator myCalc = new Calculator();
		
		//리턴값이 없는 powerOn() 메소드 호출
		myCalc.powerOn();

		//plus 메소드 호출 시 5와 6을 매개값으로 제공하고,
		//덧셈 결과를 리턴 받아 result1 변수에 대입
		int result1 = myCalc.plus(5, 6);
		System.out.println("result1: " + result1);
		
		int [] arr = {5, 6, 7, 8};
		int result2 = myCalc.plus(arr);
		System.out.println("result2: " + result2);
		
		int result2_1 = myCalc.plus(new int[] {5, 6, 7, 8});
		System.out.println("result2_1: " + result2_1);
		
		int result3 = myCalc.plus2(5, 6, 7, 8, 9);
		System.out.println("result3: " + result3);

		int x = 10;
		int y = 4;
		//divide() 메소드 호출 시 변수 x와 y의 값을 매개값으로 제공하고,
		//나눗셈 결과를 리턴 받아 result2 변수에 대입
		double result4 = myCalc.divide(x, y);
		System.out.println("result3: " + result4);

		//리턴값이 없는 powerOff() 메소드 호출
		myCalc.powerOff();
	}
}