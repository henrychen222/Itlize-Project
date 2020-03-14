package com.easylearn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeHttpServlet
 */
public class WelcomeHttpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeHttpServlet() {
        super();
        System.out.println("WelcomeHttpServlet() :: is called..object is created for servlet.");
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       System.out.println("doGet() :: is called...");

	       PrintWriter out= response.getWriter();
	       
	       out.println("<body bgcolor=green>");
	       for (int i = 1; i<=7; i++) {
			out.println(" <center> <h"+i+"> <font color=red> <marquee>  Welcome to Servlet Programming..... </marquee>  </font> </h"+i+"> </center> ");
	       }
	       out.println("</body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       System.out.println("doPost() :: is called...");

	}

}
