<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>voucher Form</title>
</head>
<body>
 <spring:url value="/voucher/save" var="saveURL" />
 <form:form modelAttribute="voucherForm" method="post" action="${saveURL }" >
 <form:hidden path="id" />
  <table>
   <tr>
    <td>date: </td>
    <td>
     <form:input path="date"/>
    </td>
   </tr>
  <tr>
    <td>total: </td>
    <td>
     <form:input path="total"/>
    </td>
   </tr>
   <tr>
    <td>discount: </td>
    <td>
     <form:input path="discount"/>
    </td>
   </tr>
      <tr>
    <td>netamount: </td>
    <td>
     <form:input path="netamount"/>
    </td>
   </tr>
   <tr>
    <td>custId: </td>
    <td>
     <form:input path="custId"/>
    </td>
   </tr>
   <tr>
    <td>mechId: </td>
    <td>
     <form:input path="mechId"/>
    </td>
   </tr>
   <tr>
    <td>empId: </td>
    <td>
     <form:input path="empId"/>
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