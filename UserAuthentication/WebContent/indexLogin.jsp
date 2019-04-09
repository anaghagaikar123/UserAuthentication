<%@ page import="com.dahlia.cont.Database"%>
<jsp:useBean id="" >
<%
 Database db=new Database();
 try {
	session = request.getSession(true);
} catch (Exception e) {
}
 boolean res=db.doLogin(request);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Authentication</title>
</head>
<body>
Result is ...<%=res%>
</body>