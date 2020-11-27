<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>voucher Form</title>
</head>
<h1>Enter Buyer's Information</h1>
<p>Enter CustId when selling to a customer and MechId for mechanic.When Selling to Mech leave CustId blank and vice-versa</p>
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
.button {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 14px;
  margin: 3px 3px;
  cursor: pointer;
}
</style>
<body>
 <spring:url value="/voucher/addpost" var="saveURL" />
 <form:form modelAttribute="voucherForm" method="post" action="${saveURL }" >
 <form:hidden path="id" />
 <form:hidden path="date" />
 <form:hidden path="total" />
 <form:hidden path="discount" />
 <form:hidden path="netamount" />
  <table>
   <tr>
    <td>CustId: </td>
    <td>
     <form:input path="custId"/>
    </td>
   </tr>
   <tr>
    <td>mechId: </td>
    <td>
     <form:input path="mechId"/>
    </td>
   </tr>
   <tr>
    <td>empId: </td>
    <td>
     <form:input path="empId"/>
    </td>
   </tr>
   <tr>
   <tr>
    <td></td>
    <td>
     <button type="submit">Save</button>
    </td>
   </tr>
  </table>
  
 </form:form><br>
<a href="/customer/add" class="button">Add Customer</a><br>
<h1>Recently Added Customers</h1>
 <table width="100%" border="1">
  <tr>
   <th>ID</th>
   <th>Name</th>
   <th>Phone</th>
    <th>Address</th>
  </tr>
  <c:forEach items="${listcustomer }" var="customer" >
   <tr>
    <td>${customer.id }</td>
    <td>${customer.name }</td>
    <td>${customer.phone }</td>
    <td>${customer.address }</td>
   </tr>    
  </c:forEach>
 </table>
</body>
<br><button><a href="/" class="button">Home</a><br></button>
</html>