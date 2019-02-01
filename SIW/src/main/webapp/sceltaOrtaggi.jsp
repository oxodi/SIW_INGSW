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

<link rel="stylesheet" href="assets/css/sceltaOrtaggi.css">
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/jquery.imgcheckbox.js"></script>
<!-- Script for load Navigation Bar -->
<script>
	$(function() {
		$("#navbar").load("navBar.jsp");
		$("#footer").load("footer.jsp");
	});
</script>


</head>

<body>
	<!-- Start: Navigation with Button -->
	<div id="navbar"></div>
	<!-- End: Navigation with Button -->

	<div class="container"
		style="border-style: solid; border-radius: 25px; border-color: green">
		<div class="row" style="width: 100%; margin: 0" >
			<div class="scegli"  style="width: 100%">
				<div class="form-row form-group" align="center">
					<label style="margin: 2%"><strong>Selezionare gli
							ortaggi da coltivare e la quantit&#224 </strong></label>
				</div>
				<div class="form-row form-group" style="width: 100%">
					<div class="table-responsive" id="table-scroll" style="margin-right: 2%; margin-left: 2%">
						<table class="table table-hover">
							<thead>
								<tr>
									<th></th>
									<th><strong>Nome</strong></th>
									<th><strong>Resa</strong></th>
									<th class="text-center"><strong>Tempo Coltivazione</strong></th>
									<th><strong>Prezzo(al mt<SUP>2</SUP>)</strong></th>
									<th><strong>Quantit&#224</strong></th>

								</tr>
							</thead>
							<tbody id="items">
								<c:forEach items="${ortaggi}" var="o">
									<tr class="accordion-toggle" data-toggle="collapse">
										<td><input type="checkbox" value="${o.id}"
											name="ortaggiSelezionati"></td>
										<td>${o.nome} </td>
										<td>${o.resa}</td>
										<td class="text-center">${o.tempoColtivazione}  giorni</td>
										<td class="text-center">${o.prezzo} &#8364</td>
										<td><input class="input-column" type="text"
											style="max-width: 80px"></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

		<!--  card resoconto -->

		<div class="container col-xl-8" style="margin-right: 0; padding: 0 ">
			<div class="resoconto">
				<!-- container mb-4 -->
				<div class="row table-responsive" style="margin: 0">
					<div class="col-12">
						<div>
							<!--  class="table-responsive" -->
							<table class="table table-striped">
								<thead>
									<tr>
										<!-- <th scope="col"></th> -->
										<th scope="col">Ortaggi</th>
										<th scope="col">Resa</th>
										<th scope="col" class="text-center">Quantit&#224</th>
										<th scope="col" class="text-right">Prezzo</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<!-- <td><img src="https://dummyimage.com/50x50/55595c/fff" /> -->
										<!-- </td> -->
										<td>riga1</td>
										<td>...</td>
										<td class="text-center">10</td>
										<!-- <input class="form-control" type="text" value="1" /> -->
										<td class="text-right">10.0</td>
										<td class="text-right"><button
												class="btn btn-sm btn-danger">
												<i class="fa fa-trash"></i>
											</button></td>
									</tr>
									<tr>
										<!-- <td><img src="https://dummyimage.com/50x50/55595c/fff" />
											 </td> -->
										<td>riga2</td>
										<td>...</td>
										<td class="text-center">20</td>
										<!-- <input class="form-control" type="text" value="1" /> -->
										<td class="text-right">10.0</td>
										<td class="text-right"><button
												class="btn btn-sm btn-danger">
												<i class="fa fa-trash"></i>
											</button></td>
									</tr>
									<tr>
										<!-- <td><img src="https://dummyimage.com/50x50/55595c/fff" />
											</td> -->
										<td>riga3</td>
										<td>...</td>
										<td class="text-center">30</td>
										<!-- <input class="form-control" type="text" value="1" /> -->
										<td class="text-right">10.0</td>
										<td class="text-right"><button
												class="btn btn-sm btn-danger">
												<i class="fa fa-trash"></i>
											</button></td>
									</tr>
									<tr>
										<!-- <td></td> -->
										<td></td>
										<td></td>
										<td></td>
										<td>Parziale</td>
										<td class="text-right">100,0</td>
									</tr>
									<tr>
										<!-- <td></td> -->
										<td></td>
										<td></td>
										<td></td>
										<td>Imposte</td>
										<td class="text-right">10,0</td>
									</tr>
									<tr>
										<!-- <td></td> -->
										<td></td>
										<td></td>
										<td></td>
										<td><strong>Totale</strong></td>
										<td class="text-right"><strong>200,0 </strong></td>
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