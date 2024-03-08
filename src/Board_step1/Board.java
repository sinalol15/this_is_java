//게시물 정보를 관리하는 클래스 
package Board_step1;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Board {
	private int bno;
	private String btitle;
	private String bcontent;
	private String bwriter;
	private String bdate;
	
	public Board(int bno, String btitle, String bcontent, String bwriter) {
		this(bno, btitle, bcontent, bwriter, null);
	}
	
	public Board(String btitle, String bcontent, String bwriter) {
		this(0, btitle, bcontent, bwriter);
	}
	
	public void print() {
		   System.out.printf("%-6s%-12s%-12s%-24s%-40s\n"
				 , bno
				 , btitle
				 , bwriter
				 , bdate
				 , bcontent
				 );
	}
}