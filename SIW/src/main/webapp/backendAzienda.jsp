<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<script src="assets/js/jquery.min.js"></script>
<link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	id="bootstrap-css">
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="assets/css/backend.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="assets/js/profileAzienda.js">
<link href="assets/css/backend.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script>
	$(function() {
		$("#navbar").load("navBarAreaAziende.jsp");
		$("#footer").load("footer.jsp");
	});
</script>


<meta charset="ISO-8859-1">
<title>profilo azienda</title>
</head>
<body>

	<div id="navbar"></div>
	<div class="container bootstrap snippet border-profile" >
		<div class="row" style="margin-top: 30px; margin-bottom: 30px">
			<div class="col-sm-10" align="left">
				<h1>Nome Azienda</h1>	
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3" style="min-width: 180px">
				<!--left col-->

				<!-- 	<div class="text-center">
					<img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png"
						class="avatar img-circle img-thumbnail" alt="avatar">
					<h6>Upload a different photo...</h6>
					<input type="file" class="text-center center-block file-upload">
				</div>  -->
				
				<div class="text-center">
					<img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png"
						class="avatar img-circle img-thumbnail" alt="avatar">
					<h6>Stemma Aziendale</h6>
					<input type="file" class="text-center center-block file-upload">
				</div>
				
				<br>

				<!-- info laterali -->

				<!--left col-->
				<div class="container" style="margin-bottom: 20px">
					<ul class="list-group" style="min-width: 150px">
						<li class="list-group-item text-muted">Profilo</li>
						<li class="list-group-item text-left"><span class="pull-left"><strong>Nome</strong></span>
							Andrea</li>
						<li class="list-group-item text-left"><span class="pull-left"><strong>Email</strong></span>
							andrearossi.it</li>
						<li class="list-group-item text-left"><span class="pull-left"><strong>Telefono</strong></span>
							+391236669992</li>
						<li class="list-group-item text-left"><span class="pull-left"><strong>Ultimo
									accesso</strong></span> 23/07/2016</li>
					</ul>
				</div>
				<!-- end info laterali -->
			</div>

			<div class="col-sm-9">

				<!-- navbar profilo -->
				<ul class="nav nav-tabs">
					<li class="nav-item"><a class="nav-link active" href="#">Home</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">Inserisci
							Terreno</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Inserisci
							Prodotto</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
					</li>
				</ul>
				<!-- end navbar profilo -->

				<!-- form azienda -->
				<div class="custom-form" style="margin-top: 20px;">

					<div class="row" style="margin-left: 10px">
						<div class="col-md-6 ">
							<br>
							<div class="form-group">
								<div class="row">
									<div class="col-md-4">
										<label>Ragione Sociale</label>
									</div>
									<div class="col-xs-2">
										<input class="input-column" type="text">
									</div>
								</div>
							</div>
							
							<div class="form-group">
								<div class="row">
									<div class="col-md-4">
										<label>Referente</label>
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
										<label>Sede Legale</label>
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
										<label>Indirizzo</label>
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
										<label>Citta'</label>
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
										<label>CAP</label>
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
										<label>Provincia</label>
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
										<label>P.Iva</label>
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
										<label>Telefono</label>
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
										<label>Email</label>
									</div>
									<div class="col-xs-2">
										<input class="input-column" type="text">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div id="footer"></div>
</body>
</html>