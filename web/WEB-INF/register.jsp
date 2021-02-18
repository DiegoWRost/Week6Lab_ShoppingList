<%-- 
    Document   : register
    Created on : Feb 17, 2021, 2:28:33 PM
    Author     : Diego Weidle Rost
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        
        <form action="ShoppingList" method="post">
            Username: <input type="text" name="username">
            <input type="hidden" name="action" value="register">
            <input type="submit" value="Register">
        </form>
            
        <p>${message}</p>
    </body>
</html>