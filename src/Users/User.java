//사원 정보를 관리하는 클래스 
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
		   System.out.printf("%-10s%-10s%-12s%-6s%-40s\n"
				 , userid
				 , username
				 , userpassword
				 , userage
				 , usermail
				 );
	}
}