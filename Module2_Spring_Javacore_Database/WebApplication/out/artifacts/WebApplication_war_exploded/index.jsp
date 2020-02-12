<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2/3/2020
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <style>
      #content{
        width:450px;
        margin: 0 auto;
        padding: 0px 20px 20px;
        background: white;
        border: solid navy 2px;
      }
      label{
        width: 10em;
        padding-right: 1em;
        float: left;
      }
      #data input{
        float: left;
        width: 15em;
        margin-bottom: .5em;
      }
    </style>
  </head>
  <body>
  <div id="content">
    <h1>Product Discount Calculator</h1>
    <form action="/calculator" method="post">
      <div id="data">
        <label>Product Description</label>
        <input type="text" name="description">
        <br>
        <label>Price</label>
        <input type="text" name="price">
        <br>
        <label>Discount Percent</label>
        <input type="text" name="discount">
      </div>
      <div>
        <br>
        <input type="submit" value="Discount Product">
      </div>
    </form>
  </div>

  <h2>Bai Login</h2>
  <form method="post" action="/login">
    <div class="login">
      <h2>Login</h2>
      <input type="text" name="username" size="30" placeholder="usename">
      <input type="password" name="password" size="30" placeholder="password">
      <input type="submit" value="Sign in">
    </div>
  </form>

<%--  <h3>Transfer currency ex</h3>--%>
<%--  <form method="post" action="/convert">--%>
<%--    <label>Rate: </label><br/>--%>
<%--    <input type="text" name="rate" placeholder="RATE" value="22000"/><br/>--%>
<%--    <label>USD: </label><br/>--%>
<%--    <input type="text" name="usd" placeholder="USD" value="0"/><br/>--%>
<%--    <input type = "submit" id = "submit" value = "Converter"/>--%>
<%--  </form>--%>

  <h2>Vietnamese Dictionary</h2>
  <form method="post" action="/translate">
    <input type="text" name="txtSearch" placeholder="Enter your word">
    <input type="submit" id="submit" value="Search"/>
  </form>
  </body>
</html>
