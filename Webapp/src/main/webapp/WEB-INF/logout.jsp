<%-- 
    Document   : logout
    Created on : 14 oct. 2020, 12:08:03
    Author     : gonza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="layout/menu.jspf" %>

<% String logoutName=(String)request.getAttribute("logoutName");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
        <h1> Adiós <%=logoutName%></h1>
    </body>
</html>
