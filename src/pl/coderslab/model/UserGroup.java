package pl.coderslab.model;

public class UserGroup {

	private int id;
	private String name;

	public UserGroup() {
	}

	public UserGroup(String name) {
		setName(name);

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public UserGroup setName(String name) {
		this.name = name;
		return this;
	}

}
