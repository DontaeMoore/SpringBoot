<%@page contentType="text/html" pageEncoding="UTF-8"%>
   <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Race Horse Page</title>
</head>

<style><%@include file="/WEB-INF/includes/style.css"%>
<%@include file="/WEB-INF/includes/dataTable.css"%>
</style>

<body>
<div align="center">
<h1>Derby Race Horses</h1>
<%@ include file="/WEB-INF/includes/mainHeader.jsp" %>

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
<div class = "feat">
<table id = "mytable3" border="2" cellpadding="5" hidden>
<thead>
<tr>

	<th>Name</th>
	<th>Gender</th>
	<th>Foal Year </th>
	<th>Owner </th>
	<th>Trainer </th>
	<th>Comments</th>
	<th>Action</th>

</tr>
</thead>
<tbody>
		<c:forEach items="${racehorse}" var="r" varStatus="status">
         <tr>

       		 <td><a href="${r.link}">${r.name}</a></td>
       		 <td>${r.gender}</td>
       		 <td>${r.foalyear}</td>
       		 <td>${r.owner}</td>
       		 <td>${r.trainer}</td>
             <td>${r.comments}</td>
               <td>
                                                		  <a href="viewRaceHorse?id=${r.id}">View</a>&nbsp;
                                                		  <a href="editRaceHorse?id=${r.id}">Edit</a>
                                                		  &nbsp;
                                                		   <a href="deleteRaceHorse?id=${r.id}">Delete</a>
                                                		  </td>

                                   </tr>

         </tr>
      </c:forEach>
      </tbody>
</table>
<div>

<h3><a href = "addRaceHorse">Add a Race Horse</a></h3>
<%@ include file="/WEB-INF/includes/footerNonAbs.jsp" %>
</div>
</body>
</html>