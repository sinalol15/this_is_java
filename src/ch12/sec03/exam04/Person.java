package ch12.sec03.exam04;

import java.util.Objects;

//DTO(Data Transfer Object) - 데이터 전송할 때 사용
public class Person {
	private final String ssn;
	private final String name;
	private final int age;
	
	public Person(String ssn, String name, int age) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.age = age;
	}

	public String getSsn() {
		return ssn;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ssn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(ssn, other.ssn);
	}

	@Override
	public String toString() {
		return "Person [ssn=" + ssn + ", name=" + name + ", age=" + age + "]";
	}
}