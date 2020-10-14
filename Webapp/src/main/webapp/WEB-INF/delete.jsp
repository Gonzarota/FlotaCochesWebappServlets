<%-- 
    Document   : delete
    Created on : 8 oct. 2020, 10:05:15
    Author     : gonza
--%>

<%@page import="com.mycompany.webapp.domain.Vehiculo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="layout/menu.jspf" %>
         <h2>Eliminado</h2>
         <% HttpSession mySession=request.getSession(false);
         
         Vehiculo result=(Vehiculo)mySession.getAttribute("vehiculoBorrado");
        %>
        Se ha borrado:
            <h3><%= result.getMarca()%></h3>
            <h3><%= result.getModelo()%></h3>
            <h3><%= result.getMatricula()%></h3>
            <h3><%= result.getPlazas()%></h3>
            
            <h1></h1>
       
    </body>
</html>
