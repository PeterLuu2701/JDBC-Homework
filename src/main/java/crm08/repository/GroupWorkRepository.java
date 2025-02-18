package crm08.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.MysqlConfig;
import entity.GroupWorkEntity;
import entity.JobEntity;
import entity.RoleEntity;

public class GroupWorkRepository {
	public List<GroupWorkEntity> findAll() {
	    List<GroupWorkEntity> list = new ArrayList<>();
	    String query = "SELECT id, name, start_date, end_date FROM jobs";

	    try (Connection connection = MysqlConfig.getConnection();
	         PreparedStatement statement = connection.prepareStatement(query);
	         ResultSet resultSet = statement.executeQuery()) {

	        while (resultSet.next()) {
	        	GroupWorkEntity entity = new GroupWorkEntity();
	            entity.setId(resultSet.getInt("id"));
	            entity.setName(resultSet.getString("name"));
	            entity.setStartDate(resultSet.getDate("start_date"));
	            entity.setEndDate(resultSet.getDate("end_date"));
	            list.add(entity);
	        }

	    } catch (Exception e) {
	        System.out.println("findAll: " + e.getLocalizedMessage());
	    }

	    return list;
	}
}
