package ch09.sec06.exam03;

public class Button {
	//정적 멤버 인터페이스
	public static interface ClickListener {
		//추상 메소드
		void onClick();
	}

	//필드
	private ClickListener clickListener;

	//메소드
	public void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;
	}

	//click() 메소드가 호출되면 clickListener 참조 변수가 null 이 아니면 onClick() 함수를 호출하여 처리한다.
	public void click() {
		if (clickListener != null) {
			this.clickListener.onClick();
		}
	}
}