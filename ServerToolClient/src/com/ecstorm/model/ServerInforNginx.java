package com.ecstorm.model;

import org.json.JSONException;
import org.json.JSONObject;

public class ServerInforNginx extends ServerInfor {
	String url = "/server/nginx/";
	
	public String getFullUrl() {
		return this.getDomain() + this.url;
	}
	
	public String parseResponse(String result) {
		String out = "";
		try {
			JSONObject jsonObj = new JSONObject(result);
			out = "Nginx £º " + jsonObj.getString("nginx") + "\n";
		
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return out;
	}
}
