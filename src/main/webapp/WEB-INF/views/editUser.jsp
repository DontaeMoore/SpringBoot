
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri ="http://www.springframework.org/tags/form" prefix="form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View/Edit User Account</title>
    </head>
    <body>
     <div align="center">
             <%@ include file="/WEB-INF/includes/mainHeader.jsp" %>
             <a href="home"><input type="submit" value="Back"/></a>
             </div>

             <div align="center">
             <h1>View/Edit User Account</h1>
             <form:form action="saveUser" method="post" modelAttribute="user">
               <table cellpadding="5">
                <form:hidden path="id" />

                                        <tr>
                                        <td>User Name (Non-Editable):</td>
                                        <td><form:input path="username" readonly="true"/></td>
                                        </tr>

                                         <tr>
                                        <td>Role:</td>
                                        <td><form:input path="role"/></td>
                                        </tr>

                                         <tr>
                                        <td>Status:</td>
                                        <td><form:input path="status"/></td>
                                        </tr>

                                         <tr>
                                        <td>New Password:</td>
                                        <td><form:input path="password"/></td>
                                        </tr>


                                        <tr>
                                        <td colspan="2" align="center"><input type="submit" value="Save User Details"/></td>
                                        </tr>
                                        </table>
                          </form:form>

             </div>
    </body>
</html>