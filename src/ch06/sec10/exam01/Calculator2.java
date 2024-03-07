package ch06.sec10.exam01;

public class Calculator2 {
	double pi = 3.14159;

	int plus(int x, int y) {
		/* 멤버 변수(독립적인 객체-ex: 컴퓨터, 모니터, 마우스 등..) 또는 멤버 메소드를 사용하지 않는 경우(인자로 넘어온 함수만 사용) -> 
		 * static 이라는 키워드를 추가하여 불필요한 heap 데이터 영역이 잡히는 것을 방지한다. ->
		 * 어디서든 객체를 사용하지 않고 함수를 사용할 수 있다.(but, static 메소드에서는 this 키워드를 사용할 수 없다. -> 멤버 변수, 함수를 사용하면 안됨.)
		 */
		return x + y;
	}
	
	int minus(int x, int y) {
		return x - y;
	}
}