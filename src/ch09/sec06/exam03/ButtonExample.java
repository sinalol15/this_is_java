package ch09.sec06.exam03;

import ch09.sec06.exam03.Button.ClickListener;

public class ButtonExample {
	public static void main(String[] args) {
		//Ok 버튼 객체 생성
		Button btnOk = new Button();
		btnOk.click();

		//Ok 버튼 클릭 이벤트를 처리할 ClickListener 구현 클래스(로컬 클래스)
		class OkListener implements Button.ClickListener {
			@Override
			public void onClick() {
				System.out.println("Ok 버튼을 클릭했습니다.");
			}
		}
		
		ClickListener listener = new Button.ClickListener() {
			@Override
			public void onClick() {
				System.out.println("Ok 버튼을 클릭했습니다.");
			}
		};

		//Ok 버튼 객체에 ClickListener 구현 객체 주입
//		btnOk.setClickListener(new Button.ClickListener() {
//			@Override
//			public void onClick() {
//				System.out.println("Ok 버튼을 클릭했습니다.");
//				System.out.println(btnOk);
//			}
//		});
		
		//위 27-33까지의 코드를 한 줄로 축약 가능.
		btnOk.setClickListener(() -> { System.out.println("Ok 버튼을 클릭했습니다."); System.out.println(btnOk); } );
		
		//Ok 버튼 클릭하기
		btnOk.click();

		//-----------------------------------------------------------------------------
		
		//Cancel 버튼 객체 생성
		Button btnCancel = new Button();

		//Cancel 버튼 클릭 이벤트를 처리할 ClickListener 구현 클래스(로컬 클래스)
		class CancelListener implements Button.ClickListener {
			@Override
			public void onClick() {
				System.out.println("Cancel 버튼을 클릭했습니다.");
			}
		}
		
		//Cancel 버튼 객체에 ClickListener 구현 객체 주입
		btnCancel.setClickListener(new CancelListener());
		
		//Cancel 버튼 클릭하기
		btnCancel.click();
	}
}