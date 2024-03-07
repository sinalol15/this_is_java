package ch06.sec03;

class Tire {
	//속성
	String 색깔;
	int 속도;
	
	//동작
	void 달린다() {
		System.out.println(색깔 + "색 차가 " + 속도 + "속도로 달립니다.");
	}
	void 멈춘다() {
		System.out.println(색깔 + "색 차가 " + 속도 + "속도로 달리다가 멈췄습니다.");
	}
}

public class SportsCar {
	public static void main(String[] arg) {
		//객체 생성
		Tire 차 = new Tire();
		
		차.색깔 = "검정";
		차.속도 = 10000;
		
		
		차.달린다();
		차.멈춘다();
	}
}