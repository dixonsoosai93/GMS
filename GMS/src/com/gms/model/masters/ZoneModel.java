package com.gms.model.masters;

public class ZoneModel {
	private String	ZONE_CODE;
	private String	ZONE_NAME;	
	private String IS_ACTIVE;
	private String DATE_CREATED;
	
	public ZoneModel(String ZONE_CODE, String ZONE_NAME) {
		this.ZONE_CODE=ZONE_CODE;
		this.ZONE_NAME=ZONE_NAME;
	}
	public String getZONE_CODE() {
		return ZONE_CODE;
	}
	public void setZONE_CODE(String zONE_CODE) {
		ZONE_CODE = zONE_CODE;
	}
	public String getZONE_NAME() {
		return ZONE_NAME;
	}
	public void setZONE_NAME(String zONE_NAME) {
		ZONE_NAME = zONE_NAME;
	}
	public String getIS_ACTIVE() {
		return IS_ACTIVE;
	}
	public void setIS_ACTIVE(String iS_ACTIVE) {
		IS_ACTIVE = iS_ACTIVE;
	}
	public String getDATE_CREATED() {
		return DATE_CREATED;
	}
	public void setDATE_CREATED(String dATE_CREATED) {
		DATE_CREATED = dATE_CREATED;
	}
	
	

}
