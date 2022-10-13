var podatci = [];
var red_prvi = "<tr><th>Polazna lokacija</th><th>Odredište</th><th>Vrijeme dolaska</th><th>Status</th><th>Vrsta leta</th></tr>";

function setTable(){
	document.getElementById("tablePetDolazaka").innerHTML = "";
	var red = red_prvi;
	if(podatci.length >= 5){
		for(var i = 0; i < 5; i++){
			
			var polazna_lokacija = podatci[i].polazna_lokacija;
			var odrediste = podatci[i].odrediste;
			var vrijeme_polaska = podatci[i].vrijeme_polaska;
			var status = podatci[i].status;
			var vrsta_leta = podatci[i].vrsta_leta;
			red += "<tr> <th>" + polazna_lokacija + "</th> <th>" + odrediste + "</th> <th>" + vrijeme_polaska + "</th> <th>" + status +"</th> <th>" + vrsta_leta + "</th> </tr>";
		
		}
	} else{
		for(var i = 0; i < podatci.length; i++){
		
			var polazna_lokacija = podatci[i].polazna_lokacija;
			var odrediste = podatci[i].odrediste;
			var vrijeme_polaska = podatci[i].vrijeme_polaska;
			var status = podatci[i].status;
			var vrsta_leta = podatci[i].vrsta_leta;
			red += "<tr> <th>" + polazna_lokacija + "</th> <th>" + odrediste + "</th> <th>" + vrijeme_polaska + "</th> <th>" + status +"</th> <th>" + vrsta_leta + "</th> </tr>";
	
		}
	}
document.getElementById("tablePetDolazaka").innerHTML = red;
}

function ucitaj(){
	var request = new XMLHttpRequest();

	request.onreadystatechange = function() {
		if ((request.readyState == 4) && (request.status == 200)) {
			podatci = JSON.parse(request.responseText).dolasci;

			setTable();
		}
		
		timeout = setTimeout(function(){
			ucitaj();
		}, 60000)
	}

	request.open("GET","GlavniServlet?action=petSljedecihDolazakaZahtjev",true)
	request.send(null)
}