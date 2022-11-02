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