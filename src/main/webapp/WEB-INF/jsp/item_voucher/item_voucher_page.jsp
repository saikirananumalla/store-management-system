<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>ItemVoucherBrand Page</title>
</head>
<body>
 <spring:url value="/item_voucher/add" var="addURL" />
 <a href="${addURL }">Add ItemVoucherBrand</a>

 <h1>item_vouchers List</h1>
 <table width="100%" border="1">
  <tr>
   <th>VoucherID</th>
   <th>ItemId</th>
   <th>Quantity</th>
  </tr>
  <c:forEach items="${listitem_voucher }" var="item_voucher" >
   <tr>
    <td>${item_voucher.vid }</td>
    <td>${item_voucher.itemId }</td>
    <td>${item_voucher.quantity }</td>
   </tr>    
  </c:forEach>
 </table>
 
</body>
</html>