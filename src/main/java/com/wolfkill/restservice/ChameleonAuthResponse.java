package com.wolfkill.restservice;

public class ChameleonAuthResponse {

	private final String login;
	private final String password;

	public ChameleonAuthResponse(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}
}
