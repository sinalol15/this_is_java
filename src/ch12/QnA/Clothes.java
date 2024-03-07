package ch12.QnA;

import lombok.Data;

@Data
public class Clothes {
	private String color;
	private int size;
	
	public void buy() {
		System.out.println("옷을 구매했습니다.");
	}
}