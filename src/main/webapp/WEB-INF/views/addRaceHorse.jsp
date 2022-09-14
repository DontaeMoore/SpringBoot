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
     <div align="center">
        <%@ include file="/WEB-INF/includes/mainHeader.jsp" %>
        <a href="home"><input type="submit" value="Back"/></a>
        </div>

        <div align="center">
        <h1>New/Edit Race Horse</h1>
        <form:form action="saveRaceHorse" method="post" modelAttribute="race">
        <table cellpadding="5">
        <form:hidden path="id" />
        <tr>
        <td>Name:</td>
        <td><form:input path="name"/></td>
        </tr>

         <tr>
        <td>Gender:</td>
        <td><form:input path="gender" maxlength="1"/></td>
        </tr>

         <tr>
        <td>Foalyear:</td>
        <td><form:input path="foalyear"/></td>
        </tr>

        <tr>
        <td>Equibase link:</td>
        <td><form:input path="link"/></td>
        </tr>

        <tr>
        <td>Owner:</td>
        <td><form:input path="owner"/></td>
        </tr>

        <tr>
         <td>Trainer:</td>
         <td><form:input path="trainer"/></td>
         </tr>

        <tr>
        <td>Comments:</td>
        <td><form:input path="comments"/></td>
        </tr>


        <tr>
        <td colspan="2" align="center"><input type="submit" value="Save"/></td>
        </tr>
        </table>
        </form:form>

        </div>
    </body>
</html>
