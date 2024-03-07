package ch13.sec01;

public class GenericExample {
	public static void main(String[] args) {
		//Box<String> box1 = new Box<String>();
		//BoxString box1 = new BoxString("안녕하세요.");
		Box<String> box1 = new Box<>("안녕하세요.");
		box1.setContent("안녕하세요.");
		String str = box1.getContent();
		System.out.println(str);

		//Box<Integer> box2 = new Box<Integer>();
		//BoxInteger box2 = new BoxInteger(100);
		Box<Integer> box2 = new Box<>(100);
		box2.setContent(100);
		int value = box2.getContent();
		System.out.println(value);
		
		Box3 box3 = new Box3(1, 2);
		{
			int v1 = (int)box3.getContent1();
			int v2 = (int)box3.getContent2();
			System.out.println(v1 + v2);
		}
		{
			box3 = new Box3("Hello", "World");
			String v1 = (String)box3.getContent1();
			String v2 = (String)box3.getContent2();
			
			box3.setContent1(10);
			
			System.out.println(v1 + " " + v2);
		}
		{
			Box2<String, String> box4 = new Box2("Hello", "World");
			String v1 = box4.getContent1();
			String v2 = box4.getContent2();
			
//			box4.setContent1(10); //제네릭 타입으로는 강제 형변환 불가능.
			System.out.println(v1 + " " + v2);
		}
	}
}