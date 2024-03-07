package ch13.sec01;

public class Box3 {
	
	private Object content1;
	private Object content2;
	
	public Box3(Object content1, Object content2) {
		super();
		this.content1 = content1;
		this.content2 = content2;
	}
	public Object getContent1() {
		return content1;
	}
	public void setContent1(Object content1) {
		this.content1 = content1;
	}
	public Object getContent2() {
		return content2;
	}
	public void setContent2(Object content2) {
		this.content2 = content2;
	}
	
}