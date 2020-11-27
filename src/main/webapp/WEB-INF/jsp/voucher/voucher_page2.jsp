<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>voucher Page</title>
</head>
<style>
table {
  border-collapse: collapse;
  width: 100%;
}

th {
  text-align: left;
  padding: 1px;
}
td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
  background-color: #4CAF50;
  color: white;
}
</style>
<body>
 <h1>Bill Details</h1>
 <table width="100%" border="1">
 <c:forEach items="${listvoucher }" var="voucher" >
  <tr>
   <th>ID</th>
   <td>${voucher.id }</td>
   </tr>
   <tr>
   <th>Date</th>
   <td>${voucher.date }</td>
   </tr>
   <tr>
   <th>Total</th>
   <td>${voucher.total }</td>
   </tr>
   <tr>
   <th>Discount</th>
     <td>${voucher.discount }</td>
     </tr>
   <tr>
   <th>Netamount</th>
   <td>${voucher.netamount }</td>
   </tr>
   <tr>
    <th>custId</th>
    <td>${voucher.custId }</td>
    </tr>
    <tr>
   <th>mechId</th>
   <td>${voucher.mechId }</td>
   </tr>
   <tr>
   <th>empId</th>
    <td>${voucher.empId }</td>
    </tr>
    <tr>
   <th colspan="1">Action</th>
   <td>
     <spring:url value="/item_voucher/additems/${voucher.id }" var="addyURL" />
     <a href="${addyURL }">ADD ITEMS</a>
    </td>
  </tr>
    </c:forEach>
    

 </table>
 <a href="/">Home</a>
</body>
</html>