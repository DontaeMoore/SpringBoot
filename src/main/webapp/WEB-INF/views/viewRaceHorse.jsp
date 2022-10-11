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
       <h1>View Race Horse Details!</h1>
    <%@ include file="/WEB-INF/includes/mainHeader.jsp" %>

    </div>

        <div align="center">
        <form:form action="save" method="post" modelAttribute="racehorse">
        <table cellpadding="5">
        <form:hidden path="id" />
        <tr>
        <td>Name:</td>
        <td>${racehorse.name}</td>
        </tr>



        <tr>
        <td>Foal Year:</td>
        <td>${racehorse.foalyear}</td>
        </tr>

       <tr>
       <td>Gender:</td>
       <td>${racehorse.gender}</td>
       </tr>


        <tr>
        <td>Equibase Link:</td>
        <td><a href = "${racehorse.link}">${racehorse.name}</td>
        </tr>

        <tr>
        <td>Owner:</td>
        <td>${racehorse.owner}</td>
        </tr>

        <tr>
        <td>Trainer:</td>
        <td>${racehorse.trainer}</td>
        </tr>

        <tr>
        <td>Comments:</td>
        <td>${racehorse.comments}</td>
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