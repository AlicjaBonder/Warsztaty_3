package pl.coderslab.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ExcerciseDao {
	
	public static List<Excercise> loadAll(){
		
		List<Excercise> exercises = new ArrayList<>();
		String query = "Select * from exercise;";
		
		try(Connection conn = DbUtil.getConn();
				PreparedStatement st = conn.prepareStatement(query);){
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Excercise tmpEx = new Excercise(rs.getString(2),rs.getString(3));
				tmpEx.setId(rs.getInt(1));
				exercises.add(tmpEx);
			}
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return exercises;
		
	}
	
	public static void edit(Excercise ex) {
		
		String query = "Update exercise set title = ?, description = ? where id = ?;"; 
		
		try(Connection conn = DbUtil.getConn();
				PreparedStatement st = conn.prepareStatement(query);) {
			
			st.setString(1, ex.getTitle());
			st.setString(2, ex.getDescription());
			st.setInt(3, ex.getId());
			st.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
				
	}
	
	public static void add(Excercise ex) {

		String query = "Insert into exercise values(null, ? , ? );";

		try(Connection conn = DbUtil.getConn();
				PreparedStatement st = conn.prepareStatement(query);) {

			st.setString(1, ex.getTitle());
			st.setString(2, ex.getDescription());
			st.executeUpdate();

		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}


	}
	
	

}