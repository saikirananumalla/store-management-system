<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>payment Page</title>
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
 <spring:url value="/payment/add" var="addURL" />
 <a href="${addURL }">Add payment</a>

 <h1>Payments List</h1>
 <table width="100%" border="1">
  <tr>
   <th>PaymentID</th>
   <th>BankName</th>
   <th>amount</th>
   <th>Date</th>
   <th>Mode</th>
   <th>distrId</th>
   <th colspan="2">Action</th>
  </tr>
  <c:forEach items="${listpayment }" var="payment" >
   <tr>
    <td>${payment.pid }</td>
    <td>${payment.bank_name}</td>
    <td>${payment.amount }</td>
    <td>${payment.date }</td>
    <td>${payment.mode }</td>
    <td>${payment.distrId }</td>
    <td>
     <spring:url value="/payment/update/${payment.pid }" var="updateURL" />
     <a href="${updateURL }">Update</a>
    </td>
    <td>
     <spring:url value="/payment/delete/${payment.pid }" var="deleteURL" />
     <a href="${deleteURL }">Delete</a>
    </td>
   </tr>    
  </c:forEach>
 </table>
 <br>
  <a href="/distributor/list">Distributor List</a><br>
 <br>
 <br>
<button><a href="/">Home</a></button>
</body>
</html>