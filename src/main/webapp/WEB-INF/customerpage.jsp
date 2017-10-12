<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
    </head>
    <body>
        <h1>Hello <%=request.getParameter("email")%> </h1>
        You are now logged in as a customer of our wonderful site.
        
        <form name="PlaceOrder" action="FrontController" method="POST">
            <input type="hidden" name="command" value="PlaceOrder">
            Length:<br>
            <input type="text" name="length">
            <br>
            Width:<br>
            <input type="text" name="width">
            <br>
            Height:<br>
            <input type="text" name="height">
            <br>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
