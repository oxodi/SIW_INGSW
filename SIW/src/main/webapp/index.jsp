<%@page contentType="text/html" pageEncoding="UTF-8" %>	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
		$("#navbar").load("navBar.jsp");
		$("#footer").load("footer.jsp");
	});
</script>

</head>
<body>
	<!-- Start: Navigation with Button -->
	<div id="navbar"></div>
	<!-- End: Navigation with Button -->
	<!-- Start: Simple Slider -->
	<div class="simple-slider">
		<!-- Start: Slideshow -->
		<div class="swiper-container">
			<!-- Start: Slide Wrapper -->
			<div class="swiper-wrapper">
				<!-- Start: Slide -->
				<div id="divs" class="swiper-slide"
					style="background-image: url(https://cdn.gamephd.com/wp-content/uploads/plixpapers1607/cloudy-vineyard-4k-wallpaper.jpg);"></div>
				<!-- End: Slide -->
				<!-- Start: Slide -->
				<div id="divs" class="swiper-slide"
					style="background-image: url(https://ded8b07dd9e637888fc2-e87978aaae5cf97349d88697fd53e4c9.ssl.cf1.rackcdn.com/10933.jpg);"></div>
				<!-- End: Slide -->
				<!-- Start: Slide -->
				<div id="divs" class="swiper-slide"
					style="background-image: url(http://www.lovepotatoes.co.uk/media/1089/maris-piper.jpg?anchor=center&amp;mode=crop&amp;width=650&amp;height=345&amp;rnd=130881041440000000&amp;Format=Jpeg);"></div>
				<!-- End: Slide -->
				<!-- Start: Slide -->
				<div id="divs" class="swiper-slide"
					style="background-image: url(http://st.gde-fon.com/wallpapers_original/412004_vinograd_belyj_yagody_grozd_yashhik_meshok_1680x1050_www.Gde-Fon.com.jpg);"></div>
				<!-- End: Slide -->
				<!-- Start: Slide -->
				<div id="divs" class="swiper-slide"
					style="background-image: url(https://static.wixstatic.com/media/4886cf_51c132567e1e4ffb835001c5db81c7d5.jpg);"></div>
				<!-- End: Slide -->
			</div>
			<!-- End: Slide Wrapper -->
			<!-- Start: Previous -->
			<!--  	<div class="swiper-button-prev"></div>   -->
			<!-- End: Previous -->
			<!-- Start: Next -->
			<!-- 	<div class="swiper-button-next"></div>   -->
			<!-- End: Next -->
		</div>
		<!-- End: Slideshow -->
	</div>
	<!-- End: Simple Slider -->



	<!-- Start: Article List -->
	<div class="article-list">
		<div class="container">
			<!-- Start: Intro -->
			<div class="intro">
				<h2 class="text-center">I nostri servizi  ${requestScope.failed}</h2>
				<p class="text-center">Un nuovo modo per valorizzare il mondo dell'agricoltura.</p>
			</div>
			<!-- End: Intro -->
			<!-- Start: Articles -->
			<div class="row articles">
				<div class="col-sm-6 col-md-4 item">
				
					<a href="#"><img class="img-fluid" src="assets/img/terrenobg.jpg"></a>
					<h3 class="name">Prenota un terreno</h3>
					<p class="description">Registrati come cliente per poter visualizzare le aziende
					che offrono terreni coltivabili selezionando uno dei servizi proposti. Scegli il tuo terreno
					e prova una nuova esperienza.</p>
					<c:if test="${sessionScope.cliente == null}">
						<button class="button btn-success" data-toggle="modal"
									data-target="#modalDelete" type="button" style="outline: none;border-radius: 30px; border-color: transparent; background-color: transparent;">  
									<i class="fa fa-arrow-circle-right" id="myfa"></i></button>
				</c:if>
				<c:if test="${sessionScope.cliente != null}">
				
					<a href="PageLoader?id=prenotaTerreno">
					<button class="button btn-success" 
						 type="button" style="outline: none; border-radius: 30px; border-color: transparent; background-color: transparent;" >
						<i class="fa fa-arrow-circle-right" id="myfa"></i></button></a>
				</c:if>
			
				</div>
				<div class="col-sm-6 col-md-4 item">
					<a href="#"><img class="img-fluid"
						src="assets/img/prodotti2.jpg"></a>
					<h3 class="name">Acquista un prodotto</h3>
					<p class="description">Accedendo a quest area puoi acquistare tutti i prodotti
					offerti dalle aziende. Prova la nostra ortofrutticola 2.0! 
					
					
					</p>
					<a href="#">
					<button class="button btn-success" 
						 type="button" style="outline: none; border-radius: 30px; border-color: transparent; background-color: transparent;"> 
						 <i class="fa fa-arrow-circle-right" id="myfa"></i> </button></a>
				</div>
				<div class="col-sm-6 col-md-4 item">
					<a href="#"><img class="img-fluid" src="assets/img/azienda2.jpg"></a>
					<h3 class="name">Area aziende</h3>
					<p class="description">Registrati come azienda per entrare nel mondo
					innovativo dell'agricoltura digitale. Inserisci terreni e prodotti e sperimenta una
					nuova possibilità di guadagno!</p>
					<a href="PageLoader?id=azienda">
					<button class="button btn-success" 
						 type="button" style="outline: none; border-radius: 30px; border-color: transparent; background-color: transparent;" >
						 <i class="fa fa-arrow-circle-right" id="myfa"></i></button></a>
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