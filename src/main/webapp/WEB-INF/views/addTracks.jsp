<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   
<%@ taglib uri ="http://www.springframework.org/tags/form" prefix="form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New/Edit Tracks</title>
    </head>
    <body>
    <script type="text/javascript" src="resources/TrackFunctions.js" ></script>
    <script src=https://code.jquery.com/jquery-3.6.0.min.js></script>
     <div align="center">
        <%@ include file="/WEB-INF/includes/mainHeader.jsp" %>

        </div>
   
        <div align="center">
        <h1>New/Edit Track</h1>
        <form:form action="save" method="post" modelAttribute="track">
        <table cellpadding="5">
        <form:hidden path="id" />
        <tr>
                                 <td>
                                <input type="checkbox" ${checkbox}  onclick="ToggleCheck()"  id = "remember"  ${checkValue} />Enable AutoSave
                                </td>
                                </tr>


        <tr>
        <td>Name:</td>
        <td><form:input path="name" onchange="checkName(track.name)"/></td>
        </tr>
        
         <tr>
        <td>City:</td>
        <td><form:input path="city" onchange="checkCity(track.city)"/></td>
        </tr>
        
         <tr>
        <td>State:</td>
        <td><form:input path="state" maxlength="2" onchange="checkState(track.state)"/></td>
        </tr>
        
         <tr>
        <td>Zip:</td>
        <td><form:input path="zip" onchange="checkZip(track.zip)"/></td>
        </tr>
        
         <tr>
        <td>Ownership:</td>
        <td><form:input path="ownership" onchange="checkOwner(track.ownership)"/></td>
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
