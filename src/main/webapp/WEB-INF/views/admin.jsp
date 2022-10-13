
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
     <style><%@include file="/WEB-INF/includes/style.css"%>
     <%@include file="/WEB-INF/includes/dataTable.css"%>
     </style>
    <body>
    <script type="text/javascript" src="resources/adminFunctions.js" ></script>
     <div align="center">
             <h1>Admin User Panel</h1>
             <%@ include file="/WEB-INF/includes/mainHeader.jsp" %>

             </div>

            <script src=https://code.jquery.com/jquery-3.6.0.min.js></script>
            <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>

            <script>

                // Initialize the DataTable
                $(document).ready(function () {
                  $('#mytable3').DataTable({
                    initComplete: function () {
                      $('#mytable3').show();


                    }
                  });
                });
              </script>




             <div align="center">
             <div class="feat">
            <table id = "mytable3" border="1" cellpadding="5" hidden>
            <thead>
            <tr>

            	<th>Username</th>
            	<th>Password</th>
            	<th>Role ID </th>
            	<th>Status ID </th>
            	<th>Action</th>


            </tr>
            </thead>
            <tbody>
            		<c:forEach items="${userList}" var="c" varStatus="status">
                     <tr>

                   		 <td>${c.getUsername()}</td>
                   		 <td>${c.password}</td>
                   		 <td>${c.role}</td>
                   		 <td>${c.status}</td>

                           <td>
                                               		  <a href="viewUserAdmin?id=${c.id}">View User</a>&nbsp;
                                               		  <a href="editUserAdmin?id=${c.id}">Edit User</a>
                                               		  &nbsp;
                                               		   <a href="deleteUserAdmin?id=${c.id}">Delete User</a>
                                               		  </td>

                                  </tr>

                     </tr>
                  </c:forEach>
                  </tbody>
            </table>
            </div>

            <h3><a href = "addUserAdmin">Add a new User!</a></h3>


             </div>
             <%@ include file="/WEB-INF/includes/footer.jsp" %>
    </body>
</html>
