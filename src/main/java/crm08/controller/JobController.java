package crm08.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import crm08.service.JobServices;
import entity.JobEntity;

@WebServlet(name="jobController", urlPatterns = {"/job", "/job-add"})
public class JobController extends HttpServlet {
	private JobServices jobServices = new JobServices();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
				
				switch (path) {
		        case "/job":
		            getJob(req, resp);
		            break;
		        case "/job-add": // Add this case
		            addJob(req, resp); // Forward to the add job JSP
		            break;
		        default:
		            break;
		    }
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String path = req.getServletPath();
	     String name = req.getParameter("name");
	     String start_date = req.getParameter("start_date");
	     String end_date = req.getParameter("end_date");

	     		switch (path) {
	         	case "/job-add":
	         		jobServices.insertJob(name, start_date, end_date);
	         		addJob(req, resp);
	                break;
	            default:
	                break;
	        }
	}
	
	private void getJob(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    List<JobEntity> listJob = jobServices.getJob();
	    System.out.println("Number of group work items: " + listJob.size()); 
	    req.setAttribute("job", listJob);
	    req.getRequestDispatcher("/groupwork.jsp").forward(req, resp);
	}
	
	private void addJob(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<JobEntity> listJob = jobServices.getJob();
		
		 req.setAttribute("job", listJob);
		 req.getRequestDispatcher("/groupwork-add.jsp").forward(req, resp);
    }
}
