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
		$("#switchDiv").click(function() {

			if ($(this).is(':checked')) {
				$("#noserra").hide("slow");
				$("#serra").show("slow");
			}
			if (!$(this).is(':checked')) {

				$("#serra").hide("slow");
				$("#noserra").show("slow");
			}
		});
	});
</script>

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


		<div class="row" style="width: 100%; margin: 0">
			<div class="scegli" style="width: 100%" id="myscegli">


				<div class="form-row form-group" align="center"
					style="margin-bottom: 0">


					<c:choose>
						<c:when test="${terreno.servizioCompleto==true}">
							<label style="margin: 2%"><strong>Servizio
									Completo: selezionare gli ortaggi e la quantità da coltivare nel periodo <em>${terreno.periodiDisponibilita }</em> </strong></label>
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
											<td><input type="checkbox" value="${o}"
												name="ortaggiSelezionati" id="${o.id}" onclick="cancellaRiga('${o.nome}', '${o.id}')"></td>
											<td>${o.nome}</td>
											<td>${o.resa}</td>
											<td class="text-center">${o.tempoColtivazione}  giorni</td>
											<td class="text-center">${o.prezzo}  €</td>
											<td><input class="input-column" type="text"
												style="max-width: 80px" id="q" onchange="aggiornaResoconto('${o.nome}', this.value, '${o.resa}', '${o.prezzo}', ${o.id})"> / ${terreno.dimensione} m<sup>2</sup></td>
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
									<tr class="accordion-toggle" data-toggle="collapse">
										<td><input type="checkbox" value="${o.id}"
											name="ortaggiSelezionati"></td>
										<td>${o.nome}</td>
										<td>${o.resa}</td>
										<td class="text-center">${o.tempoColtivazione}  giorni</td>
										<td class="text-center">${o.prezzo}€</td>
										<td><input class="input-column" type="text"
											style="max-width: 80px"> / ${terreno.dimensione} m<sup>2</sup></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>   	<!-- fine div NOSERRA -->

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
									<td><input type="checkbox" value="soloTerreno"
										name="ortaggiSelezionati"></td>
									<td>${terreno.locazione}</td>
									<td>${terreno.periodiDisponibilita}</td>
									<td>${terreno.costo}€</td>
									<td><input class="input-column" type="text"
										style="max-width: 80px"> / ${terreno.dimensione} m<sup>2</sup></td>
								</tr>
							</c:if>
						</tbody>
					</table>
				</div>
			</div>



		</div>
		<!-- FINE DIV SOLOTERRENO -->
		<!--  card resoconto -->

		<div class="container col-xl-8" style="margin-right: 0; padding: 0">
			<div class="resoconto" >
				<!-- container mb-4 -->
				<div class="row table-responsive" style="margin: 0">
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
										<th></th>
									</tr>
								</thead>
								<tbody id="body">
									
									<tr>
										<td></td>
										<td></td>
										<td></td>
										<td>Parziale</td>
										<td class="text-right" id="parziale">0</td>
									</tr>
									<tr>
										<td></td>
										<td></td>
										<td></td>
										<td>Imposte</td>
										<td class="text-right" id="imposte"></td>
									</tr>
									<tr>
										<td></td>
										<td></td>
										<td></td>
										<td><strong>Totale</strong></td>
										<td class="text-right" id="totale"><strong></strong></td>
									</tr>
								</tbody>
							</table>

							<div class="row">
								<div class="col-sm-12  col-md-6">
									<button class="btn btn-block btn-light">Continua</button>
								</div>
								<div class="col-sm-12 col-md-6 text-right">
									<button class="button">Conferma</button>
									<!-- class="btn btn-lg btn-block btn-success text-uppercase" -->
								</div>
							</div>

						</div>
					</div>

				</div>
			</div>
		</div>



	</div>
	<!-- fine container principale -->


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