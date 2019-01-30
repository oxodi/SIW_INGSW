<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<link rel="stylesheet" href="assets/css/inserimentoTerreno.css">
<script src="assets/js/jquery.min.js"></script>
<!-- Script for load Navigation Bar -->
<script>
	$(function() {
		$("#navbar").load("navBarAreaAziende.jsp");
		$("#footer").load("footer.jsp");
	});
</script>

<script>
	$(document).ready(function() {
		$("#avanti").click(function() {
			$("#inserimento").hide("slow");
			$("#inserimento_file").show("slow");

		});
	});
</script>
<script>
	$(document).ready(function() {
		$("#indietro").click(function() {
			$("#inserimento_file").hide("slow");
			$("#inserimento").show("slow");

		});
	});
</script>

</head>

<body>
	<!-- Start: Navigation with Button -->
	<div id="navbar"></div>
	<!-- End: Navigation with Button -->
	<div class="row register-form" style="width: 100%">
		<div class="col-md-10 offset-md-1">
			<form class="custom-form"  method="post" action="TerrenoOspitaOrtaggi">
				
				<div id="inserimento">
				<h1>Inserimento Terreno</h1>
				<div class="row">
					<!-- colonna 1  -->
					<div class="col-md-6 " >
						<div class="form-row form-group">
							<div class="col-md-4" align="left">
								<label class="label-column">Locazione</label>
							</div>
							<div class="col-xs-2">
								<input class="input-column" type="text" name="locazione"
									placeholder="">
							</div>
						</div>

						<div class="form-row form-group">
							<div class="col-md-4" align="left">
								<label class="label-column">Dimensione Terreno</label>
							</div>
							<div class="col-xs-2">
								<input class="input-column" type="text"
									name="dimensione_terreno" placeholder="">
							</div>
						</div>

						<div class="form-row form-group">
							<div class="col-md-4" align="left">
								<label class="label-column">Dimensione Serra</label>
							</div>
							<div class="col-xs-2">
								<input class="input-column" type="text" name="dimensione_serra"
									placeholder="">
							</div>
						</div>

						<div class="form-row form-group">
							<div class="col-md-4" align="left">
								<label class="label-column">Costo Terreno(mt^2)</label>
							</div>
							<div class="col-xs-2">
								<input class="input-column" type="text" name="costo_terreno"
									placeholder="">
							</div>
						</div>
						<div class="form-row form-group">
							<div class="col-md-4" align="left">
								<label class="label-column">Periodo Disponobilita'</label>
							</div>
							<div class="col-xs-2 ">
								<!-- <input class="input-column" type="text" name="disponibilita"
									placeholder=""> -->
									<select class="custom-select input-column" style="width: 190px; padding: 5px;" name="disponibilita">
										<option value="primavera"> Primavera </option>
										<option value="estate"> Estate </option>
										<option value="autunno"> Autunno </option>
										<option value="inverno"> Inverno </option>
										<option value="annuale"> Annuale </option>
										
									</select>
									
							</div>
						</div>
						<div class="form-row form-group">

							<label class="label-column"><strong>Seleziona i
									sevizi</strong></label>

						</div>
						<div class="form-check" align="left">
							<input type="checkbox" name="parziale"><label> Servizio Parziale</label>
						</div>
						<br>
						<div class="form-check" align="left">
							<input type="checkbox" name="completo"><label> Servizio Completo</label>
						</div>

					</div>
					<!-- fine colonna 1 -->
					<!-- colonna 2 -->
					<div class="col-md-6 ">
						<div class="form-row form-group" align="center">
							<label><strong>selezionare gli ortaggi
									coltivabili e inserisci il relativo costo</strong></label>
						</div>
						<div class="form-row form-group">
							<div class="table-responsive" id="table-scroll">
								<table class="table table-hover">
										<thead>
											<tr>
												<th></th>
												<th><strong>Nome</strong></th>
												<th><strong>Resa</strong></th>
												<th><strong>Prezzo</strong></th>
												<th><strong>Tempo Coltivazione</strong></th>
												
											</tr>
										</thead>
										<tbody id="items">
											<c:forEach items="${ortaggi}" var="o">
												<tr class="accordion-toggle" data-toggle="collapse">
													<td><input type="checkbox" value="${o.id}" name="ortaggiSelezionati"></td>
													<td>${o.nome}</td>
													<td>${o.resa}</td>
													<td><input class="input-column" type="text"
														style="max-width: 80px" name="prezzo${o.id}" placeholder="prezzo"></td>
													<td><input class="input-column" type="text"
														style="max-width: 80px" name="tempo${o.id}" placeholder="tempo coltivazione"></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
							</div>
						</div>
					</div>
					<!-- fine colonna 2 -->
					<div class="container">
						<div align="center">
							<button class="button" id="annulla" type="button">Annulla</button>
							<button class="button" id="avanti" type="button">Avanti</button>
							
						</div>
					</div>
				</div>
				</div>
				<div class="container" id="inserimento_file" style="display: none">
			
					<h5><strong>Inserire un documento di proprieta' del terreno</strong></h5>
					<input  type="file"
						class="text-center center-block file-upload container-fluid button">
						
					<div align="center">

								<button class="button" id="indietro" type="button">Indietro</button>
							
							
								<button class="button" type="submit">Conferma</button>
							
						</div>
				</div>
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