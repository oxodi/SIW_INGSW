<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>SIW</title>
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lora">

<link rel="stylesheet" href="assets/css/sceltaTerreno.css">
<script src="assets/js/jquery.min.js"></script>
<!-- Script for load Navigation Bar -->
<script>
	$(function() {
		$("#navbar").load("navBar.jsp");
		$("#footer").load("footer.jsp");
	});
</script>
</head>

<body>
	<!-- Start: Navigation with Button -->
	<div id="navbar"></div>
	<!-- End: Navigation with Button -->
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<p>
					<a href="#">Link</a>
				</p>
				<p>
					<a href="#">Link</a>
				</p>
				<p>
					<a href="#">Link</a>
				</p>
			</div>
			<div class="col-sm-8 text-left" id="centerColumn"
				style="border-style: solid; border-radius: 25px; border-color: green;">
				<h1>

					<c:out value="${azienda.ragioneSociale}" />
				</h1>
				<p>
					<c:out value="${azienda.descrizioneServizi }"></c:out>
				</p>
				<hr>
				<h3>Terreni Disponibili</h3>
				<div class="row">
					<c:forEach items="${terreni}" var="t">
						<div class="col-sm-4">

							<div class="card" style="width: 18rem;">
								<div class="card-body">
									<h5 class="card-title">Terreno n.${t.id}</h5>
									<h6 class="card-subtitle mb-2 text-muted">${t.locazione}</h6>
									<p class="card-text">servizioParziale: ${t.servizioParziale }
										servizioCompleto: ${t.servizioCompleto } dimensione:
										${t.dimensione } dimensioneSerra: ${t.dimensioneSerra }
										periodo: ${t.periodiDisponibilita }</p>
									<button class="button" name="btnCerca" value="tutte"
										style="margin-left: 130px">Seleziona</button>
								</div>

							</div>

						</div>
					</c:forEach>
				</div>
			</div>
			<div class="col-sm-2 sidenav">
				<div class="well">
					<p>ADS</p>
				</div>
				<div class="well">
					<p>ADS</p>
				</div>
			</div>
		</div>
	</div>












	<!-- End: Article List -->
	<!-- Start: footer -->
	<div id="footer"></div>
	<!-- End: footer -->
	<!-- Start: Projects Clean -->
	<div class="projects-clean"></div>
	<!-- End: Projects Clean -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>