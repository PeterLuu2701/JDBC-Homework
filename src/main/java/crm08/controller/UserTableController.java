package crm08.controller;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.MysqlConfig;
import entity.UserEntity;

@WebServlet(name="userTableController", urlPatterns = {"/user-table"})
public class UserTableController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// SQL query to fetch users
        String query = "SELECT * FROM users"; 
        
        // Prepare connection to the database
        Connection connection = MysqlConfig.getConnection();
        List<UserEntity> listUser = new ArrayList<>();
        
        try {
            // Execute the query
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            
            while(result.next()) {
                int id = result.getInt("id");
                String email = result.getString("email");
                String fullname = result.getString("fullname");
                int role_id = result.getInt("role_id");
                
                listUser.add(new UserEntity(id, email, fullname, role_id));
            }

            // Set the listUser as a request attribute for JSP
            req.setAttribute("users", listUser);
            
            // Forward the request to the JSP page
            req.getRequestDispatcher("/user-table.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	}
