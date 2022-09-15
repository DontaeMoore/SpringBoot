<%@page contentType="text/html" pageEncoding="UTF-8"%>
   <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Race Horse Page</title>
</head>

<style><%@include file="/WEB-INF/includes/style.css"%></style>

<body>
<div align="center">
<h1>Derby Race Horses</h1>
<%@ include file="/WEB-INF/includes/mainHeader.jsp" %>
<a href="home"><input type="submit" value="Home"/></a>

<table border="2" cellpadding="5">
<tr>

	<th>Name</th>
	<th>Gender</th>
	<th>Foal Year </th>
	<th>Equibase Link</th>
	<th>Owner </th>
	<th>Trainer </th>
	<th>Comments</th>
	<th>Action</th>

</tr>
		<c:forEach items="${racehorse}" var="r" varStatus="status">
         <tr>

       		 <td>${r.name}</td>
       		 <td>${r.gender}</td>
       		 <td>${r.foalyear}</td>
       		 <td><a href="${r.link}">${r.name}</a></td>
       		 <td>${r.owner}</td>
       		 <td>${r.trainer}</td>
             <td>${r.comments}</td>
               <td>
                                                		  <a href="viewRaceHorse?id=${r.id}">View Race Horse</a> and
                                                		  <a href="editRaceHorse?id=${r.id}">Edit Race Horse</a>
                                                		  &nbsp;&nbsp;
                                                		   <a href="deleteRaceHorse?id=${r.id}">Delete Race Horse</a>
                                                		  </td>

                                   </tr>

         </tr>
      </c:forEach>
</table>
<h3><a href = "addRaceHorse">Add a Race Horse</a></h3>

</div>
</body>
</html>