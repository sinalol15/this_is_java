package ch17.sec04.exam01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
		//List 컬렉션 생성
		List<Product> list = new ArrayList<>();
		for(int i=1; i<=5; i++) {
//			Product product = new Product(i, "상품"+i, "멋진회사", (int)(10000*Math.random()));
//			list.add(product);
			list.add(new Product(i, "상품"+i, "멋진회사", (int)(10000*Math.random())));
		}
		
//		for (var product : list) { //for문 사용하여 순회
//			System.out.println(product);
//		}
		
		//객체 스트림 얻기
		Stream<Product> stream = list.stream(); //데이터가 커서 병렬처리할 때 유리함.
//		stream.forEach(p -> System.out.println(p));
		stream.forEach(System.out :: println);
	}
}