<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>supplies Form</title>
</head>
<h1>Update Supply Details</h1>
<body>
 <spring:url value="/supplies/save" var="saveURL" />
 <form:form modelAttribute="suppliesForm" method="post" action="${saveURL }" >
 <form:hidden path="sid" />
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
    <td>InvoiceId: </td>
    <td>
     <form:input path="InvoiceId"/>
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
 <form>
  <input type="button" value="Go back!" onclick="history.back()">
</form>
</body>
</html>