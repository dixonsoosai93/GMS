package com.gms.model.dashboard;

import org.json.JSONArray;
import org.json.JSONObject;

public class Status {
	
	private JSONArray series;
	
	public JSONArray getSeries() {
		return series;
	}
	
	public void setSeries(JSONArray series) {
		this.series = series;
	}

	@Override
	public String toString() {
		return "Status [series=" + series + "]";
	}

	public void put(JSONObject jsonObject) {
		// TODO Auto-generated method stub
		
	}
	
}
