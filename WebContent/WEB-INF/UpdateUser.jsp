<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update User Form</title>
</head>
<body>
<form action="/CMPE275_Lab2/homepage/${id}" method="post">
<p>
ID : <input type="text" name="id" value=${id} readonly="readonly" />
</p>
<p>
First Name : <input type="text" name="firstname" value=${firstname} />
</p>
<p>
Last Name : <input type="text" name="lastname" value=${lastname} />
</p>
<p>
Email : <input type="text" name="email" value=${email} />
</p>
<p>
Address : <input type="text" name="address" maxlength="60" value=${address} />
</p>
<p>
Organization : <input type="text" name="organization" maxlength="60" value=${organization} />
</p>
<p>
About Myself : <input type="text" name="aboutMyself" value=${aboutMyself} />
</p>

<input type="submit" name="update" value="Update">

<input type="submit" name="delete"  value="Delete">

</form>

</body>
</html>