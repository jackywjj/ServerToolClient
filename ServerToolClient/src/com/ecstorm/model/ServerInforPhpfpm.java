package com.ecstorm.model;

import org.json.JSONException;
import org.json.JSONObject;

public class ServerInforPhpfpm extends ServerInfor {
	String url = "/server/phpfpm/";
	
	public String getFullUrl() {
		return this.getDomain() + this.url;
	}
	
	public String parseResponse(String result) {
		String out = "";
		try {
			JSONObject jsonObj = new JSONObject(result);
			out = "PHP £º " + jsonObj.getString("phpfpm") + "\n";
		
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return out;
	}
}
