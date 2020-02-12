<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2/4/2020
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Customer" %>
<html>
  <head>
    <title>Danh Sach Khach Hang</title>
    <meta charset= "utf-8">
    <meta name="viewport" content="width = device-width, initial-scale = 1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

  </head>
  <body>

  <%
    List<Customer> list = Customer.getCustomer();
    request.setAttribute("abc", list);
          %>
  <div class="container">
    <h2>Danh sach khach hang</h2>
    <table class="table table-success table-hover">
        <thead>
        <tr>
          <th>Họ Tên</th>
          <th>Ngày Sinh</th>
          <th>Địa Chỉ</th>
          <th>Hình Ảnh</th>
        </tr>
        </thead>
      <tbody>
      <c:forEach var="cus" items="${abc}">
      <tr>
        <td><c:out value="${cus.name}"/> </td>
        <td><c:out value="${cus.birthday}"/> </td>
        <td><c:out value="${cus.address}"/> </td>
        <td><img src="static/123.png" class="img-repository"></td>
      </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>

  <h1>Simple Calculator</h1>
  <form method="post" action="/calculate">
  <fieldset>
    <legend>Calculator</legend>
    <table>
      <tr>
        <td>First operand: </td>
        <td><input type="text" name="first-operand"></td>
      </tr>
      <tr>
        <td>Operator: </td>
        <td><select name="operator">
          <option value="+">Addition</option>
          <option value="-">Subtraction</option>
          <option value="*">multiplication</option>
          <option value="/">division</option>
        </select>
        </td>
      </tr>
      <tr>
        <td>Second Operator</td>
        <td><input type="text" name="second-operand"></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="Calculate"></td>
      </tr>
    </table>
  </fieldset>
  </form>
  </body>
</html>
