package com.easylearn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Session session = null;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Transaction tx= session.beginTransaction();

		// Programmers information
		Programmers p1 = new Programmers(111, "RAM", 25000);
		Programmers p2 = new Programmers(222, "SAM", 15000);
		Programmers p3 = new Programmers(333, "RAJ", 10000);
		Programmers p4 = new Programmers(444, "VAMSI", 12000);
		session.save(p1);
		session.save(p2);
		session.save(p3);
		session.save(p4);

		// projects information
		Projects t1 = new Projects(1001, "Facebook");
		Projects t2 = new Projects(1002, "Amazon");
		Projects t3 = new Projects(1003, "Paypal");
		session.save(t1);
		session.save(t2);
		session.save(t3);

		// mapping projects to Programmerss
		p1.getProjectses().add(t1);
		p1.getProjectses().add(t3);

		p2.getProjectses().add(t1);
		p2.getProjectses().add(t2);
		p2.getProjectses().add(t3);

		p3.getProjectses().add(t2);

		p4.getProjectses().add(t1);
		p4.getProjectses().add(t2);
		
		tx.commit();
		
		PrintWriter out=response.getWriter();
		out.println(" <center> <h1>  Many to Many ... Records is inserted successfully...... </h1> </center>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
