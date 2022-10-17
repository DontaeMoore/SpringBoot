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
<h1>Derby Challenges</h1>


<%@ include file="/WEB-INF/includes/mainHeader.jsp" %>


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

	<th>Name</th>
	<th>Description</th>
	<th>1st Place </th>
	<th>2nd Place </th>
	<th>3rd Place </th>
	<th>4th Place </th>
	<th>Status</th>
	<th>Action</th>

</tr>
</thead>
<tbody>
		<c:forEach items="${challenge}" var="c" varStatus="status">
         <tr>

       		 <td>${c.name}</td>
       		 <td>${c.desc}</td>
       		 <td>${c.first_points}</td>
       		 <td>${c.second_points}</td>
       		 <td>${c.third_points}</td>
       		 <td>${c.fourth_points}</td>
             <td>${c.status}</td>

               <td>
                                   		  <a href="viewChallenge?id=${c.id}">View</a>&nbsp;
                                   		  <a href="editChallenge?id=${c.id}">Edit</a>
                                   		  &nbsp;
                                   		   <a href="deleteChallenge?id=${c.id}">Delete</a>

                                   		    <a href="challengeraces?id=${c.id}">Races</a>
                                   		  </td>

                      </tr>

         </tr>
      </c:forEach>
      </tbody>
</table>
</div>


<h3><a href = "addChallenge">Add a Challenge</a></h3>
<%@ include file="/WEB-INF/includes/footer.jsp" %>
</div>
</body>
</html>