<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>expenses Form</title>
</head>
<h1>Update Expense Info</h1>
<body>
 <spring:url value="/admin/expenses/save" var="saveURL" />
 <form:form modelAttribute="expensesForm" method="post" action="${saveURL }" >
 <form:hidden path="id" />
  <table>
   <tr>
    <td>Type: </td>
    <td>
     <form:input path="type"/>
    </td>
   </tr>
      <tr>
    <td>Date: </td>
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