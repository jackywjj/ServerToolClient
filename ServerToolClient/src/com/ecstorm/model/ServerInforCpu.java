package com.ecstorm.model;

import org.json.JSONException;
import org.json.JSONObject;

public class ServerInforCpu extends ServerInfor {
	String url = "/server/cpu/";
	
	public String getFullUrl() {
		return this.getDomain() + this.url;
	}
	
	public String parseResponse(String result) {
		String out = "";
		try {
			JSONObject jsonObj = new JSONObject(result);
			out = "1 ∑÷÷” £∫ " + jsonObj.getString("load_1") + "\n";
			out += "5 ∑÷÷” £∫ " + jsonObj.getString("load_5") + "\n";
			out += "15 ∑÷÷” £∫ " + jsonObj.getString("load_15") + "\n";
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return out;
	}
}
