<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>distributor Form</title>
</head>
<h1>Update Distributor Details</h1>
<body>
 <spring:url value="/distributor/save" var="saveURL" />
 <form:form modelAttribute="distributorForm" method="post" action="${saveURL }" >
 <form:hidden path="id"/>
  <table>
   <tr>
    <td>gstin: </td>
    <td>
     <form:input path="GSTIN"/>
    </td>
   </tr>
   <tr>
    <td>name: </td>
    <td>
     <form:input path="name"/>
    </td>
   </tr>
  <tr>
    <td>paymentpending: </td>
    <td>
     <form:input path="payment_pending"/>
    </td>
   </tr>
   <tr>
    <td>firm_name: </td>
    <td>
     <form:input path="firm_name"/>
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
    <td>startdate: </td>
    <td>
     <form:input path="startdate"/>
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