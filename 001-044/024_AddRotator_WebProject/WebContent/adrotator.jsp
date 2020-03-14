
<html>
<jsp:useBean id="obj" scope="session" class="myapp.Rotator" />


<jsp:scriptlet>
response.setHeader("Refresh","2");
obj.nextAdvertisement();
</jsp:scriptlet>
<body bgcolor="red" >
<a href="<jsp:getProperty name="obj" property="link" />">
		<img  width=720 height=100 src="<jsp:getProperty name="obj" property="image" />" >
</a>


<br>
<b> it is rest of the page </b>
</body>
</html>