<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
					<a href="#"></a>
				</p>
				<p>
					<a href="#"></a>
				</p>
				<p>
					<a href="#"></a>
				</p>
			</div>
			<div class="col-sm-8  " id="centerColumn"
				style="border-style: solid; border-radius: 25px; border-color: green; background: #996633">
				<div class="container" id="terreni" >
					<h1>

						<c:out value="${azienda.ragioneSociale}" />
					</h1>
					<p>
						<em><c:out value="${azienda.descrizioneServizi }"></c:out></em>
					</p>
					<hr>
					<h2>Terreni Disponibili</h2>
					<form action="DammiTerreno" method="get">
						<div class="grid-container ">
							<c:forEach items="${terreni}" var="t">
								<!-- <div class="col-sm-4" > -->

								<div class="card"
									style="background: #f2dca9;  border-style: solid; border-radius: 25px; border-color: green">
									<div class="card-body">
										<h3 class="card-title ">Terreno n.${t.id}</h3>
										<h5 class="card-subtitle mb-2 text-muted">${t.locazione}</h5>
										<p class="card-text" align="left">
											<c:if
												test="${t.servizioParziale == true && t.servizioCompleto == true }">
												<b>Servizi Disponibili:</b> <em>Parziale, Completo.</em> <br>
										</c:if>
											<c:if
												test="${t.servizioParziale == true && t.servizioCompleto == false }">
												<b>Servizi Disponibili:</b> <em>Parziale.</em> <br>
										</c:if>
											<c:if
												test="${t.servizioParziale == false && t.servizioCompleto == true }">
												<b>Servizio Disponibile:</b> <em>Completo.</em> <br>
										</c:if>
											<b>Spazio coltivabile:</b> <em>${t.dimensione } m<sup>2</sup></em> <br>
											<c:if test="${t.dimensioneSerra == 0}">
												<b>Spazio coltivabile in serra:</b> <em>Serra non presente.</em> <br>
										</c:if>
											<c:if test="${t.dimensioneSerra != null}">
												<b>Spazio coltivabile in serra:</b> ${t.dimensioneSerra } m<sup>2</sup>.  <br>
										</c:if>
											
											<b>Periodo:</b> <em>${t.periodiDisponibilita }.</em>
										</p>

										<div class="container" align="bottom" >
											<button class="button" onclick="submit" name="btnTerreno"
												value="${t.id }">Seleziona</button>
										</div>


									</div>
								</div>

								<!-- </div> -->
							</c:forEach>
						</div>
					</form>
				</div>


			</div>
			<div class="col-sm-2 sidenav">
				<div class="well">
					<p></p>
				</div>
				<div class="well">
					<p></p>
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