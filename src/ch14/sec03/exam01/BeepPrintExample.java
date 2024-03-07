package ch14.sec03.exam01;

import java.awt.Toolkit;

public class BeepPrintExample {
	public static void main(String[] args) throws Exception{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i=0; i<5; i++) {
			toolkit.beep();
			Thread.sleep(500);
		}

		for(int i=0; i<5; i++) {
			System.out.println("띵");
			try { Thread.sleep(500); } catch(Exception e) {}
		}
	}
}