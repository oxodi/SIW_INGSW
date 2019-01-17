<link rel="stylesheet" href="assets/css/navbar.css">
<nav
	class="navbar navbar-light navbar-expand-md navigation-clean-button"
	style="background-color: transparent; position: relative; z-index: 2000">
	<div class="container">
		<a class="navbar-brand" href="index.jsp" title="TheGrower"> <img
			style="max-width: 200px; margin-top: -10px;"
			src="assets/img/logo2.png">
		</a>
		<button class="navbar-toggler" data-toggle="collapse"
			data-target="#navcol-1">
			<span class="sr-only">Toggle navigation</span><span
				class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navcol-1">
			<ul class="nav navbar-nav mr-auto">
				<li class="nav-item" role="presentation"><a class="nav-link"
					href="#"><strong>Prenota un terreno</strong></a></li>
				<li class="nav-item" role="presentation"><a class="nav-link"
					href="#"><strong>Ordina un prodotto</strong></a></li>
				<li class="nav-item" role="presentation"><a class="nav-link"
					href="PageLoader?id=azienda"><strong>Area Aziende</strong></a></li>
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
			<div class="dropdown">
				<a href="#" class="dropdown-toggle btn" data-toggle="dropdown"
					style="color: white; background-color: green; border-radius: 15px;"><b>Login</b>
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
								<form class="form" role="form" method="post" action="Login"
									accept-charset="UTF-8" id="login-nav">
									<div class="form-group">
										<label class="sr-only" for="exampleInputEmail2">Email
										</label> <input type="email" class="form-control"
											id="exampleInputEmail2" placeholder="Email address" required>
									</div>
									<div class="form-group">
										<label class="sr-only" for="exampleInputPassword2">Password</label>
										<input type="password" class="form-control"
											id="exampleInputPassword2" placeholder="Password" required>
										<div class="help-block text-right">
											<a href="" style="color: green;">Hai dimenticato la
												password ?</a>
										</div>
									</div>
									<div class="form-group">
										<button type="submit" class="btn btn-primary btn-block"
											style="background-color: green; border-radius: 15px;">Accedi</button>
									</div>
									<div class="checkbox">
										<label> <input type="checkbox"> Ricorda i dati
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
			<!-- 
			<span class="navbar-text actions"> <a
				class="btn btn-light action-button" role="button"
				href="Registration" style="background-color: green">Registrazione</a>
			</span>
			 -->
		</div>

	</div>
</nav>