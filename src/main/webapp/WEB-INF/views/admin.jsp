
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri ="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View/Edit User Account</title>
    </head>
     <style><%@include file="/WEB-INF/includes/style.css"%></style>
    <body>
    <script type="text/javascript" src="resources/adminFunctions.js" ></script>
     <div align="center">
             <%@ include file="/WEB-INF/includes/mainHeader.jsp" %>
             <a href="home"><input type="submit" value="Home"/></a>
             </div>

             <div align="center">
            <table border="1" cellpadding="5">
            <tr>

            	<th>Username${userList[0].getUsername()}</th>
            	<th>Password</th>
            	<th>Role ID </th>
            	<th>Status ID </th>
            	<th>Action</th>


            </tr>
            		<c:forEach items="${userList}" var="c" varStatus="status">
                     <tr>

                   		 <td>${c.getUsername()}</td>
                   		 <td>${c.password}</td>
                   		 <td>${c.getRoleName(c.role)}</td>
                   		 <td>${c.status}</td>

                           <td>
                                               		  <a href="viewUserAdmin?id=${c.id}">View User</a> and
                                               		  <a href="editUserAdmin?id=${c.id}">Edit User</a>
                                               		  &nbsp;&nbsp;
                                               		   <a href="deleteUserAdmin?id=${c.id}">Delete User</a>
                                               		  </td>

                                  </tr>

                     </tr>
                  </c:forEach>
            </table>
            <h3><a href = "addUserAdmin">Add a new User!</a></h3>


             </div>
    </body>
</html>
