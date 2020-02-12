<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/11/2019
  Time: 10:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new product</title>
    <style>
        .message{
            color:red;
        }
    </style>
</head>
<body>
<form method="post">
    <fieldset>
        <legend>Search Product By Name</legend>
        <label>Name: </label>
        <input type="text" name="name" id="name">
        <input type="submit" value="Search">
    </fieldset>
</form>
<p>
    <a href="/products">Back to product list</a>
</p>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<table>
    <tr>
        <td>Name: </td>
        <td>${requestScope["product"].getName()}</td>
    </tr>
    <tr>
        <td>Description: </td>
        <td>${requestScope["product"].getDescription()}</td>
    </tr>
    <tr>
        <td>Price: </td>
        <td>${requestScope["product"].getPrice()}</td>
    </tr>
</table>
</body>
</html>