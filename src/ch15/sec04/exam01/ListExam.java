package ch15.sec04.exam01;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
abstract class 애완동물 {
	private String name;
	abstract public void 울다();
}

class 강아지 extends 애완동물{
	public 강아지(String name) {
		super(name);
	}
	public void 울다() {
		System.out.println(getName() + "(이)가 멍멍!");
	}
}

class 고양이 extends 애완동물{
	public 고양이(String name) {
		super(name);
	}
	public void 울다() {
		System.out.println(getName() + "(이)가 야옹~");
	}
}

class 앵무새 extends 애완동물{
	public 앵무새(String name) {
		super(name);
	}
	public void 울다() {
		System.out.println(getName() + "(이)가 앵앵~");
	}
}

//Data 관리
public class ListExam {
	List<애완동물> array = new ArrayList<>();
	
	public void createInstance() {
		array.add(new 강아지("여름이"));
		array.add(new 고양이("셜록"));
		array.add(new 강아지("루키"));
		array.add(new 고양이("마루"));
		array.add(new 강아지("치즈"));
		array.add(new 앵무새("지구"));
	}
	
	public void action() {
		for (애완동물 obj : array) {
			obj.울다();
		}
	}
	public static void main(String[] args) {
		ListExam exam = new ListExam();
		exam.createInstance();
		exam.action();
	}

}
