<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin LogIn</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" id="bootstrap-css">
</head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<body background="black">

<a href="home.html"><img src="/resources/images/logo-nav.png" alt=""></a>

	<div class="container">
    <div class="row">
    <div class="col-sm-4">
			 </div>
		<div class="col-md-4 col-md-offset-4">
    		<div class="panel panel-default">
			  	<div class="panel-heading">
			    	<h3 class="panel-title">Admin LogIn</h3>
			 	</div>
			  	<div class="panel-body">
			    <h3>No existe el user: <c:out value="${user}"></c:out></h3><br>
			    <h3>Con el password: <c:out value="${password}"></c:out></h3>
			   <br><a href="index.jsp" class="btn btn-info" name="vuelve_a_index" role="button">Volver</a>
			    
			<div class="col-sm-4">
			 </div>
		</div>
	</div>
</div>


</body>
</html>