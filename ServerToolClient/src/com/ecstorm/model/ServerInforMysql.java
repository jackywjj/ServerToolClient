package com.ecstorm.model;

import org.json.JSONException;
import org.json.JSONObject;

public class ServerInforMysql extends ServerInfor {
	String url = "/server/mysql/";
	
	public String getFullUrl() {
		return this.getDomain() + this.url;
	}
	
	public String parseResponse(String result) {
		String out = "";
		try {
			JSONObject jsonObj = new JSONObject(result);
			out = "Mysql £º " + jsonObj.getString("mysql") + "\n";
		
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return out;
	}
}
