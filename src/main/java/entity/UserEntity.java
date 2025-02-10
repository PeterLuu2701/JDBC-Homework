package entity;

public class UserEntity {
	private int id;
	private String email;
	private String fullName;
	private RoleEntity role;
	
	
	public UserEntity() {}

	public UserEntity(int id, String email, String fullname, RoleEntity role) {
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
	
	public RoleEntity getRole() {
		return role;
	}
	
	public void setRole(RoleEntity role) {
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
