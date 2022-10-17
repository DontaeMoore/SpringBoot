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
    <script type="text/javascript" src="resources/adminFunctions.js" ></script>
    <script src=https://code.jquery.com/jquery-3.6.0.min.js></script>

     <div align="center">
      <h1>ADMIN New/Edit User</h1>
        <%@ include file="/WEB-INF/includes/mainHeader.jsp" %>

        </div>

        <div align="center">

        <form:form action="saveUserAdmin" method="post" modelAttribute="user">
        <table cellpadding="5">
        <form:hidden path="id" />
        <tr>
                                 <td>
                                <input type="checkbox" ${checkbox}  onclick= "ToggleCheck()" id = "remember"  ${checkValue} />Enable AutoSave
                                </td>
                                </tr>


        <tr>
        <td>UserName:</td>
        <td><form:input path="username" onchange="checkUserName(user.username)"/></td>
        </tr>

         <tr>
        <td>Password:</td>
        <td><form:input path="password" onchange="checkPassword(user.password)"/></td>
        </tr>



                <tr>
                <td>Role:</td>
                <td><form:select path="roleName">
                <form:options items="${rolelist}"></form:options>
                </form:select>
                </td>
                </tr>

                <tr>
                                 <td>Status:</td>
                                <td><form:select path="statusName">
                                <form:options items="${statuslist}"></form:options>
                                </form:select>
                                </td>
                                </tr>






        <tr>
        <td colspan="2" align="center"><input type="submit" value="Save"/></td>
        </tr>
        </table>
        </form:form>

        </div>
        <%@ include file="/WEB-INF/includes/footer.jsp" %>
    </body>
</html>
