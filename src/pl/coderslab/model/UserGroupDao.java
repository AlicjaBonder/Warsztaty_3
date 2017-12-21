package pl.coderslab.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserGroupDao {

	public static List<UserGroup> loadAll() throws SQLException {

		List<UserGroup> groups = new ArrayList<>();
		String sql = "SELECT * FROM user_group";
		Connection conn = null;
		try {
			conn = DbUtil.getConn();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				UserGroup gr = new UserGroup(rs.getString(2));
				gr.setId(rs.getInt(1));
				groups.add(gr);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Upss coś poszło nie tak!");
		}
		return groups;
	}

	public static void editGroup(String name, int grId) {

		String sql = "UPDATE user_group SET name = ? WHERE id = ? ";

		try (Connection conn = DbUtil.getConn(); PreparedStatement preparedStatement = conn.prepareStatement(sql);) {

			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, grId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Upss coś poszło nie tak!");
		}

	}

	public static void addGroup(String name) {

		String sql = "INSERT INTO user_group VALUES(null, ?)";

		try (Connection conn = DbUtil.getConn(); PreparedStatement preparedStatement = conn.prepareStatement(sql);) {

			preparedStatement.setString(1, name);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Upss coś poszło nie tak!");
		}
	}
		
		public static void deleteGroup(int grId) {

			String sql = "DELETE FROM user_group WHERE id= ?";

			try (Connection conn = DbUtil.getConn(); PreparedStatement preparedStatement = conn.prepareStatement(sql);) {

				preparedStatement.setInt(1, grId);
				preparedStatement.executeUpdate();

			} catch (SQLException e) {
				System.out.println("Upss coś poszło nie tak!");
			}


	}

}
