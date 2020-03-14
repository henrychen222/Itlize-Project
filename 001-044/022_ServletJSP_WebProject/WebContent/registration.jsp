<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center><h1>Registration Form</h1></center>
<form action="./register" method="post">
	<fieldset style="text-align: center;">
	 <legend style="font-style: italic;">Registration</legend>
	User Name : <input type="text" name="username"/> <br>
	Password : <input type="password" name="password"/> <br>
	Confirm Password : <input type="password" name="confirmpassword"/> <br>
	</fieldset>
	
	<fieldset style="text-align: center;">
		 <legend style="font-style: italic;">Personal Information</legend>
	
			First Name : <input type="text" name="first"/> <br>
			Last Name : <input type="text" name="last"/> <br>
			Middle Name : <input type="text" name="middle"/> <br>
			SSN # : <input type="text" name="ssn">	<br>	
			Sex   : <input type="radio" name="sex" value="F" /> Female &nbsp;&nbsp;&nbsp;&nbsp; 
			<input type="radio" name="sex" value="M"/> Male <br>
			Hobbies: <input type="checkbox" name="hobbie" value="Reading"> Reading <br>
					<input type="checkbox" name="hobbie" value="Watching"> Watching <br>
					<input type="checkbox" name="hobbie" value="Playing"> Playing <br>
					<input type="checkbox" name="hobbie" value="Roaming"> Roaming <br>
	</fieldset>
	
	<fieldset style="text-align: center;">
			 <legend style="font-style: italic;">Residential Address</legend>
	
			Address : <textarea rows="10" cols="20" name="address">
			</textarea>
			 <br>
			City : <input type="text" name="city"/> <br>
			State : <select name="state" multiple="multiple">
						<option value="GA">Georgia</option>
						<option value="NY">New York</option>
						<option>New Jersy</option>
						<option>California</option>
						<option>Maine</option>
						<option>Georgia</option>
						<option>Texas</option>
					</select> 
					<br>
			Country  : <input type="text" name="country">			
	</fieldset>
	
	<fieldset>
			<center> <input type="submit" value="Register"/> </center>
	</fieldset>

</form>
</body>
</html>