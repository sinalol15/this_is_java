package ch05.QnA;

import java.util.Scanner;

public class ScoreMaxAvg9 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		boolean run = true;
		int[] scores = null;
		int stuNum = 0;
		int MaxNum = 0;
		double sum=0;
		
		while(run) {
			System.out.println("--------------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("--------------------------------------------------");
			System.out.print("선택> ");

			int num=Integer.parseInt(scanner.nextLine());
			
			if(num == 1) {
				System.out.print("학생수> ");
				String num1 = scanner.nextLine();
				stuNum = Integer.parseInt(num1);
				scores = new int[stuNum];
			} else if(num == 2) {
				for(int i=0; i<stuNum; ++i) {
					System.out.print("scores[" + i + "]> ");
					String num2 = scanner.nextLine();
					scores[i] = Integer.parseInt(num2);
				}
			} else if(num == 3) {
				for(int j=0; j<stuNum; ++j) {
					System.out.println("scores[" + j + "]: "+scores[j]);
				}
			} else if(num == 4) {
				for(int k=0; k<stuNum; ++k) {
					if(scores[k] > MaxNum) {
						MaxNum = scores[k];
					}
				}
				for(int l=0; l<stuNum; ++l) {
					sum += scores[l];
				}
				System.out.println("최고 점수: " + MaxNum);
				System.out.println("평균 점수: " + sum/stuNum);
			} else if(num == 5) {
				System.out.println("프로그램 종료");
				run = false;
			}
		}
		scanner.close();
	}

}
