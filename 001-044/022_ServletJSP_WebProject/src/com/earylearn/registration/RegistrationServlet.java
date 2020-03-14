package com.earylearn.registration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session =request.getSession();
		//session.setMaxInactiveInterval(30);
		
		ServletContext servletContext = request.getServletContext();
		
		PrintWriter out = response.getWriter();
		out.println("Username :" + request.getParameter("username"));
		out.println("Password :" + request.getParameter("password"));
		out.println("Confirm Password :" + request.getParameter("confirmpassword"));
		out.println("First Name :" + request.getParameter("first"));
		out.println("Last Name :" + request.getParameter("last"));
		out.println("Middle :" + request.getParameter("middle"));
		out.println("Sex :" + request.getParameter("sex"));

		out.println("hobbie :");
		String hobbies[] = request.getParameterValues("hobbie");
		for (int i = 0; i < hobbies.length; i++) {
			out.println(hobbies[i]);
		}

		out.println("Address :" + request.getParameter("address"));
		out.println("City :" + request.getParameter("city"));

		out.println("State :");
		String states[] = request.getParameterValues("state");
		for (int i = 0; i < states.length; i++) {
			out.println(states[i]);
		}

		out.println("Country :" + request.getParameter("country"));

	}

}
