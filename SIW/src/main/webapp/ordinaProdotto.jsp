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

<script >
 $(document).ready(function() {
	 var numeroLattici = 0;
	 var numeroOli = 0;
	 var numeroVerdure = 0;
	 var numeroFrutti = 0;
	 var numeroVini = 0;
	 var numeroCarni = 0;
	 
	 
	 <c:forEach items="${prodotti }" var="p">
	 	var categoria = "${p.categoria}"; 
	 	switch (categoria) {
		case "Latticini":
			numeroLattici++;
			break;
		case "Oli e derivati":
			numeroOli++;
			break;
		case "Verdure":
			numeroVerdure++;
			break;
		case "Frutti":
			numeroFrutti++;
			break;
		case "Vini":
			numeroVini++;
			break;
		case "Carni e derivati":
			numeroCarni++;
			break;

		default:
			break;
		}
		
	 	   
	 </c:forEach> 
	 
	 document.getElementById("numeroLattici").textContent= numeroLattici;
	 document.getElementById("numeroOli").textContent= numeroOli;
	 document.getElementById("numeroVerdure").textContent= numeroVerdure;
	 document.getElementById("numeroFrutti").textContent= numeroFrutti;
	 document.getElementById("numeroVini").textContent= numeroVini;
	 document.getElementById("numeroCarni").textContent= numeroCarni;
	 
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
	
	<div class="row" id="titolo" >
	<h1 >Compra i prodotti direttamente dalle aziende</h1>
	<h2></h2>
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

				<ul class="list-unstyled list-lg">
					<li><a href="#">Latticini <span class="float-right badge badge-light round" id="numeroLattici"></span> </a></li>
					<li><a href="#">Oli e derivati  <span class="float-right badge badge-light round" id="numeroOli"></span>  </a></li>
					<li><a href="#">Verdure <span class="float-right badge badge-light round" id="numeroVerdure"></span>  </a></li>
					<li><a href="#">Frutti <span class="float-right badge badge-light round" id="numeroFrutti"></span>  </a></li>
					<li><a href="#">Vini <span class="float-right badge badge-light round" id="numeroVini"></span>  </a></li>
					<li><a href="#">Carni e derivati <span class="float-right badge badge-light round" id="numeroCarni"></span>  </a></li>
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
			<form>
			<c:forEach items="${aziende }" var="a">
				<label class="form-check">
				  <input class="form-check-input" value="" type="checkbox">
				  <span class="form-check-label">
				  	<span class="float-right badge badge-light round">${a.prodotti.size() }</span>
				    ${a.ragioneSociale }
				  </span>
				</label>  <!-- form-check.// -->
			</c:forEach>
			</form>
			</div> <!-- card-body.// -->
		</div> <!-- collapse .// -->
	</article> <!-- card-group-item.// -->
</div> <!-- card.// -->


	</aside> <!-- col.// -->
	<aside class="col-sm-9" id="prodotti">

<c:forEach items="${prodotti }" var="p">
<article class="card card-product" id="prodotto">
	<div class="card-body">
	<div class="row">
		<aside class="col-sm-3">
			<img src="http://www.patatedelfucino.it/wp-content/uploads/2016/09/agria.png"
			class="img-reponsive img-rounded" id="imageAzienda" style="max-height: 50%;" />
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