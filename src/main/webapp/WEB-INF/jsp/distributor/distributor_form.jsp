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

<style>
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
.button {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 14px;
  margin: 3px 3px;
  cursor: pointer;
}
</style>
<body>
<div align="center">
<h1>Enter Distributor Info</h1>
 <spring:url value="/distributor/addpost" var="saveURL" />
 <form:form modelAttribute="distributorForm" method="post" action="${saveURL }" >
 <form:hidden path="id" />
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
  <form>
  <input type="button" class="button" value="Go back!" onclick="history.back()">
</form>
</div>
</body>
</html>