package ch07.sec10.exam03;

abstract class 동물 {
	public abstract void 운다();
}

class Dog extends 동물{
	private void 강아지울다() {
		System.out.println("멍멍");
	}
	public void 운다() {
		강아지울다();
	}
}

class Cat extends 동물{
	private void 고양이울다() {
		System.out.println("야옹");
	}
	public void 운다() {
		고양이울다();
	}
}

class Cow extends 동물{
	public void 운다() {
		System.out.println("음메");
	}
}

public class 동물원 {
	private 동물 [] 배열 = new 동물[100];
	private int count = 0;
	
	public void 동물추가(동물 ani) {
		if(count < 100) {
			배열[count++] = ani;
		}
	}
	
	public void 동물들이모두운다() {
		for(int i = 0; i < count; ++i) {
			배열[i].운다();
		}
	}
}