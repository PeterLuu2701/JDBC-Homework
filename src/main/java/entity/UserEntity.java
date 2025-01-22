package entity;

public class UserEntity {
	private int id;
	private String email;
	private String fullName;
	private String role;
	
	
	public UserEntity() {}

	public UserEntity(int id, String email, String fullname, String role) {
		this.id = id;
		this.email = email;
		this.fullName = fullname;
		this.role = role;
	}

	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
