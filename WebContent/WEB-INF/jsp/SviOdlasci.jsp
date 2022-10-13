<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Svi odlasci</title>
<!-- Bootstrap META -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	
	<!-- External JS --> 
	<script type="text/javascript" src="js/sviOdlasci.js"></script>
</head>
<body onload="ucitaj(0)">
	<h3>Svi odlasci</h3>
	<!-- Home link -->
	<div class="row">
		<div
			class="offset-xs-4 offset-sm-4 offset-md-4 col-xs-6 col-sm-6 col-md-6">
			<a href="<%=request.getContextPath()%>/GlavniServlet?action=pocetna"
				class="text-center" style="width: 100%">Početna stranica</a>
		</div>
	</div>
	<button type="button" class="btn btn-primary" onclick="prethodniDan()">Prethodni dan</button>
	<button type="button" class="btn btn-primary" onclick="ucitaj(0)">Današnji dan</button>
	<button type="button" class="btn btn-primary" onclick="sljedeciDan()">Sljedeći dan</button>
	<table id="table">
	
	</table>
</body>
</html>