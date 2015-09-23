<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p>
ID : <input type="text" name="id" value=${homepage1.id} readonly="readonly" />
</p>
<p>
First Name : <input type="text" name="firstname" value=${homepage1.firstname} />
</p>
<p>
Last Name : <input type="text" name="lastname" value=${homepage1.lastname} />
</p>
<p>
Email : <input type="text" name="email" value=${homepage1.email} />
</p>
<p>
Address : <input type="text" name="address" value=${homepage1.address} />
</p>
<p>
Organization : <input type="text" name="organization" value=${homepage1.organization} />
</p>
<p>
About Myself : <input type="text" name="aboutMyself" value=${homepage1.aboutMyself} />
</p>

<p> User Successfully Created </p>

</body>
</html>