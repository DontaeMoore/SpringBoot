<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

   <%@ taglib uri ="http://www.springframework.org/tags/form" prefix="form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
     <style><%@include file="/WEB-INF/includes/style.css"%></style>
     <script src=https://code.jquery.com/jquery-3.6.0.min.js></script>
     <script type="text/javascript" src="resources/basic.js" ></script>
    <body>
    <div align="center">
    <h1>Add Horse To ${race.name}</h1>
    <%@ include file="/WEB-INF/includes/mainHeader.jsp" %>

      <form:form action="saveHorseToRace?rID=${race.id}" method="post" modelAttribute="horsePick">
              <table cellpadding="5">







                                <tr>
                               <td>All Horses Not Associated with ${race.name}  </td>
                               <td><form:select path="id">
                               <c:forEach items="${race.getRh()}" var="c" varStatus="status">
                               <c:set var="index" value="${status.index}" />
                              <form:option value="${race.hIDs.get(index)}" label="${race.rh.get(index)}"/>
                                </c:forEach>
                               </form:select>
                               </td>
                               </tr>

                              <tr>
                              <td>All Avaliable post positions in ${race.name}:</td>
                              <td><form:select path="post">
                              <form:options items="${race.getPostPositions()}"></form:options>
                              </form:select>
                              </td>
                              </tr>

              <tr>
              <td colspan="2" align="center"><input type="submit" value="Save"/></td>
              </tr>

              </table>
              </form:form>

    </div>
    <%@ include file="/WEB-INF/includes/footer.jsp" %>
    </body>
</html>