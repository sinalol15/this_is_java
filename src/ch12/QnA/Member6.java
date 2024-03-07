package ch12.QnA;

public class Member6 {
	private String id;
	private String name;
	
	public Member6(String id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return id + ": " + name;
	}
}