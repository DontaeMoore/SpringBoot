<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri ="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> ADMIN View User Details!</title>
    </head>
    <body>
    <div align="center">
     <h1>ADMIN View User Details!</h1>
    <%@ include file="/WEB-INF/includes/mainHeader.jsp" %>

    </div>

        <div align="center">

        <form:form action="save" method="post" modelAttribute="user">
        <table cellpadding="5">
        <form:hidden path="id" />

        <tr>
        <td>UserName:</td>
        <td>${user.username}</td>
        </tr>



        <tr>
        <td>Password:</td>
        <td>${user.password}</td>
        </tr>

       <tr>
       <td>Status:</td>
       <td>${user.statusName}</td>
       </tr>




        <tr>
        <td>Role:</td>
        <td>${user.roleName}</td>
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