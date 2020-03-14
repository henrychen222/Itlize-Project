
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.bean.EmployeeBean"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="violet">
<%
	ArrayList<EmployeeBean> empList=(ArrayList<EmployeeBean>)request.getAttribute("empList");
%>	
<table align="center" border="2" cellspacing="2" cellpadding="2" width="80%">
<caption><h2>Employee List </h2>(Total Employees: <%=empList.size()%>) : <%=session.getId() %></caption>
<tr >
<th>Emp ID</th>
<th>Emp LastName</th>
<th>Emp FirstName</th>
<th>Emp MiddleName</th>
<th>Emp PhoneNumber</th>
<th>Emp Email</th>
<th>Emp Address</th>
</tr>

<!-- JSP  Scriptlet Code -->
<%
for(EmployeeBean emp:empList){
%>
<tr>
<td><%=emp.getId()%></td>
<td><%=emp.getLastname()%></td>
<td><%=emp.getFirstname() %></td>
<td><%=emp.getMiddlename() %></td>
<td><%=emp.getPhonenumber() %></td>
<td><%=emp.getEmail() %></td>
<td><%=emp.getAddress() %></td>
</tr>
<%} %>

</table>
</body>
</html>