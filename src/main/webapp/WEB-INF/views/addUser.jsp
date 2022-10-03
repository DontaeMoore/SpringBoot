<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri ="http://www.springframework.org/tags/form" prefix="form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADMIN New/Edit User</title>
    </head>
    <body>
    <script type="text/javascript" src="resources/TrackFunctions.js" ></script>
     <div align="center">
        <%@ include file="/WEB-INF/includes/mainHeader.jsp" %>
        <a href="home"><input type="submit" value="Home"/></a>
        </div>

        <div align="center">
        <h1>ADMIN New/Edit User</h1>
        <form:form action="saveUserAdmin" method="post" modelAttribute="user">
        <table cellpadding="5">
        <form:hidden path="id" />
        <tr>
                                 <td>
                                <input type="checkbox" ${checkbox}  onclick="ToggleCheck()"  id = "remember"  ${checkValue} />Enable AutoSave
                                </td>
                                </tr>


        <tr>
        <td>UserName:</td>
        <td><form:input path="username" /></td>
        </tr>

         <tr>
        <td>Password:</td>
        <td><form:input path="password" /></td>
        </tr>

         <tr>
        <td>Role_ID:</td>
        <td><form:input path="role" /></td>
        </tr>

         <tr>
        <td>Status_ID:</td>
        <td><form:input path="status"/></td>
        </tr>


        <tr>
        <td colspan="2" align="center"><input type="submit" value="Save"/></td>
        </tr>
        </table>
        </form:form>

        </div>
    </body>
</html>