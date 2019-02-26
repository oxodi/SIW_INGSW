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
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">

<meta name="viewport" content="width=device-width, initial-scale=1">	
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="assets/css/profiloCliente.css">
<script src="assets/js/profiloCliente.js"></script>

<title>Area Cliente</title>


<script>
	$(function() {
		$("#navbar").load("navBar.jsp");
		$("#footer").load("footer.jsp");
	});
</script>



<meta charset="ISO-8859-1">
</head>
<body>

	<div id="navbar"></div>
	<div class="container-fluid border-profile">
		<div class="row" style="margin-top: 1%; margin-bottom: 2%">
			<div class="col-sm-10" align="left">
				<h1
					style="font-style: oblique; color: green; text-shadow: 2px 2px 4px black; max-width: 100%;">${sessionScope.cliente.getNome()}
					${sessionScope.cliente.getCognome()}</h1>
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
					<div class="table-responsive">
						<ul class="list-group">
							<li class="list-group-item text-center style-info"
								style="border-bottom: green 1px solid"><strong>Dati
									Cliente</strong></li>
							<li class="list-group-item text-left style-info"
								style="border-bottom: green 1px solid;"><span
								class="pull-left"><strong>Codice Fiscale</strong></span>
								${sessionScope.cliente.getCodiceFiscale() }</li>
							<li class="list-group-item text-left style-info"
								style="border-bottom: green 1px solid;"><span
								class="pull-left"><strong>E-mail</strong></span>
								${sessionScope.cliente.getEmail() }</li>
							<li class="list-group-item text-left style-info"><span
								class="pull-left"><strong>Data di nascita</strong></span>
								${dataNascitaCliente}</li>
						</ul>
					</div>
				</div>
				<!-- end info laterali -->


				<!--left col-->
				<div class="container-fluid border-info-style">
					<div class="table-responsive" style="margin-bottom: 15px">
						<ul class="list-group">
							<li class="list-group-item text-center style-info"
								style="border-bottom: green 1px solid"><strong>Recapiti</strong></li>
							<li class="list-group-item text-left style-info"
								style="border-bottom: green 1px solid;" id="cit"><span
								class="pull-left"><strong>Città</strong></span>
								${sessionScope.cliente.getCitta()}(${sessionScope.cliente.getProvincia()})
							</li>
							<li class="list-group-item text-left style-info"
								style="border-bottom: green 1px solid;" id="indi"><span
								class="pull-left"><strong>Indirizzo</strong></span>
								${sessionScope.cliente.getIndirizzo()}
								(${sessionScope.cliente.getCap()})</li>
							<li class="list-group-item text-left style-info" id="tel"><span
								class="pull-left"><strong>Telefono</strong></span>
								${sessionScope.cliente.getTelefono()}</li>
						</ul>
					</div>
				</div>
				<!-- end info laterali -->

			</div>

			<div class="col-sm-9" id="div-disp">

				<!-- navbar profilo -->

				<div class="navbar-collapse topnav " style="border-color: green;">
					<ul class="nav nav-pills">
						<li class="active"><a data-toggle="tab" href="#modificadati">
								Modifica i miei dati</a></li>
						<li><a data-toggle="tab" href="#prenotazioni" onclick="dammiPrenotazioni()">Prenotazioni</a></li>
						<li><a data-toggle="tab" href="#acquisti" onclick="dammiAcquisti()">Acquisti</a></li>

					</ul>
				</div>

				<!-- end navbar profilo -->

				<!-- form azienda -->
				<div class="tab-content clearfix">
					<div class="custom-form tab-pane active" style="margin-top: 20px"
						id="modificadati">
						<!-- <form > -->
						<div class="row">
							<div class="col-md-6 ">
								<br>
								<div class="form-row form-group" style="display: none">
									<div class="col-xs-2">
										<input class="input-column" type="text" name="id_cliente"
											value="${sessionScope.cliente.getId()}">
									</div>

								</div>
								<div class="form-row form-group">

									<div class="col-md-4">
										<label class="label-column">Nome</label>
									</div>
									<div class="col-xs-2">
										<input class="input-column" type="text" disabled="disabled"
											name="nome" value="${sessionScope.cliente.getNome()}">
									</div>

								</div>
								<br>
								<div class=" form-row form-group">

									<div class="col-md-4">
										<label class="label-column">Cognome</label>
									</div>
									<div class="col-xs-2">
										<input class="input-column" type="text" name="cognome"
											disabled="disabled"
											value="${sessionScope.cliente.getCognome()}">
									</div>

								</div>
								<br>
								<div class="form-row form-group">

									<div class="col-md-4 ">
										<label class="label-column">Codice Fiscale</label>
									</div>
									<div class="col-xs-2 ">
										<input class="input-column" type="text" name="codice_fiscale"
											disabled="disabled"
											value="${sessionScope.cliente.getCodiceFiscale()}">
									</div>

								</div>
								<br>
								<div class="form-row form-group">

									<div class="col-md-4 ">
										<label class="label-column">Data di nascita</label>
									</div>
									<div class="col-xs-2 ">
										<input class="input-column" type="text" name="data_nascita"
											disabled="disabled"
											value="${dataNascitaCliente}">
									</div>

								</div>
								<br>
								<div class="form-row form-group">

									<div class="col-md-4 ">
										<label class="label-column">Città *</label>
									</div>
									<div class="col-xs-2 ">
										<input class="input-column" type="text" name="citta"
											id="citta" value="${sessionScope.cliente.getCitta()}">
									</div>

								</div>
							</div>


							<div class="col-md-6">
								<br>
								<div class="form-row form-group">

									<div class="col-md-4 ">
										<label class="label-column">Provincia *</label>
									</div>
									<div class="col-xs-2">
										<input class="input-column" type="text" name="provincia"
											id="provincia" value="${sessionScope.cliente.getProvincia()}">
									</div>

								</div>
								<br>
								<div class="form-row form-group">

									<div class="col-md-4 ">
										<label class="label-column">CAP *</label>
									</div>
									<div class="col-xs-2">
										<input class="input-column" type="text" name="cap" id="cap"
											value="${sessionScope.cliente.getCap()}">
									</div>

								</div>
								<br>
								<div class="form-row form-group">

									<div class="col-md-4">
										<label class="label-column">Indirizzo *</label>
									</div>
									<div class="col-xs-2">
										<input class="input-column" type="text" name="indirizzo"
											id="indirizzo" value="${sessionScope.cliente.getIndirizzo()}">
									</div>

								</div>
								<br>
								<div class="form-row form-group">

									<div class="col-md-4">
										<label class="label-column">Telefono *</label>
									</div>
									<div class="col-xs-2">
										<input class="input-column" type="tel" name="telefono"
											id="telefono" value="${sessionScope.cliente.getTelefono()}">
									</div>

								</div>
								<br>
								<div class="form-row form-group">

									<div class="col-md-4">
										<label class="label-column">Email</label>
									</div>
									<div class="col-xs-2">
										<input class="input-column" type="text" name="email"
											id="email" disabled="disabled"
											value="${sessionScope.cliente.getEmail()}">
									</div>

								</div>
							</div>
						</div>
						<br> <br>
						<div class="container-fluid" align="right">
							<p>
								<strong>(*) questi campi possono essere modificati</strong>
							</p>
						</div>
						<br>
						<div class="organize" align="center">
							<button class="button btn" onclick="aggiornaDati(${cliente.id});">Salva</button>
						</div>
						<!-- </form> -->
					</div>


					<!-- PRENOTAZIONI -->
					<div class="tab-pane" style="margin-top: 20px; margin-bottom: 50px"
						id="prenotazioni">
						
						
