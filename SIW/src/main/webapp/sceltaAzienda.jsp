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

<link rel="stylesheet" href="assets/css/sceltaAzienda.css">
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/sceltaAzienda.js"></script>
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


	<c:choose>
		<c:when test="${numeroAziende == 0 }">
			<div class="container" id="landNoAziende"
				style="border-style: solid; border-radius: 25px; border-color: green;">
				
				<div id="disegno" align="center" >
				
					<img src="assets/img/cry.png" class="img-reponsive img-rounded" style="max-height: 60%;" >	
				</div>

				<div id="testo" style="margin-top: 5%;">
					<h2 align="center">Al momento nessuna azienda soddisfa le tue
						preferenze, clicca su "Cerca Tutte" per conoscere tutte le aziende
						presenti sul sito oppure torna indietro e modifica le scelte.</h2>
					<div id="button" align="center" style="margin-bottom: 10%; margin-top: 10%;">
						<a href="prenotazioneTerreno.jsp" class="button" id="tornaIndietro">Torna Indietro</a>
						 <a href="DammiAzienda?inputCerca=&bCompleto=false&bParziale=true&primavera=off&primavera=off&estate=off&inverno=off&autunno=off&btnCerca=tutte" class="button" id="cercaTutte">Cerca Tutte</a>
					</div>
				</div>

			</div>

		</c:when>
		<c:otherwise>

			<div class="container" id="land"
				style="border-style: solid; border-radius: 25px; border-color: green;">

				<h1>Scegli Azienda</h1>
				<h5>Tutte le aziende di seguito hanno almeno un terreno che
					soddisfa le tue esigenze. Scorrile tutte e clicca su quella che più
					ti convince.</h5>

				<form action="DammiTerreniAzienda" method="get">
					<div class="list-group">
						<nav id="nav1">
							<c:forEach items="${aziende}" var="a">
								<button onclick="submit" name="btnAzienda" value="${a.id}"
									class=" list-group-item list-group-item-action">
									<div class="row" id="row1" style="max-height: 100px;">

										<div class="column" id="column1">
											<img
												src="https://www.w3schools.com/images/w3schools_green.jpg"
												class="img-reponsive img-rounded" id="imageAzienda"
												style="max-height: 90%;" />
										</div>

										<div class="column" id="column2">
											<h2>${a.ragioneSociale }</h2>
											<em>${a.indirizzo }</em> <br> <em>${a.cap }
												${a.citta } (${a.provincia }) </em>
										</div>

										<div class="column" id="column3" style="margin-top: 3%;">
											<b>Terreni disponibili: </b> <em>${a.numTerreni }</em>
										</div>

									</div>


								</button>
							</c:forEach>


						</nav>
					</div>
				</form>
			</div>

		</c:otherwise>

	</c:choose>










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