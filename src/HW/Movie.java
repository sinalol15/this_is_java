package HW;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

class Seat {
    private final int row;
    private final int column;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
	public int hashCode() {
		return Objects.hash(column, row);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seat other = (Seat) obj;
		return column == other.column && row == other.row;
	}

    @Override
    public String toString() {
        return row + "-" + column;
    }
}

public class Movie {
    private static final int ROWS = 4;
    private static final int COLUMNS = 5;
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Seat> bookings = new HashMap<>();
    private static final Set<String> reservedSet = new HashSet<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("********************");
            System.out.println("*****영화 예매 시스템*****");
            System.out.println("********************");
            System.out.println("1. 예매하기");
            System.out.println("2. 예매조회");
            System.out.println("3. 예매취소");
            System.out.println("4. 종료");
            System.out.print("선택: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    bookSeat();
                    System.out.println();
                    break;
                case "2":
                    searchBooking();
                    System.out.println();
                    break;
                case "3":
                    cancelBooking();
                    System.out.println();
                    break;
                case "4":
                    System.out.println("영화 예매 시스템을 종료하겠습니다.");
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
                    System.out.println();
            }
        }
    }

    private static void bookSeat() {
        while (true) {
            System.out.println("********좌석 현황********");
            for (int i = 1; i <= ROWS; i++) {
                for (int j = 1; j <= COLUMNS; j++) {
                    Seat seat = new Seat(i, j);
                    if (bookings.containsValue(seat)) {
                        System.out.print("[예매] ");
                    } else {
                        System.out.print("[" + i + "-" + j + "] ");
                    }
                }
                System.out.println();
            }
            System.out.println("--------------------");
            System.out.println("좌석을 선택해 주세요. 예)1-1");
            System.out.println("이미 예매된 좌석은 \"예매\"라고 표시됩니다.");
            String seatStr = scanner.nextLine();
            String[] seatParts = seatStr.split("-");
            if (seatParts.length != 2) {
                System.out.println("잘못된 좌석 형식입니다. 다시 입력해주세요.");
                continue;
            }
            int row, column;
            try {
                row = Integer.parseInt(seatParts[0]);
                column = Integer.parseInt(seatParts[1]);
            } catch (NumberFormatException e) {
                System.out.println("잘못된 좌석 형식입니다. 다시 입력해주세요.");
                continue;
            }
            if (row < 1 || row > ROWS || column < 1 || column > COLUMNS) {
                System.out.println("존재하지 않는 좌석입니다. 다시 선택해주세요.");
                continue;
            }
            Seat selectedSeat = new Seat(row, column);
            if (bookings.containsValue(selectedSeat)) {
                System.out.println("이미 예매된 좌석입니다. 다시 선택해주세요.");
                continue;
            }
            // 예매 가능한 좌석이면 예매 진행
            reserveSeat(selectedSeat);
            break; // 정상적인 좌석 선택이 완료되면 반복문 탈출
        }
    }

    private static void reserveSeat(Seat selectedSeat) {
        System.out.println("예매 가능합니다. 예매하시겠습니까?");
        System.out.println("네(1), 아니오(2), 초기화면(0)중 하나를 입력해주세요.");
        String input = scanner.nextLine();
        switch (input) {
            case "1":
            	String bookingId;
            	while(true) {
            		bookingId = generateBookingId();
                    if(!reservedSet.contains(bookingId)) {
                    	bookings.put(bookingId, selectedSeat);
                    	break;
                    }
            	}
                System.out.println("예매가 완료되었습니다.");
                System.out.println("예매한 좌석번호: " + selectedSeat + " / 예매번호: [" + bookingId + "]");
                System.out.println("감사합니다.");
                break;
            case "2":
                System.out.println("예매를 완료하지 않았습니다.");
                break;
            case "0":
                break;
            default:
                System.out.println("잘못된 선택입니다. 초기 화면으로 돌아갑니다.");
                break;
        }
    }

    private static String generateBookingId() {
        return String.format("%08d", (int) (Math.random() * 100000000));
    }

    private static void searchBooking() {
        System.out.println("예매번호를 입력해주세요.");
        String bookingId = scanner.nextLine();
        Seat seat = bookings.get(bookingId);
        if (seat != null) {
            System.out.println("고객님이 예매하신 좌석은 " + seat + " 입니다.");
        } else {
            System.out.println("예매번호를 다시 한 번 확인해주세요. 없는 번호입니다.");
        }
    }

    private static void cancelBooking() {
        System.out.println("예매번호를 입력해주세요.");
        String bookingId = scanner.nextLine();
        Seat seat = bookings.get(bookingId);
        if (seat != null) {
            System.out.println("고객님이 예매하신 좌석은 " + seat + " 입니다. 예매를 취소하시겠습니까?");
            System.out.println("네(1), 아니오(2) 중 하나를 입력해주세요.");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    bookings.remove(bookingId);
                    System.out.println("예매가 취소되었습니다. 감사합니다.");
                    break;
                case "2":
                    System.out.println("예매를 취소하지 않았습니다. 감사합니다.");
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 초기 화면으로 돌아갑니다.");
                    break;
            }
        } else {
            System.out.println("예매번호를 다시 한 번 확인해주세요. 없는 번호입니다.");
        }
    }
}