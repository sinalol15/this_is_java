package ch17.sec06.exam03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class FlatMappingExample {
	public static void main(String[] args) {
		//문장 스트림을 단어 스트림으로 변환
		List<String> list1 = new ArrayList< >();
		list1.add("this is java");
		list1.add("i am a best developer");
		
//		List<String> newArr = new ArrayList<String>();
//		for (var str : list1) {
//			StringTokenizer token = new StringTokenizer(str, " ");
//			while (token.hasMoreTokens()) {
//				newArr.add(token.nextToken());
//			}
//		}
//		System.out.println(newArr);
//		System.out.println();
		
//		List<String> newArr = new ArrayList<String>();
//		for (var str : list1) {
//			String [] arr = str.split(" ");
//			for (var token : arr) {
//				newArr.add(token);
//			}
//		}
//		System.out.println(newArr);
//		System.out.println();
		
		list1.stream()
		.flatMap(data -> Arrays.stream(data.split(" "))) //안에 있는 데이터를 내가 원하는 형태의 데이터로 변환하는 코드
		.forEach(word -> System.out.println(word));
		
		System.out.println();
		
		//문자열 숫자 목록 스트림을 숫자 스트림으로 변환
		List<String> list2 = Arrays.asList("10, 20, 30", "40, 50");
		//원본
		list2.stream()
		.flatMapToInt(data -> {
			String[] strArr = data.split(",");
			int[] intArr = new int[strArr.length];
			for (int i = 0; i < strArr.length; i++) {
				intArr[i] = Integer.parseInt(strArr[i].trim());
			}
			return Arrays.stream(intArr);
		})
		.forEach(number -> System.out.println(number));
		System.out.println();
		
		//향상된 for 문으로 변경-1
		list2.stream()
		.flatMapToInt(data -> {
			String[] strArr = data.split(",");
			int[] intArr = new int[strArr.length];
			int i = 0;
			for (var str : strArr) {
				intArr[i++] = Integer.parseInt(str.trim());
			}
			return Arrays.stream(intArr);
		})
		.forEach(number -> System.out.println(number));
		System.out.println();
		
		//향상된 for 문으로 변경-2
		list2.stream()
		.flatMapToInt(data -> {
			String[] strArr = data.split(",");
			List<Integer> intArr = new ArrayList<Integer>();
			for (var str : strArr) {
				intArr.add(Integer.parseInt(str.trim())); //trim => 문자열 사이 공백 삭제
			}
			return intArr.stream().mapToInt(o -> o.intValue());
		})
		.forEach(number -> System.out.println(number));
		System.out.println();
		
		//mapToInt() 변경-1
		list2.stream()
		.flatMapToInt(data -> {
			String[] strArr = data.split(",");
			return Arrays.stream(strArr).mapToInt(s -> Integer.parseInt(s));
		})
		.forEach(number -> System.out.println(number));
		System.out.println();
		
		//mapToInt() 변경-2
		list2.stream()
		.flatMapToInt(data -> {
			return Arrays.stream(data.split(",")).mapToInt(s -> Integer.parseInt(s));
		})
		.forEach(number -> System.out.println(number));
		System.out.println();
		
		//mapToInt() 변경-3
		list2.stream()
		.flatMapToInt(data -> {
			return Arrays.stream(data.split(",")).mapToInt(Integer :: parseInt);
		})
		.forEach(System.out :: println);
		System.out.println();
	}
}	