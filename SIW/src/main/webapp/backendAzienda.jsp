<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<script src="assets/js/jquery.min.js"></script>
<link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	id="bootstrap-css">
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="assets/css/backend.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="assets/css/backend.css">
<meta charset="ISO-8859-1">
<title>Area Azienda</title>

<script src="assets/js/profileAzienda.js"></script>

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
	<div class="container-fluid border-profile">
		<div class="row" style="margin-top: 30px; margin-bottom: 30px">
			<div class="col-sm-10" align="left">
				<h1
					style="font-style: oblique; color: green; text-shadow: 2px 2px 4px black;">${sessionScope.azienda.getRagioneSociale()}</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<!--left col-->

				<div class="text-center">
					<img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png"
						class="avatar rounded-circle img-thumbnail image-profile"
						alt="avatar">
					<h6>Upload a different photo...</h6>
					<input type="file"
						class="text-center center-block file-upload container-fluid">
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
							style="border-bottom: green 1px solid;"><span
							class="pull-left" ><strong>Nome</strong></span>    ${sessionScope.azienda.getRagioneSociale() }</li>
						<li class="list-group-item text-left style-info"
							style="border-bottom: green 1px solid;"><span
							class="pull-left"><strong>Email</strong></span>    ${sessionScope.azienda.getEmail() }</li>
						<li class="list-group-item text-left style-info"
							style="border-bottom: green 1px solid"><span
							class="pull-left"><strong>Telefono</strong></span>    ${sessionScope.azienda.getTelefono() }</li>
						<li class="list-group-item text-left style-info"><span
							class="pull-left"><strong>Partita IVA</strong></span>    ${sessionScope.azienda.getPartitaIVA() }</li>
					</ul>
				</div>
				<!-- end info laterali -->
			</div>

			<div class="col-sm-9" id="div-disp">

				<!-- navbar profilo -->

				<div class="navbar-collapse topnav " style="border-color: green;">
					<ul class="nav nav-pills">
						<li class="active"><a data-toggle="tab" href="#modificadati">
								Dati</a></li>
						<li><a data-toggle="tab" href="#imieiterreni">I miei
								terreni</a></li>
						<li><a data-toggle="tab" href="imieiprodotti">I miei
								prodotto</a></li>
						<li><a class="nav-link disabled" data-toggle="tab" href="#">Disabled</a>
						</li>
					</ul>
				</div>

				<!-- end navbar profilo -->

				<!-- form azienda -->
				<div class="tab-content clearfix">
					<div class="custom-form tab-pane active"
						style="margin-left: 20px; margin-top: 20px" id="modificadati">

						<div class="row">
							<div class="col-md-6 ">
								<br>
								<div class="form-group">
									<div class="row">
										<div class="col-md-4">
											<label class="label-column">Ragione Sociale</label>
										</div>
										<div class="col-xs-2">
											<input class="input-column" type="text" disabled="disabled"
												name="ragione_sociale"
												placeholder="${sessionScope.azienda.getRagioneSociale()}">
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
											<input class="input-column" type="text" name="referente"
												placeholder="${sessionScope.azienda.getReferente()}">
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
											<input class="input-column" type="text" name="sede_legale"
												placeholder="${sessionScope.azienda.getSedeLegale()}">
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
											<input class="input-column" type="text" name="indirizzo"
												placeholder="${sessionScope.azienda.getIndirizzo()}">
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
											<input class="input-column" type="text" name="citta"
												placeholder="${sessionScope.azienda.getCitta()}">
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
											<input class="input-column" type="text" name="cap"
												placeholder="${sessionScope.azienda.getCap()}">
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
											<input class="input-column" type="text" name="provincia"
												placeholder="${sessionScope.azienda.getProvincia()}">
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
											<input class="input-column" type="text" name="partita_iva"
												placeholder="${azienda.getPartitaIVA()}">
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
											<input class="input-column" type="tel" name="telefono"
												placeholder="${sessionScope.azienda.getTelefono()}">
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
											<input class="input-column" type="text" name="email"
												placeholder="${sessionScope.azienda.getEmail()}">
										</div>
									</div>
								</div>
							</div>
						</div>
						<br>
						<div align="center">
							<button class="button" type="submit">Salva</button>
						</div>
					</div>
					<div class="tab-pane" style="margin-left: 20px; margin-top: 20px"
						id="imieiterreni">
						<div class="table-responsive">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>Locazione</th>
										<th>Dimensione</th>
										<th>Dimensione Serra</th>
										<th>Servizio Completo</th>
										<th>Servizio Parziale</th>
										<th>Periodo Coltivazione</th>
									</tr>
								</thead>
								<tbody id="items">

									<c:forEach items="${terreni}" var="t">
										<tr data-toggle="collapse" data-target="#demo1"
											class="accordion-toggle ">
											<td>${t.locazione}</td>
											<td>${t.dimensione }</td>
											<td>${t.dimensioneSerra }</td>
											<td>${t.servizioCompleto }</td>
											<td>${t.servizioParziale}</td>
											<td>${t.periodiDisponibilita}</td>
										</tr>
									</c:forEach>
							</table>
						</div>
						<div align="center">
							<a href="PageLoader?id=inserimentoTerreno">
								<button class="button" type="submit">Aggiungi Terreno</button>
							</a>


						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="footer"></div>
</body>
</html>