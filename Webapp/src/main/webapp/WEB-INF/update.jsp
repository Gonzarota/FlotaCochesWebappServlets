<%-- 
    Document   : update
    Created on : 9 oct. 2020, 12:28:33
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
        <h1>Hello World!</h1>
           
            <% HttpSession mySession=request.getSession(false);
         
            Vehiculo result=(Vehiculo)mySession.getAttribute("vehiculo");
            
            %>
            <form method="post" action="update">
            
            Marca:<input type="text" name="marca">
            <br><br>
            Modelo:<input type="text" name="modelo">
            <br><br>
            Matricula:<input type="text" name="matricula">
            <br><br>
            Plazas:<input type="number" name="plazas">
            <br><br>
           
            
            <input type="submit" value="Modificar Vehículo">
            <input type="hidden" name="id" value=<%=result.getId()%>>

        </form>
                       

    </body>
</html>
