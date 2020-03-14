package com.easylearn;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class DisplayServlet
 */
@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Session session = null;     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		/** Steps to Activate Hibernate Framework **/
		Configuration cfg=new Configuration();
		cfg.configure("/com/easylearn/hibernate.cfg.xml");
		
		SessionFactory sFactory = cfg.buildSessionFactory();
		session= sFactory.openSession();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Transaction tx= session.beginTransaction();
		PrintWriter out= response.getWriter();
		
		try{
	        out.println("<h1>all programmers..</h1><hr>");	
	    List<Programmers> programmerList=session.createQuery("from Programmers").list();
	    
	    for (Programmers p1 : programmerList) {
	    	out.println("<font color=blue size=6>"+p1.getPid()+"   "+p1.getPname()+ "  "+p1.getSalary()+"<br></font>");
			Set<Projects>  projects=p1.getProjectses();
			for (Projects t1 : projects) {
		           out.println("<font color=green><b>----->"+t1.getProid()+"  "+t1.getProname()+"</font><br>");
			}
		}
	    
	    	out.println("<h1>all projects</h1><hr>");
	  List<Projects>  projectsList=session.createQuery("from Projects").list();
	  for (Projects t1 : projectsList) {
			out.println("<font color=green size=6>"+t1.getProid()+"  "+t1.getProname()+"</font><br>");
			Set<Programmers> programmers=t1.getProgrammerses();
			for (Programmers p1 : programmers) {
				 out.println("<font color=blue><b>---->"+p1.getPid()+"  " +p1.getPname()+"  "+p1.getSalary()+"</font><br>");
			}
	  }
	  	  
	}catch(HibernateException e)
	{	
		e.printStackTrace();
		out.println(e);
	}
		
		
		tx.commit();

	}

}
