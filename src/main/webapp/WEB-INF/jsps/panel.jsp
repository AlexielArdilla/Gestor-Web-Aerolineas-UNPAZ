<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Panel de control</title>

<meta name="description"
	content="Source code generated using layoutit.com">
<meta name="author" content="LayoutIt!">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<spring:url value="/resources/images/img_1.jpg" var="img_1" />
<spring:url value="/resources/images/img_2.jpg" var="img_2" />
<spring:url value="/resources/images/img_3.jpg" var="img_3" />
<style>
/* Make the image fully responsive */
.carousel-inner img {
	width: 100%;
	height: 100%;
}
</style>


</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<nav
					class="navbar navbar-expand-lg navbar-light bg-light navbar-dark bg-dark">

					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="navbar-toggler-icon"></span>
					</button>
					<a class="navbar-brand" href="panel">UNPAZ</a>
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="navbar-nav">
							<li class="nav-item active"><a class="nav-link" href="panel">ABM
									Vuelos <span class="sr-only">(current)</span>
							</a></li>
							<li class="nav-item"><a class="nav-link" href="logOut">Log-out</a></li>
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" href="http://example.com"
								id="navbarDropdownMenuLink" data-toggle="dropdown">Aviones y
									vuelos</a>
								<div class="dropdown-menu"
									aria-labelledby="navbarDropdownMenuLink">
									<a class="dropdown-item" href="getAviones">Ver aviones</a> <a
										class="dropdown-item" href="getVuelos">Ver vuelos</a> <a
										class="dropdown-item" href="getCiudades">Ver ciudades</a>
									<div class="dropdown-divider"></div>
									<a class="dropdown-item" href="getEquipajes">Equipajes</a>
								</div></li>
						</ul>
						<form class="form-inline" action="byDni" method="get">
							<input class="form-control mr-sm-2" type="text" name="dniPasajero" required="">
							<button class="btn btn-primary my-2 my-sm-0" type="submit">
								Pasajero por DNI</button>
						</form>
						<ul class="navbar-nav ml-md-auto">
							<li class="nav-item active"><a class="nav-link" href="getVuelosExdEquipaje">Equipaje extra <span class="sr-only">(current)</span>
							</a></li>
							<!-- Button trigger modal -->
							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#exampleModal">Coffee Break</button>

							<!-- Modal -->
						</ul>
					</div>
				</nav>
				<div class="carousel slide" id="carousel-740027">
					<ol class="carousel-indicators">
						<li data-slide-to="0" data-target="#carousel-740027"
							class="active"></li>
						<li data-slide-to="1" data-target="#carousel-740027"></li>
						<li data-slide-to="2" data-target="#carousel-740027"></li>
					</ol>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img class="d-block w-100" alt="Carousel Bootstrap First"
								src="${img_1}">
							<div class="carousel-caption"></div>
						</div>
						<div class="carousel-item">
							<img class="d-block w-100" alt="Carousel Bootstrap Second"
								src="${img_2}">
							<div class="carousel-caption"></div>
						</div>
						<div class="carousel-item">
							<img class="d-block w-100" alt="Carousel Bootstrap Third"
								src="${img_3}">
							<div class="carousel-caption"></div>
						</div>
					</div>
					<a class="carousel-control-prev" href="#carousel-740027"
						data-slide="prev"><span class="carousel-control-prev-icon"></span>
						<span class="sr-only">Previous</span></a> <a
						class="carousel-control-next" href="#carousel-740027"
						data-slide="next"><span class="carousel-control-next-icon"></span>
						<span class="sr-only">Next</span></a>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<h3>Reservar Vuelo</h3>
				<a href="altaVuelo" type="button"
					class="btn btn-block btn-lg btn-primary"> Ir </a>
					<h4>${Exito}</h4>
			</div>
			<div class="col-md-4">
				<h3>Cancelar Reserva</h3>
				<a href="mostrar_baja"
					class="btn btn-block btn-lg btn-danger"> Ir </a>
			</div>
			<div class="col-md-4">
				<h3>Reporte de facturación</h3>
				<a href="facturacionPage" class="btn btn-block btn-success btn-lg"> Ir </a>
			</div>
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Coffee break</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">Pedido de Break para múltiples
					propósitos, Carga de datos, Baño, descanso</div>
				<div class="modal-footer">
					
					<a href="pedir_break" type="button"
					class="btn btn-primary">Comenzar break</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>