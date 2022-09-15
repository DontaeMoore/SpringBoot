<%@page contentType="text/html" pageEncoding="UTF-8"%>
   <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact ManagerHome</title>
</head>
 <style><%@include file="/WEB-INF/includes/style.css"%></style>
<body>
<div align="center">
<h1>Derby Race List</h1>
<%@ include file="/WEB-INF/includes/mainHeader.jsp" %>
<a href="home"><input type="submit" value="Home"/></a>


<table border="1" cellpadding="5">
<tr>

	<th>Name</th>
	<th>Year</th>
	<th>Track</th>
	<th>Date</th>
	<th>Deadline (military time)</th>
	<th>Distance (m)</th>
	<th>Finish Time (s) </th>
	<th>Action</th>

</tr>
		<c:forEach items="${RaceList}" var="race" varStatus="status">
         <tr>

       		 <td>${race.name}</td>
       		 <td>${race.year}</td>
       		  <td>${race.getTrackName()}</td>
       		  <td>${race.date}</td>
       		  <td>${race.deadline}</td>
       		  <td>${race.distance}</td>
               <td>${race.finish_time}</td>
               <td>
                      		  <a href="viewRace?id=${race.id}">View Race</a> and
                      		  <a href="editRace?id=${race.id}">Edit Race</a>
                      		  &nbsp;&nbsp;
                      		   <a href="deleteRace?id=${race.id}">Delete</a>
                      		  </td>

         </tr>
      </c:forEach>
</table>
<h3><a href = "addRace">Add Race</a></h3>


</div>
</body>
</html>