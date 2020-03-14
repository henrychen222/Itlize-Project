<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP with XML syntax</title>
</head>
<body>
	<h2>JSP with XML syntax</h2>

	<jsp:declaration>
		public int sum(int x, int y) {
			return x + y;
		}
	</jsp:declaration>

	Sum (X+Y) : <font color=red> <jsp:expression>sum(65, 96)</jsp:expression></font>

	<%
		int n = 6;
	
		for(int i = 1; i<=10; i++){
	%>

	<h4>  <%=n%> * <%= i%> = <%=i*n%> </h4>

	<%}%>
	

</body>
</html>