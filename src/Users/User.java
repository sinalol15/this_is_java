//게시물 정보를 관리하는 클래스 
package Users;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	private String userid;
	private String username;
	private String userpassword;
	private int userage;
	private String usermail;
	public void print() {
		   System.out.printf("%-12s%-12s%-24s%-6s%-40s\n"
				 , userid
				 , username
				 , userpassword
				 , userage
				 , usermail
				 );
	}
}