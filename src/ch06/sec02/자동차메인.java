package ch06.sec02;

public class 자동차메인 {

	public static void main(String[] args) {
		//객체 생성
		자동차 시은차 = new 자동차("검정", 100, "벤츠");
					//생성자 함수 호출
		자동차 시호차 = new 자동차("빨강", 100);
		시은차.정보출력();
		시호차.정보출력();
		
		System.out.println("시은차 색상 : " + 시은차.get색상());
		System.out.println("시호차 색상 : " + 시호차.get색상());
	}

}