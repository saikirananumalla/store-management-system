<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>wage Page</title>
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
 <spring:url value="/admin/wage/add" var="addURL" />
 <a href="${addURL }">Add wage</a>

 <h1>Wages List</h1>
 <table width="100%" border="1">
  <tr>
   <th>ID</th>
   <th>Amount</th>
   <th>Date</th>
    <th>EmployeeId</th>
   <th colspan="2">Action</th>
  </tr>
  <c:forEach items="${listwage }" var="wage" >
   <tr>
    <td>${wage.id }</td>
    <td>${wage.amount }</td>
    <td>${wage.date }</td>
    <td>${wage.empId }</td>
    <td>
     <spring:url value="/admin/wage/update/${wage.id }" var="updateURL" />
     <a href="${updateURL }">Update</a>
    </td>
    <td>
     <spring:url value="/admin/wage/delete/${wage.id }" var="deleteURL" />
     <a href="${deleteURL }">Delete</a>
    </td>
   </tr>    
  </c:forEach>
 </table>
 <br>
<button> <a href="/admin">Admin Page</a></button>
</body>
</html>