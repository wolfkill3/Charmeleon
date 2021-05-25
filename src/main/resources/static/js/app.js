const uri = 'http://localhost:8083/auth';
let playButton = document.querySelector('#play-button');

playButton.addEventListener('click', () => {
	let login = document.querySelector('.auth-login').value;
	let password = document.querySelector('.auth-pass').value;

	let user = {
		login: login,
		password: password,
	};

	let url = uri + '?' + $.param(user);
	fetch(url, { method: 'POST' })
		.then((response) => {
			return response.json();
		})
		.then((data) => {
			console.log(data);
		});
});
