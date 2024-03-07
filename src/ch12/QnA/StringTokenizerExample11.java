package ch12.QnA;

import java.util.StringTokenizer;

public class StringTokenizerExample11 {

	public static void main(String[] args) {
		String str = "아이디,이름,패스워드";
		StringTokenizer str2 = new StringTokenizer(str, ",");
		while(str2.hasMoreTokens()) {
			String str3 = str2.nextToken();
			System.out.println(str3);
		}
	}

}