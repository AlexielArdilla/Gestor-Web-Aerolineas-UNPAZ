<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Psajero por DNI</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<spring:url value="/resources/css/style.css" var="aloneCSS" />
<link href="${aloneCSS}" rel="stylesheet" />
<spring:url value="/resources/js/index.js" var="aloneJS" />
<link href="${aloneJS}" rel="stylesheet" />

</head>
<body>
<div>
<nav class="navbar navbar-expand-lg navbar-light bg-light navbar-dark bg-dark">

					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="navbar-toggler-icon"></span>
					</button>
					<a class="navbar-brand" href="index.jsp">UNPAZ</a>
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="navbar-nav">
							<li class="nav-item active"><a class="nav-link" href="panel">ABM Vuelos
									<span class="sr-only">(current)</span>
							</a></li>
							<li class="nav-item"><a class="nav-link" href="logOut">Log-out</a></li>
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" href="http://example.com"
								id="navbarDropdownMenuLink" data-toggle="dropdown">Aviones y vuelos</a>
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
							<li class="nav-item active"><a class="nav-link" href="getVuelosExdEquipaje">Equipaje extra
									<span class="sr-only">(current)</span>
							</a></li>
							<!-- Button trigger modal -->
							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#exampleModal">Coffee Break</button>

							<!-- Modal -->
						</ul>
					</div>
				</nav>
</div>
 
 <section>
  <h3><c:out value="${pasajero.nombre}"></c:out></h3>
    <h3><c:out value="${pasajero.dni}"></c:out></h3>
  <!--for demo wrap-->
  <h1>Vuelos reservados por ${pasajero.dni}</h1>
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
   
      <thead>
        <tr>
          <th>Vuelo ID</th>
          <th>Fecha</th>
          <th>Origen</th>
          <th>Destino</th>
          <th>Avion</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
      <c:forEach items="${vuelos}" var="vuelo">
        <tr>
         <td>${vuelo.id}</td>
          <td>${vuelo.fecha}</td>
           <td>${vuelo.ciudad_origen}</td>
          <td>${vuelo.ciudad_destino}</td>
           <td>${vuelo.avion}</td>
        </tr>
       </c:forEach>
      </tbody>
    </table>
  </div>
</section>
		
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
		

  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

  

    <script  src="${aloneJS}"></script>

</body>
</html>