<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@ include file="/WEB-INF/includes/mainHeader.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Hello World!</h1>
         <p>This is the Horse Page</p>
         <img src="resources/img/horsepic.jpg">
         <a href="home"><input type="submit" value="Back"/></a>
            <p>Here is a weather Report from here in Lexington!</p>
         <p> It is ${Weather[0]} Degrees Fahrenheit , With ${Weather[1]}, The wind speed is ${Weather[3]} MPH  </p>


            <img src="resources/img/icons/${Weather[2]}.png">


    </body>
</html>