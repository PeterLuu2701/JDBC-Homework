package crm08.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import config.MysqlConfig;
import entity.RoleEntity;

public class UserRepository {
	
	public int insertUser(String fullname, String password, String email, int roleId) {
		String query = "INSERT INTO users(fullname, email, password, role_id) VALUES(?, ?, ?, ?);";
		int count = 0;
		
		try {
			Connection connection = MysqlConfig.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, fullname);
			statement.setString(2, email);
			statement.setString(3, password);
			statement.setInt(4, roleId);
			
			count = statement.executeUpdate();
			
			
		}catch(Exception e) {
			System.out.println("findAll: " + e.getLocalizedMessage());
		}
		
		return count;
	}
	
	
}
