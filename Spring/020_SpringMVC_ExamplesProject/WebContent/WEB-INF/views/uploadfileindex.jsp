<html>
<head>
<title>Welcome</title>
</head>
<body>
<h2><a href="uploadfile.jsp">Upload Example</a></h2>
<br>
<br>
<br>
<br>
<%
	if (session.getAttribute("uploadFile") != null
			&& !(session.getAttribute("uploadFile")).equals("")) {
%>
<h3>Uploaded File</h3>
<br>
<img src="<%=session.getAttribute("uploadFile")%>" width="100" height="100">
<%
out.println(session.getAttribute("uploadFile"));
	}
%>
</body>
</html>