package ch14.sec05.exam03;

public class WorkThread extends Thread {
	//필드
	public boolean work = true;
	public boolean run = true;
	
	//생성자
	public WorkThread(String name) {
		setName(name);
	}
	
	//메소드
	@Override
	public void run() {
		while(run) {
			if(work) {
				System.out.println(getName() + ": 작업처리");
			} else {
				System.out.println(getName() + ": 다른스레드에게 양보함");
				Thread.yield();
			}
		}
	}
}