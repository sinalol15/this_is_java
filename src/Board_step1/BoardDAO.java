package Board_step1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//수정 중간_2 과정(JAVA, JDBC 분리) -JDBC 작업

public class BoardDAO {
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
			stmt1 = conn.prepareStatement("SELECT * FROM boards ORDER BY bno");
			stmt2 = conn.prepareStatement("INSERT INTO boards(bno, btitle, bcontent, bwriter, bdate) VALUES (seq_bno.nextval, ?, ?, ?, sysdate)");
			stmt3 = conn.prepareStatement("UPDATE boards SET btitle=?, bcontent=?, bwriter=? WHERE bno=?");
			stmt4 = conn.prepareStatement("DELETE FROM boards WHERE bno=?");
			stmt5 = conn.prepareStatement("DELETE FROM boards");
			stmt6 = conn.prepareStatement("SELECT * FROM boards WHERE bno=?");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Method
	public List<Board> list() {
		List<Board> list = new ArrayList<>();
		try {
			ResultSet rs = stmt1.executeQuery();
			while (rs.next()) {
				Board board = new Board(rs.getInt("bno"), rs.getString("btitle"), rs.getString("bcontent"), rs.getString("bwriter"), rs.getString("bdate"));
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int insert(Board board) {
		int updated = 0;
		try {
			stmt2.setString(1, board.getBtitle());
			stmt2.setString(2, board.getBcontent());
			stmt2.setString(3, board.getBwriter());

			updated = stmt2.executeUpdate();
			conn.commit();
			
			return updated;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Board read(int bno) {
		Board board = null;
		try {
			stmt6.setInt(1, bno);

			ResultSet rs = stmt6.executeQuery();
			if (rs.next()) {
				// 찾고자 하는 자료가 있음
				board = new Board(rs.getInt("bno"), rs.getString("btitle"), rs.getString("bcontent"), rs.getString("bwriter"), rs.getString("bdate"));
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board;
	}

	public int update(Board board) {
		int updated = 0;
		try {
			// 입력 값을 설정 한다.
			stmt3.setString(1, board.getBtitle());
			stmt3.setString(2, board.getBcontent());
			stmt3.setString(3, board.getBwriter());
			stmt3.setInt(4, board.getBno());
			updated = stmt3.executeUpdate();

			conn.commit();
			
			return updated;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int delete(int userid) {
		int updated = 0;
		try {
			stmt4.setInt(1, userid);
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