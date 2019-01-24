<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

<link rel="stylesheet" href="assets/css/prenotazioneTerreno.css">
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/jquery.imgcheckbox.js"></script>
<!-- <script src="assets/js/scriptPrenotazioneTerreno.js"></script>  -->
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

	<div class="container"
		style="border-style: solid; border-radius: 25px; border-color: green">
		<h1 class="text-center" style='margin-top: 50px;'>Prenotare un
			terreno</h1>

		<div class="container" style="margin-left: 20px; margin-right: 20px">
			<h3 style="margin-top: 50px; margin-bottom: 30px" align=left>Seleziona
				un servizio</h3>

			<div class="row d-flex justify-content-center">

				<!--team-1-->
				<div class="col-lg-4">
					<div class="our-team-main">

						<div class="team-front">
							<img src="assets/img/ruotaStagioni/iconServizioCompleto.png"
								class="img-fluid" />
							<h3>Servizio Completo</h3>
							<p>Maggiori informazioni</p>
						</div>

						<div class="team-back">
							<span> Servizio completo </span>
							<p>
								<button class="button">Seleziona</button>
							</p>
						</div>

					</div>
				</div>
				<!--team-1-->

				<!--team-2-->
				<div class="col-lg-4">
					<div class="our-team-main">

						<div class="team-front">
							<img src="assets/img/ruotaStagioni/iconServizioParziale.png"
								class="img-fluid" />
							<h3>Servizio Parziale</h3>
							<p>Maggiori informazioni</p>
						</div>

						<div class="team-back">
							<span> Servizio parziale </span>
							<p >
							<button class="button">Seleziona</button>
							</p>
						</div>

					</div>
				</div>
				<!--team-2-->

				<!--team-3-->
				<!-- <div class="col-lg-4">
				<div class="our-team-main">

					<div class="team-front">
						<img src="http://placehold.it/110x110/607d8b/fff?text=Dilip"
							class="img-fluid" />
						<h3>Entrambi</h3>
						<p>Maggiori informazioni</p>
					</div>

					<div class="team-back">
						<span> Entrambi </span>
					</div>

				</div>
			</div>  -->
				<!--team-3-->
			</div>
			<div align="left">
				<h3 style="margin-top: 30px; margin-bottom: 30px" align="left">Seleziona
					un periodo di coltivazione</h3>

			</div>
			<div class="conteiner d-flex justify-content-center">
				<div class="custom-form">

					<ul>
						<li><input type="checkbox" id="cb1" /> <label for="cb1"><img
								src="assets\img\ruotaStagioni\primavera.png" /></label></li>

						<li><input type="checkbox" id="cb4" /> <label for="cb4"><img
								src="assets\img\ruotaStagioni\estate.png" /></label></li>
					</ul>

					<div style='margin-top: -15px;'>
						<ul>
							<li><input type="checkbox" id="cb2" /> <label for="cb2"><img
									src="assets\img\ruotaStagioni/inverno.png" /></label></li>

							<li><input type="checkbox" id="cb5" /> <label for="cb5"><img
									src="assets\img\ruotaStagioni\autunno.png" /></label></li>
						</ul>
					</div>
				</div>

			</div>
		</div>
		<!--team-4-->

		<!--team-4-->

		<!--team-5-->

		<!--team-5-->

		<!--team-6-->

		<!--team-6-->



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