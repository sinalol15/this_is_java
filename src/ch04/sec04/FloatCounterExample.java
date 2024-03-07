package ch04.sec04;

public class FloatCounterExample {
	public static void main(String[] args) {
//		for(float x=0.1f; x<=1.0f; x+=0.1f) {
//			System.out.println(x);
//		}
		for(float x=1; x<=10; ++x) {
			System.out.println((float)(x/10));
		}
	}
}