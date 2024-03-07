package ch12.sec12;

public class Service {
	@PrintAnnotation
	public void method1() {
		System.out.println("실행 내용1");
	}
	
	@PrintAnnotation("*")
	public void method2() {
		System.out.println("실행 내용2");
	}
	
	@PrintAnnotation(value="#", number=20) //변수명을 명시했을 경우 순서 변경 가능.
	public void method3() {
		System.out.println("실행 내용3");
	}
}