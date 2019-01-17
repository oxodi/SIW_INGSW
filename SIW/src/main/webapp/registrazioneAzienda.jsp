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
<link rel="stylesheet" href="assets/css/registration.min.css">
<script src="assets/js/jquery.min.js"></script>
<!-- Script for load Navigation Bar -->
<!-- <script src="jquery.js"></script> -->
<script>
	$(function() {
		$("#navbar").load("navBar.jsp");
		$("#footer").load("footer.jsp");
	});
</script>
<script>
	$(document).ready(function() {
		$("#bottone").click(function() {
			$("#formregistrazione").hide("slow");
			$("#descrizione").show("slow");
			
		});
	});
</script>

</head>

<body>
	<!-- Start: Navigation with Button -->
	<div id="navbar"></div>
	<!-- End: Navigation with Button -->
	
	<div class="row register-form" style="height: 768px; display:none" id="descrizione">
		<div class="col-md-8 offset-md-2">
			<form class="custom-form" id="descAzienda" method="post" name="azienda" action="InserisciAzienda">
				<h1>Descrizione Azienda</h1>
				<div>
					<div>
						<div style="align-content: centre">
						<!-- 	<label class="col-form-label" for="name-input-field"><h5>Descrizione
									Azienda</h5></label>  -->
									<p><strong>Inserire una descrizione sui servizi proposti dall'azienda e sui metodi di produzione</strong></p>
						</div>
					</div>
					<div>
				
						<div style="text-align: center; whidt:100%; margin-top: 25px">
							<textarea class="form-control" style=" margin-left: auto; margin-right: auto; resize: none; border: 2px green solid; border-radius: 15px; background-color: #cfc7af" 
								rows="10" cols="80" maxlength="1000"></textarea>
						</div>
					</div>
			
			</div>
				 	<button class="btn btn-light submit-button" type="submit">Conferma</button>
			</form>
		</div>
	</div>
	
	
	<div id="formregistrazione" class="row register-form">
		<div class="col-md-8 offset-md-2">
			<form class="custom-form" id="regFormAzienda" method="post" name="azienda" action="InserisciAzienda">
				<h1>Registrazione Azienda</h1>
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label class="col-form-label" for="name-input-field">Ragione Sociale</label>
					</div>
					<div class="col-sm-6 input-column">
						<input class="form-control" type="text" name="ragioneSociale">
					</div>
				</div>
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label class="col-form-label" for="name-input-field">Indirizzo</label>
					</div>
					<div class="col-sm-6 input-column">
						<input class="form-control" type="text" name="indirizzo">
					</div>
				</div>
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label class="col-form-label" for="name-input-field">CAP</label>
					</div>
					<div class="col-sm-6 input-column">
						<input class="form-control" type="text" name="cap">
					</div>
				</div>
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label class="col-form-label" for="name-input-field">Citta'</label>
					</div>
					<div class="col-sm-6 input-column">
						<input class="form-control" type="text" name="citta">
					</div>
				</div>
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label class="col-form-label" for="name-input-field">Referente </label>
					</div>
					<div class="col-sm-6 input-column">
						<input class="form-control" type="text" name="referente">
					</div>
				</div>
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label class="col-form-label" for="name-input-field">Sede Legale </label>
					</div>
					<div class="col-sm-6 input-column">
						<input class="form-control" type="text" name="sedeLegale">
					</div>
				</div>
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label class="col-form-label" for="name-input-field">Provincia </label>
					</div>
					<div class="col-sm-6 input-column">
						<input class="form-control" type="text">
					</div>
				</div>
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label class="col-form-label" for="name-input-field">Telefono</label>
					</div>
					<div class="col-sm-6 input-column">
						<input class="form-control" type="text" name="telefono">
					</div>
				</div>
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label class="col-form-label" for="name-input-field">P.
							Iva</label>
					</div>
					<div class="col-sm-6 input-column">
						<input class="form-control" type="text" name="iva">
					</div>
				</div>
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label class="col-form-label" for="email-input-field">Email
						</label>
					</div>
					<div class="col-sm-6 input-column">
						<input class="form-control" type="email" name="email">
					</div>
				</div>
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label class="col-form-label" for="pawssword-input-field">Password
						</label>
					</div>
					<div class="col-sm-6 input-column">
						<input class="form-control" type="password" name="password">
					</div>
				</div>
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label class="col-form-label" for="repeat-pawssword-input-field">Ripeti
							Password </label>
					</div>
					<div class="col-sm-6 input-column">
						<input class="form-control" type="password">
					</div>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" id="formCheck-1"><label
						class="form-check-label" for="formCheck-1">Ho letto e
						accettato i termini e condizione di servizio</label>
				</div>
				 	<button class="btn btn-light submit-button" id="bottone" type="button">Submit
					Form</button>
			</form>
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