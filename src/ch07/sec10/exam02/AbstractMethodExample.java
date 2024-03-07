package ch07.sec10.exam02;

public class AbstractMethodExample {
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.sound(); //특별화

		Cat cat = new Cat();
		cat.sound();

		//매개변수의 다형성
		animalSound(new Dog()); //일반화
		animalSound(new Cat());
	}

	public static void animalSound( Animal animal ) { //비즈니스 로직
		animal.sound();
	}
}