package ch06.QnA;

import java.util.Scanner;

public class BankApplication20 {
	private static Scanner scanner = new Scanner(System.in);
	private static Account20[] accountArray = new Account20[100];
	
	public static void main(String[] args) {
		boolean run = true;
		
		while(run) {
			System.out.println("----------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("----------------------------------------------");
			System.out.print("선택> ");
			
			String num = scanner.nextLine();
			
			switch(num) {
				case "1" -> {
					createAccount();
				}
				case "2" -> {
					accountList();
				}
				case "3" -> {
					plusAmount();
				}
				case "4" -> {
					minusAmount();
				}
				case "5" -> {
					System.out.println("프로그램 종료");
					run = false;
				}
			}
		}
	}
	
	private static void minusAmount() {
		System.out.println("----------");
		System.out.println("출금");
		System.out.println("----------");
		System.out.print("계좌번호: ");
		String Num3 = scanner.nextLine();
		System.out.print("출금액: ");
		int Amount3 = Integer.parseInt(scanner.nextLine());
		
		Account20 account = fineAccount(Num3);
		if (account == null) {
			System.out.println("결과: 계좌가 없습니다.");
			return;
		}
		account.setAmount(account.getAmount() - Amount3);
		System.out.println("결과: 출금이 성공되었습니다.");
	}

	private static void plusAmount() {
		System.out.println("----------");
		System.out.println("예금");
		System.out.println("----------");
		System.out.print("계좌번호: ");
		String Num2 = scanner.nextLine();
		System.out.print("예금액: ");
		int Amount2 = Integer.parseInt(scanner.nextLine());
		
		Account20 account = fineAccount(Num2);
		if(account == null) {
			System.out.println("결과: 계좌가 없습니다.");
			return;
		}
		account.setAmount(account.getAmount() + Amount2);
		System.out.println("결과: 예금이 성공되었습니다.");
	}

	private static Account20 fineAccount(String num2) {
		Account20 account = null;
		for(int i = 0; i < accountArray.length; ++i) {
			if(accountArray[i] != null) {
				String fnnum = accountArray[i].getNum();
				if(fnnum.equals(num2)) {
					account = accountArray[i];
					break;
				}
			}
		}
		return account;
	}

	private static void accountList() {
		System.out.println("----------");
		System.out.println("계좌목록");
		System.out.println("----------");
		for(int i = 0; i < accountArray.length; ++i) {
			if(accountArray[i] == null) {
				return;
			} else {
				System.out.println(accountArray[i].getNum() + "    " + accountArray[i].getName() + "    "  + accountArray[i].getAmount());
			}
		}
	}

	private static void createAccount() {
		System.out.println("----------");
		System.out.println("계좌생성");
		System.out.println("----------");
		System.out.print("계좌번호: ");
		String Num = scanner.nextLine();
		System.out.print("계좌주: ");
		String Name = scanner.nextLine();
		System.out.print("초기입금액: ");
		int Amount = Integer.parseInt(scanner.nextLine());
		
		Account20 newAccount = new Account20(Num, Name, Amount);
		for(int i = 0; i < accountArray.length; ++i) {
			if(accountArray[i] == null) {
				accountArray[i] = newAccount;
				System.out.println("결과: 계좌가 생성되었습니다.");
				break;
			}
		}
	}

}