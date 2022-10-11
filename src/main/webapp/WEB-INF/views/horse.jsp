<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

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
    <h1>Horse Page</h1>
    <%@ include file="/WEB-INF/includes/mainHeader.jsp" %>

         <p><img src="resources/img/horsepic.jpg"/></p>

            <p>Here is a weather Report from here in Lexington!</p>
         <p> It is ${Weather[0]} Degrees Fahrenheit , With ${Weather[1]}, The wind speed is ${Weather[3]} MPH  </p>


            <img src="${Weather[2]}">

    </div>
    <%@ include file="/WEB-INF/includes/footer.jsp" %>
    </body>
</html>