<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Views</title>
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
<h1 style="">Srinivasa Auto Stores</h1>
<body>
<a  href="/invoice/list" class="button">View Invoices</a><br>
<br>
<a href="/voucher/list" class="button">View Vouchers</a><br>
<br>
<a  href="/feedback/list" class="button"> View Feedbacks</a><br>
<br>
<a  href="/payment/list" class="button">View Payments</a><br>
<br>
<a  href="/items/list" class="button">View Items</a><br>
<br>
<a  href="/customer/list" class="button">View Customers</a><br>
<br>
<a  href="/mechanic/list" class="button">View Mechanics</a><br>
<br>
<a  href="/supplies/list" class="button">View Supplies</a><br>
<br>
<a  href="/" class="button">Home</a><br>
<br>
</body>
</div>
</html>