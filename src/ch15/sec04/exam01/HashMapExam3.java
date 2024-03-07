package ch15.sec04.exam01;

import java.util.HashMap;
import java.util.Map;

//DTO -> Map 으로 대신하여 구현하는 방법
public class HashMapExam3 {
	
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

		HashMapExam3 exam = new HashMapExam3();
		
		exam.addStudent("1", "강연규", "010-1234-1234");
		exam.addStudent("2", "김혜진", "010-1234-1235");

		exam.output();
	}

}