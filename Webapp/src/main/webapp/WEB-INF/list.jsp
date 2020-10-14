<%-- 
    Document   : hello
    Created on : 6 oct. 2020, 12:28:02
    Author     : gonza
--%>

<%@page import="com.mycompany.webapp.domain.Login"%>
<%@page import="java.util.List"%>
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
        <h1 align="center">¡Bienvenid@ a nuestra lista de vehículos!</h1>
        <div align="center"><img src="C:\Users\gonza\OneDrive\Imágenes\ferrari.jpg" align="middle" width="313" height="150"></div>
        <% HttpSession mySession=request.getSession(false);
        
        List<Vehiculo> result=(List<Vehiculo>)mySession.getAttribute("vehiculos");
        %>
        <table border="1" align="center" bordercolor="blue">
            <tr>
                <th bgcolor="mediumaquamarine" height="50" width="150">ID</th>
                <th bgcolor="mediumaquamarine" height="50" width="150">Marca</th>
                <th bgcolor="mediumaquamarine" height="50" width="150">Modelo</th>
                <th bgcolor="mediumaquamarine" height="50" width="150">Matrícula</th>
                <th bgcolor="mediumaquamarine" height="50" width="150">Plazas</th>
                <th bgcolor="mediumaquamarine" height="50" width="150">Borrar</th>
                <th bgcolor="mediumaquamarine" height="50" width="150">Modificar</th>
            </tr>

        <%for(Vehiculo v:result){
            %>
        <tr>
            <h2><td align="center"><%= v.getId()%></td></h2>
            <h2><td align="center"><%= v.getMarca()%></td></h2>
            <h2><td align="center"><%= v.getModelo()%></td></h2>
            <h2><td align="center"><%= v.getMatricula()%></td></h2>
            <h2><td align="center"><%= v.getPlazas()%></td></h2>
            <td align="center">
                <% if(login !=null && login.isLogeado()){%>
            <a href=http://localhost:8080/Webapp/delete?id=<%=v.getId()%>><img src="C:\Users\gonza\OneDrive\Imágenes\basura.jpg" width="25" height="25"></a>
                <%}%>
            </td>
            <td align="center">
                <% if(login !=null && login.isLogeado()){%>
            <a href=http://localhost:8080/Webapp/update?id=<%=v.getId()%>><img src="C:\Users\gonza\OneDrive\Imágenes\reciclar.png" width="25" height="25"></a>
                <%}%>
            </td>
        <%}
        %>
        </table>
        <a href="http://localhost:8080/Webapp/insert.html"><p style="text-align:center">Insertar vehículo</a>
    </body>
</html>
