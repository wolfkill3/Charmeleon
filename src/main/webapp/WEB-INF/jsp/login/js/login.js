const uri = 'http://localhost:8083/auth';
let playButton = document.querySelector('#play-button');
let alertText = document.querySelector('.alert-text');
let alert = document.querySelector('.alert');
//document.location.href = "/login";

playButton.addEventListener('click', async () => {
	let login = document.querySelector('.auth-login').value;
	let password = document.querySelector('.auth-pass').value;

	let user = {
		login: login,
		password: password,
	};

	let url = uri + '?' + $.param(user);
	const response = fetch(url, { method: 'POST' })
		.then((response) => response.json())
		.then((user) => {
			return user.responseStatus;
		});

	const printAddress = async () => {
		let responseStatus = await response;
		if (responseStatus === 'NOT_CONFIRMED') {
			responseStatus = 'Wrong password';
		} else {
			responseStatus = 'Success';
		}

		alertText.innerHTML = responseStatus;
		alert.style.backgroundColor = 'bisque';
		alert.style.borderWidth = '2px';
		alert.style.borderColor = 'black';
	};

	await printAddress();
});
