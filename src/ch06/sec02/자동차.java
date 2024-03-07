package ch06.sec02;

public class 자동차 {
	private String 색상; //멤버변수
	private int 속도;
	private String 모델;
	
//	public 자동차(String 색상) { //지역변수
//		this.색상 = 색상; //멤버변수를 지역변수로 바꿈.
//		this.속도 = 0;
//	}
	

	public void 정보출력() {
		System.out.println("자동차 색상 : " + 색상);
		System.out.println("자동차 속도 : " + 속도);
	}
	
	public 자동차(String 색상) {
		this.색상 = 색상;
	}
	
	public 자동차(String 색상, int 속도) {
		this(색상, 속도, "기본모델"); //함수 랩핑
//		this.색상 = 색상;
//		this.속도 = 속도;
	}
	
	public 자동차(String 색상, int 속도, String 모델) {
		this.색상 = 색상;
		this.속도 = 속도;
		this.모델 = 모델;
	}
	
	public 자동차() {
	}

	public int get속도() {
		return 속도;
	}

	public String get색상() {
		return 색상;
	}

	public String get모델() {
		return 모델;
	}
}