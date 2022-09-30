<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
    <h3><a href="editUser">${WelcomeMessage}. Role: ${rolename}</a>&emsp; &emsp;<a href="logout"><input type="submit" value="Logout"/></a> </h3>
    <a href="horse"><input type="submit" value="Horse Page"/></a>
    <a href="race"><input type="submit" value="Races Page"/></a>
    <a href="challenge"><input type="submit" value="Challenge Page"/></a>
    <a href="racehorse"><input type="submit" value="Race Horse Page"/></a>
    <a href="admin"><input type="submit" value="Admin Only Page"/></a>
    </body>
</html>
