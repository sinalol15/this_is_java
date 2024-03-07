package ch14.sec06.exam01;

public class Calculator {
	private int memory;

	public int getMemory() {
		return memory;
	}

	//대기
	public synchronized void setMemory1(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {}
		System.out.println(Thread.currentThread().getName() + ": " + this.memory);
	}
	//풀림

	public void setMemory2(int memory) {
		System.out.println("동기화 영역이 아님.");
		synchronized(this) { //대기
			this.memory = memory;
			try {
				Thread.sleep(2000);
			} catch(InterruptedException e) {}
			System.out.println(Thread.currentThread().getName() + ": " + this.memory);
		} //풀림
	}
}