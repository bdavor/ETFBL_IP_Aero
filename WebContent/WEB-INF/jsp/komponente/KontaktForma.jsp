<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<!-- Moj JS -->
	<script src="js/kontakt.js" type="text/javascript"></script>
</head>
<body>
	<h3>Kontakt</h3>
	<div class="containter-fluid">
		<div class="row _content-row">
			<div class="col-md-12">
				<div class="row mt-2">
					<div class="col-xs-12 col-sm-12 col-md-9">
					<div class="label text-wrap">
						Kontakt telefon: 051/123-456
					</div>
					<div class="label text-wrap">
						Fax: 051/456-123
					</div>
						<div class="d-flex justify-content-center align-items-center _content">

							<form id="text-form" name="textForm" class="_form">
								<div class="row">
									<div
										class=" offset-xs-2 offset-sm-2 offset-md-2 col-xs-8 col-sm-8 col-md-8">
										<div
											class="d-flex justify-content-center border border-info mb-1">
											<label for="name" style="font-size: 20px">Unesite poruku</label>
										</div>
									</div>
								</div>

								<!-- Email field -->
								<div class="row mt-1">
									<div
										class=" offset-xs-2 offset-sm-2 offset-md-2 col-xs-2 col-sm-2 col-md-2">
										<label for="email" class="col-form-label text-nowrap">Vaš email</label>
									</div>
									<div class="col-xs-6 col-sm-6 col-md-6">
										<input class="form-control" type="text" id="email"
											name="email" placeholder="Unesite Vaš email." />
									</div>
								</div>

								<!-- Email warning field -->
								<div class="row">
									<div
										class="offset-xs-4 offset-sm-4 offset-md-4 col-xs-6 col-sm-6 col-md-6">
										<label id="email-warning"
											class="col-form-label text-danger" hidden="hidden">Greška
											pri unosu email-a.</label>
									</div>
								</div>

								<!-- Naslov field -->
								<div class="row mt-1">
									<div
										class=" offset-xs-2 offset-sm-2 offset-md-2 col-xs-2 col-sm-2 col-md-2">
										<label for="naslov" class="col-form-label">Naslov poruke</label>
									</div>
									<div class="col-xs-6 col-sm-6 col-md-6">
										<input class="form-control" type="text" id="naslov"
											name="naslov" placeholder="Unesite naslov poruke." />
									</div>
								</div>

								<!-- Naslov warning field -->
								<div class="row">
									<div
										class="offset-xs-4 offset-sm-4 offset-md-4 col-xs-6 col-sm-6 col-md-6">
										<label id="naslov-warning"
											class="col-form-label text-danger" hidden="hidden">Greška pri unosu naslova poruke.</label>
									</div>
								</div>

								<!-- Text field -->
								<div class="row mt-1">
									<div
										class=" offset-xs-2 offset-sm-2 offset-md-2 col-xs-2 col-sm-2 col-md-2">
										<label for="text" class="col-form-label">Tekst poruke</label>
									</div>
									<div class="col-xs-6 col-sm-6 col-md-6">
										<input class="form-control" type="text" id="text"
											name="text" placeholder="Unesite tekst poruke." />
									</div>
								</div>

								<!-- Text warning field -->
								<div class="row">
									<div
										class="offset-xs-4 offset-sm-4 offset-md-4 col-xs-6 col-sm-6 col-md-6">
										<label id="text-warning"
											class="col-form-label text-danger" hidden="hidden">Greška pri unosu teksta poruke.</label>
									</div>
								</div>
								
								<!-- Unsuccessful auth field -->
								<div class="row">
									<div
										class="offset-xs-4 offset-sm-4 offset-md-4 col-xs-6 col-sm-6 col-md-6">
										<label id="auth-warning" class="col-form-label text-danger"
											hidden="hidden">Greška pri unosu podataka.</label>
									</div>
								</div>
								
								<!-- Send success field -->
								<div class="row">
									<div class="offset-xs-4 offset-sm-4 offset-md-4 col-xs-6 col-sm-6 col-md-6">
										<label id="send-notification" class="col-form-label text-success" hidden="hidden">Obavještenje o uspješnom slanju poruke.</label>
									</div>							
								</div>

								<div class="row mt-1">
									<div
										class="offset-xs-8 offset-sm-8 offset-md-8 col-xs-2 col-sm-2 col-md-2">
										<div class="d-flex flex-row-reverse">
											<button type="submit" class="btn btn-primary float-right"
												onclick="event.preventDefault(); send();">Pošalji</button>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>