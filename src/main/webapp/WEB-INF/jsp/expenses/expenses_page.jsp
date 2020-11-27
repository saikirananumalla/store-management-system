<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>expenses Page</title>
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
<h1>Expenses Info</h1>
<body>
 <spring:url value="/admin/expenses/add" var="addURL" />
 <a href="${addURL }">Add expenses</a>

 <h1>expensess List</h1>
 <table width="100%" border="1">
  <tr>
   <th>ID</th>
   <th>Type</th>
   <th>Date</th>
    <th>Amount</th>
   <th colspan="2">Action</th>
  </tr>
  <c:forEach items="${listexpenses }" var="expenses" >
   <tr>
    <td>${expenses.id }</td>
    <td>${expenses.type }</td>
    <td>${expenses.date }</td>
    <td>${expenses.amount }</td>
    <td>
     <spring:url value="/admin/expenses/update/${expenses.id }" var="updateURL" />
     <a href="${updateURL }">Update</a>
    </td>
    <td>
     <spring:url value="/admin/expenses/delete/${expenses.id }" var="deleteURL" />
     <a href="${deleteURL }">Delete</a>
    </td>
   </tr>    
  </c:forEach>
 </table>
 <br>
<button> <a href="/admin">Admin Page</a></button>
</body>
</html>