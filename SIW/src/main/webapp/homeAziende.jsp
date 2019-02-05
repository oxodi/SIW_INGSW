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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/css/swiper.min.css">

<link rel="stylesheet" href="assets/css/home.min.css">
<script src="assets/js/jquery.min.js"></script>
<!-- Script for load Navigation Bar -->
<script>
	$(function() {
		$("#navbar").load("navBarAreaAziende.jsp");
		$("#footer").load("footer.jsp");
	});
</script>

</head>
<body>

	<!-- Start: Navigation with Button -->
	<div id="navbar"></div>
	<!-- End: Navigation with Button -->

	<!-- Start: Article List -->
	<div class="article-list">
		<div class="container">
			<!-- Start: Intro -->
			<div class="intro"> 
				<h2 class="text-center">Sei proprietario di un'azienda agricola?</h2>
				<p class="text-center" style="color: black;"><strong>Entra nel network TheGrower!</strong></p>
			</div>
			<!-- End: Intro -->
			<!-- Start: Articles -->
			<div class="row articles">
				<div class="col-sm-6 col-md-4 item">
					<a href="#"><img class="img-fluid" src="assets/img/aziendaP.jpg"></a>
					<h3 class="name">Gestione Prodotti</h3>
					<a class="description"><strong>Dalla tua area riservata avrai accesso agli strumenti
				necessari per gestire al meglio la vendita dei tuoi prodotti.</strong></a>
					
				</div>
				<div class="col-sm-6 col-md-4 item">
					<a href="#"><img class="img-fluid"
						src="assets/img/AziendaT.jpg"></a>
					<h3 class="name">Gestione terreni</h3>
					<a class="description"><strong>All'interno dell' area riservata puoi mettere a disposizione
					dei terreni di tua proprieta', che gli utenti potranno fittare per coltivare
					gli ortaggi che preferiscono.</strong></a>
					
				</div>
				<div class="col-sm-6 col-md-4 item">
					<a href="#"><img class="img-fluid" src="assets/img/aziendaS.jpg"></a>
					<h3 class="name">Statistiche</h3>
					<a class="description"><strong>Controlla l'andamento delle tue vendite e la resa dei
					tuoi terreni, in tempo reale.</strong></a>
					
				</div>
			</div>
			<!-- End: Articles -->
		</div>

	</div>
	<!-- End: Article List -->
<!-- Start: footer -->
	<div id="footer"></div>
	<!-- End: footer -->

	<!-- Start: Projects Clean -->
	<div class="projects-clean"></div>
	<!-- End: Projects Clean -->
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/js/swiper.jquery.min.js"></script>
	<script src="assets/js/scriptHome.min.js"></script>
</body>
</html>