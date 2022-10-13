const max_email_len = 45;
const max_naslov_len = 45;
const max_text_len = 2000;

function sendText(){
	var email = document.forms["text-form"]["email"].value;
	var naslov = document.forms["text-form"]["naslov"].value;
	var text = document.forms["text-form"]["text"].value;
	
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (4 == this.readyState && 200 == this.status) {
			  var responseJson = JSON.parse(xhttp.responseText);
			  if(responseJson.result){
				  var sendNotification = document.getElementById('send-notification');
				  sendNotification.innerHTML = "Poruka je uspješno poslana.";
				  sendNotification.removeAttribute('hidden');
				  
				  setInterval(function(){
					  window.location.replace(responseJson.redirectUrl);
				  }, 5000);
				  			  
			  }else{
				  console.log('Slanje poruke nije uspjelo');
			  }
		}
	 }

	xhttp.open("GET", "GlavniServlet?action=slanjePoruke" + 
			"&email=" + email +
			"&naslov=" + naslov + 
			"&text=" + text, true);
	xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded;charset=utf-8');
	xhttp.send();
}

function send(){
	if(validateForm()){
		var authWarning = document.getElementById('auth-warning');
		authWarning.setAttribute('hidden', 'true');
		sendText();
	} else{
		var email = document.forms["text-form"]["email"].value;
		var naslov = document.forms["text-form"]["naslov"].value;
		var text = document.forms["text-form"]["text"].value;
		var emailWarning = document.getElementById('email-warning');
		var naslovWarning = document.getElementById('naslov-warning');
		var textWarning = document.getElementById('text-warning');
		
		
		if(0 === email.length || max_email_len < email.length){
			result = false;
			emailWarning.innerHTML = "Unesite email do 45 karaktera.";
			emailWarning.removeAttribute('hidden');
		}else{
			emailWarning.setAttribute('hidden', 'true');
		}
		
		if(0 === naslov.length || max_naslov_len < naslov.length){
			result = false;
			naslovWarning.innerHTML = 'Unesite naslov poruke do 45 karaktera.';
			naslovWarning.removeAttribute('hidden');
		}else{
			naslovWarning.setAttribute('hidden', 'true');
		}
		
		if(0 === text.length || max_text_len < text.length){
			result = false;
			textWarning.innerHTML = 'Unesite tekst poruke do 2000 karaktera.';
			textWarning.removeAttribute('hidden');
		}else{
			textWarning.setAttribute('hidden', 'true');
		}
	}
}

function validateForm(){
	var result = false;
	var email = document.forms["text-form"]["email"].value;
	var naslov = document.forms["text-form"]["naslov"].value;
	var text = document.forms["text-form"]["text"].value;
	if(
			(0 < email.length && max_email_len >= email.length) &&
			(0 < naslov.length && max_naslov_len >= naslov.length) &&
			(0 < text.length && max_text_len >= text.length)
			){
		result = true;
	}
	return result;
}