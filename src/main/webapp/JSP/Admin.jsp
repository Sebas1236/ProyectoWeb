<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Admin Page</title>
</head>
<% //In case, if Admin session is not set, redirect to Login page
if((request.getSession(false).getAttribute("Admin")== null) )
{
%>
<jsp:forward page="/JSP/Login.jsp"></jsp:forward>
<%} %>
<body>
<center><h2>Bienvenido, Administrador!</h2></center>

Welcome <%=request.getAttribute("userName") %>
<a href="ServletControladorUsuario">Administrar Usuarios</a>
<a href="ServletControladorEmpresa">Administrar Empresas</a>
<a href="ServletControladorEF">Administrar Entidades Federativas</a>
<div style="text-align: right"><a href="<%=request.getContextPath()%>/LogoutServlet">Cerrar Sesión</a></div>
</body>
</html>
<!--
El administrador puede:
1.- Gestionar usuarios
2.- Gestionar empresas
3.- Gestionar Entidades Federativas
4.- 

-->