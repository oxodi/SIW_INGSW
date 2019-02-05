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
<link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lora">
<script src="assets/js/jquery.min.js"></script>

<link rel="stylesheet" href="assets/css/sceltaOrtaggi.css">
<script src="assets/js/sceltaOrtaggi.js"></script>


<!-- Script for load Navigation Bar -->
<script>
	$(function() {
		$("#navbar").load("navBar.jsp");
		$("#footer").load("footer.jsp");
	});
</script>

<script>
	$(document).ready(function() {

				var dimTotale = ${terreno.dimensione};
				var dimSerra = ${terreno.dimensioneSerra};
				var dimTerreno = dimTotale - dimSerra;
				
				$("#terrenoDisp").html("Disponibilità terreno: " + dimTerreno+ " m<sup>2</sup>");

				$("#switchDiv").click(function() {

							if ($(this).is(':checked')) {
								$("#noserra").hide("slow");
								$("#serra").show("slow");
								$("#terrenoDisp").html("Disponibilità serra: " + dimSerra+ " m<sup>2</sup>");
							}
							if (!$(this).is(':checked')) {

								$("#serra").hide("slow");
								$("#noserra").show("slow");
								$("#terrenoDisp").html("Disponibilità terreno: " + dimTerreno+ " m<sup>2</sup>");

							}
						});
			});
</script>

<!-- <script>
$(document).ready(function() {
	  $('.accordion-toggle').click(function(event) {
	    if (event.target.type !== 'checkbox') {
	      $(':checkbox', this).trigger('click');
	    }
	  });
	});
</script> -->


</head>

