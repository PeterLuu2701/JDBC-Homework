package entity;

public class UserEntity {
	private int id;
	private String email;
	private String fullName;
	private int roleId;
	
	
	public UserEntity() {}

	public UserEntity(int id, String email, String fullname, int roleId) {
		this.id = id;
		this.email = email;
		this.fullName = fullname;
		this.roleId = roleId;
	}

	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public int getRoleId() {
		return roleId;
	}
	
	public void setRoleId(int roleId) {
		this.roleId = roleId;
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
