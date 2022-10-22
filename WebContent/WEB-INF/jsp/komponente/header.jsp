<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.unibl.etf.dto.Korisnik" %>	
	
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>

<!-- Bootstrap META -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<!-- External JS -->
	<script src="js/login.js" type="text/javascript"></script>
</head>
<body>

	<div class="containter-fluid">
		<div class="row _content-row">
			<!-- Text column-->
			<div class="col-md-9">
				<div
					class=" offset-xs-2 offset-sm-2 offset-md-2 col-xs-8 col-sm-8 col-md-8">
					<div class="d-flex justify-content-center border border-info mb-1">
						<label for="name" style="font-size: 20px">Internet
							programiranje - projektni zadatak</label>
					</div>
				</div>
			</div>
      
      <!-- Login column-->
			<div class="col-md-3">
				<div class="row mt-2">
					<div class="col-xs-12 col-sm-12 col-md-12">
					<%boolean loggedIn = (Boolean)session.getAttribute("logged");
					if(loggedIn){ 
					Korisnik user = (Korisnik)session.getAttribute("prijavljeni korisnik");%>
					<div class="label text-wrap">
						<%=user.getIme() + " " + user.getPrezime() %>
					</div>
					<!-- Logout link -->
					<div class="row">
						<div
							class="offset-xs-4 offset-sm-4 offset-md-4 col-xs-6 col-sm-6 col-md-6">
							<a href="<%=request.getContextPath()%>/GlavniServlet?action=Odjava"
								class="text-center" style="width: 100%">Odjavite se</a>
						</div>
					</div>
					<%} else{ %>
						<div
							class="d-flex justify-content-center align-items-center _content">

							<form id="login-form" name="loginForm" class="_form">
								<div class="row">
									<div
										class=" offset-xs-2 offset-sm-2 offset-md-2 col-xs-8 col-sm-8 col-md-8">
										<div
											class="d-flex justify-content-center border border-info mb-1">
											<label for="name" style="font-size: 20px">Prijava</label>
										</div>
									</div>
								</div>

								<!-- Username field -->
								<div class="row mt-1">
									<div
										class=" offset-xs-2 offset-sm-2 offset-md-2 col-xs-2 col-sm-2 col-md-2">
										<label for="username" class="col-form-label text-nowrap">Korisnicko ime</label>
									</div>
									<div class="col-xs-6 col-sm-6 col-md-6">
										<input class="form-control" type="text" id="username"
											name="username" placeholder="Unesite korisnicko ime." />
									</div>
								</div>

								<!-- Username warning field -->
								<div class="row">
									<div
										class="offset-xs-4 offset-sm-4 offset-md-4 col-xs-6 col-sm-6 col-md-6">
										<label id="username-warning"
											class="col-form-label text-danger" hidden="hidden">Greška
											pri unosu korisnickog imena.</label>
									</div>
								</div>

								<!-- Password field -->
								<div class="row mt-1">
									<div
										class=" offset-xs-2 offset-sm-2 offset-md-2 col-xs-2 col-sm-2 col-md-2">
										<label for="password" class="col-form-label">Lozinka</label>
									</div>
									<div class="col-xs-6 col-sm-6 col-md-6">
										<input class="form-control" type="password" id="password"
											name="password" placeholder="Unesite lozinku." />
									</div>
								</div>

								<!-- Password warning field -->
								<div class="row">
									<div
										class="offset-xs-4 offset-sm-4 offset-md-4 col-xs-6 col-sm-6 col-md-6">
										<label id="password-warning"
											class="col-form-label text-danger" hidden="hidden">Greška pri unosu lozinke.</label>
									</div>
								</div>

								<!-- Unsuccessful auth field -->
								<div class="row">
									<div
										class="offset-xs-4 offset-sm-4 offset-md-4 col-xs-6 col-sm-6 col-md-6">
										<label id="auth-warning" class="col-form-label text-danger"
											hidden="hidden">Greška pri unosu para korisnicko ime / lozinka.</label>
									</div>
								</div>

								<div class="row mt-1">
									<div
										class="offset-xs-8 offset-sm-8 offset-md-8 col-xs-2 col-sm-2 col-md-2">
										<div class="d-flex flex-row-reverse">
											<button type="submit" class="btn btn-primary float-right"
												onclick="event.preventDefault(); processSubmit();">Prijavi
												se</button>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
				<!-- Registration link -->
				<div class="row">
					<div
						class="offset-xs-4 offset-sm-4 offset-md-4 col-xs-6 col-sm-6 col-md-6">
						<a href="<%=request.getContextPath()%>/GlavniServlet?action=Registracija"
							class="text-center" style="width: 100%">Registracija</a>
					</div>
				</div>
				<%} %>
			</div>
		</div>
	</div>
</body>
</html>