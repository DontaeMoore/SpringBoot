<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
    <h1>Add Race To ${challenge.name}</h1>
    <%@ include file="/WEB-INF/includes/mainHeader.jsp" %>

      <form:form action="saveChallengeToRace" method="post" modelAttribute="chalRace">
              <table cellpadding="5">
              <form:hidden path="chal" />




                               <tr>
                              <td>All Races Not In ${challenge.name}:</td>
                              <td><form:select path="racename">
                              <form:options items="${races}"></form:options>
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