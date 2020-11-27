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
<h1>Brand And Distributor Info</h1>
<body>
 <spring:url value="/distributorbrand/deletepost" var="saveURL" />
 <form:form modelAttribute="distributorbranddeleteForm" method="post" action="${saveURL }" >
  <table>
     <tr>
    <td>distrId: </td>
    <td>
     <form:input path="distrId"/>
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
    <td></td>
    <td>
     <button type="submit">Save</button>
    </td>
   </tr>
  </table>
  
 </form:form>
 
</body>
</html>