package com.easylearn;


import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import org.springframework.jdbc.core.*;

public class DeleteBankAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 3227073452370967933L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		try {
			JdbcTemplate jt = SpringJDBCTemplate.getTemplate();
			jt.execute("DELETE FROM BANK WHERE ACC_NO=" + id);
		} catch (Exception e) {
			System.out.println(e);
		}
		RequestDispatcher rd = request.getRequestDispatcher("delete.jsp");
		rd.forward(request, response);
	}

}