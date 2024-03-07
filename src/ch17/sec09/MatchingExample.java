package ch17.sec09;

import java.util.Arrays;

public class MatchingExample {
	public static void main(String[] args) {
		int[] intArr = { 2, 4 ,6 };
		
		boolean result1 = true;
		for (int v : intArr) {
			if (v % 2 != 0) {
				result1 = false;
				break;
			}
		}
		if (result1) {
			System.out.println("모든 값은 짝수 입니다.");
		} else {
			System.out.println("모든 값이 짝수는 아닙니다.");
		}
		
		boolean result = Arrays.stream(intArr)
			.allMatch(a -> a%2==0); //11-14번쨋 코드 축약
		System.out.println("모두 2의 배수인가? " + result);
		
		result1 = false;
		for (int v : intArr) {
			if (v % 3 == 0) {
				result1 = true;
				break;
			}
		}
		if (result1) {
			System.out.println("배열에 3의 배수가 존재합니다.");
		} else {
			System.out.println("배열에 3의 배수가 존재하지 않습니다.");
		}
		
		result = Arrays.stream(intArr)
			.anyMatch(a -> a%3==0); //28-31번쨋 코드 축약
		System.out.println("하나라도 3의 배수가 있는가? " + result);
		
		result1 = true;
		for (int v : intArr) {
			if (v % 3 != 0) {
				result1 = false;
				break;
			}
		}
		if (result1) {
			System.out.println("배열에 3의 배수가 존재하지 않습니다.");
		} else {
			System.out.println("배열에 3의 배수가 존재합니다.");
		}
		
		result = Arrays.stream(intArr)
			.noneMatch(a -> a%3==0);
		System.out.println("3의 배수가 없는가?  " + result);
	}
}
