package ch17.sec06.exam01;

import java.util.ArrayList;
import java.util.List;

public class MapExample {
	public static void main(String[] args) {
		//List 컬렉션 생성
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("홍길동", 85));
		studentList.add(new Student("홍길동", 92));
		studentList.add(new Student("홍길동", 87));
		
		for (var student : studentList) {
			System.out.println(student.getScore());
		}
		
		//Student 를 score 스트림으로 변환
		studentList.stream()
			.mapToInt(s -> s.getScore())
			.forEach(score -> System.out.println(score));
		System.out.println();
		
		studentList.stream() //19-22번째 코드 축약버전.
			.mapToInt(Student :: getScore)
			.forEach(System.out :: println);
	}
}