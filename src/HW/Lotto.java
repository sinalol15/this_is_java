package HW;

public class Lotto {

	public static void main(String[] args) {
		int count = 5;
		int[] num = new int[5];
		boolean run = true;
		
		while(run) {
			for(int j = 0; j < num.length; ++j) {
				int Num = (int)(Math.random() * 45 + 1);
				if(num[j] != Num) {
					num[5-count] = Num;
					count--;
				}
			}
			if(count == 0) {
				for(int i=0; i<num.length; ++i) {
					System.out.print(num[i] + " ");
				}
				run = false;
			}
		}
	}

}