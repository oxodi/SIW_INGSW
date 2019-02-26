<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>SIW</title>
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/home.min.css">
<link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lora">

<link rel="stylesheet" href="assets/css/registration.min.css">
<link rel="stylesheet" href="assets/css/inserimentoTerreno.css">
<link rel="stylesheet" href="assets/css/inserimentoProdotto.css">
<link rel="stylesheet" href="assets/css/backend.css">
<script src="assets/js/jquery.min.js"></script>
<!-- Script for load Navigation Bar -->
<script>
	$(function() {
		$("#navbar").load("navBarAreaAziende.jsp");
		$("#footer").load("footer.jsp");
	});
</script>
<script>
	function validazioneDati() {
		$("#validazioneNome").text($("#nome").val());
		$("#validazioneCategoria").text($("#categoria").val());
		$("#validazioneQuantita").text($("#quantita").val());
		$("#validazioneCosto").text($("#costo").val());
		$("#validazioneDescrizione").text($("#formDescrizione").val());
		
	};
</script>
<script>
	$(document).ready(function() {
		$("#avanti").click(function() {
			$("#inserimento").hide("slow");
			$("#validazione").show("slow");
			validazioneDati();

		});
	});
</script>
<script>
	$(document).ready(function() {
		$("#indietro").click(function() {
			$("#validazione").hide("slow");
			$("#inserimento").show("slow");

		});
	});
</script>

</head>

<body>
	<!-- Start: Navigation with Button -->
	<div id="navbar"></div>
	<!-- End: Navigation with Button -->
	<div class="container-fluid border-profile-prodotto">
		<div class="row register-form-prodotto">
			<div class="col-md-auto" style="width: 100%">
				<form class="custom-form" method="post"
					action="InserisciProdotto?edit=false">
					<div id="inserimento">
						<h1 style="overflow: auto;">Inserimento Prodotto</h1>
						<div class="row">
							<!-- colonna 1  -->
							<div class="col-md-6 ">
								<div class="form-row form-group">
									<div class="col-md-4" align="left">
										<label class="label-column">Nome</label>
									</div>
									<div class="col-xs-2">
										<input class="input-column" type="text" name="nome" id="nome"
											placeholder="">
									</div>
								</div>
								<br>
								<div class="form-row form-group">
									<div class="col-md-4" align="left">
										<label class="label-column">Categoria</label>
									</div>
									<div class="col-xs-2">
										<!-- <input class="input-column" type="text" name="categoria"
											id="categoria" placeholder=""> -->
											<select class="input-column" style="padding: 5px;"
											name="categoria" id="categoria">
											<option value="Latticini">Latticini</option>
											<option value="Oli">Oli e derivati</option>
											<option value="Verdure">Verdure</option>
											<option value="Frutti">Frutti</option>
											<option value="Vini">Vini</option>
											<option value="Carni">Carni e derivati</option>
											<option value="Altro">Altro</option>
											<!-- <option value="annuale">Annuale</option>  -->

										</select>
									</div>
								</div>
								<br>
								<div class="form-row form-group">
									<div class="col-md-4" align="left">
										<label class="label-column">Quantità</label>
									</div>
									<div class="col-xs-2">
										<input class="input-column" type="text" name="quantita"
											id="quantita" placeholder="">
									</div>
								</div>
								<br>
								<div class="form-row form-group">
									<div class="col-md-4" align="left">
										<label class="label-column">Costo €</label>
									</div>
									<div class="col-xs-2">
										<input class="input-column" type="text" name="costo"
											id="costo" placeholder="">
									</div>
								</div>
							</div>
							<!-- fine colonna 1 -->
							<!-- colonna 2 -->
							<div class="col-md-6">
								<div class="form-group">
									<label for="comment">Descrizione:</label>
										<textarea class="form-control"
										style="margin-left: auto; margin-right: auto; resize: none; border: 2px green solid; border-radius: 15px; background-color: #cfc7af"
										rows="8" name="formDescrizione" id="formDescrizione"></textarea>
								</div>
							</div>
							<!-- fine colonna 2 -->
							<div class="container">
								<div align="center">
									<button class="button buttonoverflow btn" data-toggle="modal"
										data-target="#annullamentoProdotto" type="button">Annulla</button>

									<button class="button buttonoverflow btn" id="avanti"
										type="button" style="word-spacing: 4px">Avanti ▶</button>

								</div>
							</div>
						</div>
					</div>
					<div class="container" id="validazione" style="display: none">
						<div class="container style-div-table">
							<div class="container" align="center" style="margin-top: 30px;">
								<h5>
									<strong>Controllare i dati inseriti, se si è sicuri,
										confermare l'inserimento</strong>
								</h5>
							</div>
							<br>
							<div class="table-responsive" style="border-radius: 15px;">
								<table class="table" id="valid">
									<thead class="thead style-table">
										<tr>
											<th scope="col">Nome</th>
											<th scope="col">Categoria</th>
											<th scope="col">Quantità</th>
											<th scope="col">Costo (Cadauno)</th>
											<th scope="col">Descrizione</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td class="input" id="validazioneNome" scope="row"></td>
											<td class="input" id="validazioneCategoria" scope="row"></td>
											<td class="input" id="validazioneQuantita" scope="row"></td>
											<td class="input" id="validazioneCosto" scope="row"></td>
											<td class="input" id="validazioneDescrizione" scope="row"></td>
										</tr>
									</tbody>
								</table>
							</div>
							<br>
						</div>
						<br>
						<div class="container-fluid" align="center">
							<h5>
								<strong>Inserire un immagine del prodotto</strong>
							</h5>
							<input type="file" style="margin-left: -3px" name="file"
								class="text-center center-block file-upload container-fluid button">
						</div>
						<div align="center">

							<button class="button btn" id="indietro" type="button"
								style="word-spacing: 4px">◀ Indietro</button>


							<button class="button btn" type="submit">Conferma</button>

						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<div id="annullamentoProdotto" class="modal fade" role="dialog"
		style="z-index: 2500; border-radius: 25px">
		<div class="modal-dialog" style="border: 2px #ad835a solid; border-radius: 15px">
			<!-- Modal content-->
			<div class="modal-content" style="background: #d3c3b3; border-radius: 15px">
				<div class="modal-header">
					<h4 class="modal-title">Conferma Annullamento</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<p>Sei sicuro di voler annullare l'inserimento?</p>
				</div>
				<div class="modal-footer">
						<div class="container" align="right">
							<button type="button" class="btn" style="border-radius: 15px"
								data-dismiss="modal" id="buttonoverflow">Annulla</button>
							<a href="PageLoader?id=backendAzienda"><button type="button"
										class="btn btn-success"
										style="font: bold; border-radius: 15px">Conferma</button> </a>
						</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end modal -->
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