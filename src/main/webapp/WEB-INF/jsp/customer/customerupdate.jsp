<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>customer Form</title>
</head>
<h1>Update Customer Details</h1>
<body>
 <spring:url value="/customer/save" var="saveURL" />
 <form:form modelAttribute="customerForm" method="post" action="${saveURL }" >
 <form:hidden path="id" />
  <table>
   <tr>
    <td>name: </td>
    <td>
     <form:input path="name"/>
    </td>
   </tr>
   <tr>
    <td>phone: </td>
    <td>
     <form:input path="phone"/>
    </td>
   </tr>
   <tr>
    <td>address: </td>
    <td>
     <form:input path="address"/>
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
 
</body>
</html>