package ch12.sec10;

import java.util.regex.Pattern;

public class PatternExample {
	public static void main(String[] args) {
		String regExp = "(02|010)-\\d{3,4}-\\d{4}"; //문자열에서 \는 제어문자이기 때문에 \\를해야 \으로 본다.
		String data = "010-123-4567";
		boolean result = Pattern.matches(regExp, data);
		if(result) {
			System.out.println("정규식과 일치합니다.");
		} else {
			System.out.println("정규식과 일치하지 않습니다.");
		}
			
		regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		//1개 이상의 숫자/알파벳@1개 이상의 숫자/알파벳.1개 이상의 숫자/알파벳(.1개 이상의 숫자/알파벳)
		//aaa@aaa.com
		//aaa@aaa.co.kr
		//aaa@aaa.co.kr.jp
		data = "angel@mycompanycom";
		result = Pattern.matches(regExp, data);
		if(result) {
			System.out.println("정규식과 일치합니다.");
		} else {
			System.out.println("정규식과 일치하지 않습니다.");
		}
	}
}