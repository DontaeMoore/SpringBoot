<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   
<%@ taglib uri ="http://www.springframework.org/tags/form" prefix="form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New/Edit Tracks</title>
    </head>
    <body>
    <div style="padding-left: 100px;">
    <a href="home"><input type="submit" value="Back"/></a> 
    </div>
   
        <div align="center">
        <h1>New/Edit Track</h1>
        <form:form action="save" method="post" modelAttribute="contact">
        <table cellpadding="5">
        <form:hidden path="id" />
        <tr>
        <td>Name:</td>
        <td><form:input path="name"/></td>
        </tr>
        
         <tr>
        <td>City:</td>
        <td><form:input path="city"/></td>
        </tr>
        
         <tr>
        <td>State:</td>
        <td><form:input path="state"/></td>
        </tr>
        
         <tr>
        <td>Zip:</td>
        <td><form:input path="zip"/></td>
        </tr>
        
         <tr>
        <td>Ownership:</td>
        <td><form:input path="ownership"/></td>
        </tr>
        <tr>
        <td colspan="2" align="center"><input type="submit" value="Save"/></td>
        </tr>
        </table>
        </form:form>
        
        </div>
    </body>
</html>
