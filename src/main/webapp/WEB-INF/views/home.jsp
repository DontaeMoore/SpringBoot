<%@page contentType="text/html" pageEncoding="UTF-8"%>
   <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<style>
<%@include file="/WEB-INF/includes/dataTable.css"%>
</style>

<body>
<div align="center">
<h1>Derby Tracks List</h1>
<%@ include file="/WEB-INF/includes/mainHeader.jsp" %>

<script src=https://code.jquery.com/jquery-3.6.0.min.js></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>

<script>

    // Initialize the DataTable
    $(document).ready(function () {
      $('#mytable4').DataTable({
        initComplete: function () {
          $('#mytable4').show();


        }
      });
    });
  </script>


<div class="feat">
<table id="mytable4"border="1" cellpadding="5" hidden>
<thead>
<tr>

	<th>Track</th>
	<th>City</th>
	<th>State</th>
	<th>Temp</th>
	<th>Icon</th>
	<th>Action</th>

</tr>
</thead>
<tbody>
		<c:forEach items="${listContact}" var="contact" varStatus="status">
         <tr>

       		 <td>${contact.name}</td>
       		 <td>${contact.city}</td>
       		  <td>${contact.state}</td>
       		  <td>${contact.temp}</td>
       		  <td><img src="${contact.icon}" width="40" height="40" alt = "N/A"></td>

       		  <td>
       		  <a href="view?id=${contact.id}">View</a>&nbsp;
       		  <a href="edit?id=${contact.id}">Edit</a>
       		  &nbsp;
       		   <a href="delete?id=${contact.id}">Delete</a>
       		  </td>
         </tr>
      </c:forEach>
      </tbody>
</table>
</div>

<h3><a href = "add">Add Tracks</a></h3>

</div>
<%@ include file="/WEB-INF/includes/footerNonAbs.jsp" %>
</body>
</html>