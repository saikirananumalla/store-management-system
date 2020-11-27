<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>distributor Page</title>
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
 <spring:url value="/distributor/add" var="addURL" />
 <a href="${addURL }">Add distributor</a>

 <h1>Distributors List</h1>
 <table width="100%" border="1">
  <tr>
   <th>ID</th>
   <th>GSTIN</th>
   <th>Name</th>
   <th>Paymentpending</th>
   <th>firm_name</th>
   <th>Phone</th>
   <th>Address</th>
   <th>STARTdate</th>
   <th colspan="2">Action</th>
  </tr>
  <c:forEach items="${listdistributor }" var="distributor" >
   <tr>
    <td>${distributor.id }</td>
    <td>${distributor.GSTIN }</td>
    <td>${distributor.name }</td>
    <td>${distributor.payment_pending }</td>
    <td>${distributor.firm_name }</td>
    <td>${distributor.phone }</td>
    <td>${distributor.address }</td>
    <td>${distributor.startdate }</td>
    <td>
     <spring:url value="/distributor/update/${distributor.id }" var="updateURL" />
     <a href="${updateURL }">Update</a>
    </td>
   </tr>    
  </c:forEach>
 </table>
 
</body>
<br>
<a href="/payment/add">Make Payment</a><br>
 <br>
<br>
<button><a href="/">Home</a></button>

</html>