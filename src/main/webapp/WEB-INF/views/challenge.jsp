<%@page contentType="text/html" pageEncoding="UTF-8"%>
   <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact ManagerHome</title>
</head>
<body>
<div align="center">
<h1>Derby Challenges</h1>
<%@ include file="/WEB-INF/includes/mainHeader.jsp" %>

<div>


</div>
<a href="horse"><input type="submit" value="Horse Page"/></a>
<a href="race"><input type="submit" value="Races Page"/></a>
 <a href="home"><input type="submit" value="Back"/></a>

<table border="1" cellpadding="5">
<tr>

	<th>Name</th>
	<th>Description</th>
	<th>1st Place </th>
	<th>2nd Place </th>
	<th>3rd Place </th>
	<th>4th Place </th>
	<th>Status</th>

</tr>
		<c:forEach items="${challenge}" var="c" varStatus="status">
         <tr>

       		 <td>${c.name}</td>
       		 <td>${c.desc}</td>
       		 <td>${c.first_points}</td>
       		 <td>${c.second_points}</td>
       		 <td>${c.third_points}</td>
       		 <td>${c.fourth_points}</td>
             <td>${c.status}</td>

         </tr>
      </c:forEach>
</table>


</div>
</body>
</html>