package com.easylearn;


import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import org.springframework.jdbc.core.*;

public class InsertBankAccountServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int acno = Integer.parseInt(request.getParameter("t1"));
		String acname = request.getParameter("t2");
		double balance = Double.parseDouble(request.getParameter("t3"));
		try {
			JdbcTemplate jt = SpringJDBCTemplate.getTemplate();
			jt.execute("insert into bank values(" + acno + ",'" + acname + "'," + balance + ")");
		} catch (Exception e) {
			System.out.println(e);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/selectaction");
		rd.forward(request, response);
	}
}