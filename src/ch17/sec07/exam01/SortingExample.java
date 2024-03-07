package ch17.sec07.exam01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingExample {
	public static void main(String[] args) {
		//List 컬렉션 생성
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("홍길동", 30));
		studentList.add(new Student("신용권", 10));
		studentList.add(new Student("유미선", 20));
		
		//점수를 기준으로 오름차순으로 정렬한 새 스트림 얻기
		studentList.stream() //코드 수정 권한이 있어서 Comparable 에 정의되어있던 compareTo함수를 재정의 했다.
			.sorted()
			.forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));	
		System.out.println();
		
		//점수를 기준으로 내림차순으로 정렬한 새 스트림 얻기
		studentList.stream()
		.sorted(Comparator.reverseOrder()) //static 으로 만들어진 default 함수
		.forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
	}
}
