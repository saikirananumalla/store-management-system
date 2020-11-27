<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>customer Page</title>
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
.button {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 14px;
  margin: 3px 3px;
  cursor: pointer;
}
</style>
<body>
 <spring:url value="/customer/add" var="addURL" />
 <a href="${addURL }" class="button">Add customer</a>

 <h1>Customers List</h1>
 <table width="100%" border="1">
  <tr>
   <th>ID</th>
   <th>Name</th>
   <th>Phone</th>
    <th>Address</th>
   <th colspan="2">Action</th>
  </tr>
  <c:forEach items="${listcustomer }" var="customer" >
   <tr>
    <td>${customer.id }</td>
    <td>${customer.name }</td>
    <td>${customer.phone }</td>
    <td>${customer.address }</td>
    <td>
     <spring:url value="/customer/update/${customer.id }" var="updateURL" />
     <a href="${updateURL }">Update</a>
    </td>
    <td>
     <spring:url value="/customer/delete/${customer.id }" var="deleteURL" />
     <a href="${deleteURL }">Delete</a>
    </td>
   </tr>    
  </c:forEach>
 </table>
<button><a href="/" class="button">Home</a></button>
</body>
</html>