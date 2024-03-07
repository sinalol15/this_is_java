package ch17.sec07.exam02;

import java.util.ArrayList;
import java.util.List;

public class SortingExample {
	public static void main(String[] args) {
		//List 컬렉션 생성
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("홍길동", 30));
		studentList.add(new Student("신용권", 10));
		studentList.add(new Student("유미선", 20));
		
		//점수를 기준으로 오름차순으로 정렬한 새 스트림 얻기
		studentList.stream()
			//코드 수정 권한이 없어서 sorted 안에 비교방법을 명시하였다.
			.sorted((s1, s2) -> Integer.compare(s1.getScore(), s2.getScore()))
//			.sorted((s1, s2) -> s1.getScore() - s2.getScore()) //위 코드와 같은 기능
			.forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));	
		System.out.println();
		
		//점수를 기준으로 내림차순으로 정렬한 새 스트림 얻기
		studentList.stream()
			.sorted((s1, s2) -> Integer.compare(s2.getScore(), s1.getScore()))
			.forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));	
	}
}