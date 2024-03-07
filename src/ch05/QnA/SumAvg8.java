package ch05.QnA;

public class SumAvg8 {

	public static void main(String[] args) {
		int[][] array = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88}
		};
		
		int count = 0;
		int sum = 0;
		double avg = 0.0;
		for(int i=0; i<array.length; ++i) {
			for(int j=0; j<array[i].length; j++) {
				sum += array[i][j];
				count++;
			}
		}
		avg = (double) sum/count;
		System.out.println("이 배열의 총합은 " + sum + "입니다.");
		System.out.println("이 배열의 평균은 " + avg + "입니다.");
	}

}
