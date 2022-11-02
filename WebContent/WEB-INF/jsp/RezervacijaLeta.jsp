<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.unibl.etf.dto.Korisnik" %>
<!DOCTYPE html>
<html>
<head>
<title>Rezervacija leta</title>

<!-- Bootstrap META -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	
	<!-- External JS --> 
	<script type="text/javascript" src="js/reservation.js"></script>
</head>
<body onload="readCB()">
	<div class="container-fluid">
		<!-- Home link -->
		<div class="row">
			<div
				class="offset-xs-4 offset-sm-4 offset-md-4 col-xs-6 col-sm-6 col-md-6">
				<a href="<%=request.getContextPath()%>/GlavniServlet?action=pocetna"
					class="text-center" style="width: 100%">Pocetna stranica</a>
			</div>
		</div>
		<div class="row mt-2">
			<div class="col-xs-12 col-sm-12 col-md-12">
				<div class="d-flex justify-content-center align-items-center _content">
									
					<form id="reservation-form" name="reservation-form" class="_form">
						<div class="row">
							<div class=" offset-xs-2 offset-sm-2 offset-md-2 col-xs-8 col-sm-8 col-md-8">
								<div class="d-flex justify-content-center border border-info mb-1">
									<label for="name" style="font-size: 20px">Nova rezervacija</label>
								</div>					
							</div>							
						</div>
						<!-- Date field -->
						<div class="row">
							<div class=" offset-xs-2 offset-sm-2 offset-md-2 col-xs-2 col-sm-2 col-md-2">
								<label for="date" class="col-form-label">Datum leta</label>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<input class="form-control" type="date" id="date" name="date" onchange="procitajLet()"/>
							</div>							
						</div>
						
						<!-- Date warning field -->
						<div class="row">
							<div class=" offset-xs-4 offset-sm-4 offset-md-4 col-xs-6 col-sm-6 col-md-6">
								<label id="date-warning" class="col-form-label text-danger" hidden="hidden">Greška pri unosu datuma.</label>
							</div>							
						</div>
						
						<!-- Location1 field -->
						<div class="row mt-1">
							<div class=" offset-xs-2 offset-sm-2 offset-md-2 col-xs-2 col-sm-2 col-md-2">
								<label for="location1" class="col-form-label">Polazna lokacija</label>
							</div>
						</div>
						<div class="row mt-1">
							<div class=" offset-xs-2 offset-sm-2 offset-md-2 col-xs-2 col-sm-2 col-md-2">
								<label for="location11" class="col-form-label">Država</label>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<select name="location11" id="location11" onchange="readCity1()"></select>
							</div>
						</div>
						<div class="row mt-1">	
							<div class=" offset-xs-2 offset-sm-2 offset-md-2 col-xs-2 col-sm-2 col-md-2">
								<label for="location12" class="col-form-label">Grad</label>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<select name="location12" id="location12"></select>
							</div>							
						</div>
						
						<!-- Location1 warning field -->
						<div class="row">
							<div class=" offset-xs-4 offset-sm-4 offset-md-4 col-xs-6 col-sm-6 col-md-6">
								<label id="location1-warning" class="col-form-label text-danger" hidden="hidden">Greška pri odabiru polazne lokacije.</label>
							</div>							
						</div>
						
						<!-- Location2 field -->
						<div class="row mt-1">
							<div class=" offset-xs-2 offset-sm-2 offset-md-2 col-xs-2 col-sm-2 col-md-2">
								<label for="location2" class="col-form-label text-nowrap">Odredišna lokacija</label>
							</div>
						</div>
						<div class="row mt-1">
							<div class=" offset-xs-2 offset-sm-2 offset-md-2 col-xs-2 col-sm-2 col-md-2">
								<label for="location21" class="col-form-label">Država</label>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<select name="location21" id="location21" onchange="readCity2()"></select>
							</div>
						</div>
						<div class="row mt-1">	
							<div class=" offset-xs-2 offset-sm-2 offset-md-2 col-xs-2 col-sm-2 col-md-2">
								<label for="location22" class="col-form-label">Grad</label>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<select name="location22" id="location22"></select>
							</div>								
						</div>
						
						<!-- Location2 warning field -->
						<div class="row">
							<div class=" offset-xs-4 offset-sm-4 offset-md-4 col-xs-6 col-sm-6 col-md-6">
								<label id="location2-warning" class="col-form-label text-danger" hidden="hidden">Greška pri odabiru odredišne lokacije.</label>
							</div>							
						</div>
						<%Korisnik user = (Korisnik)session.getAttribute("prijavljeni korisnik"); 
							if("putnicki".equals(user.getPutnicki_teretni())){
						%>
						<!-- Number field -->
						<div class="row mt-1">
							<div class=" offset-xs-2 offset-sm-2 offset-md-2 col-xs-2 col-sm-2 col-md-2">
								<label for="number" class="col-form-label">Broj mjesta</label>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<input class="form-control" type="text" id="number" name="number" placeholder="Unesite broj mjesta."/>
							</div>								
						</div>
						
						<!-- Number warning field -->
						<div class="row">
							<div class=" offset-xs-4 offset-sm-4 offset-md-4 col-xs-6 col-sm-6 col-md-6">
								<label id="number-warning" class="col-form-label text-danger" hidden="hidden">Greška pri unosu broja mjesta.</label>
							</div>							
						</div>
						<%} %>
						
						<%if("teretni".equals(user.getPutnicki_teretni())){ %>
						<!-- Description field -->
						<div class="row mt-1">
							<div class=" offset-xs-2 offset-sm-2 offset-md-2 col-xs-2 col-sm-2 col-md-2">
								<label for="description" class="col-form-label">Opis tereta</label>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<input class="form-control" type="text" id="description" name="description" placeholder="Unesite opis tereta."/>
							</div>							
						</div>
						
						<!-- Description warning field -->
						<div class="row">
							<div class="offset-xs-4 offset-sm-4 offset-md-4 col-xs-6 col-sm-6 col-md-6">
								<label id="description-warning" class="col-form-label text-danger" hidden="hidden">Greška pri unosu opisa tereta.</label>
							</div>							
						</div>
						
						<!-- Specification field -->
						<div class="row">
							<div class=" offset-xs-2 offset-sm-2 offset-md-2 col-xs-2 col-sm-2 col-md-2">
								<label for="specification" class="col-form-label">Specifikacija robe</label>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<input class="form-control" type="file" id="specification" name="specification" placeholder="Unesite specifikaciju tereta."/>
								
							</div>								
						</div>
						
						<!-- Specification warning field -->
						<div class="row">
							<div class=" offset-xs-4 offset-sm-4 offset-md-4 col-xs-6 col-sm-6 col-md-6">
								<label id="specification-warning" class="col-form-label text-danger" hidden="hidden">Greška pri unosu specifikacije robe.</label>
							</div>							
						</div>
						<%} %>
						
						<!-- Reservation success field -->
						<div class="row">
							<div class="offset-xs-4 offset-sm-4 offset-md-4 col-xs-6 col-sm-6 col-md-6">
								<label id="reservation-notification" class="col-form-label text-success" hidden="hidden">Obavještenje o uspješnoj rezervaciji.</label>
							</div>							
						</div>
						
						<div class="row mt-1">
						<%if("putnicki".equals(user.getPutnicki_teretni())){ %>
							<div class="offset-xs-8 offset-sm-8 offset-md-8 col-xs-2 col-sm-2 col-md-2">
								<div class="d-flex flex-row-reverse">
									<button type="button" id="unesi" class="btn btn-primary" onclick="reservationPutnicki()">Unesite rezervaciju</button>
								</div>
							</div>
							<%} else{ %>
							<div class="offset-xs-8 offset-sm-8 offset-md-8 col-xs-2 col-sm-2 col-md-2">
								<div class="d-flex flex-row-reverse">
									<button type="button" id="unesi" class="btn btn-primary" onclick="reservationTeretni()">Unesite rezervaciju</button>
								</div>
							</div>
							<%} %>
						</div>
						
				
					</form>
		
				</div>

			</div>
		</div>
	</div>
</body>
</html>