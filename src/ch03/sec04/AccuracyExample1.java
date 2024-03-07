package ch03.sec04;

public class AccuracyExample1 {
	public static void main(String[] args) {
		int apple = 1;
		double pieceUnit = 0.1; //실수계산기
		int number = 7;
		
		double result = apple - number*pieceUnit; //실수계산기
		System.out.println("사과 1개에서 남은 양: " + result);
	}
}