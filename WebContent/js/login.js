const max_username_len = 45;
const max_password_len = 100;

function validateLoginForm(){
	var result = false;
	var username = document.forms["login-form"]["username"].value;
	var password = document.forms["login-form"]["password"].value;
	if(
			(0 < username.length && max_username_len >= username.length) &&
			(0 < password.length && max_password_len >= password.length)
			){
		result = true;
	}
	return result;
}

function sendLoginData(){
	
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (4 == this.readyState && 200 == this.status) { 
			var responseJson = JSON.parse(xhttp.responseText);
			  if(responseJson.isLoggedIn){
				  successfulLogin(responseJson.data);
			  }else{
				  unsuccessfulLogin(responseJson.reason);
			  }
		}
	 }
	xhttp.open("GET", "GlavniServlet?action=prijava"  +
			"&username=" + document.forms["login-form"]["username"].value + 
			"&password=" + document.forms["login-form"]["password"].value, true);
	xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded;charset=utf-8');
	xhttp.send();
	
}

function successfulLogin(dataJson){
	window.location.replace(dataJson.redirectUrl);
}

function unsuccessfulLogin(reason){
	var authWarning = document.getElementById('auth-warning');
	authWarning.innerHTML = "Nalog s datim kredencijalima ne postoji.";
	authWarning.removeAttribute('hidden');
}