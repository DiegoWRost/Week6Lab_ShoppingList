<%-- 
    Document   : shoppinglist
    Created on : Feb 17, 2021, 2:28:56 PM
    Author     : Diego Weidle Rost
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        
        <h1>Shopping List</h1>
        <p>Hello <c:out value="${username}"/></p>
        <p><a href="ShoppingList?action=logout">Logout</a></p>
        
        <form action="" method="post">
            <h2>Add Item</h2>
            <input type="text" name="item"> <input type="submit" value="Add Item">
            <input type="hidden" name="action" value="add">
        </form>
        
        <form action="" method="post">
            <c:choose>
                <c:when test="${items.size() == 0}">
                    <p>No items currently in your list</p>
                </c:when>
                <c:otherwise>
                    <ul style="list-style-type: none; padding: 0; margin: 5px;">
                        <c:forEach var="item" items="${items}">
                            <li style="padding: 3px;"><input type="radio" name="item" value="<c:out value='${item}'/>"><c:out value="${item}"/></li>
                        </c:forEach>
                    </ul>
                </c:otherwise>
            </c:choose>
            
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form>
        
        <c:if test="${error}">
            <p>Error: Item cannot be empty</p>
        </c:if>
            
    </body>
</html>
