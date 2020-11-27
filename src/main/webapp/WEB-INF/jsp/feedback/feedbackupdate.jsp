<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>feedback Form</title>
</head>
<h1>Update Feedback</h1>
<body>
 <spring:url value="/feedback/save" var="saveURL" />
 <form:form modelAttribute="feedbackForm" method="post" action="${saveURL }" >
 <form:hidden path="id" />
  <table>
   <tr>
    <td>customer-Id: </td>
    <td>
     <form:input path="custId"/>
    </td>
   </tr>
   <tr>
    <td>Date: </td>
    <td>
     <form:input path="date"/>
    </td>
   </tr>
   <tr>
    <td>remarks: </td>
    <td>
     <form:input path="remarks"/>
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