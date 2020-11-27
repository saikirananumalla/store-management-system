<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>supplies Form</title>
</head>
<h1>Add Supplies</h1>
<body>
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
 <spring:url value="/supplies/addpost" var="saveURL" />
 <form:form modelAttribute="suppliesForm" method="post" action="${saveURL }" >
 <form:hidden path="sid" />
 <form:hidden path="InvoiceId" />
  <table>
   <tr>
    <td>itemId: </td>
    <td>
     <form:input path="itemId"/>
    </td>
   </tr>
   <tr>
    <td>quantity: </td>
    <td>
     <form:input path="quantity"/>
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
  
 </form:form>
  <h1>Recent Supplies List</h1>
 <table width="100%" border="1">
  <tr>
   <th>ID</th>
   <th>ItemId</th>
    <th>Quantity</th>
   <th colspan="2">Action</th>
  </tr>
  <c:forEach items="${listsupplies }" var="supplies" >
   <tr>
    <td>${supplies.sid }</td>
    <td>${supplies.itemId }</td>
    <td>${supplies.quantity }</td>
    <td>
     <spring:url value="/supplies/delete/${supplies.sid }" var="deleteURL" />
     <a href="${deleteURL }">Delete</a>
    </td>
   </tr>    
  </c:forEach>
 </table>
</body>
<br><a href="/">Home</a>
</html>