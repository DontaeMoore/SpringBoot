<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri ="http://www.springframework.org/tags/form" prefix="form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Race Details!</title>
    </head>
    <body>
    <div align="center">
    <%@ include file="/WEB-INF/includes/mainHeader.jsp" %>

    </div>

        <div align="center">
        <h1>View Race Details!</h1>
        <form:form action="save" method="post" modelAttribute="race">
        <table cellpadding="5">
        <form:hidden path="id" />
        <tr>
        <td>Name:</td>
        <td>${race.name}</td>
        </tr>



        <tr>
        <td>Year:</td>
        <td>${race.year}</td>
        </tr>

       <tr>
       <td>Track:</td>
       <td>${race.trackName}</td>
       </tr>


        <tr>
        <td>Date:</td>
        <td>${race.date}</td>
        </tr>

        <tr>
        <td>Deadline:</td>
        <td>${race.deadline}</td>
        </tr>

        <tr>
        <td>Distance:</td>
        <td>${race.distance}</td>
        </tr>

        <tr>
        <td>Finish Time:</td>
        <td>${race.finish_time}</td>
        </tr>



        </tr>
        <tr>
        <td colspan="2" align="center"></td>
        </tr>
        </table>
        </form:form>

        </div>
        <%@ include file="/WEB-INF/includes/footer.jsp" %>
    </body>
</html>