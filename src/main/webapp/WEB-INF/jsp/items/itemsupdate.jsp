<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>items Form</title>
</head>
<h1>Update Item Details</h1>
<body>
 <spring:url value="/items/save" var="saveURL" />
 <form:form modelAttribute="itemsForm" method="post" action="${saveURL }" >
 <form:hidden path="id"/>
  <table>
   <tr>
    <td>name: </td>
    <td>
     <form:input path="name"/>
    </td>
   </tr>
   <tr>
    <td>color: </td>
    <td>
     <form:input path="color"/>
    </td>
   </tr>
  <tr>
    <td>MRP: </td>
    <td>
     <form:input path="MRP"/>
    </td>
   </tr>
   <tr>
    <td>quantity: </td>
    <td>
     <form:input path="quantity"/>
    </td>
   </tr>
   <tr>
    <td>mech_discount: </td>
    <td>
     <form:input path="mech_discount"/>
    </td>
   </tr>
   <tr>
    <td>brandId: </td>
    <td>
     <form:input path="brandId"/>
    </td>
   </tr>
   <tr>
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