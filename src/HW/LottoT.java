package HW;

public class LottoT {
	final int [] ball = new int[45];
	final int [] result = new int[6];

	LottoT() {
		for(int i = 0; i < ball.length ; ++i) {
			ball[i] = i+1; // 뽑힐 공에 차례대로 번호 매기기
		}
	}
	
	void assign() {
		for(int i = 0; i < result.length; ++i) {
			final int num = (int)(Math.random()*(ball.length - i));
			result[i] = ball[num]; // 뽑힌 공을 결과 값에 저장하기
			ball[num] = ball[ball.length - 1 - i]; // 뽑힌 공 위치에 마지막 공을 옮기기
		}
	}
	
	void printLotto() {
		for(int i = 0; i < result.length; ++i) {
			System.out.print(result[i] + " "); // 결과 추출하기
		}
	}
	
	public static void main(String[] args) {
		LottoT lotto = new LottoT();
		lotto.assign();
		lotto.printLotto();
	}
}