<body>
	<!-- Start: Navigation with Button -->
	<div id="navbar"></div>
	<!-- End: Navigation with Button -->

	<div class="container"
		style="border-style: solid; border-radius: 25px; border-color: green">



		<h1 style="margin: 2%; margin-bottom: 0">Terreno n°${terreno.id}
			di ${azienda.ragioneSociale}</h1>
		<h3 style="margin: 2%; margin-top: 0; margin-left: 3%">${terreno.locazione}</h3>
		<h4 id="terrenoDisp" style="margin-left: 65%; margin-bottom: -1%;"></h4>

		<div class="row" style="width: 100%; margin: 0">
			<div class="scegli" style="width: 100%" id="myscegli">


				<div class="form-row form-group" align="center"
					style="margin-bottom: 0">


					<c:choose>
						<c:when test="${terreno.servizioCompleto==true}">
							<label style="margin: 2%"><strong>Servizio
									Completo: selezionare gli ortaggi e la quantità da coltivare
									nel periodo <em>${terreno.periodiDisponibilita }</em>
							</strong></label>
							<label style="margin-top: 2%; margin-left: 12%"> <strong>Coltivabili
									in serra</strong></label>
							<label class="switch"><input type="checkbox"
								id="switchDiv"> <span class="slider round"></span> </label>


						</c:when>
						<c:otherwise>
							<script>
								$("#myscegli").addClass("disabilita");
							</script>

							<label style="margin: 2%"><strong>Questo terreno
									non offre un servizio completo </strong></label>
							<label style="margin-top: 2%; margin-left: 27%"> <strong>Coltivabili
									in serra</strong></label>
							<label class="switch"><input type="checkbox"
								id="switchDiv"> <span class="slider round"></span> </label>
						</c:otherwise>
					</c:choose>


				</div>


				<div class="form-row form-group" style="width: 100%" id="noserra">
					<div class="table-responsive" id="table-scroll"
						style="margin-right: 2%; margin-left: 2%">
						<table class="table table-hover">
							<thead>
								<tr>
									<th></th>
									<th><strong>Nome</strong></th>
									<th><strong>Resa</strong></th>
									<th class="text-center"><strong>Tempo
											Coltivazione</strong></th>
									<th><strong>Prezzo(al m<SUP>2</SUP>)
									</strong></th>
									<th><strong>Quantità</strong></th>

								</tr>
							</thead>
							<tbody id="items">
								<c:forEach items="${ortaggi}" var="o">
									<c:if
										test="${ (terreno.periodiDisponibilita == o.periodoColtivazione || o.periodoColtivazione == 'Annuale') &&
										 terreno.servizioCompleto == true}">
										<tr class="accordion-toggle" data-toggle="collapse">
											<td><label style="display: block; text-align: center"><input
													type="checkbox" value="${o}" name="ortaggiSelezionati"
													id="${o.id}" onclick="cancellaRiga('${o.nome}', '${o.id}')"></label></td>
											<td>${o.nome}</td>
											<td>${o.resa}</td>
											<td class="text-center">${o.tempoColtivazione}  giorni</td>
											<td class="text-center">${o.prezzo}  €</td>
											<td><input class="input-column" type="text"
												style="max-width: 80px" id="${o.id}input"
												onchange="aggiornaResocontoTerreno('${o.nome}', this.value, '${o.resa}', '${o.prezzo}', '${o.id}', 
												'${terreno.dimensione}', '${terreno.dimensioneSerra}', this.id)">
												<!-- 'dimensioneTerreno(${terreno.dimensione}, ${terreno.dimensioneSerra}) -->
												m<sup>2</sup></td>
										</tr>
									</c:if>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>




				<div class="form-row form-group"
					style="width: 100%; display: none !important;" id="serra">
					<div class="table-responsive" id="table-scroll"
						style="margin-right: 2%; margin-left: 2%">
						<table class="table table-hover">
							<thead>
								<tr>
									<th></th>
									<th><strong>Nome</strong></th>
									<th><strong>Resa</strong></th>
									<th class="text-center"><strong>Tempo
											Coltivazione</strong></th>
									<th><strong>Prezzo(al m<SUP>2</SUP>)
									</strong></th>
									<th><strong>Quantità</strong></th>

								</tr>
							</thead>
							<tbody id="items">
								<c:forEach items="${ortaggi}" var="o">
									<c:if test="${terreno.servizioCompleto == true}">
										<tr class="accordion-toggle" data-toggle="collapse">
											<td><input type="checkbox" value="${o}"
												name="ortaggiSelezionati" id="${o.id}S"
												onclick="cancellaRiga('${o.nome}', '${o.id}')"></td>
											<td>${o.nome}</td>
											<td>${o.resa}</td>
											<td class="text-center">${o.tempoColtivazione}  giorni</td>
											<td class="text-center">${o.prezzo}  €</td>
											<td><input class="input-column" type="text"
												style="max-width: 80px" id="${o.id}inputS"
												onchange="aggiornaResocontoSerra('${o.nome}', this.value, '${o.resa}', '${o.prezzo}', '${o.id}S',
												'${terreno.dimensioneSerra}', this.id)">
												m<sup>2</sup></td>
										</tr>
									</c:if>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<!-- fine div NOSERRA -->

			</div>
		</div>
		<div class="soloTerreno" id="mysoloTerreno">



			<div class="form-row form-group" align="center"
				style="margin-bottom: 0">




				<c:choose>
					<c:when test="${terreno.servizioParziale==true}">
						<label style="margin: 2%"><strong>Servizio
								Parziale: selezionare la quantità di terreno da affittare </strong></label>

					</c:when>
					<c:otherwise>
						<script>
							$("#mysoloTerreno").addClass("disabilita");
						</script>

						<label style="margin: 2%"><strong>Questo terreno
								non offre un servizio parziale </strong> </label>
					</c:otherwise>
				</c:choose>

			</div>
			<div class="form-row form-group" style="width: 100%">
				<div class="table-responsive"
					style="margin-right: 2%; margin-left: 2%">
					<table class="table table-hover">
						<thead>
							<tr>
								<th></th>
								<th><strong>Sito in</strong></th>
								<th><strong>Periodo coltivazione</strong></th>
								<th><strong>Prezzo(al m<SUP>2</SUP>)
								</strong></th>
								<th><strong>Quantità</strong></th>

							</tr>
						</thead>
						<tbody id="items">
							<c:if test="${terreno.servizioParziale == true }">
								<tr class="accordion-toggle" data-toggle="collapse">
									<td><input type="checkbox" name="nameTerrenoSolo"
										id="soloTerreno"
										onclick="cancellaRiga('${o.nome}', '${o.id}')"></td>
									<td>${terreno.locazione}</td>
									<td>${terreno.periodiDisponibilita}</td>
									<td>${terreno.costo}€</td>
									<td><input class="input-column" type="text"
										style="max-width: 80px" id="terrenoSolo"
										onchange="aggiornaResocontoTerreno('Terreno', this.value, '-', '${terreno.costo}', 'soloTerreno', 
												'${terreno.dimensione}', '${terreno.dimensioneSerra}', this.id)">
										m<sup>2</sup></td>
								</tr>
							</c:if>
						</tbody>
					</table>
				</div>
			</div>



		</div>
		<!-- FINE DIV SOLOTERRENO -->
		<!--  card resoconto -->


		<div class="container-fluid"
			style="margin-right: 0; padding: 0; margin: 2%">
			<!--  col-xl-8 -->
			<div class="row">


				<div class="col-sm-3" style="margin: 2%; margin-top: 5%">
					<ul>
						<li><input style="width: 23px; height: 20px;" type="checkbox" name="paypolCheckbox" id="paypalL"
							value="Ford"> <label class="paypal" for="paypalL"><img
								src="assets\img\ruotaStagioni\ImgPaypal.jpg" /></label></li>
						<li><input style="width: 23px; height: 20px;" type="checkbox" name="postapayCheckbox"
							id="postapay" value="Ford"> <label class="mastercard"
							for="postapay"><img
								src="assets\img\ruotaStagioni\ImgMastercard.jpg" /></label></li>
					</ul>
				</div>
				<div class="col-sm-8" style="margin: 2%">
					<!-- container mb-4 -->
					<div class="row table-responsive" style="margin: 0">
						<!-- <form action="SalvaPrenotazione" method="get"> -->
								
						<div class="col-12">
							<div>
								<!--  class="table-responsive" -->
								<table class="table table-striped" id="tabellaResoconto">
									<thead>
										<tr>
											<!-- <th scope="col"></th> -->
											<th scope="col">Ortaggi</th>
											<th scope="col">Quantità</th>
											<th scope="col">Resa</th>
											<th scope="col">Prezzo</th>
											<th scope="col">Serra</th>
											<th></th>
										</tr>
									</thead>
									<tbody id="body">

										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td>Parziale €</td>
											<td class="text-right" id="parziale"></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td>Imposte €</td>
											<td class="text-right" id="imposte"></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td><strong>Totale €</strong></td>
											<td class="text-right" id="totale"></td>
										</tr>
									</tbody>
								</table>

								<div class="row">
									<!-- <div class="col-sm-12  col-md-6">
										<button class="btn btn-block btn-light">Continua</button>
									</div> -->
									
									<div class="col-sm-12 col-md-6 text-right">
										<button class="button" onclick="prova()">Conferma</button>
										<!-- class="btn btn-lg btn-block btn-success text-uppercase" -->
									
									</div>
								
								</div>

							</div>
						</div>
					<!-- </form> -->
					</div>
				</div>
			</div>
		</div>



	</div>
	<!-- fine container principale -->


	<!-- Modal -->
	<div id="modalError" class="modal fade" role="dialog"
		style="z-index: 2500; border-radius: 25px">

		<div class="modal-dialog" style="border: 2px green solid">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Dimensione massima superata!</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<p>La quantità degli ortaggi selezionati è maggiore della
						dimensione massima di terreno disponibile.</p>
				</div>
				<div class="modal-footer">
					<div class="container" align="right">
						<input type="text" style="display: none" id="tempId" name="tempId">
						<input type="text" style="display: none" id="delete" name="delete"
							value="true">
						<button type="submit" class="btn btn-success"
							style="border-radius: 15px" data-dismiss="modal">OK</button>
					</div>
				</div>
			</div>

		</div>
	</div>
	<!-- end modal -->



	<!-- Modal -->
	<div id="modalErrorOrt" class="modal fade" role="dialog"
		style="z-index: 2500; border-radius: 25px">

		<div class="modal-dialog" style="border: 2px green solid">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Ortaggio già inserito!</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<p>Un ortaggio non può essere selezionato sia per il terreno
						che per la serra.</p>
					<p>Cancella l'ortaggio interessato dalla selezione e fai la tua
						scelta.</p>
				</div>
				<div class="modal-footer">
					<div class="container" align="right">
						<input type="text" style="display: none" id="tempId" name="tempId">
						<input type="text" style="display: none" id="delete" name="delete"
							value="true">
						<button type="submit" class="btn btn-success"
							style="border-radius: 15px" data-dismiss="modal">OK</button>
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