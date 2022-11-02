var drzaveIZBaze = [];
var gradovi1IzBaze = [];
var gradovi2IzBaze = [];
var sviOdlasciZaDatum = [];

function procitajLet(){
	var form = document.forms['reservation-form'];
	var date = document.getElementById('date').value;
	var dateWarning = document.getElementById('date-warning');
	var button = document.getElementById('unesi');
	
	return new Promise((resolve, reject)=>{
		let xhttp = new XMLHttpRequest();
		
		xhttp.onreadystatechange = function() {
			if (4 == this.readyState && 200 == this.status) {
			  var responseJson = JSON.parse(xhttp.responseText);
			  if(responseJson){
				  sviOdlasciZaDatum = responseJson.odlasci;
				  if(sviOdlasciZaDatum.length == 0){
					  button.disabled = true;
					  dateWarning.innerHTML = "Ne postoji let za izabrani datum";
					  dateWarning.removeAttribute('hidden');
					  resolve(false);
				  }else{
					  button.disabled = false;
					  dateWarning.innerHTML = "";
					  dateWarning.setAttribute('hidden', 'true');
					  resolve(true); 
				  }
			  }else{
				  button.disabled = false;
				  dateWarning.innerHTML = "";
				  dateWarning.setAttribute('hidden', 'true');
				  resolve(true);
			  }	
			}
		 }

		xhttp.open("GET", "GlavniServlet?action=provjeraLeta&date=" + date, true);
		xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded;charset=utf-8');
		xhttp.send();
	});	
}

function setCB(){
	var form = document.forms['reservation-form'];
	var option = form['location11'];
	if(drzaveIZBaze.length == 0){
		option.innerHTML = "";
	} else{
		for(var i = 0; i < drzaveIZBaze.length; i++){
			var el = document.createElement("option");
			el.innerHTML = drzaveIZBaze[i];
			option.appendChild(el);
		}
	}
	
	var option2 = form['location21'];
	if(drzaveIZBaze.length == 0){
		option.innerHTML = "";
	} else {
		for(var i = 0; i < drzaveIZBaze.length; i++){
			var el = document.createElement("option");
			el.innerHTML = drzaveIZBaze[i];
			option2.appendChild(el);
		}
	}
}

function readCB(){
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (4 == this.readyState && 200 == this.status) { 
			var responseJson = JSON.parse(xhttp.responseText);
			  if(responseJson){
				  drzaveIZBaze = responseJson.drzaveIZBaze;
				  setCB();
			 }
		}
	 }
	xhttp.open("GET", "GlavniServlet?action=readReservationCB", true);
	xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded;charset=utf-8');
	xhttp.send();
}

function setCBGradovi1(){
	var form = document.forms['reservation-form'];
	var option = form['location12'];
	if(gradovi1IzBaze.length == 0){
		option.innerHTML = "";
	} else{
		option.innerHTML = "";
		for(var i = 0; i < gradovi1IzBaze.length; i++){
			var el = document.createElement("option");
			el.innerHTML = gradovi1IzBaze[i];
			option.appendChild(el);
		}
	}
}

function readCity1(){
	var country = document.getElementById('location11').value;
	
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (4 == this.readyState && 200 == this.status) { 
			var responseJson = JSON.parse(xhttp.responseText);
			  if(responseJson){
				  gradovi1IzBaze = responseJson.gradoviIzBaze;
				  setCBGradovi1();
			 }
		}
	 }
	xhttp.open("GET", "GlavniServlet?action=readReservationCBCity&country=" + country, true);
	xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded;charset=utf-8');
	xhttp.send();
}

function setCBGradovi2(){
	var form = document.forms['reservation-form'];
	var option = form['location22'];
	if(gradovi2IzBaze.length == 0){
		option.innerHTML = "";
	} else{
		option.innerHTML = "";
		for(var i = 0; i < gradovi2IzBaze.length; i++){
			var el = document.createElement("option");
			el.innerHTML = gradovi2IzBaze[i];
			option.appendChild(el);
		}
	}
}

function readCity2(){
	var country = document.getElementById('location21').value;
	
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (4 == this.readyState && 200 == this.status) { 
			var responseJson = JSON.parse(xhttp.responseText);
			  if(responseJson){
				  gradovi2IzBaze = responseJson.gradoviIzBaze;
				  setCBGradovi2();
			 }
		}
	 }
	xhttp.open("GET", "GlavniServlet?action=readReservationCBCity&country=" + country, true);
	xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded;charset=utf-8');
	xhttp.send();
}

function reservationPutnicki(){ 
	var form = document.forms['reservation-form'];
	var date = document.getElementById('date').value;
	var polazna_lokacija = form['location11'].value + '-' + form['location12'].value; 
	var odrediste = form['location21'].value + '-' + form['location22'].value;
	var broj_mjesta = form['number'].value;
	
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (4 == this.readyState && 200 == this.status) {
			  var responseJson = JSON.parse(xhttp.responseText);
			  if(responseJson.result){
				  var regNotification = document.getElementById('reservation-notification');
				  regNotification.innerHTML = "Zahtjev za rezervaciju leta je uspješana.";
				  regNotification.removeAttribute('hidden');
				  
				  setInterval(function(){
					  window.location.replace(responseJson.redirectUrl);
				  }, 5000);
				  			  
			  }else{
				  console.log('Rezervacija leta nije uspjesna');
			  }
		}
	 }
	
	xhttp.open("GET", "GlavniServlet?action=rezervacijaLetaSlanjePodatakaPutnicki" + 
			"&date=" + date +
			"&polazna_lokacija=" + polazna_lokacija + 
			"&odrediste=" + odrediste, true);
	xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded;charset=utf-8');
	xhttp.send();
	
}

function reservationTeretni(){
	var form = document.forms['reservation-form'];
	var date = document.getElementById('date').value;
	var polazna_lokacija = form['location11'].value + '-' + form['location12'].value; 
	var odrediste = form['location21'].value + '-' + form['location22'].value;
	var opis_tereta = form['description'].value;
	var specifikacija_robe = form['specification'].value;
	
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (4 == this.readyState && 200 == this.status) {
			  var responseJson = JSON.parse(xhttp.responseText);
			  if(responseJson.result){
				  var regNotification = document.getElementById('reservation-notification');
				  regNotification.innerHTML = "Zahtjev za rezervaciju leta je uspješan.";
				  regNotification.removeAttribute('hidden');
				  
				  setInterval(function(){
					  window.location.replace(responseJson.redirectUrl);
				  }, 5000);
				  			  
			  }else{
				  console.log('Rezervacija leta nije uspjesna');
			  }
		}
	 }
	
	xhttp.open("GET", "GlavniServlet?action=rezervacijaLetaSlanjePodatakaTeretni" + 
			"&date=" + date +
			"&polazna_lokacija=" + polazna_lokacija + 
			"&odrediste=" + odrediste +
			"&opis_tereta=" + opis_tereta +
			"&specifikacija_robe=" + specifikacija_robe, true);
	xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded;charset=utf-8');
	xhttp.send();
}