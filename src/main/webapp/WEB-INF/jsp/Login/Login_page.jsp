<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>Login Page</title>
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
 <spring:url value="/admin/Login/add" var="addURL" />
 <a href="${addURL }">Add Login</a>

 <h1>Logins List</h1>
 <table width="100%" border="1">
  <tr>
   <th>EmpID</th>
   <th>Password</th>
   <th colspan="2">Action</th>
  </tr>
  <c:forEach items="${listLogin }" var="Login" >
   <tr>
    <td>${Login.empId }</td>
    <td>${Login.password }</td>
    <td>
     <spring:url value="/admin/Login/update/${Login.empId }" var="updateURL" />
     <a href="${updateURL }">Update</a>
    </td>
    <td>
     <spring:url value="/admin/Login/delete/${Login.empId }" var="deleteURL" />
     <a href="${deleteURL }">Delete</a>
    </td>
   </tr>    
  </c:forEach>
 </table>
 <br>
<button> <a href="/admin">Admin Page</a></button>
</body>
</html>