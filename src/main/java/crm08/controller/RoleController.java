package crm08.controller;

import java.io.IOException;
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
import crm08.service.RoleServices;
import entity.RoleEntity;
import entity.UserEntity;

@WebServlet(name="roleController", urlPatterns = {"/role", "/role-add"})
public class RoleController extends HttpServlet {
	 private RoleServices roleServices = new RoleServices();
	 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		
		switch (path) {
		case "/role": 
			getRole(req, resp);
			break;
		case "/role-add":
			addRole(req, resp);
			break;
		}
	}
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        String name = req.getParameter("name");
		String description = req.getParameter("description");

        switch (path) {
            case "/role-add":
            	roleServices.insertRole(name, description);
                addRole(req, resp);
                break;
            default:
                break;
        }
    }
	
	private void addRole(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<RoleEntity> roles = roleServices.getRole();
		
		req.setAttribute("role", roles);
		req.getRequestDispatcher("role-add.jsp").forward(req, resp);
    }
	
	private void getRole(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RoleEntity> listRole = roleServices.getRole();
        
        req.setAttribute("role", listRole); // Set role list to request
        req.getRequestDispatcher("/role-table.jsp").forward(req, resp); // Forward to JSP
    }
}
