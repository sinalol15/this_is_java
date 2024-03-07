package ch15.sec05.exam03_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class ComparableExample {
	public static void main(String[] args) {
		Person[] array = {
				new Person("홍길동", 45),
				new Person("감자바", 25),
				new Person("박지원", 31)
		};
		
		Arrays.sort(array, new Comparator<Person>() {
			public int compare(Person o1, Person o2) {
				return o1.age - o2.age;
			}
		});
		
		//객체를 하나씩 가져오기
		for(Person person : array) {
			System.out.println(person.name + ":" + person.age);
		}
	}
}