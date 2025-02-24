package crm08.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.MysqlConfig;
import entity.TaskEntity;

public class TaskRepository {
	
	public List<TaskEntity> findAll() {
	    List<TaskEntity> list = new ArrayList<>();
	    
	    String query = "SELECT t.id, t.name, t.start_date, t.end_date, u.fullname AS user_name, j.name AS job_name, s.name AS status_name FROM tasks t JOIN users u ON t.user_id = u.id JOIN jobs j ON t.job_id = j.id JOIN status s ON t.status_id = s.id;";

	    try (Connection connection = MysqlConfig.getConnection();
	         PreparedStatement statement = connection.prepareStatement(query);
	         ResultSet resultSet = statement.executeQuery()) {

	        while (resultSet.next()) {
	        	TaskEntity entity = new TaskEntity();
	            entity.setId(resultSet.getInt("id"));
	            entity.setName(resultSet.getString("name"));
	            entity.setStart_date(resultSet.getDate("start_date"));
	            entity.setEnd_date(resultSet.getDate("end_date"));
	            entity.setUser_name(resultSet.getString("user_name")); 
                entity.setJob_name(resultSet.getString("job_name")); 
                entity.setStatus_name(resultSet.getString("status_name")); 
	            list.add(entity);
	        }

	    } catch (Exception e) {
	        System.out.println("findAll: " + e.getLocalizedMessage());
	    }

	    return list;
	}
}
