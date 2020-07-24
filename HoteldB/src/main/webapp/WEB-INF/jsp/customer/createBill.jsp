<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<body>
<h1>WELCOME!!</h1>
<br>
<br>
<br>

<div class = "offset-md-2 ">
   <div class="card bg-light filterable">  
  
    <table class="table table-striped">
        <thead class="thead-inverse">
        <tr><th>Field</th><th>Value</th></tr>
        </thead>
        <tr><td>Name              </td><td> ${customer.name} </td></tr>
        <tr><td>Table No             </td><td> ${customer.tableNo}</td></tr>
        <tr><td>Order              </td><td>${customer.bill.orderItems}</td></tr>
        <tr><td>Bill				</td><td>${customer.bill.bill}</td></tr>
    </table>
  
   
</form>
  </table>
  </div>
</div>

</body>
</html>
