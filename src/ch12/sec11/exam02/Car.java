package ch12.sec11.exam02;

public class Car {
	//필드
	private String model; // reflection 으로 은닉성을 깨서 접근할 수 있다.
	private String owner; // 은닉성(private) 관한 것은 컴파일 타임에 컴파일(구문 오류)이 잡아준다.
	
	//생성자
	public Car() {
		System.out.println("자동차 객체 생성");
	}
	public Car(String model) {
		this.model = model;
	}
	public Car(String model, String owner) {
		this.model = model;
		this.owner = owner;
	}
	
	//메소드
	public String getModel() { return model; }
	public void setModel(String model) { this.model = model; }
	public String getOwner() { return owner; }
	public void setOwner(String owner) { this.owner = owner; }
	
	@Override
	public String toString() {
		return "Car [model=" + model + ", owner=" + owner + "]";
	}
	
	public void run() {
		System.out.println("자동차가 달린다.");
	}
}