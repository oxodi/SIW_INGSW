<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="assets/css/navbar.css">
<script src="assets/js/navBar.js"></script>
<nav
	class="navbar navbar-light navbar-expand-md navigation-clean-button"
	style="background-color: transparent; position: relative; z-index: 2000">
	<div class="container">
		<a class="navbar-brand" href="Home" title="TheGrower"> <img
			style="max-width: 200px; margin-top: -10px;"
			src="assets/img/logo2.png">
		</a>
		<button class="navbar-toggler" data-toggle="collapse"
			data-target="#navcol-1">
			<span class="sr-only">Toggle navigation</span><span
				class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navcol-1">
			<ul class="nav navbar-nav mr-auto ">
				<c:if test="${sessionScope.cliente == null}">
					<li class="nav-item " role="presentation"><a
						class="nav-link text-dark" href="#" data-toggle="modal"
						data-target="#modalDelete"><strong>Prenota un terreno</strong></a></li>
				</c:if>
				<c:if test="${sessionScope.cliente != null}">
					<li class="nav-item " role="presentation"><a
						class="nav-link text-dark" href="PageLoader?id=prenotaTerreno"><strong>Prenota
								un terreno</strong></a></li>
				</c:if>
				<li class="nav-item" role="presentation"><a
					class="nav-link text-dark" href="#"><strong>Ordina un
							prodotto</strong></a></li>
				<c:if test="${sessionScope.cliente == null}">
					<li class="nav-item" role="presentation"><a
						class="nav-link text-dark" href="PageLoader?id=azienda"><strong>Area
								Aziende</strong></a></li>
				</c:if>
				<c:if test="${sessionScope.cliente != null}">
					<li class="nav-item" role="presentation"><a
						class="nav-link text-dark" href="PageLoader?id=bachecaClienti"><strong>Bacheca</strong></a></li>
				</c:if>



				<!-- 	<li class="dropdown nav-item"><a
					class="dropdown-toggle nav-link" data-toggle="dropdown"
					aria-expanded="false" href="#">Dropdown </a>
					<div class="dropdown-menu" role="menu">
						<a class="dropdown-item" role="presentation" href="#">First
							Item</a><a class="dropdown-item" role="presentation" href="#">Second
							Item</a><a class="dropdown-item" role="presentation" href="#">Third
							Item</a>
					</div></li>
					 -->
			</ul>

			<!-- <span class="navbar-text actions"> <a
				class="btn btn-light action-button" role="button" href="Login"
				style="background-color: green">Accedi</a>
			</span> -->

			<c:if test="${sessionScope.cliente != null}">
				<%-- <p>
					<strong>Ciao <em>${sessionScope.cliente.getNome()}</em></strong><br>
				</p>
				<a href="Login?logout=true">Logout</a> --%>
				<ul class="nav navbar-nav" style="margin-left: 15px;">
					<li class="nav-item" style="margin-top: 15px;">
						<p>
							<strong>Benvenuto, ${sessionScope.cliente.getNome()}</strong>
						</p>
					</li>
				</ul>
				<div class="logout" style="margin-left: 15px;">
					<a href="Login?logout=true"> <img src="assets/img/logout2.png">
						<strong>Logout</strong>
					</a>
				</div>
			</c:if>
			<c:if test="${sessionScope.cliente == null}">
				<div class="dropdown">
					<a href="#" class="dropdown-toggle btn" data-toggle="dropdown"
						style="color: white; background-color: green; border-radius: 15px; margin-left: 12px"><b>Login</b>
						<span class="caret"></span></a>
					<ul id="login-dp" class="dropdown-menu">
						<li>
							<div class="row">
								<div class="col-md-12">
									Accedi con
									<div class="social-buttons">
										<a href="#" class="btn btn-fb"><i class="fa fa-facebook"></i>
											Facebook</a>
										<!--  <a href="#" class="btn btn-tw"><i
										class="fa fa-twitter"></i> Twitter</a>
								 -->
									</div>
									o
									<form class="form" role="form" method="post"
										action="Login?area=utente" accept-charset="UTF-8"
										id="login-nav" name="loginUtente">
										<div class="form-group">
											<label class="sr-only" for="exampleInputEmail2">Email
											</label> <input type="email" class="form-control"
												id="exampleInputEmail2" name="email"
												placeholder="Email address" required>
										</div>
										<div class="form-group">
											<label class="sr-only" for="exampleInputPassword2">Password</label>
											<input type="password" class="form-control"
												id="exampleInputPassword2" name="pass"
												placeholder="Password" required>
											<div class="help-block text-right">
												<a href="" style="color: green;">Hai dimenticato la
													password ?</a>
											</div>
										</div>
										<div class="form-group">
											<button type="submit" class="btn btn-primary btn-block"
												style="background-color: green; border-radius: 15px;"
												name="utente">Accedi</button>
										</div>
										<div class="checkbox">
											<label> <input type="checkbox"> Ricorda i
												dati
											</label>
										</div>
									</form>
								</div>
								<div class="bottom text-center">
									Sei nuovo? <a href="PageLoader?id=utente" style="color: green;"><b>Registrati</b></a>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</c:if>

			<!-- 
			<span class="navbar-text actions"> <a
				class="btn btn-light action-button" role="button"
				href="Registration" style="background-color: green">Registrazione</a>
			</span>
			 -->
		</div>

	</div>
</nav>

<!-- Modal -->
<div id="modalDelete" class="modal fade" role="dialog"
	style="z-index: 2500; border-radius: 25px">

	<div class="modal-dialog" style="border: 2px green solid">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">Effettua l'accesso!</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body">
				<p>Per poter prenotare un terreno devi prima accedere al
					sistema.</p>
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