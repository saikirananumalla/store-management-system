<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AutoStoreManager</title>
</head>
<style>
.button {
  background-color: #ddd;
  border: none;
  color: black;
  padding: 6px 10px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 14px;
  margin: 3px 3px;
}
.button:hover{
background-color: #4CAF50;
}
</style>
<div align="center">
<h1 style="">Srinivasa Auto Stores Management</h1>
<body >
<a  href="/invoice/add" class="button">Add Invoice</a><br>
<br>
<a href="/voucher/add" class="button">Sell Items</a><br>
<br>
<a  href="/distributor/list" class="button"> Distributor List</a><br>
<br>
<a  href="/payment/add" class="button">Pay To Distributor</a><br>
<br>
<a  href="/feedback/add" class="button">Feedback</a><br>
<br>
<a  href="/distributorbrand/list" class="button">Distributor's Brands</a><br>
<br>
<a  href="/brand/list" class="button">Brands Info</a><br>
<br>
<a  href="/items/list" class="button">Items Info</a><br>
<br>
<a  href="/views" class="button">Other Info</a><br>
<br>
<a  href="/logout" class="button">LogOut</a><br>
<br>
</body>
</div>
</html>