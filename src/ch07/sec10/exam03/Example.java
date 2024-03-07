package ch07.sec10.exam03;

public class Example {

	public static void main(String[] args) {
		동물원 애버랜드 = new 동물원();
		
		애버랜드.동물추가(new Dog());
		애버랜드.동물추가(new Cat());
		애버랜드.동물추가(new Cow());
		
		애버랜드.동물들이모두운다();
	}

}