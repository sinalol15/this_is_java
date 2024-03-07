package ch15.sec04.exam01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//DTO -> Map 으로 대신하여 구현하는 방법
public class HashMapExam4 {
	
	List<Map<String, String>> array = new ArrayList<Map<String, String>>();
	
	public void addStudent(String id, String name, String phone) {
		Map<String, String> map = new HashMap<>();
		
		map.put("id", id);
		map.put("name", name);
		map.put("phone", phone);
		
		//배열에 map 객체 추가
		//array.add(map);
		array.add(map);
	}
	
	public void output() {
		for (var map : array) {
			System.out.println(map);
		}
	}
	
	public boolean find(String name) {
		for (Map<String, String> student : array) {
			if (name.equals(student.get("name"))) {
				//원하는 자료 찾음
				System.out.println(student);
				return true;
			}
//			if (id.equals(student.get("id"))) {
//				System.out.println(student);
//				break;
//			}
		}return false;
	}
	
	//한사람의 객체를 map 으로 생성하여 List 에 추가해 관리
	public static void main(String[] args) {

		HashMapExam4 exam = new HashMapExam4();
		
		for (int i = 0; i < 10000; ++i) {
			exam.addStudent(String.valueOf(i), "홍길동" + String.valueOf(i), "010-1234-1234");
		}

		//exam.output();
		//찾을 자료
		String name = "홍길동9000";
		String id = "9000";
		
		//이름을 이용하여 배열에서 자료를 찾는 코드
		//검색 시간을 출력할 것
		long time1 = System.nanoTime();
		exam.find(name);
		long time2 = System.nanoTime();
		System.out.println("홍길동9000을 찾는데 걸리는 나노타임은 " + (time2 - time1) + "초 입니다.");
		
		time1 = System.nanoTime();
		exam.find("홍길동10");
		time2 = System.nanoTime();
		System.out.println("홍길동10을 찾는데 걸리는 나노타임은 " + (time2 - time1) + "초 입니다.");
	}

}