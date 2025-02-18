package crm08.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm08.service.GroupWorkServices;
import crm08.service.JobServices;
import crm08.service.RoleServices;
import entity.GroupWorkEntity;
import entity.JobEntity;
import entity.RoleEntity;

@WebServlet(name="jobController", urlPatterns = {"/groupwork", "/groupwork-add"})
public class GroupWorkController extends HttpServlet {
	private GroupWorkServices groupWorkServices = new GroupWorkServices();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
				
				switch (path) {
				case "/groupwork": 
					getGroupWork(req, resp);
					break;
//				case "/groupwork-add":
//					addRole(req, resp);
//					break;
				}
	}
	
	private void getGroupWork(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    List<GroupWorkEntity> listGroupWork = groupWorkServices.getGroupWork();
	    System.out.println("Number of group work items: " + listGroupWork.size()); 
	    if (listGroupWork == null) {
	        System.out.println("groupwork list is null"); 
	    }

	    req.setAttribute("groupwork", listGroupWork);
	    req.getRequestDispatcher("/groupwork.jsp").forward(req, resp);
	}
}
