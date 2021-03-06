package com.gms.model.user;

import org.json.JSONArray;

public class ZoneGenderAll {
	private JSONArray xCategories;
	private JSONArray zCategories;
	private JSONArray series;
	
	public JSONArray getxCategories() {
		return xCategories;
	}
	public void setxCategories(JSONArray xCategories) {
		this.xCategories = xCategories;
	}
	public JSONArray getzCategories() {
		return zCategories;
	}
	public void setzCategories(JSONArray zCategories) {
		this.zCategories = zCategories;
	}
	public JSONArray getSeries() {
		return series;
	}
	public void setSeries(JSONArray series) {
		this.series = series;
	}
}
