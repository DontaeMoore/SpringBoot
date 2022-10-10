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
    <%@ include file="/WEB-INF/includes/mainHeader.jsp" %>




    <a href="home"><input type="submit" value="Home"/></a>
        <h1>Hello World!</h1>
         <p>This is the Horse Page</p>
         <div>
             <input id="btn" type="button" value="button" />
         </div>
         <input id = "check" type="checkbox" />Enable AutoSave

        <script>
        $(document).ready(function() {

            buttonCheck();
            $('#btn').click(function() {
                yo();
            });
              $('#check').click(function() {
                            yo();
                        });




        });
        </script>




         <p><img src="resources/img/horsepic.jpg"/></p>

            <p>Here is a weather Report from here in Lexington!</p>
         <p> It is ${Weather[0]} Degrees Fahrenheit , With ${Weather[1]}, The wind speed is ${Weather[3]} MPH  </p>


            <img src="${Weather[2]}">

    </div>
    </body>
</html>