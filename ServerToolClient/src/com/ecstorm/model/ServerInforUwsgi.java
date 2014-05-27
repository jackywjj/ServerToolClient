package com.ecstorm.model;

import org.json.JSONException;
import org.json.JSONObject;

public class ServerInforUwsgi extends ServerInfor {
	String url = "/server/uwsgi/";
	
	public String getFullUrl() {
		return this.getDomain() + this.url;
	}
	
	public String parseResponse(String result) {
		String out = "";
		try {
			JSONObject jsonObj = new JSONObject(result);
			out = "uwsgi £º " + jsonObj.getString("uwsgi") + "\n";
		
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return out;
	}
}
