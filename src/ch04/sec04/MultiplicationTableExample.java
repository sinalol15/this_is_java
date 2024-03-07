package ch04.sec04;

public class MultiplicationTableExample {
//	public static void main(String[] args) {
//		for (int m=2; m<=9; m++) {
//			System.out.println("*** " + m + "단 ***");
//			for (int n=1; n<=9; n++) {
//				System.out.println(m + " x " + n + " = " + (m*n));
//			}
//		}
//	}
	
	// 함수 사용하여 작성시
	public static void dan_display(int dan) {
		for (int i=1; i<=9; i++) {
			System.out.println(dan + " x " + i + " = " + (dan*i));
		}
	}
	
	public static void main(String[] args) {
		for (int dan=2; dan<=9; dan++) {
			System.out.println("===" + dan + "단 ===");
			dan_display(dan);
			System.out.println();
		}
	}
}