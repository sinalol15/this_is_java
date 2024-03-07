package ch13.QnA;

public class Container3<A, B> {
	public A a;
	public B b;
	public A getKey() {
		return a;
	}
	public void set(A a, B b) {
		this.a = a;
		this.b = b;
	}
	public B getValue() {
		return b;
	}
}