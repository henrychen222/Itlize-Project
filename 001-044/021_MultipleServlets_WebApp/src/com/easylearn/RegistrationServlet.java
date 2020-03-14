package com.easylearn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Registration", urlPatterns = {"/register"}, loadOnStartup = 1)
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistrationServlet() {
        System.out.println("RegistrationServlet object is created......");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("RegistrationServlet.doGet() method is called........");

			PrintWriter out = response.getWriter();
			out.println("<body bgcolor=lightgreen>");

			String user = request.getParameter("voterName");
			String age = request.getParameter("voterAge");
			
			if(user == null || age == null){
				out.println("<center> <h4> <font color=red>Please provide voter name & age</font> </h4></center>");
				return;
			}
			
			Float voterAge = 0.0f;
			try {
				voterAge = Float.parseFloat(age);
			} catch (NumberFormatException e) {
				out.println("<center> <h2> <font color=red>Please enter a valid age</font> </h4></center>");
				return;
			}
			
			if(voterAge > 18){
				out.println("<center> <h1> <bold> <font color=violet> Mr./Mrs./Miss "+user+" Your eligable for voter registration..... </font>  <bold> </h4></center>");
			}else{
				out.println("<center> <h1> <font color=red> Mr./Mrs./Miss "+user+" Your not eligable for voter registration..... </font> </h4></center>");
			}
			
			out.println("</body>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RegistrationServlet.doPost() method is called........");
		this.doGet(request, response);

	}

}
