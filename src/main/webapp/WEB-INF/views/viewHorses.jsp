<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
     <style><%@include file="/WEB-INF/includes/style.css"%>
     <%@include file="/WEB-INF/includes/dataTable.css"%>
     </style>
     <script src=https://code.jquery.com/jquery-3.6.0.min.js></script>
     <script type="text/javascript" src="resources/basic.js" ></script>
    <body>
    <div align="center">
    <h1>Horses in ${race.name} ${buttons.get(0)} ${buttons.get(1)}</h1>
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




<div class="feat">
    <table id = "mytable3" border="1" cellpadding="5" hidden>
    <thead>
    <tr>
        <th>Post Position </th>
    	<th>Name</th>
    	<th>Gender</th>
    	<th>FoalYear </th>
    	<th>Owner </th>
    	<th>Trainer </th>
    	<th>Comments </th>
    	<th>Pick Horse!</th>
    	<th>Action</th>



    </tr>
    </thead>
    <tbody>
    		<c:forEach items="${horses}" var="c" varStatus="status">

                         <tr>
                             <td>${c.post}</td>
                       		 <td><a href="viewRaceHorse?id=${c.id}"> ${c.name} </a></td>
                       		 <td>${c.gender}</td>
                       		 <td>${c.foalyear}</td>
                       		 <td>${c.owner}</td>
                       		 <td>${c.trainer}</td>
                       		 <td>${c.comments} </td>
                       		 <td>

                       		 <a href="choseRaceHorse?hID=${c.id}&rID=${race.id}"><button type="button" ${c.setButton(c.chosen)}> ${c.chosen}</button></a>





                       		 </td>


                               <td>


                                                   		   <a href="deleteHorseFromRace?hID=${c.id}&rID=${race.id}">Delete</a>


                                                   		  </td>

                                      </tr>

                         </tr>
                      </c:forEach>
          </tbody>
    </table>
</div>

<a href="addHorseToRace?id=${race.id}">Add a Horse to ${race.name}</a>






    </div>
    <%@ include file="/WEB-INF/includes/footerNonAbs.jsp" %>
    </body>
</html>