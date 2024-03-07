package ch04.sec04;

public class SumFrom1To100Example {
	public static void main(String[] args) {
		int sum = 0;
		int end = 100;
//		int i;
			
		for(int i=1; i<=end; i++) {
			sum += i;
		}
			
		System.out.println("1~" + end + " 합 : " + sum);
	}
 }