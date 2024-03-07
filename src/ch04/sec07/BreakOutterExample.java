package ch04.sec07;

public class BreakOutterExample {
	public static void main(String[] args) throws Exception {
		Outter: //탈출 레이블
		for(char upper='A'; upper<='Z'; upper++) {
			for(char lower='a'; lower<='z'; lower++) {
				System.out.println(upper + "-" + lower);
				if(lower=='g') {
					break Outter; //break만 작성하면 소문자 for문만 빠져나가서 대문자Z까지 실행함. 다만 소문자는 g까지만 출력.
				}
			}
		}
		System.out.println("프로그램 실행 종료");
	}
}