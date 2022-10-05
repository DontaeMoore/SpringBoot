<%@page contentType="text/html" pageEncoding="UTF-8"%>
   <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
 <style><%@include file="/WEB-INF/includes/style.css"%></style>
<body>
<div align="center">
<h1>Derby Tracks List
<a href="forgot"><input type="submit" value="Forgot password? Coming Soon!" disabled/></a>
</h1>

<%@ include file="/WEB-INF/includes/mainHeader.jsp" %>



<table border="1" cellpadding="5">
<tr>

	<th>Track</th>
	<th>City</th>
	<th>State</th>
	<th>Temp</th>
	<th>Icon</th>
	<th>Action</th>

</tr>
		<c:forEach items="${listContact}" var="contact" varStatus="status">
         <tr>

       		 <td>${contact.name}</td>
       		 <td>${contact.city}</td>
       		  <td>${contact.state}</td>
       		  <td>${contact.temp}</td>
       		  <td><img src="${contact.icon}" width="40" height="40" alt = "N/A"></td>

       		  <td>
       		  <a href="view?id=${contact.id}">View Details</a> and
       		  <a href="edit?id=${contact.id}">Edit Track</a>
       		  &nbsp;&nbsp;
       		   <a href="delete?id=${contact.id}">Delete</a>
       		  </td>
         </tr>
      </c:forEach>
</table>
<h3><a href = "add">Add Tracks</a></h3>

</div>
</body>
</html>