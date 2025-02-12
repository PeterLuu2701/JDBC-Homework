package crm08.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.MysqlConfig;
import entity.RoleEntity;

public class RoleRepository {

	//Nguyên tắc đặt tên hàm sao cho dêx hình dung với câu truy vấn 
	//SELECT: find
	//WHERE: By
	//example: SELECT * FROM roles r WHERE r.id = 1 AND r.name = "ABC"
	//findByIdAndName
	public List<RoleEntity> findAll() {
	    List<RoleEntity> list = new ArrayList<>();
	    String query = "SELECT id, name, description FROM roles";

	    try (Connection connection = MysqlConfig.getConnection();
	         PreparedStatement statement = connection.prepareStatement(query);
	         ResultSet resultSet = statement.executeQuery()) {

	        while (resultSet.next()) {
	            RoleEntity entity = new RoleEntity();
	            entity.setId(resultSet.getInt("id"));
	            entity.setName(resultSet.getString("name"));
	            entity.setDescription(resultSet.getString("description"));
	            list.add(entity);
	        }

	    } catch (Exception e) {
	        System.out.println("findAll: " + e.getLocalizedMessage());
	    }

	    return list;
	}
	
	public RoleEntity findByName(String name) {
	    String query = "SELECT * FROM roles WHERE name = ?";
	    try (Connection connection = MysqlConfig.getConnection();
	         PreparedStatement statement = connection.prepareStatement(query)) {
	        statement.setString(1, name);
	        try (ResultSet resultSet = statement.executeQuery()) {
	            if (resultSet.next()) {
	                RoleEntity entity = new RoleEntity();
	                entity.setId(resultSet.getInt("id"));
	                entity.setName(resultSet.getString("name"));
	                entity.setDescription(resultSet.getString("description"));
	                return entity;
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("findByName: " + e.getMessage());
	    }
	    return null;
	}

	public int insertRole(String name, String description) {
        String query = "INSERT INTO roles (name, description) VALUES (?, ?)";
        int count = 0; // Initialize count
        try {
			Connection connection = MysqlConfig.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, description);
			
			count = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("addRole: " + e.getMessage());
        }
        return count;
    }
}
