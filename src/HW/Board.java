//게시물 정보를 관리하는 클래스 
package HW;

import java.time.LocalDate;
import java.util.Objects;

import lombok.Data;

@Data
public class Board {
	private int bno;
	private String btitle;
	private String bcontent;
	private String bwriter;
	private LocalDate bdate;

	public Board(String btitle, String bcontent, String bwriter) {
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bwriter = bwriter;
		this.bdate = LocalDate.now();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		return bno == other.bno;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bno);
	}
}