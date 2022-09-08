<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri ="http://www.springframework.org/tags/form" prefix="form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Track Details!</title>
    </head>
    <body>
    <div align="center">
    <%@ include file="/WEB-INF/includes/mainHeader.jsp" %>
    <a href="home"><input type="submit" value="Back"/></a>
    </div>

        <div align="center">
        <h1>View Track Details!</h1>
        <form:form action="save" method="post" modelAttribute="contact">
        <table cellpadding="5">
        <form:hidden path="id" />
        <tr>
        <td>Name:</td>
        <td>${contact.name}</td>
        </tr>

         <tr>
        <td>City:</td>
        <td>${contact.city}</td>
        </tr>

         <tr>
        <td>State:</td>
        <td>${contact.state}</td>
        </tr>

         <tr>
        <td>Zip:</td>
        <td>${contact.zip}</td>
        </tr>

         <tr>
        <td>Ownership:</td>
        <td>${contact.ownership}</td>
        </tr>
        <tr>
        <td colspan="2" align="center"></td>
        </tr>
        </table>
        </form:form>

        </div>
    </body>
</html>