package HW;

public class LottoNum {

	public static void main(String[] args) {
		int count = 5;
		int[] num = new int[5];
		int[] ball = new int[45];
		boolean run = true;
		
		for(int i=0; i<ball.length; ++i) {
			ball[i] = i + 1;
		}
		while(run) {
			int Num = (int)(Math.random() * 45 + 1);
			for(int j=0; j<ball.length; ++j) {
				ball[j] = Num;
				ball[j] = 0;
			}
			for(int j=0; j<ball.length; ++j) {
				if(ball[j] == 0) {
					continue;
				} else if(ball[j] != 0) {
					ball[j] = num[5-count];
				}
			}
			if(count == 0) {
				run = false;
			}
		}
		
		for(int k=0; k<num.length; ++k) {
			System.out.println(num[k]);
		}
	}

}