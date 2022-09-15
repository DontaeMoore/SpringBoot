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
        <a href="home"><input type="submit" value="Home"/></a>
        </div>

        <div align="center">
        <h1>New/Edit Race</h1>
        <form:form action="saveRace" method="post" modelAttribute="race">
        <table cellpadding="5">
        <form:hidden path="id" />
        <tr>
        <td>Name:</td>
        <td><form:input path="name"/></td>
        </tr>

         <tr>
        <td>Year:</td>
        <td><form:input path="year"/></td>
        </tr>

         <tr>
        <td>Date:</td>
        <td><form:input path="date" type="date"/></td>
        </tr>

        <tr>
        <td>Track ID:</td>
        <td><form:select path="track_id">
        <form:options items="${l}"></form:options>
        </form:select>
        </td>
        </tr>

        <tr>
        <td>Deadline:</td>
        <td><form:input path="deadline" type="time"/></td>
        </tr>

        <tr>
         <td>Distance (m):</td>
         <td><form:input path="distance" type="number" step="0.01"/></td>
         </tr>

        <tr>
        <td>Finish Time (s):</td>
        <td><form:input path="finish_time" type="number" step="0.01"/></td>
        </tr>


        <tr>
        <td colspan="2" align="center"><input type="submit" value="Save"/></td>
        </tr>
        </table>
        </form:form>

        </div>
    </body>
</html>
