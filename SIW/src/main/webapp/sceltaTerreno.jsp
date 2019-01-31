<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<body>




	<div class="col-sm-8 text-left" id="centerColumn">
		<h1>
			Azienda
			<c:out value="${azienda.ragioneSociale}" />
		</h1>
		<p>
			<c:out value="${azienda.descrizioneServizi }"></c:out>
		</p>
		<hr>
		<h3>Terreni Disponibili</h3>
		<c:forEach items="${terreni}" var="t">
			<div class="card-body">
				<h4>
					<b>Terreno n.${t.id}</b>
				</h4>
				<p>${t.locazione}</p>

			</div>
		</c:forEach>
	</div>





	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>