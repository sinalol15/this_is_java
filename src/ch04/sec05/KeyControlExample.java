package ch04.sec05;

import java.util.Scanner;

public class KeyControlExample {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		int speed = 0;

		while(run) {
			System.out.println("-----------------------------");
			System.out.println("1. 증속 | 2. 감속 | 3. 중지");
			System.out.println("-----------------------------");
			System.out.print("선택: ");

			String strNum = scanner.nextLine();

			//if 문으로 작성
//			if(strNum.equals("1")) {
//				speed++;
//				System.out.println("현재 속도 = " + speed);
//			} else if(strNum.equals("2")) {
//				speed--;
//				System.out.println("현재 속도 = " + speed);
//			} else if(strNum.equals("3")) {
//				run = false;
//			}
			
			//switch case 문으로 변경
//			switch(strNum) {
//				case "1":
			
//					speed++;
//					System.out.println("현재 속도 = " + speed);
//					break;
//				case "2":
//					speed--;
//					System.out.println("현재 속도 = " + speed);
//					break;
//				default:
//					run = false;
//					break;
//			}
			
			//switch case exp(->) 문으로 변경 -1
//			run = switch(strNum) {
//				case "1" -> {
//					speed++;
//					System.out.println("현재 속도 = " + speed);
//					yield true;
//				}
//				case "2" -> {
//					speed--;
//					System.out.println("현재 속도 = " + speed);
//					yield true;
//				}
//				case "3" -> run = false;
//				default -> run = true;
//			};
			
			//switch case exp(->) 문으로 변경 -2
//			switch(strNum) {
//				case "1" -> {
//					speed++;
//					System.out.println("현재 속도 = " + speed);
//				}
//				case "2" -> {
//					speed--;
//					System.out.println("현재 속도 = " + speed);
//				}
//				case "3" -> run = false;
//			}
			
			//switch case exp(->) 문으로 변경 -3
			run = switch(strNum) {
				case "1" -> {
					speed++;
					yield true;
				}
				case "2" -> {
					speed--;
					yield true;
				}
				case "3" -> false;
				default -> true;
			};
		
			if (run) {
				System.out.println("현재 속도 = " + speed);
			}
		}

		System.out.println("프로그램 종료");
		scanner.close();
	}
}