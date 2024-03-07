package ch12.sec06;

public class ValueCompareExample {
	public static void main(String[] args) {
		//-128~127 초과값일 경우
		String s1 = new String("hello");
		String s2 = new String("hello");
		Integer obj1 = 300;
		Integer obj2 = 300;
		System.out.println("==: " + (obj1 == obj2)); //객체의 주소값을 비교하여 다름.
		System.out.println("equals(): " + obj1.equals(obj2));
		System.out.println("==: " + (s1 == s2));
		System.out.println("equals(): " + s1.equals(s2));
		System.out.println();

		//-128~127 범위값일 경우
		String s3 = "hello";
		String s4 = "hello";
		Integer obj3 = 10;
		Integer obj4 = 10;
		System.out.println("==: " + (obj3 == obj4)); //1바이트 범위안의 값을 선언하면 같은 주소값으로 할당함.
		System.out.println("equals: " + obj3.equals(obj4));
		System.out.println("==: " + (s3 == s4));
		System.out.println("equals: " + s3.equals(s4));
	}
}