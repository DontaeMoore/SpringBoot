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
    <body>
    <div align="center">
    <h1>Reset Password Page</h1>
    <%@ include file="/WEB-INF/includes/mainHeader.jsp" %>



         <p>${forgotConfirm}</p>






          <form:form action="saveForget" method="post" modelAttribute="forgot">
                        <table cellpadding="5">


                                                 <tr>
                                                 <td>Enter Email:</td>
                                                 <td><form:input path="email"/></td>
                                                 </tr>

                                                 <tr>
                                                 <td colspan="2" align="center"><input type="submit" value="Send Password to email"/></td>
                                                 </tr>




                                                 </table>
                                   </form:form>



    </div>
    <%@ include file="/WEB-INF/includes/footer.jsp" %>
    </body>
</html>