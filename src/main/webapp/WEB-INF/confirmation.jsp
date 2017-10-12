<%-- 
    Document   : confirmation
    Created on : 12-10-2017, 11:21:57
    Author     : Mads Voss
--%>

<%@page import="java.util.List"%>
<%@page import="FunctionLayer.LineItem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<LineItem> list = (List<LineItem>)request.getAttribute("LineItems");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Your order has been accepted, please wait as an employee will look over the order</h1>
        <%
          for(int i = 0; i < list.size(); i++) {
        %>
        <h1><%=list.get(i).toString()%></h1>
        <% } %>
    </body>
</html>
