package ch04.sec03;

public class SwitchValueExample {
	public static void main(String[] args) {
		String grade = "B";
		
		//Java 11 이전 문법
		int score1 = 0;
		switch(grade) {
		    case "A":
		    	score1 = 100;
		    	break;
		    case "B":
		    	int result = 100 - 20;
		    	score1 = result;
		    	break;
		    default:
		    	score1 = 60;
		}
		System.out.println("score1: " + score1);
		
		//Java 14부터 가능
		int score2 = switch(grade) {
			case "A" -> 100;
			case "B" -> {
				int result = 100 - 20;
				yield result; //return 대신 yield 사용(but, 괄호를 사용하여 작성할 때만-여러문장, 한 문장이면 ->으로 가능)
			}
			default -> 60;
		};
		System.out.println("score2: " + score2);
	}
}