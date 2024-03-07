package ch04.sec02;

public class IfDiceExample {
	public static void main(String[] args) {
		
		//1,2,3,4,5,6
		//0.0 <= n < 1
		//0.0 <= n*6 < 6
		//(0,1,2,3,4,5) + 1
		//1,2,3,4,5,6
		
		int num = (int)(Math.random()*6) + 1;
		
		if(num==1) {
			System.out.println("1번이 나왔습니다.");
		} else if(num==2) {	
			System.out.println("2번이 나왔습니다.");
		} else if(num==3) {
			System.out.println("3번이 나왔습니다.");
		} else if(num==4) {
			System.out.println("4번이 나왔습니다.");
		} else if(num==5) {
			System.out.println("5번이 나왔습니다.");
		} else {
			System.out.println("6번이 나왔습니다.");
		}
	}
}