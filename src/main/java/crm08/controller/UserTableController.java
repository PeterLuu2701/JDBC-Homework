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
import crm08.repository.RoleRepository;
import crm08.service.RoleServices;
import crm08.service.UserServices;
import entity.RoleEntity;
import entity.UserEntity;

@WebServlet(name="userTableController", urlPatterns = {"/user", "/user-add"})
public class UserTableController extends HttpServlet {
	
	private UserServices userServices = new UserServices();
	private RoleServices roleServices = new RoleServices();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		
		switch (path) {
		case "/user": 
			getUser(req, resp);
			break;
		case "/user-add":
			userAdd(req, resp);
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		
		String fullname = req.getParameter("fullname");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		int idRole = Integer.parseInt(req.getParameter("role"));
		
		switch (path) {
		case "/user": 
			
			break;
		case "/user-add":
			userServices.insertUser(fullname, password, email, idRole);
			userAdd(req, resp);
			
			break;
		}
	}
		
		private void getUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// SQL query to fetch users
			String query = "SELECT u.id, u.fullname, u.email, r.id as role_id, r.name as role_name, r.description as role_description FROM users u JOIN roles r ON r.id = u.role_id";

	    Connection connection = MysqlConfig.getConnection();
	    List<UserEntity> listUser = new ArrayList<UserEntity>();

	    try {
	        PreparedStatement statement = connection.prepareStatement(query);
	        ResultSet result = statement.executeQuery();

	        while (result.next()) {
	            int id = result.getInt("id");
	            String fullname = result.getString("fullname");
	            String email = result.getString("email");

	            int roleId = result.getInt("role_id");        // Get role ID
	            String roleName = result.getString("role_name");  // Get role name
	            String roleDescription = result.getString("role_description"); // Get role description

	            RoleEntity role = new RoleEntity(roleId, roleName, roleDescription); // Create RoleEntity object

	            UserEntity user = new UserEntity(id, email, fullname, role); // Pass the RoleEntity to UserEntity

	            listUser.add(user);
	            }

	            // Set the listUser as a request attribute for JSP
	            req.setAttribute("users", listUser);
	            
	            // Forward the request to the JSP page
	            req.getRequestDispatcher("/user-table.jsp").forward(req, resp);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
		
		private void userAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			List<RoleEntity> roles = roleServices.getRole();
			
			req.setAttribute("role", roles);
			
			req.getRequestDispatcher("user-add.jsp").forward(req, resp);
		}
		
		
   }
	
