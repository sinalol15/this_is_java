package ch15.sec05.exam04_1;

import java.util.TreeSet;
import java.util.Comparator;

public class ComparatorExample {
	public static void main(String[] args) {
		//비교자를 제공한 TreeSet 컬렉션 생성
//		TreeSet<Fruit> treeSet = new TreeSet<Fruit>(new Comparator<Fruit>() { //직접 Comparator 코드를 구현
//			public int compare(Fruit o1, Fruit o2) {
//				return o1.price - o2.price;
//			}
//		});
		TreeSet<Fruit> treeSet = new TreeSet<Fruit>((o1, o2) -> o1.price - o2.price); //람다 표현식으로 코드를 구현
			
		//객체 저장
		treeSet.add(new Fruit("포도", 3000));
		treeSet.add(new Fruit("수박", 10000));
		treeSet.add(new Fruit("딸기", 6000));
		
		//객체를 하나씩 가져오기
		for(Fruit fruit : treeSet) {
			System.out.println(fruit.name + ":" + fruit.price);
		}
	}
}