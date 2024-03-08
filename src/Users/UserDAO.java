package Users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//수정 중간_2 과정(JAVA, JDBC 분리) -JDBC 작업

public class UserDAO {
	// Field
	private static Connection conn = null;
	private static PreparedStatement stmt1 = null;
	private static PreparedStatement stmt2 = null;
	private static PreparedStatement stmt3 = null;
	private static PreparedStatement stmt4 = null;
	private static PreparedStatement stmt5 = null;
	private static PreparedStatement stmt6 = null;

	static {
		try {
			// JDBC Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");

			// 연결하기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "bituser", "1004");
			conn.setAutoCommit(false);
			stmt1 = conn.prepareStatement("SELECT * FROM users ORDER BY userid");
			stmt2 = conn.prepareStatement("INSERT INTO users(userid, username, userpassword, userage, usermail) VALUES (?, ?, ?, ?, ?)");
			stmt3 = conn.prepareStatement("UPDATE users SET username=?, userpassword=?, userage = ?, usermail = ? WHERE userid=?");
			stmt4 = conn.prepareStatement("DELETE FROM users WHERE userid=?");
			stmt5 = conn.prepareStatement("DELETE FROM users");
			stmt6 = conn.prepareStatement("SELECT * FROM users WHERE userid=?");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Method
	public List<User> list() {
		List<User> list = new ArrayList<>();
		try {
			ResultSet rs = stmt1.executeQuery();
			while (rs.next()) {
				User user = new User(rs.getString("userid"), rs.getString("username"), rs.getString("userpassword"), rs.getInt("userage"), rs.getString("usermail"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int insert(User user) {
		int updated = 0;
		try {
			stmt2.setString(1, user.getUserid());
			stmt2.setString(2, user.getUsername());
			stmt2.setString(3, user.getUserpassword());
			stmt2.setInt(4, user.getUserage());
			stmt2.setString(5, user.getUsermail());

			updated = stmt2.executeUpdate();
			conn.commit();
			
			return updated;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public User read(String nid) {
		User user = null;
		try {
			stmt6.setString(1, nid);

			ResultSet rs = stmt6.executeQuery();
			if (rs.next()) {
				// 찾고자 하는 자료가 있음
				user = new User(rs.getString("userid"), rs.getString("username"), rs.getString("userpassword"), rs.getInt("userage"), rs.getString("usermail"));
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public int update(User user) {
		int updated = 0;
		try {
			// 입력 값을 설정 한다.
			stmt3.setString(1, user.getUsername());
			stmt3.setString(2, user.getUserpassword());
			stmt3.setInt(3, user.getUserage());
			stmt3.setString(4, user.getUsermail());
			stmt3.setString(5, user.getUserid());

			updated = stmt3.executeUpdate();

			conn.commit();
			
			return updated;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int delete(String userid) {
		int updated = 0;
		try {
			stmt4.setString(1, userid);
			updated = stmt4.executeUpdate();

			conn.commit();
			
			return updated;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int clear() {
		int updated = 0;
		try {
			updated = stmt5.executeUpdate();

			conn.commit();
			
			return updated;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}