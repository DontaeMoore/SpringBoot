<%@page contentType="text/html" pageEncoding="UTF-8"%>
   <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Race Horse Page</title>
</head>
<body>
<div align="center">
<h1>Derby Race Horses</h1>
<%@ include file="/WEB-INF/includes/mainHeader.jsp" %>
<a href="home"><input type="submit" value="Back"/></a>

<table border="1" cellpadding="5">
<tr>

	<th>Name</th>
	<th>Gender</th>
	<th>Foal Year </th>
	<th>Equibase Link</th>
	<th>Owner </th>
	<th>Trainer </th>
	<th>Comments</th>

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

         </tr>
      </c:forEach>
</table>


</div>
</body>
</html>