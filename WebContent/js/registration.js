/**
 * 
 */

function validateForm(){
	var result = true;
	var usernamePromise;
	var emailPromise;
	var form = document.forms['registration-form'];
	var nameWarning = document.getElementById('name-warning');
	var surnameWarning = document.getElementById('surname-warning');
	var usernameWarning = document.getElementById('username-warning');
	var passwordWarning = document.getElementById('password-warning');
	var emailWarning = document.getElementById('email-warning');
	var addressWarning = document.getElementById('address-warning');
	var countryWarning = document.getElementById('country-warning');
	var accountWarning = document.getElementById('account-warning');
	
	var name = form['name'].value;
	var surname = form['surname'].value;
	var username = form['username'].value;
	var password = form['password'].value;
	var passwordRepeat = form['password-repeat'].value;
	var email = form['email'].value;
	var address = form['address'].value;
	var country = form['country'].value;
	
	if(0 === name.length || max_name_len < name.length){
		result = false;
		nameWarning.innerHTML = "Unesite ime do 45 karaktera.";
		nameWarning.removeAttribute('hidden');	
	}else{
		nameWarning.setAttribute('hidden', 'true');
	}
	
	if(0 === surname.length || max_surname_len < surname.length){
		result = false;
		surnameWarning.innerHTML = "Unesite prezime do 45 karaktera.";
		surnameWarning.removeAttribute('hidden');
	}else{
		surnameWarning.setAttribute('hidden', 'true');
	}
	
	if(0 === username.length || max_username_len < username.length){
		result = false;
		usernameWarning.innerHTML = "Unesite korisnicko ime do 45 karaktera.";
		usernameWarning.removeAttribute('hidden');
	}else{
		usernamePromise = checkUsername(username, usernameWarning);
	}
	
	if(0 === password.length || max_password_len < password.length){
		result = false;
		passwordWarning.innerHTML = "Unesite lozinku do 100 karaktera.";
		passwordWarning.removeAttribute('hidden');
	}else{
		if(0 === passwordRepeat.length || max_password_len < passwordRepeat.length){
			result = false;
			passwordWarning.innerHTML = "Ponovite unesenu lozinku.";
			passwordWarning.removeAttribute('hidden');
		}else if (password !== passwordRepeat){
			result = false;
			passwordWarning.innerHTML = "Lozinke se ne podudaraju.";
			passwordWarning.removeAttribute('hidden');
		}else{
			passwordWarning.setAttribute('hidden', 'true');
		}
	}
	
	
	if(0 === email.length || max_email_len < email.length){
		result = false;
		emailWarning.innerHTML = "Unesite email adresu do 100 karatkera.";
		emailWarning.removeAttribute('hidden');
	}else{
		emailPromise = checkEmail(email, emailWarning);
	}
	
	if(0 === address.length || address_len < address.length){
		result = false;
		addressWarning.innerHTML = "Unesite adresu do 100 karaktera.";
		addressWarning.removeAttribute('hidden');
	}else{
		addressWarning.setAttribute('hidden', 'true');
	}
	
	if(0 === country.length || country_len < country.length){
		result = false;
		countryWarning.innerHTML = "Izaberite državu.";
		countryWarning.removeAttribute('hidden');
	}else{
		countryWarning.setAttribute('hidden', 'true');
	}
	
	
	Promise.all([usernamePromise, emailPromise]).then(function(values) {
			for(var i = 0; i < values.length; i++){
				if(!values[i]){
					result = false;
				}
			}  
	});
	
	return result;
}

function checkUsername(username, usernameWarning){
	return new Promise((resolve, reject)=>{
		let xhttp = new XMLHttpRequest();
		
		xhttp.onreadystatechange = function() {
			if (4 == this.readyState && 200 == this.status) {
			  var responseJson = JSON.parse(xhttp.responseText);
			  if(responseJson.exists){
				  usernameWarning.innerHTML = "Korisnicko ime je zauzeto";
				  usernameWarning.removeAttribute('hidden');
				  resolve(false);
			  }else{
				  usernameWarning.setAttribute('hidden', 'true');
				  resolve(true);
			  }	
			}
		 }

		xhttp.open("GET", "GlavniServlet?action=check-username&username=" + username, true);
		xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded;charset=utf-8');
		xhttp.send();
	});	
}

function checkEmail(email, emailWarning){
	return new Promise((resolve, reject)=>{
		let xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (4 == this.readyState && 200 == this.status) {
				  var responseJson = JSON.parse(xhttp.responseText);
				  if(responseJson.exists){
					  emailWarning.innerHTML = "Email adresa je zauzeta";
					  emailWarning.removeAttribute('hidden');
					  resolve(false);
				  }else{
					  emailWarning.setAttribute('hidden', 'true');
					  resolve(true);
				  }
			}
		 }
	
		xhttp.open("GET", "GlavniServlet?action=check-email&email=" + email, true);
		xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded;charset=utf-8');
		xhttp.send();
	});
}