<%-- 						<div class="table-responsive" id="terreni">
	<table class="table table-hover" >
		<thead style="background: #f7d08c">
			<tr>
				<th>Azienda</th>
				<th>Terreno</th>
				<th>Locazione</th>
				<th>Info</th>
			</tr>
		</thead>
		<c:forEach items="${terreni}" var="t" varStatus="status">
			
	 	<tbody id="items" style="background: #f4ddb5">
				<tr class="clickable" data-toggle="collapse"
					data-target="#group-of-rows-1" aria-expanded="false"
					aria-controls="group-of-rows-1">
					<td>${t.id}</td>
					<td>${t.locazione}</td>
					<td>${aziende[status.index].ragioneSociale}</td>
					<td><a><i class="fa fa-info-circle" aria-hidden="true" style="font-size: 25px; color: #136000" onclick="mostraOrtaggi('${t.id}','${t.periodiDisponibilita}')"></i></a></td>
					
				</tr>
		</tbody>
		<tbody id="group-of-rows-1${t.id}" class="collapse"> 
			
		</tbody>
			</c:forEach>
	</table>


</div>
						
						
						 --%>
						
						
					
					</div>  <!-- fine div prenotazioni -->
					
					
					<!-- ACQUISTI -->
					<div class="tab-pane" style="margin-top: 20px; margin-bottom: 50px"
						id="acquisti">
						
					
					</div>  <!-- fine div acquisti -->

				</div>
			</div>
		</div>
	</div>

	<!-- Modal -->
	<div id="modalSuccess" class="modal fade" role="dialog"
		style="z-index: 2500; border-radius: 25px;">

		<div class="modal-dialog"
			style="border: 2px #936232 solid; border-radius: 15px">

			<!-- Modal content-->
			<div class="modal-content"
				style="background: #c48548; border-radius: 15px" align="center">
				<img src="assets/img/imageSuccess.png"
					style="max-height: 150px; max-width: 150px" alt="success"
					id="center">

				<div class="modal-body">
					<p>
						<strong>Dati aggiornati!</strong>
					</p>
				</div>

				<div class="container" align="center" style="margin-bottom: 2%">
					<input type="text" style="display: none" id="tempId" name="tempId">
					<input type="text" style="display: none" id="delete" name="delete"
						value="true">
					<button type="submit" class="btn btn-success"
						style="border-radius: 15px" data-dismiss="modal">OK</button>
				</div>

			</div>

		</div>
	</div>
	<!-- end modal -->


	<div id="footer"></div>
</body>
</html>