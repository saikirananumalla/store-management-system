<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>invoice Page</title>
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
 <spring:url value="/invoice/add" var="addURL" />
 <a href="${addURL }">Add invoice</a>

 <h1>Invoices List</h1>
 <table width="100%" border="1">
  <tr>
   <th>ID</th>
   <th>date</th>
   <th>amount</th>
   <th>delivery_charge</th>
   <th>delivery_by</th>
   <th>distrId</th>
   <th colspan="2">Action</th>
  </tr>
  <c:forEach items="${listinvoice }" var="invoice" >
   <tr>
    <td>${invoice.id }</td>
    <td>${invoice.date }</td>
    <td>${invoice.amount }</td>
    <td>${invoice.delivery_charge }</td>
    <td>${invoice.delivery_by }</td>
    <td>${invoice.distrId }</td>
    <td>
     <spring:url value="/invoice/update/${invoice.id }" var="updateURL" />
     <a href="${updateURL }">Update</a>
    </td>
    <td>
     <spring:url value="/invoice/delete/${invoice.id }" var="deleteURL" />
     <a href="${deleteURL }">Delete</a>
    </td>
   </tr>    
  </c:forEach>
 </table>
 
</body>
</html>