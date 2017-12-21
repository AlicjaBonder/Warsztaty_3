package pl.coderslab.model;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	
	public static List<User> loadAll(){
		
		List<User> users = new ArrayList<>();
		String sql = "SELECT * FROM users";
		
		try(Connection conn = DbUtil.getConn();
				PreparedStatement preaparedStatement = conn.prepareStatement(sql);){
						
				ResultSet rs = preaparedStatement.executeQuery();
				while(rs.next()) {
					User user = new User(rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
					user.setId(rs.getInt(1));
					users.add(user);
				}
								
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("Upss coś poszło nie tak!");
			}
			
		return users;
		
	}
	
	public static List<User> loadAllByGroupId(int grId){
		
		List<User> users = new ArrayList<>();
		String sql = "SELECT * FROM users WHERE person_group_id = ?";
		
		try(Connection conn = DbUtil.getConn();
			PreparedStatement preparedStatemnt = conn.prepareStatement(sql);){
						
			preparedStatemnt.setInt(1, grId);
			ResultSet rs = preparedStatemnt.executeQuery();
				while(rs.next()) {
					User user = new User(rs.getString(3),rs.getString(2),rs.getString(4),rs.getInt(5));
					user.setId(rs.getInt(1));
					users.add(user);
				}
								
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("Upss coś poszło nie tak!");
			}
				
		return users;
		
	}
	
	public static User loadUserById(int id) {
		
		User user = new User();
		String sql = "SELECT * FROM users WHERE id = ?";
		
		try(Connection conn = DbUtil.getConn();
				PreparedStatement preparedStatement = conn.prepareStatement(sql);){
						
			preparedStatement.setInt(1, id);
				ResultSet rs = preparedStatement.executeQuery();
				if(rs.next()) {
					user = new User(rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
					user.setId(rs.getInt(1));
				}
								
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("Upss coś poszło nie tak!");
			}
		
		return user;
	}
	
	public static void editUser(User user) {
		
		String sql = "UPDATE users SET username = ? , email = ? , password = ? , person_group_id = ? WHERE id = ?;";
		
		try(Connection conn = DbUtil.getConn();
				PreparedStatement preparedStatement = conn.prepareStatement(sql);) {
			
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setInt(4, user.getGroupId());
			preparedStatement.setInt(5, user.getId());
			preparedStatement.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("Upss coś poszło nie tak!");
		}
		
	}
	
	public static void addUser(User user) {
		
		String sql = "INSERT INTO users VALUES(null, ? , ? , ? , ? )";
		
		try(Connection conn = DbUtil.getConn();
				PreparedStatement preparedStatement = conn.prepareStatement(sql);) {
			
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getUsername());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setInt(4, user.getGroupId());
			preparedStatement.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("Upss coś poszło nie tak!");
		}
		
		
	}

}

