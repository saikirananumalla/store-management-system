<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>items Page</title>
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
 <spring:url value="/items/add" var="addURL" />
 <a href="${addURL }">Add items</a>

 <h1>items List</h1>
 <table width="100%" border="1">
  <tr>
   <th>ID</th>
   <th>Name</th>
   <th>Color</th>
   <th>MRP</th>
   <th>quantity</th>
   <th>mech_discount</th>
   <th>brandId</th>
   <th colspan="2">Action</th>
  </tr>
  <c:forEach items="${listitems }" var="items" >
   <tr>
    <td>${items.id }</td>
    <td>${items.name}</td>
    <td>${items.color }</td>
    <td>${items.MRP }</td>
    <td>${items.quantity }</td>
    <td>${items.mech_discount }</td>
    <td>${items.brandId }</td>
    <td>
     <spring:url value="/items/update/${items.id }" var="updateURL" />
     <a href="${updateURL }">Update</a>
    </td>
    <td>
     <spring:url value="/items/delete/${items.id }" var="deleteURL" />
     <a href="${deleteURL }">Delete</a>
    </td>
   </tr>    
  </c:forEach>
 </table>
 <button><a style="text-decoration:none" href="/">Home</a><br></button><br>
</body>
</html>