package ch12.QnA;

public class Sec8 {

	public static void main(String[] args) {
		long time1 = System.nanoTime();
		
		int[] scores = new int[1000];
		for(int i = 0; i < scores.length; ++i) {
			scores[i] = i;
		}
		
		int sum = 0;
		for(int score : scores) {
			sum += score;
		}
		
		double avg = sum / scores.length;
		System.out.println(avg);
		
		long time2 = System.nanoTime();
		
		System.out.println("총 걸리는 시간은 " + (time2 - time1) + " 나노초 입니다.");
	}

}