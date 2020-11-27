<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ItemVoucher Form</title>
</head>
<style>
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
  background-color: #4CAF50;
  color: white;
}
</style>
<h1>Items in Voucher Form</h1>
<body>
 <spring:url value="/item_voucher/addpost" var="saveURL" />
 <form:form modelAttribute="item_voucherForm" method="post" action="${saveURL }" >
  <form:hidden path="vid"/>
  <table>
   <tr>
    <td>itemId: </td>
    <td>
     <form:input path="itemId"/>
    </td>
   </tr>
   <tr>
    <td>quantity: </td>
    <td>
     <form:input path="quantity"/>
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
 <a href="/voucher/listy">SHOW BILL</a>
</body>
</html>