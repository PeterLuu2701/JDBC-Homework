package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConfig {
	
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/crm_app";
        String user = "root";
        String password = "1234";
        Connection connection = null;

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	connection = DriverManager.getConnection(url, user, password);
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return connection;
	}
}
