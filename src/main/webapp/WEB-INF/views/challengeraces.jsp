<%@page contentType="text/html" pageEncoding="UTF-8"%>
   <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
     <style><%@include file="/WEB-INF/includes/style.css"%>
     <%@include file="/WEB-INF/includes/dataTable.css"%>
     </style>
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

    <body>
    <div align="center">
    <h1>Challenge-Race Page</h1>
    <%@ include file="/WEB-INF/includes/mainHeader.jsp" %>

<h1>Every Race that occurs in ${challenge.name}</h1>


          <div class="feat">
         <table id = "mytable2" border="1" cellpadding="5" hidden>
         <thead>
         <tr>

         	<th>Name</th>
         	<th>Starting Date</th>
         	<th>Track Name</th>
         	<th>Remove</th>


         </tr>
         </thead>
         <tbody>
         		<c:forEach items="${r}" var="race" varStatus="status">
                  <tr>

                		 <td><a href = "viewRace?id=${race.id}">${race.name}</a></td>
                		 <td>${race.date}</td>
                		 <td>${race.trackName}</td>
                		 <td><a href = "deleteRaceFromChallenge?Cid=${challenge.id}&Rid=${race.id}">Delete</a></td>


                  </tr>
               </c:forEach>
          </tbody>


         </table>
         </div>
         <h3><a href = "addRaceToChallenge?id=${challenge.id}">Add a Race to ${challenge.name}</a></h3>



    <%@ include file="/WEB-INF/includes/footerNonAbs.jsp" %>
    </body>
</html>