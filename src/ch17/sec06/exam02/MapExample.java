package ch17.sec06.exam02;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MapExample {
	public static void main(String[] args) {
		int[] intArray = { 1, 2, 3, 4, 5};
		Integer num = 10;
		String str1 = "hello"; //refCnt : 1
		String str2 = str1; //refCnt : 2
		String str3 = str1; //refCnt : 3
		//참조계수(refCnt)
//		str3 = null; //refCnt : 2 감소
//		str2 = null; //refCnt : 1 감소
//		str1 = null; //refCnt : 0 감소 - 잠시후 쓰레기 수집기에 의해 수집됨.

		
		IntStream intStream = Arrays.stream(intArray);
		intStream
			.asDoubleStream() //double형 데이터로 변환
			.forEach(d -> System.out.println(d));
			
		System.out.println();
		
		intStream = Arrays.stream(intArray);
		intStream
			.boxed() //object로 감싸기.
			.forEach(obj -> System.out.println(obj.intValue()));
	}
}