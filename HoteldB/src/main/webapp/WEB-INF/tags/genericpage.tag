<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>HMsupportt</title>
    <link rel="stylesheet" type=¨text/css¨ href=¨src/main/resources/static/css/bootstrap-cerulean.min.css"/>
    <link rel="stylesheet" type=¨text/css¨ href=¨src/main/resources/static/css/navItem.css"/>
    <link rel="stylesheet" type=¨text/css¨ href=¨src/main/resources/static/css/font-awesome.min.css"/>
    <link rel="stylesheet" type=¨text/css¨ href=¨src/main/resources/static/css/jquery.dataTables.min.css"/>
    <link rel="stylesheet" type=¨text/css¨ href=¨src/main/resources/static/css/dataTables.fontAwesome.css') }}"/>
    <link rel="stylesheet" type=¨text/css¨ href=¨src/main/resources/static/css/breadcrumb.css"/>
    <link rel="stylesheet" type=¨text/css¨ href=¨src/main/resources/static/css/graph.css"/>
    <link rel="stylesheet" type=¨text/css¨ href=¨src/main/resources/static/css/chosen.css"/>
    <link rel="stylesheet" type=¨text/css¨ href=¨src/main/resources/static/css/chosen-bootstrap.css"/>
    <link rel="stylesheet" type=¨text/css¨ href=¨src/main/resources/static/css/daterangepicker.css"/>
    <link rel="stylesheet" type=¨text/css¨ href=¨src/main/resources/static/css/main.css"/>
    <link rel="stylesheet" type=¨text/css¨ href=¨src/main/resources/static/css/metrotiles.css"/>
    <link rel="stylesheet" type=¨text/css¨ href=¨src/main/resources/static/css/badgets_labels.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
  <body>
    <div id="pageheader">
      <jsp:invoke fragment="header"/>
      <div class="ftdash_header" >
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="/">
            <span style="font-size:1.65rem;">HMsupport</span> </a>
              <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation" style="">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarColor01">
    <ul class="navbar-nav ml-auto">
         <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle"  id="cmdbDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fa fa-cloud"></i> Customer
            </a>
            <div class="dropdown-menu" aria-labelledby="cmdbDropdown">
                <a class="dropdown-item" href="addCustomerTemplate"><i class="fa fa-cloud"></i> Add New</a>
                <a class="dropdown-item" href="currentCustomers"><i class="fa fa-building"></i> GetCurrentCustomers</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="allCustomers"><i class="fa fa-server"></i> GetAllCustomers</a>
            </div>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="cmdbDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fa fa-cloud"></i> ManageMenu
            </a>
            <div class="dropdown-menu" aria-labelledby="cmdbDropdown">
                <a class="dropdown-item" href="addOrderItemsTemplate"><i class="fa fa-cloud"></i> Add MenuItem</a>
                <a class="dropdown-item" href="updateOrderItemTemplate"><i class="fa fa-server"></i> Update MenuItem</a>
                
            </div>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="cmdbDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fa fa-cloud"></i> FilterSearch
            </a>
            <div class="dropdown-menu" aria-labelledby="cmdbDropdown">
                <a class="dropdown-item" href="#"><i class="fa fa-cloud"></i>Name</a>
                <a class="dropdown-item" href="#"><i class="fa fa-building"></i>Date </a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#"><i class="fa fa-server"></i> Between Dates</a>
                <a class="dropdown-item" href="#"><i class="fa fa-server"></i> From Date</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#"><i class="fa fa-server"></i> Before Date</a>
            </div>
        </li>	

        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="monitoringDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fa fa-desktop"></i> Analysis
            </a>
            <div class="dropdown-menu" aria-labelledby="monitoringDropdown">
                <a class="dropdown-item" href="#"><i class="fa fa-plus-square"></i> Recently Added</a>
                <a class="dropdown-item" href="#"><i class="fa fa-eye-slash"></i> Not Monitored</a>
                <a class="dropdown-item" href="#"><i class="fa fa-pie-chart"></i> Reports</a>
                <a class="dropdown-item" href="#"><i class="fa fa-pie-chart"></i> List users changes</a>
            </div>
        </li>
        <li>
        <form class="form-inline ml-auto">
      <input class="form-control mr-sm-2" type="search" placeholder="Search table" aria-label="Search">
      <button class="btn btn-primary " type="submit">Search</button>
    </form>
    </li>
              </ul>
              </div>
    </nav>
</div>
<div class="ftdash_content">
    </div>
    <div id="body">
      <jsp:doBody/>
    </div>
    <div id="pagefooter">
      <jsp:invoke fragment="footer"/>
    </div>
  </body>
</html>