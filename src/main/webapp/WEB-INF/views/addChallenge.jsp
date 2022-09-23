<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri ="http://www.springframework.org/tags/form" prefix="form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New/Edit Challenge</title>
    </head>
    <body>
    <script type="text/javascript" src="../resources/ChallengeFunctions.js" ></script>
     <div align="center">
        <%@ include file="/WEB-INF/includes/mainHeader.jsp" %>
        <a href="home"><input type="submit" value="Home"/></a>
        </div>

        <div align="center">
        <h1>New/Edit Challenge ${challenge.id}</h1>
        <form:form action="saveChallenge" method="post" modelAttribute="challenge">
        <table cellpadding="5">
        <form:hidden path="id" />

        <tr>
                         <td>
                        <input type="checkbox" ${checkbox}  onclick="ToggleCheck()"  id = "remember"  ${checkValue} />Enable AutoSave
                        </td>
                        </tr>


        <tr>
        <td>Name:</td>
        <td><form:input path="name" onchange="checkName(challenge.name)"/></td>
        </tr>

         <tr>
        <td>Description:</td>
        <td><form:input path="desc" onchange="checkDesc(challenge.desc)"/></td>
        </tr>

         <tr>
        <td>First Place:</td>
        <td><form:input path="first_points" type="number" onchange="checkFirst(challenge.first_points)"/></td>
        </tr>

        <tr>
        <td>Second Place:</td>
        <td><form:input path="second_points" type="number" onchange="checkSecond(challenge.second_points)"/></td>
        </tr>

        <tr>
        <td>Third Place:</td>
        <td><form:input path="third_points" type="number" onchange="checkThird(challenge.third_points)"/></td>
        </tr>

        <tr>
         <td>Fourth Place:</td>
         <td><form:input path="fourth_points" type="number" onchange="checkFourth(challenge.fourth_points)"/></td>
         </tr>

        <tr>
        <td>Status:</td>
        <td><form:input path="status" onchange="checkStatus(challenge.status)"/></td>
        </tr>

        <tr>
        <td>Date:</td>
        <td><form:input path="date" type="date" onchange="checkDate(challenge.date)"/></td>
        </tr>


        <tr>
        <td colspan="2" align="center"><input type="submit" value="Save" name = "save"/></td>
        </tr>
        </table>
        </form:form>

        </div>
    </body>
</html>
