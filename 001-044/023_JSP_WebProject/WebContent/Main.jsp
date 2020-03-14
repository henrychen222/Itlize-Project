<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:scriptlet>
response.setHeader("Refresh", "1");
</jsp:scriptlet>
</head>
<body bgcolor="yellow">

<p> The current date and time is
<h1> <font color=red> <%@ include file="date.jsp" %></font>  </h1>
</p>


</body>
</html>