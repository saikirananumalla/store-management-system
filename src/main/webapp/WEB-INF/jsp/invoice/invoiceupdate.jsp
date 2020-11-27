<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Invoice Form</title>
</head>
<h1>Update Invoice Details</h1>
<body>
 <spring:url value="/invoice/save" var="saveURL" />
 <form:form modelAttribute="invoiceForm" method="post" action="${saveURL }" >
 <form:hidden path="id" />
  <table>
   <tr>
    <td>date: </td>
    <td>
     <form:input path="date"/>
    </td>
   </tr>
   <tr>
    <td>amount: </td>
    <td>
     <form:input path="amount"/>
    </td>
   </tr>
   <tr>
    <td>delivery_charge: </td>
    <td>
     <form:input path="delivery_charge"/>
    </td>
   </tr>
      <tr>
    <td>delivery_by: </td>
    <td>
     <form:input path="delivery_by"/>
    </td>
   </tr>
   <tr>
    <td>distrId: </td>
    <td>
     <form:input path="distrId"/>
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