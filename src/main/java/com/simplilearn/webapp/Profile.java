package com.simplilearn.webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Profile() {
	}

	// load profile page
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// add navigation
		request.getRequestDispatcher("index.jsp").include(request, response);
		request.getRequestDispatcher("login.html").include(request, response);
		
		// fetch request params : read url for query parameters
		String userId = request.getParameter("userId");
		String useremail = request.getParameter("useremail");
		
		if ( useremail!=null && userId !=null) {
			if (useremail.equals("admin@gmail.com")) {
				out.println("<h3 style='color:green'> Welcome to user profile '" + useremail + "' </h3>");
			} else {
				out.println("<h3 style='color:red'>Login Failed * Invalid credntials </h3>");
			}
		} else {
			out.println("<h3 style='color:red'>Invalid access, please login to see profile ! </h3>");
		}
	}

	// submit profile page
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
