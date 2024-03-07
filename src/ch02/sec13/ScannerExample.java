package ch02.sec13;

import java.util.Scanner;

public class ScannerExample {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		System.out.print("x 값 입력: ");
		String strX = scanner.nextLine();
		int x = Integer.parseInt(strX);

		System.out.print("y 값 입력: ");
		String strY = scanner.nextLine();
		int y = Integer.parseInt(strY);

		int result = x + y;
		System.out.println("x + y: " + result);
		System.out.println();

		while(true) {
			System.out.print("입력 문자열: ");
			String data = scanner.nextLine();
			//if(data == "q") { <--이 문장은 문자에 대한 주소만 맞는지 확인하고 문자가 맞는지 확인하는 건 아니다. 고로 equals로 맞는지 확인하기.
			//if(data.equals("q")) {
			if("q".equals(data)) {
				break;
			}
			System.out.println("출력 문자열: " + data);
			System.out.println();
		}

		System.out.println("종료");
		scanner.close();
	}
}