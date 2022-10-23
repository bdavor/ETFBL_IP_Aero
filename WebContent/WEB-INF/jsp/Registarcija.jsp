<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
	<title>Registracija</title>
	
	<!-- Bootstrap META -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	
	<!-- External JS --> 
	<script type="text/javascript" src="js/registration.js"></script>   

</head>
<body onload="read()">
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
									
					<form id="registration-form" name="registration-form" class="_form">
						<div class="row">
							<div class=" offset-xs-2 offset-sm-2 offset-md-2 col-xs-8 col-sm-8 col-md-8">
								<div class="d-flex justify-content-center border border-info mb-1">
									<label for="name" style="font-size: 20px">Novi nalog</label>
								</div>					
							</div>							
						</div>
						<!-- Name field -->
						<div class="row">
							<div class=" offset-xs-2 offset-sm-2 offset-md-2 col-xs-2 col-sm-2 col-md-2">
								<label for="name" class="col-form-label">Ime</label>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<input class="form-control" type="text" id="name" name="name" placeholder="Unesite ime."/>
							</div>								
						</div>
						
						<!-- Name warning field -->
						<div class="row">
							<div class=" offset-xs-4 offset-sm-4 offset-md-4 col-xs-6 col-sm-6 col-md-6">
								<label id="name-warning" class="col-form-label text-danger" hidden="hidden">Greška pri unosu imena.</label>
							</div>							
						</div>
						
						<!-- Surname field -->
						<div class="row mt-1">
							<div class=" offset-xs-2 offset-sm-2 offset-md-2 col-xs-2 col-sm-2 col-md-2">
								<label for="surname" class="col-form-label">Prezime</label>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<input class="form-control" type="text" id="surname" name="surname" placeholder="Unesite prezime."/>
							</div>								
						</div>
						
						<!-- Surname warning field -->
						<div class="row">
							<div class=" offset-xs-4 offset-sm-4 offset-md-4 col-xs-6 col-sm-6 col-md-6">
								<label id="surname-warning" class="col-form-label text-danger" hidden="hidden">Greška pri unosu prezimena.</label>
							</div>							
						</div>
						
						<!-- Username field -->
						<div class="row mt-1">
							<div class=" offset-xs-2 offset-sm-2 offset-md-2 col-xs-2 col-sm-2 col-md-2">
								<label for="username" class="col-form-label text-nowrap">Korisnicko ime</label>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<input class="form-control" type="text" id="username" name="username" placeholder="Unesite korisnicko ime."/>
							</div>								
						</div>
						
						<!-- Username warning field -->
						<div class="row">
							<div class=" offset-xs-4 offset-sm-4 offset-md-4 col-xs-6 col-sm-6 col-md-6">
								<label id="username-warning" class="col-form-label text-danger" hidden="hidden">Greška pri unosu korisnickog imena.</label>
							</div>							
						</div>
						
						<!-- Password field -->
						<div class="row mt-1">
							<div class=" offset-xs-2 offset-sm-2 offset-md-2 col-xs-2 col-sm-2 col-md-2">
								<label for="password" class="col-form-label">Lozinka</label>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<input class="form-control" type="password" id="password" name="password" placeholder="Unesite lozinku."/>
							</div>								
						</div>
						
						<!-- Repeat password field -->
						<div class="row mt-1">
							<div class=" offset-xs-2 offset-sm-2 offset-md-2 col-xs-2 col-sm-2 col-md-2">
								<label for="password-repeat" class="col-form-label text-nowrap">Ponovite lozinku</label>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<input class="form-control" type="password" id="password-repeat" name="password-repeat" placeholder="Ponovite lozinku."/>
							</div>								
						</div>
						
						<!-- Password warning field -->
						<div class="row">
							<div class=" offset-xs-4 offset-sm-4 offset-md-4 col-xs-6 col-sm-6 col-md-6">
								<label id="password-warning" class="col-form-label text-danger" hidden="hidden">Greška pri unosu lozinke.</label>
							</div>							
						</div>
						
						<!-- Email field -->
						<div class="row mt-1">
							<div class=" offset-xs-2 offset-sm-2 offset-md-2 col-xs-2 col-sm-2 col-md-2">
								<label for="email" class="col-form-label">Email</label>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<input class="form-control" type="text" id="email" name="email" placeholder="Unesite mail adresu."/>
							</div>								
						</div>
						
						<!-- Email warning field -->
						<div class="row">
							<div class="offset-xs-4 offset-sm-4 offset-md-4 col-xs-6 col-sm-6 col-md-6">
								<label id="email-warning" class="col-form-label text-danger" hidden="hidden">Greška pri unosu mail adrese.</label>
							</div>							
						</div>
						
						<!-- Address field -->
						<div class="row">
							<div class=" offset-xs-2 offset-sm-2 offset-md-2 col-xs-2 col-sm-2 col-md-2">
								<label for="address" class="col-form-label">Adresa</label>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<input class="form-control" type="text" id="address" name="address" placeholder="Unesite adresu."/>
							</div>								
						</div>
						
						<!-- Address warning field -->
						<div class="row">
							<div class=" offset-xs-4 offset-sm-4 offset-md-4 col-xs-6 col-sm-6 col-md-6">
								<label id="address-warning" class="col-form-label text-danger" hidden="hidden">Greška pri unosu adrese.</label>
							</div>							
						</div>
						
						<!-- Country field -->
						<div class="row">
							<div class=" offset-xs-2 offset-sm-2 offset-md-2 col-xs-2 col-sm-2 col-md-2">
								<label for="country" class="col-form-label">Država</label>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<select name="country" id="country"></select>
							</div>								
						</div>
						
						<!-- Country warning field -->
						<div class="row">
							<div class=" offset-xs-4 offset-sm-4 offset-md-4 col-xs-6 col-sm-6 col-md-6">
								<label id="country-warning" class="col-form-label text-danger" hidden="hidden">Greška pri odabiru države.</label>
							</div>							
						</div>
						
						<!-- Account field -->
						<div class="row">
							<div class=" offset-xs-2 offset-sm-2 offset-md-2 col-xs-2 col-sm-2 col-md-2">
								<label for="account" class="col-form-label">Vrsta naloga</label>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div id="account">
									<input type="radio" checked="checked" id="putnicki" name="putnicki"/>Putnicki
									<input type="radio" id="teretni" name="teretni"/>Teretni
								</div>
							</div>								
						</div>
						
						<!-- Account warning field -->
						<div class="row">
							<div class=" offset-xs-4 offset-sm-4 offset-md-4 col-xs-6 col-sm-6 col-md-6">
								<label id="account-warning" class="col-form-label text-danger" hidden="hidden">Greška pri odabiru vrste naloga.</label>
							</div>							
						</div>
						
						<!-- Registration success field -->
						<div class="row">
							<div class="offset-xs-4 offset-sm-4 offset-md-4 col-xs-6 col-sm-6 col-md-6">
								<label id="registration-notification" class="col-form-label text-success" hidden="hidden">Obavještenje o uspješnoj registraciji.</label>
							</div>							
						</div>
						
						<div class="row mt-1">
							<div class="offset-xs-8 offset-sm-8 offset-md-8 col-xs-2 col-sm-2 col-md-2">
								<div class="d-flex flex-row-reverse">
									<button type="button" class="btn btn-primary" onclick="registration()">Napravite nalog</button>
								</div>
								
							</div>
						</div>
						
				
					</form>
		
				</div>

			</div>
		</div>
	</div>
</body>
</html>