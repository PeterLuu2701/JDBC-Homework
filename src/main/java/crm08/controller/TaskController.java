package crm08.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm08.service.TaskServices;
import entity.TaskEntity;

@WebServlet(name="taskController", urlPatterns = {"/task", "/task-add"})
public class TaskController extends HttpServlet {
	private TaskServices taskServices = new TaskServices();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
				
		switch (path) {
			case "/task": 
				getTask(req, resp);
				break;
			case "/task-add":
				getTask(req, resp);
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
	
	private void getTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TaskEntity> listTask = taskServices.getTask();
        
        req.setAttribute("task", listTask); 
        req.getRequestDispatcher("/task.jsp").forward(req, resp); 
    }
	
}
