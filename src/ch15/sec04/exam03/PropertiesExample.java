package ch15.sec04.exam03;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Scanner;
	
public class PropertiesExample {
	public static void main(String[] args) throws Exception {
//		Properties properties = new Properties();
//		properties.load(new FileInputStream("D:\\workspace\\thisisjava\\src\\ch15\\sec04\\exam03\\in.txt"));
//		
//		for (var entry : properties.entrySet()) {
//			System.out.println("key = " + entry.getKey());
//			System.out.println("value = " + entry.getValue());
//		}
//		
//		int a = Integer.parseInt(properties.getProperty("a"));
//		int b = Integer.parseInt(properties.getProperty("b"));
		
//		Scanner scanner = new Scanner(System.in);
//		int a = scanner.nextInt();
//		int b = scanner.nextInt();
//		int sum = a + b;
//		System.out.println(a + " + " + b + " = " + sum);
//		scanner.close();
		
		//Properties 컬렉션 생성
		Properties properties = new Properties();

		//PropertiesExample.class와 동일한 ClassPath에 있는 database.properties 파일 로드
		properties.load(PropertiesExample.class.getResourceAsStream("database.properties"));

		//주어진 키에 대한 값 읽기
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String admin = properties.getProperty("admin");

		//값 출력
		System.out.println("driver : " + driver);
		System.out.println("url : " + url);
		System.out.println("username : " + username);
		System.out.println("password : " + password);
		System.out.println("admin : " + admin);
	}
}