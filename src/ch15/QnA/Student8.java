package ch15.QnA;

import java.util.Objects;

public class Student8 {
	public int studentNum;
	public String name;
	
	public Student8(int studentNum, String name) {
		this.studentNum = studentNum;
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(studentNum);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student8 other = (Student8) obj;
		return studentNum == other.studentNum;
	}
}