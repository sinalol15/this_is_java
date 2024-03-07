package ch13.sec02.exam03;

public class GenericExample {
	public static void main(String[] args) {
		//명시적 제네릭
//		Box<String> box1 = new Box<>(); //논리적 오류가 발생할 수 있으므로 미리 타입을 선언해주는 것이 좋다.
//		box1.content = "100";
//
//		Box<String> box2 = new Box<>();
//		box2.content = "100";
//		
//		Box<Integer> box3 = new Box<>();
//		box3.content = 100;
		
		//암시적 제네릭
		Box box1 = new Box(); //논리적 오류가 발생할 수 있으므로 미리 타입을 선언해주는 것이 좋다.
		box1.content = "100";

		Box box2 = new Box();
		box2.content = "100";
		
		Box box3 = new Box();
		box3.content = 100;

		boolean result1 = box1.compare(box2);
		System.out.println("result1: " + result1);

		boolean result2 = box1.compare(box3);
		System.out.println("result2: " + result2);
	}
}