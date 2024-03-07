package ch12.QnA;

public class StringBuilderExample10 {

	public static void main(String[] args) {
		String str = "";
		StringBuilder str2 = new StringBuilder();
		for( int i = 1; i <= 100; ++i) {
			str2.append(i);
		}
		str = str2.toString();
		System.out.println(str);
	}

}