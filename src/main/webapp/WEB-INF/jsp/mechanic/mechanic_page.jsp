<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>mechanic Page</title>
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
<h1>Mechanic List</h1>
<body>
 <spring:url value="/mechanic/add" var="addURL" />
 <a href="${addURL }">Add mechanic</a>

 <h1>mechanics List</h1>
 <table width="100%" border="1">
  <tr>
   <th>ID</th>
   <th>Name</th>
   <th>Aadhar</th>
   <th>Phone</th>
   <th>PaymentLeft</th>
    <th>Address</th>
   <th>shopname</th>
   <th colspan="2">Action</th>
  </tr>
  <c:forEach items="${listmechanic }" var="mechanic" >
   <tr>
    <td>${mechanic.id }</td>
    <td>${mechanic.name }</td>
    <td>${mechanic.aadhar }</td>
    <td>${mechanic.phone }</td>
    <td>${mechanic.payment_left }</td>
    <td>${mechanic.address }</td>
    <td>${mechanic.shopname }</td>
    <td>
     <spring:url value="/mechanic/update/${mechanic.id }" var="updateURL" />
     <a href="${updateURL }">Update</a>
    </td>
    <td>
     <spring:url value="/mechanic/delete/${mechanic.id }" var="deleteURL" />
     <a href="${deleteURL }">Delete</a>
    </td>
   </tr>    
  </c:forEach>
 </table>
 
</body>
</html>