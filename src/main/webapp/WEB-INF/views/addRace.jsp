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
    <script type="text/javascript" src="../resources/RaceFunctions.js" ></script>
     <div align="center">
        <%@ include file="/WEB-INF/includes/mainHeader.jsp" %>
        <a href="home"><input type="submit" value="Home"/></a>
        </div>

        <div align="center">
        <h1>New/Edit Race  <br /> ${sessionMessage}</h1>
        <form:form action="saveRace" method="post" modelAttribute="race">
        <table cellpadding="5">
        <form:hidden path="id" />
         <tr>
                 <td>
                <input type="checkbox" ${checkbox}  onclick="ToggleCheck()" value="UpdateCheck" id = "remember"  ${checkValue} />Enable AutoSave
                </td>
                </tr>



        <tr>
        <td>Name:</td>
        <td><form:input path="name" value = "${race2.name}" onchange="checkName(${race.id}, race.name)"/></td>

         <tr>
        <td>Date:</td>
        <td><form:input path="date" type="date" value = "${race2.date}" onchange="checkDate(${race.id}, date)"/></td>
        </tr>

        <tr>
        <td>Track ID:</td>
        <td><form:select path="track_id" value = "${race2.track_id}" onchange="checkTrackID(${race.id}, track_id)">
        <form:options items="${l}"></form:options>
        </form:select>
        </td>
        </tr>

        <tr>
        <td>Deadline:</td>
        <td><form:input path="deadline" type="time" value = "${race2.deadline}" onchange="checkDeadline(${race.id}, deadline)"/></td>
        </tr>

        <tr>
         <td>Distance (m):</td>
         <td><form:input path="distance" type="number" step="0.01" value = "${race2.distance}" onchange="checkDistance(${race.id}, distance)"/></td>
         </tr>


        <tr>
        <td>Finish Time (s):</td>
        <td><form:input path="finish_time" type="number" step="0.01" value = "${race2.finish_time}" onchange="checkFinish(${race.id}, finish_time)" /></td>
        </tr>



        <tr>
        <td colspan="2" align="center"><input type="submit" name = "save" value="Submit Form"/></td>
        </tr>

        <tr>
        <td colspan="2" align="center"><input type="submit" disabled="disabled" name = "submitSession" value="Save And Return Later"/>
        <input type="submit" disabled="disabled" name = "clearSession" value="Clear the session"/>
        </td>

        </tr>

        </tr>

                </tr>
        </table>
        </form:form>









        </div>
    </body>
</html>
