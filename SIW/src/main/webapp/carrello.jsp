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
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="assets/css/carrello.css">
<script src="assets/js/profiloCliente.js"></script>


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
	<div class="container">

		<div class="container-fluid" id="divGenerale">


			<div class="container">
				<br>
				<p class="text-center" style="font-size: 25px">
					<strong>Il tuo carrello</strong>
				</p>
				<hr>



				<div class="card" style="background: #dbd3c9">
					<table class="table table-hover shopping-cart-wrap">
						<thead class="text-muted" style="background: #e2be8c">
							<tr>
								<th scope="col">Prodotto</th>
								<th scope="col" width="120">Quantità</th>
								<th scope="col" width="120">Prezzo</th>
								<th scope="col" width="200" class="text-right">---</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									<figure class="media">
										<!-- <div class="img-wrap">
											<img
												src="http://bootstrap-ecommerce.com/main/images/items/2.jpg"
												class="img-thumbnail img-sm">
										</div> -->
										<figcaption class="media-body">
											<h6 class="title text-truncate">Product name goes here</h6>
											<dl class="param param-inline small">
												<dt>Size:</dt>
												<dd>XXL</dd>
											</dl>
											<dl class="param param-inline small">
												<dt>Color:</dt>
												<dd>Orange color</dd>
											</dl>
										</figcaption>
									</figure>
								</td>
								<td><select class="form-control">
										<option>1</option>
										<option>2</option>
										<option>3</option>
										<option>4</option>
								</select></td>
								<td>
									<div class="price-wrap">
										<var class="price">USD 145</var>
										<small class="text-muted">(USD5 each)</small>
									</div> <!-- price-wrap .// -->
								</td>
								<td class="text-right"><a href=""
									class="btn btn-outline-danger"> × Rimuovi</a></td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- card.// -->

			</div>
			<!--container end.//-->

			<!-- 	<br>
		<br> -->


			<!-- <article class="bg-secondary mb-3">
			<div class="card-body text-center">
				<h3 class="text-white mt-3">Bootstrap 4 UI KIT</h3>
				<p class="h5 text-white">
					Components and templates <br> for Ecommerce, marketplace,
					booking websites and product landing pages
				</p>
				<br>
				<p>
					<a class="btn btn-warning" target="_blank"
						href="http://bootstrap-ecommerce.com/">
						Bootstrap-ecommerce.com <i class="fa fa-window-restore "></i>
					</a>
				</p>
			</div>
			<br>
			<br>
		</article> -->
			<div class="row">
				<div class="col-sm-3" style="margin: 2%; margin-top: 5%">
					<ul>
						<li><input style="width: 23px; height: 20px;" type="checkbox"
							name="paypolCheckbox" id="paypall" value="Ford"> <label
							class="paypal" for="paypalL"><img
								src="assets\img\ruotaStagioni\ImgPaypal.jpg" /></label></li>
						<li><input style="width: 23px; height: 20px;" type="checkbox"
							name="postapayCheckbox" id="mastercard" value="Ford"> <label
							class="mastercard" for="postapay"><img
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
									<td><h5>Subtotal</h5></td>
									<td class="text-right"><h5>
											<strong>$24.59</strong>
										</h5></td>
								</tr>
								<tr>
									<td> </td>
									<td> </td>
									<td> </td>
									<td><h5>Estimated shipping</h5></td>
									<td class="text-right"><h5>
											<strong>$6.94</strong>
										</h5></td>
								</tr>
								<tr>
									<td> </td>
									<td> </td>
									<td> </td>
									<td><h3>Total</h3></td>
									<td class="text-right"><h3>
											<strong>$31.53</strong>
										</h3></td>
								</tr>
								<tr>
									<td> </td>
									<td> </td>
									<td> </td>
									<td align="left">
										<button type="button" class="btn btn-default"><i class="fa fa-arrow-left"></i>
											<span class="glyphicon glyphicon-shopping-cart"></span>
											Continua ad acquistare
										</button>
									</td>
									<td align="right">
										<button class="button">
											Checkout <span class="glyphicon glyphicon-play"></span>
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





	<div id="footer"></div>
</body>
</html>