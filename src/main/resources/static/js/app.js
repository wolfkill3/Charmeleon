let url = 'http://localhost:8083/auth';
let playButton = document.querySelector('#play-button');
let login = document.querySelector('#login');
let password = document.querySelector('#pass');

let user = {
	login: login,
	password: password,
};

playButton.addEventListener('click', buildRequest);

async function buildRequest() {
	console.log(login + ' ' + password);
	try {
		const response = await fetch(url, {
			method: 'POST',
			body: JSON.stringify(user),
			headers: {
				'Content-Type': 'application/json',
			},
		});
		const json = await response.json();
		console.log('Успех:', JSON.stringify(json));
	} catch (error) {
		console.error('Ошибка:', error);
	}
}