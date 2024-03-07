package ch17.sec05;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import ch17.sec04.exam01.Product;

public class FilteringExample {
	public static void main(String[] args) {
		
		//List 컬렉션 생성
		List<Product> listProduct = new ArrayList<>();
		for(int i=1; i<=5; i++) {
			listProduct.add(new Product(i, "상품"+i, "멋진회사", (int)(10000*Math.random())));
		}
		listProduct.add(new Product(1, "상품1", "멋진회사", (int)(10000*Math.random())));
		
		listProduct.stream().forEach(System.out :: println);
		System.out.println();
		
		listProduct.stream().distinct().forEach(System.out :: println);
		System.out.println();

		//List 컬렉션 생성
		List<String> list = new ArrayList<>();
		list.add("홍길동"); 
		list.add("신용권");
		list.add("감자바");
		list.add("신용권");
		list.add("신민철");
		
		//Set 을 사용하여 중복 요소 제거(but, 순서보장 x) - distinct 가 이 작업을 해줌.
		Set<String> set = new HashSet<String>();
		List<Integer> posArray = new ArrayList<Integer>();
		int pos = 0;
		for (String str : list) {
			if (set.add(str)) {
				posArray.add(pos);
			}
			pos++;
		}
		System.out.println(set);
		System.out.println(posArray);
		for (int pos2 : posArray) {
			System.out.println(list.get(pos2));
		}
		
		//중복 요소 제거 - 간단.
		list.stream()
			.distinct()
			.forEach(n -> System.out.println(n));
		System.out.println();
		
		//신으로 시작하는 문자열을 찾아 출력하는 코드 -한번에 두가지 일
		for (String str : list) {
			if (str.startsWith("신")) {
				System.out.println(str);
			}
		}
		System.out.println();
		
		//신으로 시작하는 문자열을 찾아 새로운 배열에 대입 -한번에 한가지 일(데이터 많을수록 더 빠르고 성능 좋음.), 단일 책임의 원칙
		List<String> newArray = new ArrayList<String>();
		for (String str : list) {
			if (str.startsWith("신")) {
				newArray.add(str);
			}
		}
		//배열에 있는 문자열을 출력함.
		for (String str : newArray) {
			System.out.println(str);
		}
		System.out.println();
		
		//신으로 시작하는 요소만 필터링
		list.stream()
//			.filter(new Predicate<String>() { //익명 클래스로 구현
//				public boolean test(String t) {
//					return t.startsWith("신");
//				}
//			})
			.filter(n -> n.startsWith("신")) //65-71, 80-84번째 코드 축약버전
			.forEach(n -> System.out.println(n)); //72-76번째 코드 축약버전
//			.forEach(System.out :: println);
		System.out.println();
		
		//중복 요소를 먼저 제거하고, 신으로 시작하는 요소만 필터링
		list.stream()
			.distinct()
			.filter(n -> n.startsWith("신"))
			.forEach(System.out :: println);		
	}
}