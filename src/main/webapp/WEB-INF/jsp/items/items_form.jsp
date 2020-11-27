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
  align:center;
}
</style>
<div align="center">
<h1>Enter Items Details</h1>
<body>
 <spring:url value="/items/addpost" var="saveURL" />
 <form:form modelAttribute="itemsForm" method="post" action="${saveURL }" >
 
  <table>
<tr>
    <td>id: </td>
    <td>
     <form:input path="id"/>
    </td>
   </tr>
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
 <a href="/" class="button">Home</a>
</body>
</div>
</html>