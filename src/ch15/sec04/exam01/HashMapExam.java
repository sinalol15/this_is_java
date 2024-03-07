package ch15.sec04.exam01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import lombok.Data;

@Data
class Student {
	private static int nextId = 1; //자동으로 학번 관리
	
	private int id;
	private String name;
	private String phone;
	private int score;
	
	public Student(String name, String phone) {
		this(name,  phone, 0);
	}
	
	public Student(String name, String phone, int score) {
		this.id = nextId++;
		this.name = name;
		this.phone = phone;
		this.score = score;
	}
	
	public static int getNextId() {
		return nextId;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return id == other.id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}

public class HashMapExam {
	
	public void ListExam() {
		List<Student> array = new ArrayList<Student>();
		
		array.add(new Student("강연규", "010-1234-1234"));
		array.add(new Student("김혜진", "010-1234-1235"));
		array.add(new Student("박경덕", "010-1234-1236"));
		array.add(new Student("박상훈", "010-1234-1237"));
		array.add(new Student("박상훈", "010-1234-1237"));
		
		for (var student : array) {
			System.out.println(student);
		}
	}

	public static void main(String[] args) {
		Map<Integer, Student> map = new HashMap<>();
		
		map.put(Student.getNextId(), new Student("강연규", "010-1234-1234"));
		map.put(Student.getNextId(), new Student("김혜진", "010-1234-1235"));
		map.put(Student.getNextId(), new Student("박경덕", "010-1234-1236"));
		map.put(Student.getNextId(), new Student("박상훈", "010-1234-1237"));
		map.put(Student.getNextId(), new Student("박상훈", "010-1234-1237"));
		
		for (var entry : map.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		System.out.println();
		
		
		HashMapExam hme = new HashMapExam();
		hme.ListExam();
	}

}