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
<script src="assets/js/scriptPrenotazioneTerreno.js"></script>
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
		<form action="DammiAzienda" method="get">
			<h1 class="text-center" style='margin-top: 50px;'>Prenota un
				terreno</h1>



			<div class="container h-100" style="margin-top: 4%">
				<div class="d-flex justify-content-center h-100">
					<div class="searchbar">
					
						<input class="search_input" type="text" name="inputCerca"
							placeholder="Cerca un'azienda.." style="outline: none!important"> <button name="btnCerca" value="cercaAzienda" class="search_icon"><i
							class="fa fa-search" style="outline: none!important"></i></button>
					</div>
				</div>
			</div>





			<hr size=”1″ width=”300″ color="black" noshade style="margin-top: 5%">
			<h3 style="margin-top: 3%; margin-bottom: 30px; margin-left: 30px"
				align=left>Seleziona un servizio</h3>
			<div class="container">

				<div class="row d-flex justify-content-center">

					<div class="col-lg-4">
						<div class="our-team-main" id="3">

							<div class="team-front">
								<img src="assets/img/ruotaStagioni/iconServizioCompleto.png"
									class="img-fluid" />
								<h3>Servizio Completo</h3>
								<p>Maggiori informazioni</p>
							</div>

							<div class="team-back" id="1">
								<span> Il servizio completo comprende l'affitto del
									terreno ed il processo di coltivazione &#232 completamente a
									cura dell'azienda fino alla consegna del prodotto finale. </span>
								<p>
									<input class="button" onclick="button = 1; changecolour();"
										value="Seleziona" readonly="readonly" style="max-width: 150px">
									<input type="text" id="completo" value="false" name="bCompleto"
										style="display: none" />

								</p>
							</div>

						</div>
					</div>
					<!--team-1-->

					<!--team-2-->
					<div class="col-lg-4">
						<div class="our-team-main" id="4">

							<div class="team-front">
								<img src="assets/img/ruotaStagioni/iconServizioParziale.png"
									class="img-fluid" />
								<h3>Servizio Parziale</h3>
								<p>Maggiori informazioni</p>
							</div>

							<div class="team-back" id="2">
								<span> Il servizio parziale comprende il solo affitto del
									terreno, i processi di coltivazione e raccolta sono a cura del
									cliente. </span>
								<p>
									<input class="button" onclick="button = 2; changecolour();"
										value="Seleziona" readonly="readonly" style="max-width: 150px">
									<input type="text" id="parziale" value="false" name="bParziale"
										style="display: none" />
								</p>
							</div>

						</div>
					</div>
				</div>




			</div>

			<div>
				<hr size=”1″ width=”300″ color="black" noshade
					style="margin-top: 3%; margin-bottom: 5%">

				<h3 style="margin-top: 30px; margin-bottom: 30px; margin-left: 30px"
					align="left">Seleziona un periodo di coltivazione</h3>

			</div>
			<div class="container-fluid">
				<div align="center">

					<ul class="buttomul">
						<li><input type="checkbox" id="cb1" name="primavera"
							value="off"> <label for="cb1"><img
								src="assets\img\ruotaStagioni\primavera.png" /></label> <input
							type="hidden" name="primavera" value="off"></li>

						<li><input type="checkbox" id="cb4" name="estate" /> <label
							for="cb4"><img src="assets\img\ruotaStagioni\estate.png" /></label>
							<input type="hidden" name="estate" value="off"></li>

					</ul>
				</div>
				<div align="center">
					<ul>
						<li><input type="checkbox" id="cb2" name="inverno" /> <label
							for="cb2"><img src="assets\img\ruotaStagioni/inverno.png" /></label>
							<input type="hidden" name="inverno" value="off"></li>

						<li><input type="checkbox" id="cb5" name="autunno" /> <label
							for="cb5"><img src="assets\img\ruotaStagioni\autunno.png" /></label>
							<input type="hidden" name="autunno" value="off"></li>
					</ul>


				</div>
				<div align="center">

					<!-- <div class="col-xl-6"> -->
					<button class="button btn" name="btnCerca" value="selezione"
						onclick="submit" style="min-width: 200px">Cerca selezione</button>
					<!-- </div> -->

					<!-- <div  class="col-xl-6" > -->
					<button class="button btn" name="btnCerca" value="tutte"
						style="min-width: 200px">Cerca tutte</button>

					<!-- </div> -->

				</div>


			</div>
			<!--team-4-->

			<!--team-4-->

			<!--team-5-->

			<!--team-5-->

			<!--team-6-->

			<!--team-6-->


		</form>
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