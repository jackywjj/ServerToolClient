package com.ecstorm.model;

public abstract class ServerInfor {
	private String domain = "http://115.29.162.53:9982";
	private String url = "";
	
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getFullUrl() {
		return null;
	}
	public String parseResponse(String result) {
		return "";
	}
}
