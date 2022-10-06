<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

   <%@ taglib uri ="http://www.springframework.org/tags/form" prefix="form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
     <style><%@include file="/WEB-INF/includes/style.css"%></style>
    <body>
    <div align="center">
    <%@ include file="/WEB-INF/includes/mainHeader.jsp" %>
    <a href="home"><input type="submit" value="Home"/></a>





          <form:form action="saveUser" method="post" modelAttribute="user">
                        <table cellpadding="5">
                        <form:hidden path="id" />
                        <form:hidden path="username" />
                        <form:hidden path="role" />
                        <form:hidden path="status" />


                                                 <tr>
                                                 <td>Enter New Password:</td>
                                                 <td><form:input path="password"/></td>
                                                 </tr>

                                                 <tr>
                                                 <td colspan="2" align="center"><input type="submit" value="Save new password"/></td>
                                                 </tr>




                                                 </table>
                                   </form:form>



    </div>
    </body>
</html>