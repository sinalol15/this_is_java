package ch12.sec03.exam04;

public class RecordExample {
	public static void main(String[] args) {
		Person p = new Person("1234", "홍길동", 20);
		Person q = new Person("1234", "홍길동", 20);
		
		System.out.println(p.getSsn());
		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.toString());
		System.out.println(p.equals(q));
		System.out.println();
		
		Member m = new Member("winter", "눈송이", 25);
		System.out.println(m.id());
		System.out.println(m.name());
		System.out.println(m.age());
		System.out.println(m.toString());
		System.out.println();
		
		Member m1 = new Member("winter", "눈송이", 25);
		Member m2 = new Member("winter", "눈송이", 25);
		System.out.println("m1.hashCode(): " + m1.hashCode());
		System.out.println("m2.hashCode(): " + m2.hashCode());
		System.out.println("m1.equals(m2): " + m1.equals(m2) );
	}
}