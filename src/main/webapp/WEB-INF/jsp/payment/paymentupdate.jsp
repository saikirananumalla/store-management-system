<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Form</title>
</head>
<body>
 <spring:url value="/payment/save" var="saveURL" />
 <form:form modelAttribute="paymentForm" method="post" action="${saveURL }" >
  <table>
<tr>
    <td>pid: </td>
    <td>
     <form:input path="pid"/>
    </td>
   </tr>
   <tr>
    <td>bank_name: </td>
    <td>
     <form:input path="bank_name"/>
    </td>
   </tr>
   <tr>
    <td>amount: </td>
    <td>
     <form:input path="amount"/>
    </td>
   </tr>
  <tr>
    <td>date: </td>
    <td>
     <form:input path="date"/>
    </td>
   </tr>
   <tr>
    <td>mode: </td>
    <td>
     <form:input path="mode"/>
    </td>
   </tr>
   <tr>
    <td>distrId: </td>
    <td>
     <form:input path="distrId"/>
    </td>
   </tr>
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