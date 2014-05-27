package com.ecstorm.model;

import org.json.JSONException;
import org.json.JSONObject;

public class ServerInforMemory extends ServerInfor {
	String url = "/server/memory/";
	
	public String getFullUrl() {
		return this.getDomain() + this.url;
	}
	
	public String parseResponse(String result) {
		String out = "";
		try {
			JSONObject jsonObj = new JSONObject(result);
			out = "Total £∫ " + jsonObj.getString("total") + "\n";
			out += "“— π”√ £∫ " + jsonObj.getString("used") + "\n";
			out += "ø’œ– £∫ " + jsonObj.getString("free") + "\n";
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return out;
	}
}
