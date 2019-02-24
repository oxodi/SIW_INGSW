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
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lora">

<link rel="stylesheet" href="assets/css/ordinaProdotto.css">
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

				<div class="row">
					<div class="col-sm-8">
						<h1>Compra i prodotti direttamente dalle aziende</h1>
					</div>
					<div class="col-sm-4" id="cart">
						<div style="margin-left: 60%">
							<strong style="font-size: 20px">Carrello</strong><i
								class="fa fa-shopping-cart" style="font-size: 40px;"></i>
						</div>
					</div>
				</div>
	
	<div class="row" id= "corpo">
	<aside class="col-sm-3">


<div class="card card-filter" id="divFiltri">
	<article class="card-group-item">
		<header class="card-header">
			<a class="" aria-expanded="true" href="#" data-toggle="collapse" data-target="#collapse22">
				<i class="icon-action fa fa-chevron-down"></i>
				<h6 class="title">By Category</h6>
			</a>
		</header>
		<div style="" class="filter-content collapse show" id="collapse22">
			<div class="card-body">
				<form class="pb-3">
				<div class="input-group">
				  <input class="form-control" placeholder="Search" type="text">
				  <div class="input-group-append">
				    <button class="btn btn-primary" type="button"><i class="fa fa-search"></i></button>
				  </div>
				</div>
				</form>

				<ul class="list-unstyled list-lg ">
					
					<li class="filtroBordo"><a class="filtroInterno" href="DammiProdotto" onclick="submit">Tutti </a></li>
					<li class="filtroBordo"><a class="filtroInterno" href="DammiProdottoFiltri?filtro=cat&categoria=Latticini" onclick="submit">Latticini </a></li>
					<li class="filtroBordo"><a class="filtroInterno" href="DammiProdottoFiltri?filtro=cat&categoria=Oli e derivati" onclick="submit">Oli e derivati </a></li>
					<li class="filtroBordo"><a class="filtroInterno" href="DammiProdottoFiltri?filtro=cat&categoria=Verdure" onclick="submit">Verdure </a></li>
					<li class="filtroBordo"><a class="filtroInterno" href="DammiProdottoFiltri?filtro=cat&categoria=Frutti" onclick="submit">Frutti </a></li>
					<li class="filtroBordo"><a class="filtroInterno" href="DammiProdottoFiltri?filtro=cat&categoria=Vini" onclick="submit">Vini </a></li>
					<li class="filtroBordo"><a class="filtroInterno" href="DammiProdottoFiltri?filtro=cat&categoria=Carni e derivati" onclick="submit">Carni e derivati </a></li>
					<li class="filtroBordo"><a class="filtroInterno" href="DammiProdottoFiltri?filtro=cat&categoria=Altro" onclick="submit">Altro </a></li>
					
					<%-- <span class="float-right badge badge-light round" id="numeroLattici">${c.quantita }</span>
					 --%>
				</ul>  
			</div> <!-- card-body.// -->
		</div> <!-- collapse .// -->
	</article> <!-- card-group-item.// -->
	<article class="card-group-item">
		<header class="card-header">
			<a href="#" data-toggle="collapse" data-target="#collapse33">
				<i class="icon-action fa fa-chevron-down"></i>
				<h6 class="title">By Price  </h6>
			</a>
		</header>
		<div class="filter-content collapse show" id="collapse33">
			<div class="card-body">
				<input type="range" class="custom-range" min="0" max="100" name="">
				<div class="form-row">
				<div class="form-group col-md-6">
				  <label>Min</label>
				  <input class="form-control" placeholder="$0" type="number">
				</div>
				<div class="form-group text-right col-md-6">
				  <label>Max</label>
				  <input class="form-control" placeholder="$1,0000" type="number">
				</div>
				</div> <!-- form-row.// -->
				<button class="btn btn-block btn-outline-primary">Apply</button>
			</div> <!-- card-body.// -->
		</div> <!-- collapse .// -->
	</article> <!-- card-group-item.// -->
	<article class="card-group-item">
		<header class="card-header">
			<a href="#" data-toggle="collapse" data-target="#collapse44">
				<i class="icon-action fa fa-chevron-down"></i>
				<h6 class="title">By Azienda </h6>
			</a>
		</header>
		<div class="filter-content collapse show" id="collapse44">
			<div class="card-body">
			<ul class="list-unstyled list-lg ">
			<c:forEach items="${aziende }" var="a">
				<li class="filtroBordo"><a class="filtroInterno" href="#" onclick="filtraAzienda('${a}')">${a} </a></li>
			</c:forEach>
			</ul>
			</div> <!-- card-body.// -->
		</div> <!-- collapse .// -->
	</article> <!-- card-group-item.// -->
</div> <!-- card.// --> <!-- divFiltri -->


	</aside> <!-- col.// -->
	<aside class="col-sm-9 " id="prodotti">

<c:forEach items="${prodotti }" var="p">
<article class="card card-product" id="prodotto">
	<div class="card-body">
	<div class="row">
		<aside class="col-sm-3" style="max-height: 10%;">
			<img src="http://www.patatedelfucino.it/wp-content/uploads/2016/09/agria.png"
			class="img-reponsive img-rounded" id="imageAzienda" style="max-height: 30%;" />
		</aside> <!-- col.// -->
		<article class="col-sm-6">
				<h4 class="title"> ${p.nome}  </h4>
				<div class="rating-wrap  mb-2">

<!-- 					<div class="label-rating">132 reviews</div>
					<div class="label-rating">154 orders </div> -->
				</div> <!-- rating-wrap.// -->
				<p> ${p.descrizione } </p>
				<dl class="dlist-align">
				  <dt>Azienda</dt>
				  <dd>${p.nomeAzienda }</dd>
				</dl>  <!-- item-property-hor .// -->

		</article> <!-- col.// -->
		<aside class="col-sm-3 border-left">
			<div class="action-wrap">
				<div class="price-wrap h4">
					<span class="price"> € ${p.costoUnitario } </span>	
					<!-- <del class="price-old"> $98</del> -->
				</div> <!-- info-price-detail // -->
				<p class="text-success">Free shipping</p>
				<br>
				<p>
					<a href="#" class="btn btn-primary"> Buy now </a>
					<a href="#" class="btn btn-secondary"> Details  </a>
				</p>
				<a href="#"><i class="fa fa-heart"></i> Add to wishlist</a>
			</div> <!-- action-wrap.// -->
		</aside> <!-- col.// -->
	</div> <!-- row.// -->
	</div> <!-- card-body .// -->
</article> <!-- card product .// -->
</c:forEach>



	</aside> <!-- col.// -->
</div>
<div id="numPagina" style="width: 100%;" >
<div class="pagination" id="insiemePagine">
  <a href="#">&laquo;</a>
  <c:forEach var="i" begin="1" end="${numeroPagine }">	
  <a href="<%=request.getContextPath()%>/DammiProdotto?pagina=${i}">${i}</a>
  <!-- <a class="active" href="#">2</a> -->
  </c:forEach>
  <a href="#">&raquo;</a>
</div> <!-- pagination -->
</div>

</div>

</div> <!-- container .//  -->
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