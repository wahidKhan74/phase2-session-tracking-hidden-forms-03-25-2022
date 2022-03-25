package com.simplilearn.webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    
    public Login() { }

    // load login page
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.getRequestDispatcher("index.jsp").include(request, response);
		request.getRequestDispatcher("login.html").include(request, response);
	}
	
	// submit login page
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// set the content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// add navigation
		request.getRequestDispatcher("index.jsp").include(request, response);
		request.getRequestDispatcher("login.html").include(request, response);
		
		// read data fields from form submit
		String userId = request.getParameter("userId");
		String useremail = request.getParameter("useremail");
		String password = request.getParameter("password");
		
		if(useremail !=null && !useremail.equals("") && !password.equals("")) {
			if(useremail.equals("admin@gmail.com") && password.equals("admin@123")) { 
				// create a hidden from trigger authenticate request
				// generate new hidden form
				out.println("<form method='post' action='profile' >");
				out.println("<input type='hidden' name='userId' id='userId' value='"+userId+"'>");
				out.println("<input type='hidden' name='useremail' id='useremail' value='"+useremail+"'>");
				out.println("<input type='submit' value='Go to profile' >");
				out.println("</form>");
				out.println("<br><br><br><br>");
				out.println("<h3 style='color:green'>Login sucessfull ! for user '" + useremail + "' </h3>");
			} else {
				out.println("<h3 style='color:red'>Login Failed * Invalid credntials </h3>");
			}			
		} else {
			out.println("<h3 style='color:red'>Login Failed  * Required filled are missing! </h3>");
		}
		
	}

}
