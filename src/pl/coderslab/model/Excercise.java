package pl.coderslab.model;

public class Excercise {
	
	private int id = 0;
	private String title;
	private String description;

	public Excercise() {
		
	}

	public Excercise(String title, String description) {
		setTitle(title);
		setDescription(description);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public Excercise setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Excercise setDescription(String description) {
		this.description = description;
		return this;
	}
	
	
}
