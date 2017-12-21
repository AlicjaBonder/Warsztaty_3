package pl.coderslab.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SolutionDAO {

	public static List<Solution> loadAll(int limit) throws SQLException {

		List<Solution> solutions = new ArrayList<>();
		String sql = "SELECT * FROM solution LIMIT ?";
		Connection conn = null;
		try {
			conn = DbUtil.getConn();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, limit);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Solution sol = new Solution(rs.getInt(5), rs.getInt(6));
				sol.setId(rs.getInt(1));
				sol.setCreated(rs.getDate(2));
				sol.setUpdated(rs.getDate(3));
				sol.setDescription(rs.getString(4));
				solutions.add(sol);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Upss coś poszło nie tak!");
		}
		return solutions;
	}

	public static Solution loadById(int id) throws SQLException {

		Solution solution = new Solution();
		String sql = "SELECT * FROM solution WHERE id = ?";
		Connection conn = null;
		try {
			conn = DbUtil.getConn();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				solution.setId(rs.getInt(1));
				solution.setCreated(rs.getDate(2));
				solution.setUpdated(rs.getDate(3));
				solution.setDescription(rs.getString(4));
				solution.setExerciseId(rs.getInt(5));
				solution.setUserId(rs.getInt(6));

			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Upss coś poszło nie tak!");
		}
		return solution;
	}

	public static List<Solution> loadAllByUserId(int id) {

		List<Solution> solutions = new ArrayList<>();
		String sql = "SELECT * FROM solution WHERE users_id = ? ORDER BY updated DESC";

		try (Connection conn = DbUtil.getConn(); PreparedStatement preparedStatement = conn.prepareStatement(sql);) {

			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Solution sol = new Solution(rs.getInt(5), rs.getInt(6));
				sol.setId(rs.getInt(1));
				sol.setCreated(rs.getDate(2));
				sol.setUpdated(rs.getDate(3));
				sol.setDescription(rs.getString(4));
				solutions.add(sol);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Upss coś poszło nie tak!");
		}

		return solutions;
	}

	public static void add(Solution solution) {

		String sql = "INSERT INTO solution VALUES(null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, ?, ?, ? )";

		try (Connection conn = DbUtil.getConn(); PreparedStatement preparedStatement = conn.prepareStatement(sql);) {

			preparedStatement.setString(1, solution.getDescription());
			preparedStatement.setInt(2, solution.getUsers_id());
			preparedStatement.setInt(3, solution.getExerc_id());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Upss coś poszło nie tak!");
		}

	}

}
