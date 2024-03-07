package ch12.QnA;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Remain15 {

	public static void main(String[] args) {
		LocalDateTime start = LocalDateTime.now();
		LocalDateTime end = LocalDateTime.of(start.getYear(), 12, 31, 0, 0, 0);
		
		System.out.println("남은 일: " + start.until(end, ChronoUnit.DAYS));
	}

}