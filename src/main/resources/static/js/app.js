const uri = 'http://localhost:8083/auth';
const httpRequest = new XMLHttpRequest();
let playButton = document.querySelector('#play-button');

playButton.addEventListener('click', buildLoginRequest);

async function buildLoginRequest() {
	let login = document.querySelector('.auth-login').value;
	let password = document.querySelector('.auth-pass').value;

	let user = {
		login: login,
		password: password,
	};

	let url = uri + '?' + $.param(user);
	httpRequest.open('POST', url);
	httpRequest.setRequestHeader('Content-Type', 'application/json');
	httpRequest.send();
	console.log(user);
	console.log(url);

}
