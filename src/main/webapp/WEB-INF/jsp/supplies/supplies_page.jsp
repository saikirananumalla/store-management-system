<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>supplies Page</title>
</head>
<style>
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
  background-color: #4CAF50;
  color: white;
}
</style>
<body>
 <spring:url value="/supplies/add" var="addURL" />
 <a href="${addURL }">Add supplies</a>

 <h1>Supplies List</h1>
 <table width="100%" border="1">
  <tr>
   <th>ID</th>
   <th>ItemId</th>
    <th>Quantity</th>
   <th colspan="1">Action</th>
  </tr>
  <c:forEach items="${listsupplies }" var="supplies" >
   <tr>
    <td>${supplies.sid }</td>
    <td>${supplies.itemId }</td>
    <td>${supplies.quantity }</td>
    <td>
     <spring:url value="/supplies/delete/${supplies.sid }" var="deleteURL" />
     <a href="${deleteURL }">Delete</a>
    </td>
   </tr>    
  </c:forEach>
 </table>
 <form>
  <input type="button" value="Go back!" onclick="history.back()">
</form>
</body>
<a href="/">Home</a>
</html>