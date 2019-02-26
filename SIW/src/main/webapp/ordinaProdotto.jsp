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
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lora">

<link rel="stylesheet" href="assets/css/ordinaProdotto.css">
<link rel="stylesheet" href="assets/css/carrello.css">

<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/ordinaProdotto.js"></script>
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

	<!-- ========================= SECTION CONTENT ========================= -->
	<section class="section-content bg padding-y">
		<div class="container">

			<div class="row" id="divGenerale">
				<div id="divScegliProdotti">
					<div class="row">
						<div class="col-sm-8">
							<h1 style="color: white;">Scegli i tuoi prodotti preferiti</h1>
						</div>
						<div class="col-sm-4" id="cart">
							<div id="clickCarrello">
								<a class="iconCarrello" id="scrittaClickCarrello" onclick="visualizzaCarrello()"><strong>Carrello</strong>
								<i class="fa fa-shopping-cart" id="disegnoClickCarrello"></i>
								<i id="dimensioneCarrello" style="color: #25ed3b;"></i></a>
							</div>
						</div>
					</div>

					<div class="row" id="corpo">
						<aside class="col-sm-3">


							<div class="card card-filter" id="divFiltri">
								<article class="card-group-item">
									<header class="card-header" style="border-radius:  25px 25px 0px 0px">
										<a class="" style="color: green;" aria-expanded="true" href="#"
											data-toggle="collapse" data-target="#collapse22"> <i
											class="icon-action fa fa-chevron-down"></i>
											<h6 class="title" style="color: green;" >Categoria</h6>
										</a>
									</header>
									<div style="" class="filter-content collapse show"
										id="collapse22">
										<div class="card-body">
											<form class="pb-3" method="get" action="DammiProdottoFiltri">
												<div class="input-group">
													<input class="form-control" value="cerca" name="filtro"
														style="display: none;"> <input
														class="form-control" placeholder="Search" type="text"
														name="nomeProdotto">

													<div class="input-group-append">
														<button name="btn" value="cercaNome"
															class="btn btn-primary" type="submit" style="background: green;">
															<i class="fa fa-search"></i>
														</button>
													</div>
												</div>
											</form>

											<ul class="list-unstyled list-lg ">

												<li class="filtroBordo"><a class="filtroInterno"
													href="DammiProdotto" onclick="submit">Tutti </a></li>
												<li class="filtroBordo"><a class="filtroInterno"
													href="DammiProdottoFiltri?filtro=cat&categoria=Latticini"
													onclick="submit">Latticini </a></li>
												<li class="filtroBordo"><a class="filtroInterno"
													href="DammiProdottoFiltri?filtro=cat&categoria=Oli e derivati"
													onclick="submit">Oli e derivati </a></li>
												<li class="filtroBordo"><a class="filtroInterno"
													href="DammiProdottoFiltri?filtro=cat&categoria=Verdure"
													onclick="submit">Verdure </a></li>
												<li class="filtroBordo"><a class="filtroInterno"
													href="DammiProdottoFiltri?filtro=cat&categoria=Frutti"
													onclick="submit">Frutti </a></li>
												<li class="filtroBordo"><a class="filtroInterno"
													href="DammiProdottoFiltri?filtro=cat&categoria=Vini"
													onclick="submit">Vini </a></li>
												<li class="filtroBordo"><a class="filtroInterno"
													href="DammiProdottoFiltri?filtro=cat&categoria=Carni e derivati"
													onclick="submit">Carni e derivati </a></li>
												<li class="filtroBordo"><a class="filtroInterno"
													href="DammiProdottoFiltri?filtro=cat&categoria=Altro"
													onclick="submit">Altro </a></li>

												<%-- <span class="float-right badge badge-light round" id="numeroLattici">${c.quantita }</span>
					 --%>
											</ul>
										</div>
										<!-- card-body.// -->
									</div>
									<!-- collapse .// -->
								</article>
								<!-- card-group-item.// -->
								<article class="card-group-item">
									<header class="card-header" >
										<a href="#" data-toggle="collapse" data-target="#collapse33">
											<i class="icon-action fa fa-chevron-down" style="color: green;"></i>
											<h6 class="title" style="color: green;">Prezzo</h6>
										</a>
									</header>
									<form action="DammiProdottoFiltri" method="get">
										<div class="filter-content collapse show" id="collapse33">

											<div class="card-body">

												<!-- <input type="range" class="custom-range" min="0" max="100" name=""> -->
												<div class="form-row">
													<div class="form-group col-md-6">
														<input class="form-control" value="prezzo" name="filtro"
															style="display: none;"> <label>Min €</label> <input
															class="form-control"  min="0"  type="number"
															name="minPrezzo" value="0">
													</div>
													<div class="form-group text-right col-md-6">
														<label>Max €</label> <input class="form-control"
															value="100" type="number" name="maxPrezzo">
													</div>
												</div>
												<!-- form-row.// -->
												<button class="btn btn-block btn-outline-primary "
													type="submit">Applica</button>

											</div>
											<!-- card-body.// -->

										</div>
										<!-- collapse .// -->
									</form>
								</article>
								<!-- card-group-item.// -->
								<article class="card-group-item">
									<header class="card-header">
										<a href="#" data-toggle="collapse" data-target="#collapse44">
											<i class="icon-action fa fa-chevron-down" style="color: green;"></i>
											<h6 class="title" style="color: green;">Azienda</h6>
										</a>
									</header>
									<div class="filter-content collapse show" id="collapse44">
										<div class="card-body">
											<ul class="list-unstyled list-lg ">
												<c:forEach items="${aziende }" var="a">
													<li class="filtroBordo"><a class="filtroInterno"
														href="DammiProdottoFiltri?filtro=az&azienda=${a }"
														onclick="submit">${a} </a></li>
												</c:forEach>
											</ul>
										</div>
										<!-- card-body.// -->
									</div>
									<!-- collapse .// -->
								</article>
								<!-- card-group-item.// -->
							</div>
							<!-- card.// -->
							<!-- divFiltri -->


						</aside>
						<!-- col.// -->
						<aside class="col-sm-9 " id="prodotti">

							<c:forEach items="${prodotti }" var="p">
								<div class="alert alert-success" id="alertConferma${p.id }"
									style="display: none !important">
									<strong>Prodotto inserito nel carrello!</strong>
								</div>
								<div class="alert alert-warning" id="alertGiaInserito${p.id }"
									style="display: none !important">
									<strong>Prodotto già inserito, puoi modificare la quantità nel tuo carrello!</strong>
								</div>

								<article class="card card-product" id="prodotto">
									<div class="card-body">
										<div class="row">
 											<aside class="col-sm-3" style="max-height: 10%;">
												 <img
													src="https://www.w3schools.com/images/w3schools_green.jpg"
													class="img-reponsive img-rounded" id="imageAzienda"
													style="max-height: 100%;" /> 
											</aside> 
											<!-- col.// -->
											<article class="col-sm-6">
												<h4 class="title">${p.nome}</h4>
												<div class="rating-wrap  mb-2">

													<!-- 					<div class="label-rating">132 reviews</div>
					<div class="label-rating">154 orders </div> -->
												</div>
												<!-- rating-wrap.// -->
												<p>${p.descrizione }</p>
												<dl class="dlist-align">
													<dt>Azienda</dt>
													<dd>${p.nomeAzienda }</dd>
												</dl>
												
												<dl class="dlist-align" style="float: right;"> 
													<dt>Quantità disponibile:</dt>
													<c:if test="${p.quantita > 0 }">
													<dd style="float: right;">${p.quantita }</dd>
													</c:if>
													<c:if test="${p.quantita == 0 }">
														<dd style="float: right;">Prodotto non disponibile</dd>
													</c:if>
												</dl>
												
												
												<!-- item-property-hor .// -->

											</article>
											<!-- col.// -->
											<aside class="col-sm-3 border-left">
												<div class="action-wrap">
													<div class="price-wrap h4">
														<span class="price"> € ${p.costoUnitario } </span>
														<!-- <del class="price-old"> $98</del> -->
													</div>
													<!-- info-price-detail // -->
													<p class="text-success">Spedizione gratuita</p>
													<br>
													<p>
														<button class="button"
															onclick="aggiungiAlCarrello('${p.id }','${p.nome}','${p.categoria}','${p.quantita}','${p.costoUnitario}','${p.nomeAzienda}')">Aggiungi
															al carrello</button>
												</div>
												<!-- action-wrap.// -->
											</aside>
											<!-- col.// -->
										</div>
										<!-- row.// -->
									</div>
									<!-- card-body .// -->
								</article>
								<!-- card product .// -->
							</c:forEach>



						</aside>
						<!-- col.// -->
					</div>
					<div id="numPagina" style="width: 100%;">
						<div class="pagination" id="insiemePagine">
							
							<c:choose>
								<c:when test="${(pagina - 1) > 0 }">
									<a href="<%=request.getContextPath()%>/DammiProdotto?pagina=${pagina - 1}">&laquo;</a>
								</c:when>
								<c:otherwise>
									<a href="#" onclick="return false;">&laquo;</a>
								</c:otherwise>
							</c:choose>
                           	<c:forEach var="i" begin="1" end="${numeroPagine }">
								<c:if test="${i != pagina}">
								<a href="<%=request.getContextPath()%>/DammiProdotto?pagina=${i}">${i}</a>
								</c:if>
								<c:if test="${i == pagina }">
									<a class="active" href="<%=request.getContextPath()%>/DammiProdotto?pagina=${pagina}">${pagina }</a>
								</c:if>
							</c:forEach>
							<c:choose>
								<c:when test="${pagina != numeroPagine}">
									<a
										href="<%=request.getContextPath()%>/DammiProdotto?pagina=${pagina + 1}">&raquo;</a>
								</c:when>
								<c:otherwise>
									<a href="#" onclick="return false;">&raquo;</a>
								</c:otherwise>
							</c:choose>
						</div>
						<!-- pagination -->
					</div>

				</div>





				<div class="container-fluid" id="divCarrello">


					<div class="container">
						<br>
						<p class="text-center" style="font-size: 25px">
							<strong>Il tuo carrello</strong>
						</p>
						<hr>
						<div class="alert alert-warning" id="alertWarning"
							style="display: none !important">
							<strong>Attenzione!</strong>
							La quantità inserita supera quella disponibile.
						</div>


						<div class="card" style="background: #dbd3c9">
							<table class="table table-hover shopping-cart-wrap" id="tableCarrello">
								<thead class="text-muted" style="background: #e2be8c">
									<tr>
										<th scope="col">Prodotto</th>
										<th scope="col" width="120">Quantità</th>
										<th scope="col" width="120">Prezzo</th>
										<th scope="col" width="200" class="text-right">---</th>
									</tr>
								</thead>
								<tbody id="body">

									<!--  da appendere JAVASCRIPT -->
								
								</tbody>
							</table>
						</div>
						<!-- card.// -->

					</div>
					<!--container end.//-->
					<div class="row">
						<div class="col-sm-3" style="margin: 2%; margin-top: 5%">
							<ul style="list-style-type: none">
								<li style="display: inline-block"><input style="width: 23px; height: 20px;"
									type="checkbox" name="paypolCheckbox" id="paypall" value="Ford">
									<label class="paypal" for="paypalL"><img
										src="assets\img\ruotaStagioni\ImgPaypal.jpg" /></label></li>
								<li style="display: inline-block"><input style="width: 23px; height: 20px;"
									type="checkbox" name="postapayCheckbox" id="mastercard"
									value="Ford"> <label class="mastercard" for="postapay"><img
										src="assets\img\ruotaStagioni\ImgMastercard.jpg" /></label></li>
										
							</ul>
						</div>

						<div class="col-sm-8" style="margin: 2%">
							<!-- container mb-4 -->
							<div class="row table-responsive" style="margin: 0">



								<div class="col-12">
									<table class="table table-striped">
										<tr>
											<td> </td>
											<td> </td>
											<td> </td>
											<td><h5>Parziale  €</h5></td>
											<td class="text-right"><h5 id="parziale">
													<strong></strong>
												</h5></td>
										</tr>
										<tr>
											<td> </td>
											<td> </td>
											<td> </td>
											<td><h5>Spese di spedizione  €</h5 ></td>
											<td class="text-right"><h5 id="spedizione">
													<strong></strong>
												</h5></td>
										</tr>
										<tr>
											<td> </td>
											<td> </td>
											<td> </td>
											<td><h3>Totale  €</h3></td>
											<td class="text-right"><h3 id="totale">
													<strong></strong>
												</h3></td>
										</tr>
										<tr>
											<td> </td>
											<td> </td>
											<td> </td>
											<td align="left">
												<button type="button" class="btn btn-default" onclick="visualizzaProdotti()">
													<i class="fa fa-arrow-left"></i> <span
														class="glyphicon glyphicon-shopping-cart"></span> Continua
													ad acquistare
												</button>
											</td>
											<td align="right">
												<button class="button" onclick="salvaAcquisto('paypall','mastercard')">
													Conferma <span class="glyphicon glyphicon-play"></span>
												</button>
											</td>
										</tr>

									</table>
								</div>

							</div>
						</div>
					</div>
				</div>
				<!-- fine container-fluid -->





			</div>
			<!-- fine DIV GENERALE -->

			<!-- --------------------------------------------------------------------------- -->




		</div>
		<!-- container .//  -->
	</section>
	<!-- ========================= SECTION CONTENT END// ========================= -->





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