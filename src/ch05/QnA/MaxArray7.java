package ch05.QnA;

public class MaxArray7 {

	public static void main(String[] args) {
		int[] array = {1, 5, 3, 8, 2};
		
		int max=0;
		for(int i=0; i<array.length; ++i) {
			if(array[i] > max) {
				max = array[i];
			}
		}
		System.out.println("최대값은 " + max + "입니다.");
	}

}