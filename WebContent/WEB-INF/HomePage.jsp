<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>


<h2> HOME PAGE, PLEASE ENTER THE REQUIRED INFORMATION </h2>

<form action="/CMPE275_Lab2/homepage" method="post">
<p>
ID : <input type="text" name="id" /> 
</p>
<p>
First Name : <input type="text" name="firstname" />
</p>
<p>
Last Name : <input type="text" name="lastname" />
</p>
<p>
Email : <input type="text" name="email" />
</p>
<p>
Address : <input type="text" name="address" />
</p>
<p>
Organization : <input type="text" name="organization" />
</p>
<p>
About Myself : <input type="text" name="aboutMyself" />
</p>

<input type="submit" value="Submit this form by clicking here">

</form>

</body>
</html>