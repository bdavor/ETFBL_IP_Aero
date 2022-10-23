<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Dobro došli</title>
<!-- Bootstrap META -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<!-- My CSS -->
<link rel="stylesheet" type="text/css" href="css/home.css">

<!-- Bootstrap JS -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<!-- Google location API -->
<script
	src="https://maps.googleapis.com/maps/api/js?v=3.exp&amp;libraries=places&amp;key=AIzaSyAyjkhx6cJQLODS2b6gmRhWzLK10JcY8GQ"></script>


</head>
<body>
	<div class="containter-fluid">
		<!-- Zaglavlje -->
		<div class="row _header-home">
			<div class="col-xs-12 col-sm-12 col-md-12">
				<%@include file="/WEB-INF/jsp/komponente/header.jsp"%>
			</div>
		</div>
		<!-- Horizontalni meni -->
		<nav class="navbar navbar-expand-md navbar-dark bg-primary">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<div class="navbar-nav">
					<a class="nav-item nav-link"
						href="<%=request.getContextPath()%>/GlavniServlet?action=SviDolasci">Svi dolasci</a> 
						<a
						class="nav-item nav-link"
						href="<%=request.getContextPath()%>/GlavniServlet?action=SviOdlasci">Svi odlasci</a> 
						<%
						if(loggedIn){
	  					%>
						
						<%} %>
				</div>
			</div>
		</nav>
		<!-- Centralni dio stranice -->
		<div class="row _home-row">
			<!-- Pet sljedecih dolazaka -->
			<div class="col-md-6">
				<div class="row _dolasci-row">
					<div class="col-md-12 d-flex flex-column">
						<div id="dolazak-div">
							<jsp:include page="/WEB-INF/jsp/komponente/PetSljedecihDolazaka.jsp" />
						</div>					
					</div>
				</div>
			</div>
			<!-- Pet sljedecih odlazaka -->
			<div class="col-md-6">
				<div class="row _odlasci-row">
					<div class="col-md-12 d-flex flex-column">
						<div id="odlazak-div">
							<jsp:include page="/WEB-INF/jsp/komponente/PetSljedecihOdlazaka.jsp" />
						</div>					
					</div>
				</div>
			</div>	
		</div>
		
		<!-- Forma za kontakt -->
		<div class="row _content-row">
			<!-- Google mapa -->
			<div class="col-md-6">
				<div class="row _mapa-row">
					<div class="col-md-12 d-flex flex-column">
						<div id="mapa-div">
							<jsp:include page="/WEB-INF/jsp/komponente/GoogleMapa.jsp" />
						</div>					
					</div>
				</div>
			</div>
			<!-- Kontakt i forma za slanje poruka -->
			<div class="col-md-6">
				<div class="row _kontakt-row">
					<div class="col-md-12 d-flex flex-column">
						<div id="kontakt-div">
							<jsp:include page="/WEB-INF/jsp/komponente/KontaktForma.jsp" />
						</div>					
					</div>
				</div>
			</div>	
		</div>
		
		<!-- Footer -->
		<div class="row _header-home">
			<div class="col-xs-12 col-sm-12 col-md-12">
				<%@include file="/WEB-INF/jsp/komponente/footer.jsp"%>
			</div>
		</div>
		
	</div>
</body>
</html>