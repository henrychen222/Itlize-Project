<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JDBC Registration Example</title>
<script type="text/javascript">
	function validateForm(){
		var empId = document.getElementById("id").value;
		if(empId == ""){
			alert("Please enter the Id");
			return false;
		}
		var firstName = document.getElementById("firstName").value;
		if(firstName == ""){
			alert("Please enter the firstName");
			return false;
		}
	}

</script>




</head>
<body bgcolor="violet">
<center>
<h3>JSP >>>>> Servlet >>>>> JDBC >>>>> Database ----->> Web Project</h3></center>
</br>
<form action="/025_ServletJspJdbc_WebProject/EmpRegistationServlet" method="post" onsubmit="return validateForm()">

<table align="center" border="2" cellspacing="2" cellpadding="2" width="40%">

<tr align="center"><td colspan="2" ><h2>Registration Form</h2></td></tr>

<tr><td width="10%">Your Id :</td><td width="30%"><input type="text" name="id" id="id"></td></tr>

<tr><td>First Name :</td><td> <input type="text" name="firstName" id="firstName"></td></tr>

<tr><td>Last Name :</td><td><input type="text" name="lastName"></td></tr>

<tr><td>Middle Name :</td><td> <input type="text" name="middleName"></td></tr>

<tr><td>Email Id :</td><td> <input type="text" name="emailId"></td></tr>

<tr><td>Phone Number :</td><td> <input type="text" name="phoneNumber"></td></tr>

<tr><td>Address :</td><td> <input type="text" name="address"></td></tr>

<tr align="center"><td colspan="2" ><input type="submit" value="Register"></td></tr>

</table>
</form>
</body>
</html>