<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>employee Page</title>
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
 <spring:url value="/admin/employee/add" var="addURL" />
 <a href="${addURL }">Add employee</a>

 <h1>employees List</h1>
 <table width="100%" border="1">
  <tr>
   <th>ID</th>
   <th>Name</th>
   <th>Dob</th>
   <th>Address</th>
   <th>Aadhar</th>
   <th>Wage</th>
   <th>Phone</th>
   <th>Type</th>
   <th colspan="2">Action</th>
  </tr>
  <c:forEach items="${listemployee }" var="employee" >
   <tr>
    <td>${employee.id }</td>
    <td>${employee.name}</td>
    <td>${employee.dob }</td>
    <td>${employee.address }</td>
    <td>${employee.aadhar }</td>
    <td>${employee.wagepermonth }</td>
    <td>${employee.phone }</td>
    <td>${employee.type }</td>
    <td>
     <spring:url value="/admin/employee/update/${employee.id }" var="updateURL" />
     <a href="${updateURL }">Update</a>
    </td>
    <td>
     <spring:url value="/admin/employee/delete/${employee.id }" var="deleteURL" />
     <a href="${deleteURL }">Delete</a>
    </td>
   </tr>    
  </c:forEach>
 </table>
 <br>
<button> <a href="/admin">Admin Page</a></button>
</body>
</html>