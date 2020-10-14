<%-- 
    Document   : login
    Created on : 13 oct. 2020, 17:21:52
    Author     : gonza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="layout/menu.jspf" %>
        <h1>Ingreso de usuarios</h1>
    <br>
        <% String msgError=(String)request.getSession().getAttribute("loginError");
        if(msgError!=null && !msgError.isEmpty()){
        %>
            <%= msgError %>
        <%
            }
                %>
        <form method="post" action="login">
            
            Nombre:<input type="text" name="name">
            <br><br>
            Contraseña:<input type="password" name="password">
            <br><br>
            <input type="submit" value="login">
            
       </form>
    </body>
</html>
