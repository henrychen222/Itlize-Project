package com.easylearn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
public class WelcomeServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public WelcomeServlet() {
        super();
       System.out.println("WelcomeServlet() :: is called..object is created for servlet.");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	       System.out.println("init() :: is called...");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
	       System.out.println("destroy() :: is called...");
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
	       System.out.println("getServletConfig() :: is called...");
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
	       System.out.println("getServletInfo() :: is called...");
		return null; 
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
	       System.out.println("service() :: is called...");
	       
	       PrintWriter out= response.getWriter();
	       
	       out.println("<body bgcolor=yellow>");
	       for (int i = 1; i<=7; i++) {
			out.println(" <center> <h"+i+"> <font color=red> <marquee>  Welcome to Servlet Programming..... </marquee>  </font> </h"+i+"> </center> ");
	       }
	       out.println("</body>");

	}

}
