package ch06.QnA;

public class Account20 {
	private String num;
	private String name;
	private int amount;
	
	public Account20(String num, String name, int amount) {
		this.num = num;
		this.name = name;
		this.amount = amount;
	}
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}