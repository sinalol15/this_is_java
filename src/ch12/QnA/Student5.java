package ch12.QnA;

import java.util.Objects;

public class Student5 {
	private String studentNum;
	
	public Student5(String studentNum) {
		this.studentNum = studentNum;
	}
	
	public String getStudentNum() {
		return studentNum;
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
		Student5 other = (Student5) obj;
		return Objects.equals(studentNum, other.studentNum);
	}
}