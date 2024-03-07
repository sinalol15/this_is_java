package ch11.sec04;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {

	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("c:\\temp\\in.txt");
			System.out.println("파일 읽기 작업 완료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				System.out.println("파일을 닫습니다.");
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
