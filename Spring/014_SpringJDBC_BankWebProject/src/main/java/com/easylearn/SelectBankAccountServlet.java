package com.easylearn;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class SelectBankAccountServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		try {

			JdbcTemplate jt = SpringJDBCTemplate.getTemplate();
			SqlRowSet rs = jt.queryForRowSet("SELECT * FROM BANK");
			out.println("<html><body bgcolor=#ffffcc text=olive>");
			out.println("<h1><center>All Bank Accounts Details</h1><hr><br><h3>");
			out.println("<table align=center width=80% border=2>");
			out.println("<tr><th>Account No.<th>Account Holder Name <th>Current Balance</tr>");
			while (rs.next()) {
				out.println("<tr><td>" + rs.getString(1) + "<td>" + rs.getString(2) + " <td>" + rs.getString(3) + "</tr>");
			}

			out.println("</table></body></html>");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}