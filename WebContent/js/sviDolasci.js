var podatci = [];
var red_prvi = "<tr><th>Polazna lokacija</th><th>Odredište</th><th>Vrijeme dolaska</th><th>Status</th><th>Vrsta leta</th></tr>";

function setTable(){
	document.getElementById("table").innerHTML = "";
	var red = red_prvi;
	for(var i = 0; i < podatci.length; i++){
		
		var polazna_lokacija = podatci[i].polazna_lokacija;
		var odrediste = podatci[i].odrediste;
		var vrijeme_polaska = podatci[i].vrijeme_polaska;
		var status = podatci[i].status;
		var vrsta_leta = podatci[i].vrsta_leta;
		red += "<tr> <th>" + polazna_lokacija + "</th> <th>" + odrediste + "</th> <th>" + vrijeme_polaska + "</th> <th>" + status +"</th> <th>" + vrsta_leta + "</th> </tr>";
	
}
document.getElementById("table").innerHTML = red;
}

function ucitaj(i){
	var request = new XMLHttpRequest();

	request.onreadystatechange = function() {
		if ((request.readyState == 4) && (request.status == 200)) {
			podatci = JSON.parse(request.responseText).dolasci;

			setTable();
		}
		
		timeout = setTimeout(function(){
			ucitaj(i);
		}, 60000)
	}

	request.open("GET","GlavniServlet?action=sviDolasciZahtjev&dan="+i,true)
	request.send(null)
}

function prethodniDan(){
	ucitaj(-1);
}

function sljedeciDan(){
	ucitaj(1);
}
