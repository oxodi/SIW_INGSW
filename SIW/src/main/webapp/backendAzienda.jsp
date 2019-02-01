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

<script>
	function edit(id, locazione, dim, dimSerra, costo, servizioC, servizioP,
			periodo) {
		$("#editFormId").val(id);
		$("#editFormLocazione").val(locazione);
		$("#editFormDimensione").val(dim);
		$("#editFormDimensioneSerra").val(dimSerra);
		$("#editFormCosto").val(costo);
		if (servizioC === 'true') {
			$("#editCheckCompleto").attr('checked', true);
		} else {
			$("#editCheckCompleto").attr('checked', false);
		}
		if (servizioP === 'true') {
			$("#editCheckParziale").attr('checked', true);
		} else {
			$("#editCheckParziale").attr('checked', false);
		}
		$('#dropdownDisponibilita').val(periodo);
		$("#terreni").hide("slow");
		$("#info_terreno").show("slow");

	}
</script>

<script>
	function del(id) {
		$("#tempId").val(id);
		
	}
</script>
<script>
	$(document).ready(function() {
		$("#annulla_modifica").click(function() {
			$("#terreni").show("slow");
			$("#info_terreno").hide("slow");

		});
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
						<form action="">
							<div class="row">
								<div class="col-md-6 ">
									<br>
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
											<label class="label-column">Referente</label>
										</div>
										<div class="col-xs-2">
											<input class="input-column" type="text" name="referente"
												value="${sessionScope.azienda.getReferente()}">
										</div>

									</div>
									<br>
									<div class="form-row form-group">

										<div class="col-md-4 ">
											<label class="label-column">Sede Legale</label>
										</div>
										<div class="col-xs-2 ">
											<input class="input-column" type="text" name="sede_legale"
												value="${sessionScope.azienda.getSedeLegale()}">
										</div>

									</div>
									<br>
									<div class="form-row form-group">

										<div class="col-md-4 ">
											<label class="label-column">Indirizzo</label>
										</div>
										<div class="col-xs-2 ">
											<input class="input-column" type="text" name="indirizzo"
												value="${sessionScope.azienda.getIndirizzo()}">
										</div>

									</div>
									<br>
									<div class="form-row form-group">

										<div class="col-md-4 ">
											<label class="label-column">Citta'</label>
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
											<label class="label-column">CAP</label>
										</div>
										<div class="col-xs-2">
											<input class="input-column" type="text" name="cap"
												value="${sessionScope.azienda.getCap()}">
										</div>

									</div>
									<br>
									<div class="form-row form-group">

										<div class="col-md-4 ">
											<label class="label-column">Provincia</label>
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
												value="${azienda.getPartitaIVA()}">
										</div>

									</div>
									<br>
									<div class="form-row form-group">

										<div class="col-md-4">
											<label class="label-column">Telefono</label>
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
												value="${sessionScope.azienda.getEmail()}">
										</div>

									</div>
								</div>
							</div>
							<br>
							<div style="text-align: center; whidt: 100%; margin-top: 25px">
								<div align="center">
									<label class="label-column">Descrizione Servizi Offerti</label>
								</div>
								<textarea class="form-control"
									style="margin-left: auto; margin-right: auto; resize: none; border: 2px green solid; border-radius: 15px; min-height: 150px; background-color: #cfc7af; min-width: 100%;"
									maxlength="1000" name="formDescrizione">${sessionScope.azienda.getDescrizioneServizi()}</textarea>
							</div>
							<br>
							<div align="center">
								<button class="button btn" type="submit">Salva</button>
							</div>
						</form>
					</div>
					<div class="tab-pane" style="margin-top: 20px; margin-bottom: 50px"
						id="imieiterreni">
						<div class="table-responsive" id="terreni">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>Locazione</th>
										<th>Dimensione</th>
										<th>Dimensione Serra</th>
										<th>Servizio Completo</th>
										<th>Servizio Parziale</th>
										<th>Periodo Coltivazione</th>
										<th>Modifica</th>
										<th>Elimina</th>
									</tr>
								</thead>
								<tbody id="items">


									<c:forEach items="${terreni}" var="t">
										<tr data-toggle="collapse" data-target="#demo1"
											class="accordion-toggle ">

											<td>${t.locazione}</td>
											<td>${t.dimensione }</td>
											<td>${t.dimensioneSerra }</td>
											<td><c:choose>
													<c:when test="${t.servizioCompleto}">SI</c:when>
													<c:otherwise>NO</c:otherwise>
												</c:choose></td>
											<td><c:choose>
													<c:when test="${t.servizioParziale}">SI</c:when>
													<c:otherwise>NO</c:otherwise>
												</c:choose></td>
											<td>${t.periodiDisponibilita}</td>
											<td>
												<button
													onclick="edit('${t.id}','${t.locazione}', '${t.dimensione}', '${t.dimensioneSerra}','${t.costo}', '${t.servizioCompleto}', '${t.servizioParziale}', '${t.periodiDisponibilita}')"
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
							<div align="center">
								<a href="PageLoader?id=inserimentoTerreno">
									<button class="button btn" type="submit">Aggiungi
										Terreno</button>
								</a>
							</div>



							<!-- Modal -->
							<div id="modalDelete" class="modal fade" role="dialog">

								<div class="modal-dialog">

									<!-- Modal content-->
									<div class="modal-content">
										<div class="modal-header">
											<!-- <button type="button" class="close" data-dismiss="modal">&times;</button> -->
											<h4 class="modal-title">Elimina Terreno</h4>
										</div>
										<div class="modal-body">
											<p>
												Sei sicuro di voler eliminare questo terreno? 
											</p>
										</div>
										<div class="modal-footer">
											<form action="TerrenoOspitaOrtaggi" method="get">
												<button type="button" class="btn btn-default"
													data-dismiss="modal">Annulla</button>
												
												<input type="text" id="tempId" name="tempId">
												<input type="text" id="delete" name="delete" value="true">
												<!-- <a href="">  -->
													<button type="submit" class="btn btn-default">Conferma</button>
												<!--  </a> -->
											</form>
										</div>
									</div>

								</div>
							</div>
							<!-- end modal -->
						</div>

						<!-- modifica -->
						<div class="container" id="info_terreno"
							style="display: none; margin-top: 20px">
							<div align="center">
								<h4>Modifica dati Terreno</h4>
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
												<label class="label-column">Dimensione</label>
											</div>
											<div class="col-xs-2">
												<input class="input-column" type="text"
													id="editFormDimensione" name="editFormDimensione">
											</div>

										</div>
										<br>
										<div class="form-row form-group">
											<div class="col-md-4">
												<label class="label-column">Dimensione Serra</label>
											</div>
											<div class="col-xs-2">
												<input class="input-column" type="text"
													id="editFormDimensioneSerra" name="editFormDimensioneSerra">
											</div>

										</div>
										<br>
									</div>

									<div class="col-md-6 ">
										<div class="form-row form-group">
											<div class="col-md-4">
												<label class="label-column">Costo</label>
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
												<select class="custom-select input-column"
													style="width: 190px; padding: 3px;"
													id="dropdownDisponibilita" name="dropdownDisponibilita">
													<option value="primavera">Primavera</option>
													<option value="estate">Estate</option>
													<option value="autunno">Autunno</option>
													<option value="inverno">Inverno</option>
													<option value="annuale">Annuale</option>

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
								<div align="center">

									<button class="button btn" id="annulla_modifica" type="submit">Annulla</button>
									<button class="button btn" type="submit">Salva</button>
								</div>
							</form>
						</div>
						<!-- end modifiche -->

					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="footer"></div>
</body>
</html>