package pl.coderslab.model;

import java.sql.Date;

public class Solution {

	private int id = 0;
	private Date created;
	private Date updated;
	private String description;
	private int exerc_id;
	private int users_id;

	public Solution() {
	}

	public String toString() {
		String sol = this.getId() + " " + this.getDescription();
		return sol;
	}

	public Solution(int userId, int exerciseId) {
		setUserId(userId);
		setExerciseId(exerciseId);
	}

	public String getDescription() {
		return description;
	}

	public Solution setDescription(String description) {
		this.description = description;
		return this;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getExerc_id() {
		return exerc_id;
	}

	public Solution setExerciseId(int exerciseId) {
		this.exerc_id = exerciseId;
		return this;
	}

	public int getUsers_id() {
		return users_id;
	}

	public Solution setUserId(int userId) {
		this.users_id = userId;
		return this;
	}

	public int getId() {
		return id;
	}

	public Date getCreated() {
		return created;
	}

	public Solution setCreated(Date created) {
		this.created = created;
		return this;
	}

	public Date getUpdated() {
		return updated;
	}

	public Solution setUpdated(Date updated) {
		this.updated = updated;
		return this;
	}

}
