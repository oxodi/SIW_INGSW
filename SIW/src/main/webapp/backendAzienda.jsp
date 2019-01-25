<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<script src="assets/js/jquery.min.js"></script>
<link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="assets/css/backend.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="assets/css/backend.css">
<meta charset="ISO-8859-1">
<title>Area Azienda</title>

<script src="assets/js/profileAzienda.js"></script>

<script>
	$(function() {
		$("#navbar").load("navBar.jsp");
		$("#footer").load("footer.jsp");
	});
</script>

<meta charset="ISO-8859-1">
<title>profilo azienda</title>
</head>
<body>

	<div id="navbar"></div>
	<div class="container-fluid border-profile">
		<div class="row" style="margin-top: 30px; margin-bottom: 30px">
			<div class="col-sm-10" align="left">
				<h1 style="font-style: oblique; color: green; text-shadow: 2px 2px 4px black;">Nome Azienda</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3" >
				<!--left col-->

				<div class="text-center">
					<img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png"
						class="avatar rounded-circle img-thumbnail image-profile" alt="avatar">
					<h6>Upload a different photo...</h6>
					<input type="file" class="text-center center-block file-upload container-fluid">
				</div>

				<br>

				<!-- info laterali -->

				<!--left col-->
				<div class="container border-info-style">
					<ul class="list-group">
						<li class="list-group-item text-center style-info"
							style="border-bottom: green 1px solid"><strong>Dati
								Azienda</strong></li>
						<li class="list-group-item text-left style-info"
							style="border-bottom: green 1px solid"><span
							class="pull-left"><strong>Nome</strong></span> Andrea</li>
						<li class="list-group-item text-left style-info"
							style="border-bottom: green 1px solid"><span
							class="pull-left"><strong>Email</strong></span> andrearossi.it</li>
						<li class="list-group-item text-left style-info"
							style="border-bottom: green 1px solid"><span
							class="pull-left"><strong>Telefono</strong></span> 1236669992</li>
						<li class="list-group-item text-left style-info"><span
							class="pull-left"><strong>Ultimo accesso</strong></span>
							23/07/2016</li>
					</ul>
				</div>
				<!-- end info laterali -->
			</div>

			<div class="col-sm-9" id="div-disp" >

				<!-- navbar profilo -->

				<div class="navbar-collapse topnav" style="border-color: green;">
					<a class="nav-link active" style="border-color: green" href="#">Home</a>
					<a class="nav-link" href="#">I miei terreni</a> <a class="nav-link"
						href="#">I miei prodotto</a> <a class="nav-link disabled" href="#">Disabled</a>
				</div>

				<!-- end navbar profilo -->

				<!-- form azienda -->
				<div class="custom-form" style="margin-left:20px;margin-top: 20px;">

					<div class="row">
						<div class="col-md-6 ">
							<br>
							<div class="form-group">
								<div class="row">
									<div class="col-md-4">
										<label class="label-column">Ragione Sociale</label>
									</div>
									<div class="col-xs-2">
										<input class="input-column" type="text">
									</div>
								</div>
							</div>
							<br>
							<div class="form-group">
								<div class="row">
									<div class="col-md-4">
										<label class="label-column">Referente</label>
									</div>
									<div class="col-xs-2">
										<input class="input-column" type="text">
									</div>
								</div>
							</div>
							<br>
							<div class="form-group">
								<div class="row">
									<div class="col-md-4 ">
										<label class="label-column">Sede Legale</label>
									</div>
									<div class="col-xs-2 ">
										<input class="input-column" type="text">
									</div>
								</div>
							</div>
							<br>
							<div class="form-group">
								<div class="row">
									<div class="col-md-4 ">
										<label class="label-column">Indirizzo</label>
									</div>
									<div class="col-xs-2 ">
										<input class="input-column" type="text">
									</div>
								</div>
							</div>
							<br>
							<div class="form-group">
								<div class="row">
									<div class="col-md-4 ">
										<label class="label-column">Citta'</label>
									</div>
									<div class="col-xs-2 ">
										<input class="input-column" type="text">
									</div>
								</div>
							</div>
						</div>


						<div class="col-md-6">
							<br>
							<div class="form-group">
								<div class="row">
									<div class="col-md-4 ">
										<label class="label-column">CAP</label>
									</div>
									<div class="col-xs-2">
										<input class="input-column" type="text">
									</div>
								</div>
							</div>
							<br>
							<div class="form-group">
								<div class="row">
									<div class="col-md-4 ">
										<label class="label-column">Provincia</label>
									</div>
									<div class="col-xs-2">
										<input class="input-column" type="text">
									</div>
								</div>
							</div>
							<br>
							<div class="form-group">
								<div class="row">
									<div class="col-md-4">
										<label class="label-column">P.Iva</label>
									</div>
									<div class="col-xs-2">
										<input class="input-column" type="text">
									</div>
								</div>
							</div>
							<br>
							<div class="form-group">
								<div class="row">
									<div class="col-md-4">
										<label class="label-column">Telefono</label>
									</div>
									<div class="col-xs-2">
										<input class="input-column" type="text">
									</div>
								</div>
							</div>
							<br>
							<div class="form-group">
								<div class="row">
									<div class="col-md-4">
										<label class="label-column">Email</label>
									</div>
									<div class="col-xs-2">
										<input class="input-column" type="text">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<br>
				<div align="center">
					<button class="button" type="submit">Conferma</button>
				</div>
			</div>
		</div>
	</div>


	<div id="footer"></div>
</body>
</html>