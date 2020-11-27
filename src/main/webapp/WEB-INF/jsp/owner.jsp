<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AutoStore Admin</title>
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
<h1>Srinivasa Auto Stores</h1>
<body>
<a class="button" href="/admin/employee/list">Employee List</a><br>
<br>
<a class="button" href="/admin/expenses/list">Expenses List</a><br>
<br>
<a class="button" href="/admin/Login/list"> Login List</a><br>
<br>
<a class="button" href="/admin/wage/list">List Wages</a><br>
<br>
<a class="button" href="/">Home</a><br>
</body>
</div>
</html>