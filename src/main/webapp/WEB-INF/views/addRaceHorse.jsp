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
    <script type="text/javascript" src="resources/RaceHorseFunctions.js" ></script>
     <div align="center">
        <%@ include file="/WEB-INF/includes/mainHeader.jsp" %>
        <a href="home"><input type="submit" value="Home"/></a>
        </div>

        <div align="center">
        <h1>New/Edit Race Horse</h1>
        <form:form action="saveRaceHorse" method="post" modelAttribute="race">
        <table cellpadding="5">
        <form:hidden path="id" />
        <tr>
                                 <td>
                                <input type="checkbox" ${checkbox}  onclick="ToggleCheck()"  id = "remember"  ${checkValue} />Enable AutoSave
                                </td>
                                </tr>

        <tr>
        <td>Name:</td>
        <td><form:input path="name" onchange="checkName(race.name)"/></td>
        </tr>

         <tr>
        <td>Gender:</td>
        <td><form:input path="gender" maxlength="1" onchange="checkGender(race.gender)"/></td>
        </tr>

         <tr>
        <td>Foalyear:</td>
        <td><form:input path="foalyear" type="number" maxlength="4" onchange="checkFoal(race.foalyear)"/></td>
        </tr>

        <tr>
        <td>Equibase link:</td>
        <td><form:input path="link" cssStyle="width:350%" onchange="checkLink(race.link)"/></td>
        </tr>

        <tr>
        <td>Owner:</td>
        <td><form:input path="owner" cssStyle="width:250%" onchange="checkOwner(race.owner)"/></td>
        </tr>

        <tr>
         <td>Trainer:</td>
         <td><form:input path="trainer" cssStyle="width:250%" onchange="checkTrainer(race.trainer)"/></td>
         </tr>

        <tr>
        <td>Comments:</td>
        <td><form:input path="comments" cssStyle="width:250%" onchange="checkComments(race.comments)"/></td>
        </tr>


        <tr>
        <td colspan="2" align="center"><input type="submit" value="Save"/></td>
        </tr>
        </table>
        </form:form>

        </div>
    </body>
</html>
