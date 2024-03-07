package HW;

public class Diary {
	/* 하루일과
	 * 1. 아침을 먹는다.
	 * 2. 광역버스 1번을 탄다.
	 * 3. 강의를 듣는다.
	 * 4. 점심을 먹는다.
	 * 5. 강의를 듣는다.
	 * 6. 광역버스 1번을 탄다.
	 * 5. 저녁을 먹는다.
	 * */

	public static void main(String[] args) {
		식사 eat = new 식사();
		버스 bus = new 버스();
		강의 listen = new 강의();
		
		eat.먹는다("아침");
		bus.setNum(1);
		bus.탄다("광역");
		listen.듣는다();
		eat.먹는다("점심");
		listen.듣는다();
		bus.탄다("광역");
		eat.먹는다("저녁");
	}
}

class 식사 {
	void 먹는다 (String time) {
		System.out.println(time + "을 먹는다.");
	}
}

class 버스 {
	int num;
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		if (num > 0) {
			this.num = num;
		}
	}

	void 탄다 (String bus) {
		System.out.println(bus + "버스 " + num + "번을 탄다.");
	}
}

class 강의 {		
	void 듣는다 () {
		System.out.println("강의를 듣는다.");
	}
}