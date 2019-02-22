<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<script src="assets/js/jquery.min.js"></script>
<link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	id="bootstrap-css">
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>

<link rel="stylesheet" href="assets/css/backend.css">
<link rel="stylesheet" href="assets/css/home.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<title>Area Azienda</title>

<meta charset="ISO-8859-1">
<title>profilo azienda</title>
</head>
<body>

	<div id="navbar"></div>
	<div class="container-fluid border-profile">
		<div class="row" style="margin-top: 30px; margin-bottom: 30px">
			<div class="col-sm-8" align="left">
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
				<div class="container-fluid border-info-style">
					<div class="table-responsive" style="margin-bottom: 15px">
						<ul class="list-group">
							<li class="list-group-item text-center style-info"
								style="border-bottom: green 1px solid"><strong>Dati
									Azienda</strong></li>
							<li class="list-group-item text-left style-info"
								style="border-bottom: green 1px solid;"><span
								class="pull-left"><strong>Referente</strong></span>
								${sessionScope.azienda.getReferente() }</li>
							<li class="list-group-item text-left style-info"
								style="border-bottom: green 1px solid;"><span
								class="pull-left"><strong>Email</strong></span>
								${sessionScope.azienda.getEmail() }</li>
							<li class="list-group-item text-left style-info"
								style="border-bottom: green 1px solid"><span
								class="pull-left"><strong>Telefono</strong></span>
								${sessionScope.azienda.getTelefono() }</li>
							<li class="list-group-item text-left style-info"><span
								class="pull-left"><strong>Partita IVA</strong></span>
								${sessionScope.azienda.getPartitaIVA() }</li>
						</ul>
					</div>
				</div>
				<!-- end info laterali -->
			</div>

			<div class="col-sm-9" id="div-disp">

				<!-- navbar profilo -->

				<div class="navbar-collapse topnav " style="border-color: green;">
					<ul class="nav nav-pills">
						
						<li><a data-toggle="tab" href="#tabStatistiche">Statistiche</a></li>
						<li><a data-toggle="tab" href="#imieiterreni">I miei
								terreni</a></li>
						<li><a data-toggle="tab" href="#imieiprodotti">I miei
								prodotti</a></li>
						<li><a data-toggle="tab" href="#prenotazioni" onclick="prenotazioniAzienda()">Prenotazioni</a></li>
						<li class="active"><a data-toggle="tab" href="#modificadati">
								Dati Azienda</a></li>

					</ul>
				</div>

				<!-- end navbar profilo -->

				<!-- form azienda -->
				<div class="tab-content clearfix">
					<div class="custom-form tab-pane" style="margin-top: 20px"
						id="modificadati">
						<form action="InserisciAzienda?edit=true" method="post">
							<div class="row">
								<div class="col-md-6 ">
									<br>
									<div class="form-row form-group" style="display: none">
										<div class="col-xs-2">
											<input class="input-column" type="text" name="id_azienda" id="id_azienda"
												value="${sessionScope.azienda.getId()}">
										</div>

									</div>
									<div class="form-row form-group">

										<div class="col-md-4">
											<label class="label-column">Ragione Sociale</label>
										</div>
										<div class="col-xs-2">
											<input class="input-column" type="text" disabled="disabled"
												name="ragione_sociale"
												value="${sessionScope.azienda.getRagioneSociale()}">
										</div>

									</div>
									<br>
									<div class=" form-row form-group">

										<div class="col-md-4">
											<label class="label-column">Referente *</label>
										</div>
										<div class="col-xs-2">
											<input class="input-column" type="text" name="referente"
												value="${sessionScope.azienda.getReferente()}">
										</div>

									</div>
									<br>
									<div class="form-row form-group">

										<div class="col-md-4 ">
											<label class="label-column">Sede Legale *</label>
										</div>
										<div class="col-xs-2 ">
											<input class="input-column" type="text" name="sede_legale"
												value="${sessionScope.azienda.getSedeLegale()}">
										</div>

									</div>
									<br>
									<div class="form-row form-group">

										<div class="col-md-4 ">
											<label class="label-column">Indirizzo *</label>
										</div>
										<div class="col-xs-2 ">
											<input class="input-column" type="text" name="indirizzo"
												value="${sessionScope.azienda.getIndirizzo()}">
										</div>

									</div>
									<br>
									<div class="form-row form-group">

										<div class="col-md-4 ">
											<label class="label-column">Citta' *</label>
										</div>
										<div class="col-xs-2 ">
											<input class="input-column" type="text" name="citta"
												value="${sessionScope.azienda.getCitta()}">
										</div>

									</div>
								</div>


								<div class="col-md-6">
									<br>
									<div class="form-row form-group">

										<div class="col-md-4 ">
											<label class="label-column">CAP *</label>
										</div>
										<div class="col-xs-2">
											<input class="input-column" type="text" name="cap"
												value="${sessionScope.azienda.getCap()}">
										</div>

									</div>
									<br>
									<div class="form-row form-group">

										<div class="col-md-4 ">
											<label class="label-column">Provincia *</label>
										</div>
										<div class="col-xs-2">
											<input class="input-column" type="text" name="provincia"
												value="${sessionScope.azienda.getProvincia()}">
										</div>

									</div>
									<br>
									<div class="form-row form-group">

										<div class="col-md-4">
											<label class="label-column">P.Iva</label>
										</div>
										<div class="col-xs-2">
											<input class="input-column" type="text" name="partita_iva"
												disabled="disabled" value="${azienda.getPartitaIVA()}">
										</div>

									</div>
									<br>
									<div class="form-row form-group">

										<div class="col-md-4">
											<label class="label-column">Telefono *</label>
										</div>
										<div class="col-xs-2">
											<input class="input-column" type="tel" name="telefono"
												value="${sessionScope.azienda.getTelefono()}">
										</div>

									</div>
									<br>
									<div class="form-row form-group">

										<div class="col-md-4">
											<label class="label-column">Email</label>
										</div>
										<div class="col-xs-2">
											<input class="input-column" type="text" name="email"
												disabled="disabled"
												value="${sessionScope.azienda.getEmail()}">
										</div>

									</div>
								</div>
							</div>
							<br>

							<div style="text-align: center; whidt: 100%; margin-top: 25px">
								<div align="center">
									<label class="label-column">Descrizione Servizi Offerti
										*</label>
								</div>
								<textarea class="form-control"
									style="margin-left: auto; margin-right: auto; resize: none; border: 2px green solid; border-radius: 15px; min-height: 150px; background-color: #cfc7af; min-width: 100%;"
									maxlength="1000" name="formDescrizione">${sessionScope.azienda.getDescrizioneServizi()}</textarea>
							</div>
							<br>
							<div class="container-fluid" align="right">
								<p>
									<strong>(*) questi campi possono essere modificati</strong>
								</p>
							</div>
							<br>
							<div class="organize" align="center">
								<button class="button buttonoverflow btn" type="submit">Salva</button>
							</div>
						</form>
					</div>
					<!-- terreni -->
					<div class="tab-pane" style="margin-top: 20px;" id="imieiterreni">
						<div class="container" id="terreni">
							<div class="table-responsive">
								<table class="table table-hover">
									<thead>
										<tr align="center">
											<th>Locazione</th>
											<th>Dimensione</th>
											<th>Dimensione Serra</th>
											<th>Servizio Completo</th>
											<th>Servizio Parziale</th>
											<th>Periodo Coltivazione</th>
											<th>Costo</th>
											<th>Modifica</th>
											<th>Elimina</th>
										</tr>
									</thead>
									<tbody id="items">


										<c:forEach items="${terreni}" var="t">
											<tr data-toggle="collapse" data-target="#demo1"
												class="accordion-toggle " align="center">

												<td>${t.locazione}</td>
												<td>${t.dimTerreno }</td>
												<td>${t.dimSerra }</td>
												<td><c:choose>
														<c:when test="${t.servizioCompleto}">SI</c:when>
														<c:otherwise>NO</c:otherwise>
													</c:choose></td>
												<td><c:choose>
														<c:when test="${t.servizioParziale}">SI</c:when>
														<c:otherwise>NO</c:otherwise>
													</c:choose></td>
												<td>${t.periodiDisponibilita}</td>
												<td>${t.costo}€</td>
												<td>
													<button
														onclick="edit('${t.id}','${t.locazione}', '${t.dimTerreno}', '${t.dimSerra}','${t.costo}', '${t.servizioCompleto}', '${t.servizioParziale}', '${t.periodiDisponibilita}')"
														name="${t.id}" type="button" id="modifica"
														class="button_modifica btn"></button>
												</td>
												<td>
													<%-- <a
												href="TerrenoOspitaOrtaggi?delete=true&id=${t.id}">
													<button type="submit" class="button_elimina btn"></button>
											</a> --%>

													<button type="button" name="${t.id}" data-toggle="modal"
														data-target="#modalDelete" class="button_elimina btn"
														onclick="del('${t.id}'); "></button>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<div align="center" style="margin-top: 30px">
								<a href="PageLoader?id=inserimentoTerreno">
									<button class="button buttonoverflow btn" type="submit">Aggiungi
										Terreno</button>
								</a>
							</div>
						</div>

						<!-- modifica terreno-->
						<div class="container" id="info_terreno"
							style="display: none; margin-top: 20px">
							<div class="container" id="formModificaTerreno">
								<div align="center">
									<h4>Informazioni sul Terreno</h4>
								</div>
								<form class="custom-form" method="post"
									action="TerrenoOspitaOrtaggi?edit=true">
									<div class="row" style="margin-top: 40px">
										<div class="col-md-6 ">
											<div class="form-row form-group" style="display: none;">
												<div class="col-xs-2" style="display: none !important">
													<input class="input-column" type="text" id="editFormId"
														name="editFormId">
												</div>
											</div>
											<div class="form-row form-group">
												<div class="col-md-4">
													<label class="label-column">Locazione</label>
												</div>
												<div class="col-xs-2">
													<input class="input-column" type="text" disabled="disabled"
														id="editFormLocazione">
												</div>
											</div>
											<br>
											<div class="form-row form-group">

												<div class="col-md-4">
													<label class="label-column">Dimensione (mt²)</label>
												</div>
												<div class="col-xs-2">
													<input class="input-column" type="text"
														id="editFormDimensione" name="editFormDimensione">
												</div>

											</div>
											<br>
											<div class="form-row form-group">
												<div class="col-md-4">
													<label class="label-column">Dimensione Serra (mt²)</label>
												</div>
												<div class="col-xs-2">
													<input class="input-column" type="text"
														id="editFormDimensioneSerra"
														name="editFormDimensioneSerra">
												</div>
											</div>
											<br>
										</div>
										<div class="col-md-6 ">
											<div class="form-row form-group">
												<div class="col-md-4">
													<label class="label-column">Costo (€/mt²)</label>
												</div>
												<div class="col-xs-2">
													<input class="input-column" type="text" id="editFormCosto"
														name="editFormCosto">
												</div>
											</div>
											<br>
											<div class="form-row form-group">
												<div class="col-md-4" align="left">
													<label class="label-column">Periodo Disponibilita'</label>
												</div>
												<div class="col-xs-2">
													<select class="input-column"
														style="margin: 3%; padding: 3px;"
														id="dropdownDisponibilita" name="dropdownDisponibilita">
														<option value="primavera">Primavera</option>
														<option value="estate">Estate</option>
														<option value="autunno">Autunno</option>
														<option value="inverno">Inverno</option>
														<!-- <option value="annuale">Annuale</option>  -->
													</select>
												</div>
											</div>
											<br>
											<div class="form-row form-group">
												<label class="label-column"><strong>Seleziona
														i sevizi</strong></label>
											</div>
											<div class="form-check" align="left">
												<input id="editCheckParziale" type="checkbox"
													name="editCheckParziale" value="parziale"><label>
													Servizio Parziale</label>
											</div>
											<br>
											<div class="form-check" align="left">
												<input id="editCheckCompleto" type="checkbox"
													name="editCheckCompleto" value="completo"><label>
													Servizio Completo</label>
											</div>
											<br>
										</div>
									</div>
									<!-- Ortaggi terreno -->
									<div class="container" id="containerModificaOrtaggi"
										style="margin-top: 20px">
										<div align="center">
											<h4>Ortaggi Coltivabili</h4>
										</div>
										<div class="table-responsive" id="table-scroll" style="margin-top: 20px">
											<table class="table table-hover" id="formModificaOrtaggi">
												<thead>
													<tr align="center">
														<th><strong>Nome</strong></th>
														<th><strong>Resa</strong></th>
														<th><strong>Prezzo</strong></th>
														<th><strong>Tempo Coltivazione</strong></th>
														<th><strong>Modifica</strong></th>
														<th><strong>Elimina</strong></th>
													</tr>
												</thead>
												<tbody id="items">
												</tbody>
											</table>
										</div>
									</div>
									<div align="center">
										<button class="button buttonoverflow btn"
											id="annulla_modifica" type="button">Annulla</button>
										<button class="button buttonoverflow btn" type="submit">Salva</button>
										<button class="button buttonoverflow btn" type="button" id="buttonAggiungiOrtaggio" onclick="funAggiungiOrtaggi()">Aggiungi Ortaggio</button>
									</div>
								</form>
							</div>	
						</div>
						<!-- end modifiche terreno -->
						
						<!-- modifca ortaggi terreno -->
							<div class="container" id="formModificaOrtaggio"
								style="display: none">
								<div align="center">
									<h4>Modifica dati Ortaggi</h4>
								</div>
								<form class="custom-form" method="POST"
									action="">
									<div class="row" style="margin-top: 40px">
										<div class="col-md-6 ">
											<div class="form-row form-group" style="display: none;">
												<div class="col-xs-2" >
													<input class="input-column" type="text" id="editOrtaggioId"
														name="editOrtaggioId">
												</div>
											</div>
											<div class="form-row form-group">
												<div class="col-md-4">
													<label class="label-column">Nome</label>
												</div>
												<div class="col-xs-2">
													<input class="input-column" type="text" disabled="disabled"
														id="editOrtaggioNome">
												</div>
											</div>
											<br>
											<div class="form-row form-group">

												<div class="col-md-4">
													<label class="label-column">Resa</label>
												</div>
												<div class="col-xs-2">
													<input class="input-column" type="text"
														id="editOrtaggioResa" name="editOrtaggioResa">
												</div>
											</div>
											<br>
										</div>

										<div class="col-md-6 ">
											<div class="form-row form-group">
												<div class="col-md-4">
													<label class="label-column">Costo €</label>
												</div>
												<div class="col-xs-2">
													<input class="input-column" type="text"
														id="editOrtaggioCosto" name="editOrtaggioCosto">
												</div>
											</div>
											<br>
											<div class="form-row form-group">
												<div class="col-md-4">
													<label class="label-column">Tempo Coltivazione</label>
												</div>
												<div class="col-xs-2">
													<input class="input-column" type="text"
														id="editOrtaggioTempo" name="editOrtaggioTempo">
												</div>
											</div>
										</div>
									</div>
									<div align="center">
										<button class="button buttonoverflow btn"
											id="annulla_ortaggio" type="button">Annulla</button>
										<button class="button buttonoverflow btn" id="confermaModificaOrtaggio" type="submit">Salva</button>
									</div>
								</form>
							</div>
							<!-- end modifica ortaggio -->
					</div>
					<!-- end terreni -->

					<!--prodotti -->
					<div class="tab-pane" style="margin-top: 20px; margin-bottom: 50px"
						id="imieiprodotti">
						<div class="container-fluid" id="prodotti">
							<div class="table-responsive">
								<table class="table table-hover">
									<thead>
										<tr align="center">
											<th>Nome</th>
											<th>Categoria</th>
											<th>Prezzo</th>
											<th>Quantita'</th>
											<th>Modifica</th>
											<th>Elimina</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${prodotti}" var="p">
											<tr align="center">
												<td>${p.nome}</td>
												<td>${p.categoria}</td>
												<td>${p.costoUnitario}</td>
												<td>${p.quantita}</td>
												<td><button class="button_modifica btn" type="button"
														onclick="prodotto('${p.id}','${p.nome}','${p.categoria}','${p.costoUnitario}','${p.quantita}','${p.descrizione}')"></button></td>

												<td><button class="button_elimina btn"
														data-toggle="modal" data-target="#deleteProdotto"
														type="button" name="${p.id}"
														onclick="delProdotto('${p.id}');"></button></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<div align="center" style="margin-top: 30px">
								<a href="inserimentoProdotto.jsp">
									<button class="button buttonoverflow btn" type="submit">Aggiungi
										Prodotto</button>
								</a>
							</div>
						</div>
						<div class="container-fluid" id="info_prodotto"
							style="margin-top: 20px; display: none">
							<div class="container" id="formModificaTerreno">
								<div align="center">
									<h4>Modifica dati Prodotto</h4>
								</div>
								<form action="InserisciProdotto?edit=true" method="post"
									id="modificaProdotto">
									<div class="row" style="margin-top: 40px">
										<div class="col-md-6 ">
											<div class="form-row form-group" style="display: none;">
												<div class="col-xs-2" style="display: none !important">
													<input class="input-column" type="text" id="editProdottoId"
														name="editProdottoId">
												</div>
											</div>
											<div class="form-row form-group">
												<div class="col-md-4">
													<label class="label-column">Nome</label>
												</div>
												<div class="col-xs-2">
													<input class="input-column" type="text" disabled="disabled"
														id="editProdottoNome" name="editProdottoNome">
												</div>
											</div>
											<div class="form-row form-group">
												<div class="col-md-4">
													<label class="label-column">Categoria</label>
												</div>
												<div class="col-xs-2">
													<input class="input-column" type="text"
														id="editProdottoCategoria" disabled="disabled"
														name="editProdottoCategoria">
												</div>
											</div>
										</div>
										<div class="col-md-6 ">
											<div class="form-row form-group">
												<div class="col-md-4">
													<label class="label-column">Costo €</label>
												</div>
												<div class="col-xs-2">
													<input class="input-column" type="text"
														id="editProdottoCosto" name="editProdottoCosto">
												</div>
											</div>
											<div class="form-row form-group">
												<div class="col-md-4">
													<label class="label-column">Quantita'</label>
												</div>
												<div class="col-xs-2">
													<input class="input-column" type="text"
														id="editProdottoQuantita" name="editProdottoQuantita">
												</div>
											</div>
										</div>
									</div>
									<div style="text-align: center; whidt: 100%; margin-top: 25px">
										<div align="center">
											<label class="label-column">Descrizione Prodotti
												Offerti *</label>
										</div>
										<textarea class="form-control"
											style="margin-left: auto; margin-right: auto; resize: none; border: 2px green solid; border-radius: 15px; min-height: 150px; background-color: #cfc7af; min-width: 100%;"
											maxlength="1000" name="editProdottoDescrizione"
											id="editProdottoDescrizione"></textarea>
									</div>
									<br>
									<div class="container-fluid" align="center">
										<button class="button buttonoverflow btn" type="button"
											id="annulla_prodotto">Annulla</button>
										<button class="button buttonoverflow btn" id="buttonoverflow">Salva</button>
									</div>
								</form>

							</div>
						</div>
						<!-- end prodotti -->
					</div>
					<!-- prenotazioni -->
					<div class="tab-pane" style="margin-top: 20px; margin-bottom: 50px"
						id="prenotazioni">
						<div class="container-fluid" align="center">
							<h4>Prenotazioni Terreni</h4>
						</div>
						
					</div>	
					<!-- end prenotazioni -->
					<!-- statistiche -->
					<div class="tab-pane active" style="margin-top: 20px; margin-bottom: 50px"
						id="tabStatistiche">
							<canvas id="myChart"></canvas>
					</div>
					<!-- end statistiche -->
				</div>
			</div>
		</div>
		<!-- Modal TERRENI-->
		<div id="modalDelete" class="modal fade" role="dialog"
			style="z-index: 2500; border-radius: 25px">

			<div class="modal-dialog" style="border: 2px green solid">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Elimina Terreno</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<p>Sei sicuro di voler eliminare questo terreno?</p>
					</div>
					<div class="modal-footer">
						<form action="TerrenoOspitaOrtaggi" method="get">
							<div class="container" align="right">
								<input type="text" style="display: none" id="idDaEliminare"
									name="tempId"> <input type="text" style="display: none"
									id="delete" name="delete" value="true">
								<button type="button" class="btn" style="border-radius: 15px"
									data-dismiss="modal" id="buttonoverflow">Annulla</button>
								<button type="submit" class="btn btn-success"
									style="border-radius: 15px" id="buttonoverflow">Conferma</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end modal -->

	<!-- Modal PRODOTTI-->
	<div id="deleteProdotto" class="modal fade" role="dialog"
		style="z-index: 2500; border-radius: 25px">

		<div class="modal-dialog" style="border: 2px green solid">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Elimina Prodotto</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<p>Sei sicuro di voler eliminare questo prodotto?</p>
				</div>
				<div class="modal-footer">
					<form action="InserisciProdotto" method="get">
						<div class="container" align="right">
							<input type="text" style="display: none;"
								id="prodottoDaEliminare" name="tempId"> <input
								type="text" style="display: none" id="delete" name="delete"
								value="true">
							<button type="button" class="btn" style="border-radius: 15px"
								data-dismiss="modal" id="buttonoverflow">Annulla</button>
							<button type="submit" class="btn btn-success"
								style="border-radius: 15px" id="buttonoverflow">Conferma</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- end modal -->
	<div id="footer"></div>
	<script src="assets/js/profileAzienda.js"></script>
</body>
</html>