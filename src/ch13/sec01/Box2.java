package ch13.sec01;

public class Box2<A, B> { //타입도 매개변수처럼 전달 가능.
	
	private A content1;
	private B content2;
	
	public Box2(A content1, B content2) {
		super();
		this.content1 = content1;
		this.content2 = content2;
	}
	public A getContent1() {
		return content1;
	}
	public void setContent1(A content1) {
		this.content1 = content1;
	}
	public B getContent2() {
		return content2;
	}
	public void setContent2(B content2) {
		this.content2 = content2;
	}
	
}