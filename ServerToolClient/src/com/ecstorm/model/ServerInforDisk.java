package com.ecstorm.model;

import org.json.JSONException;
import org.json.JSONObject;

public class ServerInforDisk extends ServerInfor {
	String url = "/server/disk/";
	
	public String getFullUrl() {
		return this.getDomain() + this.url;
	}
	
	public String parseResponse(String result) {
		String out = "";
		try {
			JSONObject jsonObj = new JSONObject(result);
			out = " £”‡¥≈≈Ã £∫ " + jsonObj.getString("disk_left") + "\n";
			out += "’º±» £∫ " + jsonObj.getString("disk_percent") + "%\n";
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return out;
	}
}
