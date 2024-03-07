package ch04.sec03;

//public class SwitchNoBreakCaseExample {
//	public static void main(String[] args) {
//		int time = (int)(Math.random()*4) + 8;  
//		System.out.println("[현재시간: " + time + " 시]");
//		
//		switch(time) {
//			case 8:
//				System.out.println("출근합니다.");
//			case 9:
//				System.out.println("회의를 합니다.");
//			case 10:
//				System.out.println("업무를 봅니다.");
//			default:
//				System.out.println("외근을 나갑니다.");
//		}
//	}
//}

public class SwitchNoBreakCaseExample {
	public static void work8() {
		System.out.println("출근합니다.");
		work9();
	}
	public static void work9() {
		System.out.println("회의를 합니다.");
		work10();
	}
	public static void work10() {
		System.out.println("업무를 봅니다.");
		work11();
	}
	public static void work11() {
		System.out.println("외근을 나갑니다.");
	}
	
	public static void main(String[] args) {
		int time = (int)(Math.random()*4) + 8;  
		System.out.println("[현재시간: " + time + " 시]");
		
		switch(time) {
			case 8:
				work8();
				break;
			case 9:
				work9();
				break;
			case 10:
				work10();
				break;
			default:
				work11();
				break;
		}
	}
}