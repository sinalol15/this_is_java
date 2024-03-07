package ch12.sec03.exam05;

import java.util.Objects;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class Member {
	private final String id;
	@NonNull private String name;
	private int age;
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return age == other.age && Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, id, name);
	}
}