package ch15.sec04.exam01;

import java.util.HashMap;
import java.util.Map;

//DTO -> Map 으로 대신하여 구현하는 방법
public class HashMapExam5 {
	
	//id 를 키로해서 Map 객체를 관리
	Map<String, Map<String, String>> array = new HashMap<String, Map<String, String>>();
	
	public void addStudent(String id, String name, String phone) {
		Map<String, String> map = new HashMap<>();
		
		map.put("id", id);
		map.put("name", name);
		map.put("phone", phone);
		
		//배열에 map 객체 추가
		//array.add(map);
		array.put(id, map);
	}
	
	public void output() {
		for (var map : array.entrySet()) {
			System.out.println(map.getValue());
		}
	}
	
	//한사람의 객체를 map 으로 생성하여 List 에 추가해 관리
	public static void main(String[] args) {

		HashMapExam5 exam = new HashMapExam5();
		
		for (int i = 0; i < 10000; ++i) {
			exam.addStudent(String.valueOf(i), "홍길동" + String.valueOf(i), "010-1234-1234");
		}
		
		for (int i = 0; i < 10; i++) {
			long tick = System.nanoTime();
			var student = exam.array.get("9000");
			if (student != null) {
				System.out.println(student);
			}
			System.out.println("실행시간 : " + (System.nanoTime() - tick));
		}
	}

}