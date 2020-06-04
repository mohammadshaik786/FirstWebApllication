package com.webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet{
	public  void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException,IOException{
			String name = request.getParameter("names");
			request.setAttribute("name1", name);
			request.getRequestDispatcher("WEB-INF/Views/login.jsp").forward(request, response);

		
	}

}*/
@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet{
	private UserValidationService  uservalid = new UserValidationService();
	
	public  void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException,IOException{
			request.getRequestDispatcher("WEB-INF/Views/loginform.jsp").forward(request, response);
	
	}
	
	
	public  void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException,IOException{
		String name = request.getParameter("name");
		String password = request.getParameter("pwd");	
		boolean b = uservalid.isValidUser(name,password);
		if(b){
			request.setAttribute("name", request.getParameter("name"));
			request.getRequestDispatcher("WEB-INF/Views/welcome.jsp").forward(request, response);
		}
		else{
			request.setAttribute("error", "invalid credentials");
			request.getRequestDispatcher("WEB-INF/Views/loginform.jsp").forward(request, response);
		}
	}
}
