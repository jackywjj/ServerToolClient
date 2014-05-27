package com.ecstorm.model;

import org.json.JSONException;
import org.json.JSONObject;

public class ServerInforGunicorn extends ServerInfor {
String url = "/server/gunicorn/";
	
	public String getFullUrl() {
		return this.getDomain() + this.url;
	}
	
	public String parseResponse(String result) {
		String out = "";
		try {
			JSONObject jsonObj = new JSONObject(result);
			out = "gunicorn �� " + jsonObj.getString("gunicorn") + "\n";
		
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return out;
	}
}
