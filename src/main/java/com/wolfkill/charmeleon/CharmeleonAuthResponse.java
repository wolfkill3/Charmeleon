package com.wolfkill.charmeleon;

public class CharmeleonAuthResponse {

	private final String login;
	private final String password;

	public CharmeleonAuthResponse(String login, String password) {
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
