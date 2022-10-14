<%@page contentType="text/html" pageEncoding="UTF-8"%>
   <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact ManagerHome</title>
</head>
 <style><%@include file="/WEB-INF/includes/style.css"%>
 <%@include file="/WEB-INF/includes/dataTable.css"%>
</style>

<body>
<div align="center">
<h1>Derby Race List</h1>
<%@ include file="/WEB-INF/includes/mainHeader.jsp" %>



<script src=https://code.jquery.com/jquery-3.6.0.min.js></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="resources/RaceFunctions.js" ></script>

<script>

    // Initialize the DataTable
    $(document).ready(function () {
      $('#mytable').DataTable({
        order: [[2, 'asc']],
        initComplete: function () {
          $('#mytable').show();


        }
      });
    });
  </script>


<div class="feat">
<table id="mytable" class="hover display" border="1" hidden>
<thead>
<tr>

	<th>Name</th>
	<th>Track</th>
	<th>Date</th>
	<th>Deadline (military time)</th>
	<th>Distance (m)</th>
	<th>Finish Time (s) </th>
	<th>Action</th>




</tr>
</thead>
<tbody>
		<c:forEach items="${RaceList}" var="race" varStatus="status">
         <tr>

       		 <td>${race.name}</td>
       		  <td>${race.getTrackName()}</td>
       		  <td>${race.date}</td>
       		  <td>${race.deadline}</td>
       		  <td>${race.distance}</td>
               <td>${race.finish_time}</td>
               <td>
                      		  <a href="viewRace?id=${race.id}">View</a>&nbsp;
                      		  <a href="editRace?id=${race.id}">Edit</a>
                      		  &nbsp;
                      		   <a href="deleteRace?id=${race.id}">Delete</a>
                      		  </td>

         </tr>
      </c:forEach>
 </tbody>
</table>
</div>

<h3><span><a href = "addRace">Add Race</a></span></h3>


</div>
<%@ include file="/WEB-INF/includes/footerNonAbs.jsp" %>
</body>
</html>