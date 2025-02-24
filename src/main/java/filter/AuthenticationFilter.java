package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "authenFilter", urlPatterns = {"/user-add", "/user", "/role", "/role-add", "/job", "/job-add", "/task", "/task-add"})
public class AuthenticationFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String roleName = "";
		Cookie[] cookies = req.getCookies();
		for(Cookie data : cookies) {
			if(data.getName().equals("role")) {
				roleName = data.getValue();
			}
		}
		
		String context = req.getContextPath();
		String path = req.getServletPath();
		
		switch (path) {
			case "/user":
				if(roleName.equals("ROLE_ADMIN") || roleName.equals("ROLE_MANAGER") || roleName.equals("ROLE_USER")) {
					System.out.println("Check user filter");
					chain.doFilter(req, resp);
				} else {
					resp.sendRedirect("/login");
				}
				break;
			case "/user-add":
				if(roleName.equals("ROLE_ADMIN")) {
					System.out.println("Check filter");
					chain.doFilter(req, resp);
				} else {
					resp.sendRedirect("/login");
				}
				break;
			case "/role":
				if(roleName.equals("ROLE_ADMIN")) {
					System.out.println("Check role filter");
					chain.doFilter(req, resp);
				} else {
					resp.sendRedirect("/login");
				}
				break;
			case "/role-add":
				if(roleName.equals("ROLE_ADMIN")) {
					System.out.println("Check role add filter");
					chain.doFilter(req, resp);
				} else {
					resp.sendRedirect("/login");
				}
				break;
			case "/job":
				if(roleName.equals("ROLE_ADMIN") || roleName.equals("ROLE_MANAGER") || roleName.equals("ROLE_USER")) {
					System.out.println("Check job filter");
					chain.doFilter(req, resp);
				} else {
					resp.sendRedirect("/login");
				}
				break;
			case "/job-add":
				if(roleName.equals("ROLE_ADMIN") || roleName.equals("ROLE_MANAGER") || roleName.equals("ROLE_USER")) {
					System.out.println("Check job filter");
					chain.doFilter(req, resp);
				} else {
					resp.sendRedirect("/login");
				}
				break;
			case "/task":
				if(roleName.equals("ROLE_ADMIN") || roleName.equals("ROLE_MANAGER") || roleName.equals("ROLE_USER")) {
					System.out.println("Check job filter");
					chain.doFilter(req, resp);
				} else {
					resp.sendRedirect("/login");
				}
				break;
			default:
		}
		
		
	}

}
