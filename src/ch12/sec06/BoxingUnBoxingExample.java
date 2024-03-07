package ch12.sec06;

public class BoxingUnBoxingExample {
	public static void main(String[] args) {
		//Boxing
		Integer obj = 100;
		System.out.println("value: " + obj.intValue());
		System.out.println("value: " + obj);

		//Unboxing
		int value = obj;
		System.out.println("value: " + value);
		
		//연산 시 Unboxing
		int result = obj + 100;
		System.out.println("result: " + result);
		
		//원래 안되는 걸 컴파일러가 래퍼 클래스로 바꿔줌.
		Object[] arr= {10, 2.0f, 1000L};
		for(int i = 0; i < arr.length; ++i) {
			System.out.println(arr[i]);
		}
		
	}
}