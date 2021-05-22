package com.wolfkill.restservice;

public class ChameleonResponse {

	private final long id;
	private final String content;

	public ChameleonResponse(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}
