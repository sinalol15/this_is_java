package ch14.sec07.exam01;

public class PrintThread extends Thread {
	private boolean stop;

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	@Override
	public void run() {
		while(!stop) { //flag 변수를 가지고 while 루프를 멈췄다.-대기타임 없음.
			System.out.println("실행 중");
		}
		System.out.println("리소스 정리");
		System.out.println("실행 종료");
	}
}