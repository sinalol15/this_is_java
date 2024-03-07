package ch12.sec03.exam01;

import java.util.Objects;

public class Member {
	public String id;

	public Member(String id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
//		return id != null ?id.hashCode() : 0;
	}

	@Override
	public boolean equals(Object obj) {
		/*
		 * 1. 전달된 인자가 null이면 false
		 * 2. 나의 hashCode와 전달된 인자의 hashCode가 다르면 false
		 * 3. 나의 객체 주소와 전달된 인자의 객체 주소가 다르면 false
		 * 4. 나의 클래스 정보와 전달된 인자의 클래스 정보가 다르면 false
		 * 5. 나의 객체 멤버 변수와 전달된 객체의 멤버 변수를 직접 비교하여 같으면 true, 아니면 false
		 * */
		if (obj == null)
			return false;
		if (hashCode() != obj.hashCode())
			return false;
		if (this == obj)
			return true;
		if (getClass() != obj.getClass()) // obj와 this 가 같은 타입인지 확인 (예: 멤버, 스트링, 인트 등등..)
			//!=와 ==는 기본형, 참조의 주소가 같은지 비교; getClass()는 정적멤버함수라 !=으로 비교 가능.
			return false;
		Member other = (Member) obj;
		return Objects.equals(id, other.id);
		// 위 24-28까지의 코드와 기능은 같나 부모자식간의 관계도 뒤져야하기 때문에 성능이 느리다.
//		if (obj instanceof Member other) {
//			return id.equals(other.id);
//		}
//		return false;
	}

//	@Override
//	public boolean equals(Object obj) {
//		if(obj instanceof Member target) {
//			if(id.equals(target.id)) {
//				return true;
//			}
//		}
//		return false;
//	}
}