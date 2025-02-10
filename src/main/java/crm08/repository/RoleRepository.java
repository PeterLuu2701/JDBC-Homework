package crm08.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	    String query = "SELECT * FROM roles";

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
}
