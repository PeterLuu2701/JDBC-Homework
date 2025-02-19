package crm08.repository;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import config.MysqlConfig;
import entity.JobEntity;
import entity.JobEntity;
import entity.RoleEntity;

public class JobRepository {
	public List<JobEntity> findAll() {
	    List<JobEntity> list = new ArrayList<>();
	    String query = "SELECT id, name, start_date, end_date FROM jobs";

	    try (Connection connection = MysqlConfig.getConnection();
	         PreparedStatement statement = connection.prepareStatement(query);
	         ResultSet resultSet = statement.executeQuery()) {

	        while (resultSet.next()) {
	        	JobEntity entity = new JobEntity();
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
	
	public int insertJob(String name, String start_date_str, String end_date_str) {
        String query = "INSERT INTO jobs (name, start_date, end_date) VALUES (?, ?, ?)";
        int count = 0;

        try (Connection connection = MysqlConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, name);

            // Parse and format start_date
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy"); // Format from JSP
            java.util.Date utilStartDate = inputFormat.parse(start_date_str);
            Date sqlStartDate = new Date(utilStartDate.getTime()); // Convert to java.sql.Date
            statement.setDate(2, sqlStartDate);


            // Parse and format end_date (same logic as start_date)
            SimpleDateFormat inputFormatEnd = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date utilEndDate = inputFormatEnd.parse(end_date_str);
            Date sqlEndDate = new Date(utilEndDate.getTime());
            statement.setDate(3, sqlEndDate);

            count = statement.executeUpdate();

        } catch (SQLException | ParseException e) { // Catch both exceptions
            System.out.println("addJob: " + e.getMessage());
        }
        return count;
    }
}
