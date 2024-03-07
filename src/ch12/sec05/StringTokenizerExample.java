package ch12.sec05;

import java.util.StringTokenizer;

public class StringTokenizerExample {
	public static void main(String[] args) {
		String data1 = "홍길동&이수홍,박연수|이순신";
		String[] arr = data1.split("&|,");
		for(String token : arr) {
			System.out.println(token);
		}
		System.out.println();

		String data2 = "홍길동/이수홍/박연수|이순신/홍길동/이순신|박연수";
		StringTokenizer st = new StringTokenizer(data2, "/|");
		
		// 실행 중에 끝나는데 for 문은 다 자른 후 배열로 반환해주는 거라 StringTokenizer 가 더 빠르고 성능이 좋다.
		long time3 = System.nanoTime();
		int i = 0;
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			if (i == 2) {
				System.out.println("1. " + token);
				break;
			}
			i++;
		}
		long time4 = System.nanoTime();
		System.out.println(time4 - time3);
		
		// 위 18-24까지의 코드와 같은 코드(While 문을 for 문으로)
		long time1 = System.nanoTime();
		for (int j = 0; st.hasMoreTokens(); ++j) {
			String token = st.nextToken();
			if (j != 2) continue;
			System.out.println("2. " + token);
			break;
		}
		long time2 = System.nanoTime();
		System.out.println(time2 - time1);
	}
}