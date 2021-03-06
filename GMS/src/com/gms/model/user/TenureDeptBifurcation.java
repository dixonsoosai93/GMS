package com.gms.model.user;

import org.json.JSONArray;

public class TenureDeptBifurcation {
	private JSONArray categories;
	private JSONArray series;
	
	public JSONArray getSeries() {
		return series;
	}
	public void setSeries(JSONArray series) {
		this.series = series;
	}
	public JSONArray getCategories() {
		return categories;
	}
	public void setCategories(JSONArray categories) {
		this.categories = categories;
	}
}
