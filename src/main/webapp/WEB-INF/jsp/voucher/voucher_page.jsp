<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>voucher Page</title>
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
 <spring:url value="/voucher/add" var="addURL" />
 <a href="${addURL }">Add voucher</a>

 <h1>vouchers List</h1>
 <table width="100%" border="1">
  <tr>
   <th>ID</th>
   <th>Date</th>
   <th>Total</th>
   <th>Discount</th>
   <th>Netamount</th>
    <th>custId</th>
   <th>mechId</th>
   <th>empId</th>
   <th colspan="2">Action</th>
  </tr>
  <c:forEach items="${listvoucher }" var="voucher" >
   <tr>
    <td>${voucher.id }</td>
    <td>${voucher.date }</td>
    <td>${voucher.total }</td>
    <td>${voucher.discount }</td>
    <td>${voucher.netamount }</td>
    <td>${voucher.custId }</td>
    <td>${voucher.mechId }</td>
    <td>${voucher.empId }</td>
    <td>
     <spring:url value="/voucher/update/${voucher.id }" var="updateURL" />
     <a href="${updateURL }">Update</a>
    </td>
    <td>
     <spring:url value="/voucher/delete/${voucher.id }" var="deleteURL" />
     <a href="${deleteURL }">Delete</a>
    </td>
   </tr>    
  </c:forEach>
 </table>
 
</body>
<a href="/">Home</a>
</html>