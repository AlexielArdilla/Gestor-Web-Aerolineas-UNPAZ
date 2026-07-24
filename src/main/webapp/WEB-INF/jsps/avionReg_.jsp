<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<spring:url value="/resources/css/bootstrap.min.css" var="aliCSS" />
<link href="${aliCSS}" rel="stylesheet" />

<title>Crear Avion</title>
<style>
#grad1 {
	height: 1200px;
	background-color: blue;
	/* For browsers that do not support gradients */
	background-image: linear-gradient(to bottom right, #27B157, #12C5EB);
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js">
	
</script>
<script>
	$(document).ready(function() {
		$("#id").change(function() {

			$.ajax({

				url : 'validateId',
				data : {
					id : $("#id").val()
				},
				success : function(responseText) {
					$("#errMsg").text(responseText);

					if (responseText != "") {
						$("#id").focus();
					}

				}

			});

		});
	});
</script>

</head>
<body id="grad1">
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Registrar avion</h3>
					</div>
					<div class="panel-body">
						<form accept-charset="UTF-8" role="form" action="registerAvion"
							method="POST">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="id" name="id" id="id"
										type="text">
								</div>

								<div class="form-group">
									<input class="form-control" placeholder="cant_pasajero"
										name="cant_pasajero" type="text">
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="descripcion"
										name="descripcion" type="text">
								</div>

								<input class="btn btn-lg btn-success btn-block" type="submit"
									value="enviar">
							</fieldset>
						</form>
					</div>
					<div>
						<span id="errMsg"></span>
					</div>
					<br> <br />${result}<br> 
					<a href="getAviones">Ver listado de aviones</a>

				</div>
			</div>
		</div>
	</div>

</body>
</html>