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
    <a href="home"><input type="submit" value="Back"/></a>
    </div>

        <div align="center">
        <h1>View Challenge Details!</h1>
        <form:form action="save" method="post" modelAttribute="challenge">
        <table cellpadding="5">
        <form:hidden path="id" />
        <tr>
        <td>Name:</td>
        <td>${challenge.name}</td>
        </tr>



        <tr>
        <td>Description:</td>
        <td>${challenge.desc}</td>
        </tr>

       <tr>
       <td>First Place Points:</td>
       <td>${challenge.first_points}</td>
       </tr>


        <tr>
        <td>Second Place Points:</td>
        <td>${challenge.second_points}</td>
        </tr>

        <tr>
        <td>Third Place Points:</td>
        <td>${challenge.third_points}</td>
        </tr>

        <tr>
        <td>Fourth Place Points:</td>
        <td>${challenge.fourth_points}</td>
        </tr>

        <tr>
        <td>Status:</td>
        <td>${challenge.status}</td>
        </tr>



        </tr>
        <tr>
        <td colspan="2" align="center"></td>
        </tr>
        </table>
        </form:form>

        </div>
    </body>
</html>