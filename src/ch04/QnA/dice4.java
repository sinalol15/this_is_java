package ch04.QnA;

public class dice4 {

	public static void main(String[] args) {
		
		while(true) {
			int 눈1 = (int)(Math.random()*6)+1;
			int 눈2 = (int)(Math.random()*6)+1;
			System.out.println("(" + 눈1 + ", " + 눈2 + ")");
			if (눈1 + 눈2 == 5) {
				break;
			}
		}
	}

}
