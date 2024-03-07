package ch02.sec13;

import java.util.Scanner;

public class ScannerLearn {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("x값 입력 : ");
		String str1 = scanner.nextLine();
		int x = Integer.parseInt(str1);
		
		System.out.print("y값 입력 : ");
		String str2 = scanner.nextLine();
		int y = Integer.parseInt(str2);
		
		int result = x + y;
		System.out.println("x + y: " + result);
		System.out.println();
		
		while(true) {
			System.out.print("입력 문자열: ");
			String abc = scanner.nextLine();
			
			if ("q".equalsIgnoreCase(abc)) {
				break;
			}
			
			System.out.println("출력 문자열: " + abc);
			System.out.println();
		}
		System.out.println("종료");
		scanner.close();
	}

}