<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%!
		public int sum(int x, int y) {
			return x + y;
		}
	%>

	Sum (X+Y) : <font color=red> <%=sum(5,6)%> </font>

	<%
	     int n = 8;
		for(int i=1; i<=8; i++){ 
	%>
		
		<h1> <%=n%> * <%=i%> = <%=i*n %>  =======================<%=n%> + <%=i%>=> <%=sum(i,n)%>   </h1>
			
	<%	}
	 %>

</body>
</html>