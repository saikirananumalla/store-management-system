<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>Brand Page</title>
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
 <spring:url value="/brand/add" var="addURL" />
 <a href="${addURL }" class="button">Add Brand</a>

 <h1>Brands List</h1>
 <table width="100%" border="1">
  <tr>
   <th>ID</th>
   <th>Type</th>
   <th>Name</th>
   <th colspan="1">Action</th>
  </tr>
  <c:forEach items="${listbrand }" var="brand" >
   <tr>
    <td>${brand.id }</td>
    <td>${brand.type }</td>
    <td>${brand.name }</td>
    <td>
     <spring:url value="/brand/update/${brand.id }" var="updateURL" />
     <a href="${updateURL }">Update</a>
    </td>
   </tr>    
  </c:forEach>
 </table>
 <button><a class="button" href="/">Home</a><br></button><br>
</body>
</html>