<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link href="hello.css" rel="stylesheet">

<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>

<body>
	<c:out value="${json}"></c:out>
</body>




<tr>
	<td><center>9:00 - 10:00</center></td>
	<td><label><input type="checkbox" name="free"
			value="mon09"></label></td>
	<td><label><input type="checkbox" name="free"
			value="tue09"></label></td>
	<td><label><input type="checkbox" name="free"
			value="wed09"></label></td>
	<td><label><input type="checkbox" name="free"
			value="thu09"></label></td>
	<td><label><input type="checkbox" name="free"
			value="fri09"></label></td>
</tr>
<style type="text/css">
td label {
	display: block;
	text-align: center;
}
</style>