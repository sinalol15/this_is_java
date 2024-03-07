package ch15.sec03.exam02;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member {
	private int id;
	public String name;
	public int age;
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return id == other.id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	//모든 멤버 변수를 사용하는 경우 hashCode(), equals() 재정의 x(but, 특정 필드만 사용하는 경우 재정의 o)
				
//	//hashCode 재정의
//	@Override
//	public int hashCode() {
//		return name.hashCode() + age;
//	}
//
//	//equals 재정의
//	@Override
//	public boolean equals(Object obj) {
//		if(obj instanceof Member target) {
//			return target.name.equals(name) && (target.age==age) ;
//		} else {
//			return false;
//		}
//	}
}