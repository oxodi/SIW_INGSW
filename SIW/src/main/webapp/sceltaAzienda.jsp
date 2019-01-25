<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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

<link rel="stylesheet" href="assets/css/sceltaAzienda.css">
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



	<div class="container" id="land" 
		style="border-style: solid; border-radius: 25px; border-color: green;" >

		<h1>Scegli Azienda</h1>
		<h5>Tutte le aziende di seguito hanno almeno un terreno che
			soddisfa le tue esigenze. Scorrile tutte e clicca su quella che più
			ti convince.</h5>


		<div class="list-group" >
			<nav id="nav1">
				<c:forEach items="${aziende}" var="a">
				<button type="button" class="list-group-item list-group-item-action" >
					
					<h2 class="list-group-item-heading">${a.id }</h2>

					<div class="row">
						
						<div class="column" id="column1">
							<img src="https://www.w3schools.com/images/w3schools_green.jpg"
								class="img-reponsive img-rounded" id="imageAzienda" />
						</div>

						<div class="column" id="column2">${a.descrizioneServizi}</div>

						<div class="column" id="column3">terreni disponibili: ${a.terreni.size() }</div>

					</div>

				
				</button>
					</c:forEach>


			</nav>
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