package ch14.sec05.exam02;

public class JoinExample {
	public static void main(String[] args) {
		SumThread sumThread = new SumThread();
		sumThread.start();
		try {
			sumThread.join(); //끝날때까지 기다려라.
		} catch (InterruptedException e) {
		}
		System.out.println("1~100 합: " + sumThread.getSum());
	}
}