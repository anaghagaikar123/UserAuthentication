<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Personal Info</title>
</head>
<body>
	<% 
	String name=request.getAttribute("name");
	if(name.equals("anagha"))
	{
%>
	id : ${id}
	</br> name : ${name}
	</br> password :${password}
	</br> role: ${role}
	</br>
	<% 
	}
else
{
	request.getRequestDispatcher("Error.jsp").forward(request, response);
}
	%>

</body>
</html>