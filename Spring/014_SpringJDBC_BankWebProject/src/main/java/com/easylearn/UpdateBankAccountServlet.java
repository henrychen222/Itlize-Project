package com.easylearn;


import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import org.springframework.jdbc.core.*;

public class UpdateBankAccountServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int acno = Integer.parseInt(request.getParameter("t1"));
		double balance = Double.parseDouble(request.getParameter("t3"));
		try {
			JdbcTemplate jt = SpringJDBCTemplate.getTemplate();
			jt.update("UPDATE BANK SET ACC_BAL=? WHERE ACC_NO=?", new Object[] { new Double(balance), new Integer(acno) });
		} catch (Exception e) {
			System.out.println(e);
		}
		RequestDispatcher rd = request.getRequestDispatcher("transaction.jsp");
		rd.forward(request, response);
	}
}