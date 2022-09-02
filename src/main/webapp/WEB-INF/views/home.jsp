<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact ManagerHome</title>
</head>
<body>
<div align="center">
<h1>Derby Tracks List</h1>
<h3><a href = "add">New Tracks</a></h3>
<a href="horse"><input type="submit" value="Horse Page"/></a>
<table border="1" cellpadding="5">
<tr>
	<th>ID</th>
	<th>Track</th>
	<th>City</th>
	<th>State</th>
	<th>Action</th>
</tr>
		<c:forEach items="${listContact}" var="contact" varStatus="status">
         <tr>
       	 	 <td>${status.index + 1 }</td>
       		 <td>${contact.name}</td>
       		 <td>${contact.city}</td>
       		  <td>${contact.state}</td>

       		  <td>
       		  <a href="edit?id=${contact.id}">View Details and Edit Track</a>
       		  &nbsp;&nbsp;
       		   <a href="delete?id=${contact.id}">Delete</a>
       		  </td>
         </tr>
      </c:forEach>
</table>
</div>
</body>
</html>