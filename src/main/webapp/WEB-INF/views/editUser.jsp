
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
      <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@ taglib uri ="http://www.springframework.org/tags/form" prefix="form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View/Edit ${rolename} Account</title>
    </head>
    <style><%@include file="/WEB-INF/includes/style.css"%>
    <%@include file="/WEB-INF/includes/dataTable.css"%>
    </style>
    <body>
     <div align="center">
     <h1>View/Edit ${rolename} Account</h1>
             <%@ include file="/WEB-INF/includes/mainHeader.jsp" %>

             </div>

                <p></p>
             <div align="center" >

             <form:form action="saveUser" method="post" modelAttribute="user">
               <table cellpadding="5">
                <form:hidden path="id" />

                                        <tr>
                                        <td>User Name (Non-Editable):</td>
                                        <td><form:input path="username" readonly="true"/></td>
                                        </tr>

                                         <tr>
                                        <td>Role:</td>
                                        <td><form:input path="role" type="number"/></td>
                                        </tr>

                                         <tr>
                                        <td>Status:</td>
                                        <td><form:input path="status" type="number"/></td>
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

            <h1>Show all horse picks for ${user.username}</h1>

             <script src=https://code.jquery.com/jquery-3.6.0.min.js></script>
             <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>

             <script>

                 // Initialize the DataTable
                 $(document).ready(function () {
                   $('#mytable2').DataTable({
                     initComplete: function () {
                       $('#mytable2').show();


                     }
                   });
                 });
               </script>

             <div class = "feat">
             <table id = "mytable2" border="1" cellpadding="5" hidden>
             <thead>
             <tr>

             	<th>Date</th>
             	<th>Horse</th>
             	<th>Race</th>

             </tr>
             </thead>
             <tbody>
             		<c:forEach items="${picks}" var="c" varStatus="status">
                      <tr>

                    		 <td>${c.date}</td>
                    		 <td><a href = "viewRaceHorse?id=${c.horse_id}">${c.horseName}</a></td>
                    		 <td><a href = "viewHorses?id=${c.race_id}">${c.raceName}</a></td>




                                   </tr>

                      </tr>
                   </c:forEach>
                   </tbody>
             </table>
             </div>
</div>






             <%@ include file="/WEB-INF/includes/footer.jsp" %>
    </body>
</html>
