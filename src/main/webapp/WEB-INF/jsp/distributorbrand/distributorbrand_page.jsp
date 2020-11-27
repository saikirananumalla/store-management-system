<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>DistrBrand Page</title>
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
<body>
 <spring:url value="/distributorbrand/add" var="addURL" />
 <a href="${addURL }">Add DistrBrand</a>

 <h1>DistributorBrands List</h1>
 <table width="100%" border="1">
  <tr>
   <th>BrandID</th>
   <th>DistrId</th>
  </tr>
  <c:forEach items="${listdistributorbrand }" var="distributorbrand" >
   <tr>
    <td>${distributorbrand.brandId }</td>
    <td>${distributorbrand.distrId }</td>
   </tr>    
  </c:forEach>
 </table>
 <button><a style="text-decoration:none" href="/">Home</a><br></button><br>
</body>
</html>