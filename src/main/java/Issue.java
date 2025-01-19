
public class Issue {
	
	protected String title;
	protected String description;
	protected String location;
	protected String name;
	protected String email;
	protected String phone;
	protected String priority;
	protected String assign;
	protected String status;
	protected String comment;
	
	public Issue(String title, String description, String location, String name, String email, String phone,
			String priority, String assign, String status, String comment) {
		super();
		this.title = title;
		this.description = description;
		this.location = location;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.priority = priority;
		this.assign = assign;
		this.status = status;
		this.comment = comment;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPriority() {
		return priority;
	}
	
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	public String getAssign() {
		return assign;
	}
	
	public void setAssign(String assign) {
		this.assign = assign;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}

}
