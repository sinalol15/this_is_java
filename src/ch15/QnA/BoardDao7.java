package ch15.QnA;

import java.util.List;
import java.util.ArrayList;

public class BoardDao7 {
	public List<Board7> getBoardList(){
		List<Board7> list = new ArrayList<Board7>();
		list.add(new Board7("제목1", "내용1"));
		list.add(new Board7("제목2", "내용2"));
		list.add(new Board7("제목3", "내용3"));
		return list;
	}
}