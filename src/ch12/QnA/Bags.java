package ch12.QnA;

import lombok.Data;

@Data
public class Bags {
	private String color;
	private String brand;
	
	public void buy() {
		System.out.println("가방을 구매했습니다.");
	}
}