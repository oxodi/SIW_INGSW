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
				<h2 class="text-center">Latest Articles</h2>
				<p class="text-center">Nunc luctus in metus eget fringilla.
					Aliquam sed justo ligula. Vestibulum nibh erat, pellentesque ut
					laoreet vitae.</p>
			</div>
			<!-- End: Intro -->
			<!-- Start: Articles -->
			<div class="row articles">
				<div class="col-sm-6 col-md-4 item">
					<a href="#"><img class="img-fluid" src="assets/img/desk.jpg"></a>
					<h3 class="name">Article Title</h3>
					<p class="description">Aenean tortor est, vulputate quis leo
						in, vehicula rhoncus lacus. Praesent aliquam in tellus eu gravida.
						Aliquam varius finibus est, interdum justo suscipit id.</p>
					<a href="#" class="action"><i class="fa fa-arrow-circle-right"></i></a>
				</div>
				<div class="col-sm-6 col-md-4 item">
					<a href="#"><img class="img-fluid"
						src="assets/img/building.jpg"></a>
					<h3 class="name">Article Title</h3>
					<p class="description">Aenean tortor est, vulputate quis leo
						in, vehicula rhoncus lacus. Praesent aliquam in tellus eu gravida.
						Aliquam varius finibus est, interdum justo suscipit id.</p>
					<a href="#" class="action"><i class="fa fa-arrow-circle-right"></i></a>
				</div>
				<div class="col-sm-6 col-md-4 item">
					<a href="#"><img class="img-fluid" src="assets/img/loft.jpg"></a>
					<h3 class="name">Article Title</h3>
					<p class="description">Aenean tortor est, vulputate quis leo
						in, vehicula rhoncus lacus. Praesent aliquam in tellus eu gravida.
						Aliquam varius finibus est, interdum justo suscipit id.</p>
					<a href="#" class="action"><i class="fa fa-arrow-circle-right"></i></a>
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