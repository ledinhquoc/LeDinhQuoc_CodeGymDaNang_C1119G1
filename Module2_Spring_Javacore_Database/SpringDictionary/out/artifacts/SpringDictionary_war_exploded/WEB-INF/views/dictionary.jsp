<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2/11/2020
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/dictionary" method="post">
    <label>Vietnamese dictionary</label>
    <br>
    <input type="text" name="word" value="${word}" id="word">
    <input type="submit" value="search" >
</form>
<div>
    <h1>Vietnamese Meaning: ${result}</h1>
</div>
</body>
</html>