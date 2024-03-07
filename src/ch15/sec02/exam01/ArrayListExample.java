package ch15.sec02.exam01;

import java.util.ArrayList;
import java.util.List;
	
public class ArrayListExample {
	/*
	 * new 로 객체를 생성하면 힙에 저장이 되는데 ArrayList를 사용하면 Array 에 16개 저장가능한 공간이 생겨 16개까진 괜찮은데
	 * 17개부턴 기존 Array 를 복사한 후 그 만큼의 새로운 공간이 늘어나 힙에 추가를 한다. ex :) 16-> 32-> 64-> ...
	 * ArrayList는 색인 배열이기 때문에 배열 갯수가 많이 질 수록 속도가 느려진다.
	 * 중간 위치에 삽입, 삭제해야 할 경우에는 사용하지 않는게 좋다.
	 * 그 뒤의 데이터 들을 다 복사한 후 밀거나 끌어와야해서 속도가 느려지기 때문.
	 * but, memory 를 적게 써서 색인번호를 알거나, 한방에 데이터를 추가하거나 삭제할 땐 빠르다.
	*/
	public static void main(String[] args) {
		
//-----------------------------------------------------------------------
		
//		Board[] array = {
//			new Board(1, "제목1", "내용1", "글쓴이1"),
//			new Board(2, "제목2", "내용2", "글쓴이2"),
//			new Board(3, "제목3", "내용3", "글쓴이3"),
//			new Board(4, "제목4", "내용4", "글쓴이4"),
//			new Board(5, "제목5", "내용5", "글쓴이5")
//		};
//		
//		for(Board board : array) {
//			System.out.println(board);
//		}
//		
//		Board [] newArray = new Board[6];
//		for (int i = 0; i < array.length; ++i) {
//			newArray[i] = array[i];
//		}
//		
//		newArray[5] = new Board(6, "제목6", "내용6", "글쓴이6");
//		
//		for(Board board : newArray) {
//			System.out.println(board);
//		}
		
//-----------------------------------------------------------------------
		
	//위 코드를 List 컬렉션을 사용하여 간단히 작성하기.
		
		//ArrayList 컬렉션 생성
		List<Board> list = new ArrayList< >();
		
		//객체 추가
		list.add(new Board(1, "제목1", "내용1", "글쓴이1"));
		list.add(new Board(2, "제목2", "내용2", "글쓴이2"));
		list.add(new Board(3, "제목3", "내용3", "글쓴이3"));
		list.add(new Board(4, "제목4", "내용4", "글쓴이4"));
		list.add(new Board(5, "제목5", "내용5", "글쓴이5"));

		//저장된 총 객체 수 얻기
		int size = list.size();
		System.out.println("총 객체 수: " + size);
		System.out.println();
				
		//특정 인덱스의 객체 가져오기
		Board board = list.get(2);
		System.out.println(board.getSubject() + "\t" + board.getContent() +
								"\t" + board.getWriter());
		System.out.println();
			
		//모든 객체를 하나씩 가져오기
		for(int i=0; i<list.size(); i++) {
			Board b = list.get(i);
			System.out.println(b.getSubject() + "\t" + b.getContent() +
								"\t" + b.getWriter());
		}
		System.out.println();
			
		//객체 삭제
		list.remove(2); //배열의 크기도 줄고 데이터도 앞으로 땡겨오는 코드.
		list.remove(2);
		list.add(new Board(6, "제목6", "내용6", "글쓴이6"));
			
		//향상된 for 문으로 모든 객체를 하나씩 가져오기
		for(Board b : list) {
		//데이터 객체를 모르면 암시적으로 for(var b : list)로 작성해도 작동된다.
			System.out.println(b.getSubject() + "\t" + b.getContent() +
								"\t" + b.getWriter());
		}
		System.out.println();
		
		Board board2 = new Board(3);
		if (list.contains(board2)) {
			int idx = list.indexOf(board2);
			//Board 타입인 board2 자리에 Integer 타입으로 바꿔서 출력하면 자료는 찾지만 hashCode가 달라서 Integer 타입을 넣으면 안된다.
			//indexOf는 hashCode와 equals 함수를 같이 호출하기 때문에 Integer 타입을 넣으면 데이터 출력은 되지만 아이디가 존재하지 않는다고 출력한다.
			//hashCode가 같을 경우에는 equals 함수를 수정하면 Integer 타입이 들어와도 같은지 다른지 비교할 수 있다.
			if (idx != -1) {
				board2 = list.get(idx);
				System.out.println("====찾은 자료====");
				System.out.println("아이디가 " + board2.getId() + "인 자료의 위치 = " + idx);
				System.out.println(board2);
			}
		} else {
			System.out.println(board2.getId() + "번째 위치한 자료가 존재하지 않습니다.");
		}
		
//-----------------------------------------------------------------------
	}
}