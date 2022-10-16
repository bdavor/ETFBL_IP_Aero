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