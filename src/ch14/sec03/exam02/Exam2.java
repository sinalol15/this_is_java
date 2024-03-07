package ch14.sec03.exam02;

public class Exam2 {

	public static void main(String[] args) {
		//스레드를 생성만 한 것. 실행은 안됨. - 익명클래스로 구현
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for ( int i = 0 ; i < 10000 ; i++) {
					System.out.println("네트워크 작업");
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for ( int i = 0 ; i < 10000 ; i++) {
					System.out.println("드로잉 작업");
				}
			}
		});
		
		//스레드를 실행
		t1.start();
		t2.start();
		
		for ( int i = 0 ; i < 10000 ; i++) {
			System.out.println("메인 스레드 실행");
		}
	}

}
