const uri = 'http://localhost:8083/registration';
let playButton = document.querySelector('#play-button');
let alertText = document.querySelector('.alert-text');
let alert = document.querySelector('.alert');

playButton.addEventListener('click', async () => {
	let email = document.querySelector('.auth-email').value;
	let login = document.querySelector('.auth-login').value;
	let password = document.querySelector('.auth-pass').value;
	let confPass = document.querySelector('.auth-pass-confirm').value;
	let success = true;
	let successAlert = '';

	let user = {
		email: email,
		login: login,
		password: password,
	};

	if (email === '') {
		successAlert = successAlert + '<br>Field e-mail is incorrect!</br>';
		success = false;
	}

	if (login === '') {
		successAlert = successAlert + '<br>Field login is incorrect!</br>';
		success = false;
	}

	if (password !== confPass) {
		successAlert = successAlert + '<br>Passwords has no matches</br>';
		success = false;
	}

	if (password.length < 6) {
		successAlert = successAlert + '<br>Passwords is shorter 6 chars</br>';
		success = false;
	}

	if (!success) {
		alertText.innerHTML = successAlert;
		alert.style.backgroundColor = 'bisque';
		alert.style.borderWidth = '2px';
		alert.style.borderColor = 'black';
	} else {
		const response = fetch(uri, {
			method: 'POST',
			mode: 'cors',
			headers: {
				'Content-Type': 'application/json',
			},
			redirect: 'follow',
			body: JSON.stringify(user),
		})
			.then((response) => response.json())
			.then((registrationStatus) => {
				return registrationStatus;
			});

		const printAddress = async () => {
			let responseStatus = await response;
			if (responseStatus === 'USED') {
				responseStatus = 'Login is already used';
			} else if (responseStatus === 'NOT_USED') {
				responseStatus = 'Success';
			} else {
				responseStatus = 'Bad request';
			}

			alertText.innerHTML = responseStatus;
			alert.style.backgroundColor = 'bisque';
			alert.style.borderWidth = '2px';
			alert.style.borderColor = 'black';
		};

		await printAddress();
	}
});
