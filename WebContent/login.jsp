<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<% 
	if(request.getAttribute("login.jsp")==null)
		response.sendRedirect("AxisBank");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projekt Gruppe1</title>
</head>
<body>
	<form method="post" action="AxisBank">
		<input type="hidden" name="site" value="Login" >
		<table>
		<tr><td><label>Benutzername</label></td><td><input type="text" name="benutzername" value="<%=request.getParameter("benutzername")!=null?request.getParameter("benutzername"):"" %>" ></td></tr>
		<tr><td><label>Passwort</label></td><td><input type="password" name="passwort" value="<%=request.getParameter("passwort")!=null?request.getParameter("passwort"):"" %>" ></td></tr>
		<tr><td colspan="2" ><input type="submit" value="anmelden" ></td></tr>
		</table>
	</form>
</body>
</html>