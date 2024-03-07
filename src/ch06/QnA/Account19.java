package ch06.QnA;

public class Account19 {
	public static final int MIN_BALANCE = 0;
	public static final int MAX_BALANCE = 1000000;
	private int balance;
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		if(balance < Account19.MIN_BALANCE || balance >= Account19.MAX_BALANCE) {
			return;
		}
		this.balance = balance;
	}
}