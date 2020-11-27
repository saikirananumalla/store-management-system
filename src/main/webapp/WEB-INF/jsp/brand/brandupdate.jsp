<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Brand Form</title>
</head>
<h1>Update Brand Info</h1>
<body>
 <spring:url value="/brand/save" var="saveURL" />
 <form:form modelAttribute="brandForm" method="post" action="${saveURL }" >
  <table>
     <tr>
    <td>id: </td>
    <td>
     <form:input path="id"/>
    </td>
   </tr>
   <tr>
    <td>type: </td>
    <td>
     <form:input path="type"/>
    </td>
   </tr>
   <tr>
    <td>name: </td>
    <td>
     <form:input path="name"/>
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