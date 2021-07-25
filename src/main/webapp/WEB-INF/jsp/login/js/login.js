const uri = 'http://localhost:8083/auth';
let playButton = document.querySelector('#play-button');
let alertText = document.querySelector('.alert-text');
let alert = document.querySelector('.alert');

function getRandomInt(max) {
	return Math.floor(Math.random() * max) + 1;
}

function getCookie(login, password) {
	return getRandomInt(login.length * password.length)
		* getRandomInt(password.length * password.length)
		* getRandomInt(login.length * login.length)+password;
}

playButton.addEventListener('click', async () => {
	let login = document.querySelector('.auth-login').value;
	let password = document.querySelector('.auth-pass').value;
	let frontCookie = getCookie(login, password);

	let user = {
		login: login,
		password: password,
		cookie: frontCookie,
	};

	let url = uri + '?' + $.param(user);
	const response = fetch(url, { method: 'POST' })
		.then((response) => response.json())
		.then((user) => {
			return user;
		});

	const printAddress = async () => {
		let awaitedResponse = await response;
		if (awaitedResponse.responseStatus === 'NOT_CONFIRMED') {
			awaitedResponse.responseStatus = 'Wrong password';
		} else {
			if (awaitedResponse.personalCookie === frontCookie) {
				document.location.href = '/lk/' + awaitedResponse.userData.id;
			} else {
				awaitedResponse.responseStatus = 'Fail session';
			}
		}

		console.log(typeof frontCookie + ' frontCookie = ' + frontCookie);
		console.log(typeof awaitedResponse.personalCookie +  'cookie = ' + awaitedResponse.personalCookie);
		console.log(frontCookie === awaitedResponse.personalCookie);
		alertText.innerHTML = awaitedResponse.responseStatus;
		alert.style.backgroundColor = 'bisque';
		alert.style.borderWidth = '2px';
		alert.style.borderColor = 'black';
	};

	await printAddress();
});
