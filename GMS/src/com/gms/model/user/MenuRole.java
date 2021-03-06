package com.gms.model.user;

public class MenuRole {
	private int	MENU_ROLE_MAP_ID;
	private int MENU_ID;
	private String MENU_NAME;
	private int ROLE_CODE;
	private boolean MENU_ACCESS;
	private String MENU_URL;
	private String MODULE_TAG;
	private boolean ACCESS_ADD;
	private boolean ACCESS_EDIT;
	private boolean ACCESS_DELETE;
	private boolean ACCESS_UPLOAD;
	private boolean ACCESS_DOWNLOAD;
	private boolean ACCESS_EMAIL;
	
	public int getMENU_ROLE_MAP_ID() {
		return MENU_ROLE_MAP_ID;
	}
	public void setMENU_ROLE_MAP_ID(int mENU_ROLE_MAP_ID) {
		MENU_ROLE_MAP_ID = mENU_ROLE_MAP_ID;
	}
	
	public int getMENU_ID() {
		return MENU_ID;
	}
	public void setMENU_ID(int mENU_ID) {
		MENU_ID = mENU_ID;
	}
	
	public int getROLE_CODE() {
		return ROLE_CODE;
	}
	public void setROLE_CODE(int rOLE_CODE) {
		ROLE_CODE = rOLE_CODE;
	}
	
	public boolean getMENU_ACCESS() {
		return MENU_ACCESS;
	}
	
	public void setMENU_ACCESS(boolean mENU_ACCESS) {
		MENU_ACCESS = mENU_ACCESS;
	}
	
	public boolean getACCESS_ADD() {
		return ACCESS_ADD;
	}
	
	public void setACCESS_ADD(boolean aCCESS_ADD) {
		ACCESS_ADD = aCCESS_ADD;
	}
	
	public boolean getACCESS_EDIT() {
		return ACCESS_EDIT;
	}
	
	public void setACCESS_EDIT(boolean aCCESS_EDIT) {
		ACCESS_EDIT = aCCESS_EDIT;
	}
	
	public boolean getACCESS_DELETE() {
		return ACCESS_DELETE;
	}
	
	public void setACCESS_DELETE(boolean aCCESS_DELETE) {
		ACCESS_DELETE = aCCESS_DELETE;
	}
	
	public boolean getACCESS_UPLOAD() {
		return ACCESS_UPLOAD;
	}
	
	public void setACCESS_UPLOAD(boolean aCCESS_UPLOAD) {
		ACCESS_UPLOAD = aCCESS_UPLOAD;
	}
	
	public boolean getACCESS_DOWNLOAD() {
		return ACCESS_DOWNLOAD;
	}
	
	public void setACCESS_DOWNLOAD(boolean aCCESS_DOWNLOAD) {
		ACCESS_DOWNLOAD = aCCESS_DOWNLOAD;
	}
	
	public boolean getACCESS_EMAIL() {
		return ACCESS_EMAIL;
	}
	
	public void setACCESS_EMAIL(boolean aCCESS_EMAIL) {
		ACCESS_EMAIL = aCCESS_EMAIL;
	}
	public String getMENU_NAME() {
		return MENU_NAME;
	}
	public void setMENU_NAME(String mENU_NAME) {
		MENU_NAME = mENU_NAME;
	}
	@Override
	public String toString() {
		return "MenuRole [MENU_ROLE_MAP_ID=" + MENU_ROLE_MAP_ID + ", MENU_ID=" + MENU_ID 
				+ ", MENU_NAME=" + MENU_NAME + ", ROLE_CODE=" + ROLE_CODE + ", MENU_ACCESS=" + MENU_ACCESS
				+ ", ACCESS_ADD=" + ACCESS_ADD + ", ACCESS_EDIT=" + ACCESS_EDIT + ", ACCESS_DELETE=" + ACCESS_DELETE
				+ ", ACCESS_UPLOAD=" + ACCESS_UPLOAD + ", ACCESS_DOWNLOAD=" + ACCESS_DOWNLOAD + ", ACCESS_EMAIL="
				+ ACCESS_EMAIL + "]";
	}
	public String getMENU_URL() {
		return MENU_URL;
	}
	public void setMENU_URL(String mENU_URL) {
		MENU_URL = mENU_URL;
	}
	public String getMODULE_TAG() {
		return MODULE_TAG;
	}
	public void setMODULE_TAG(String mODULE_TAG) {
		MODULE_TAG = mODULE_TAG;
	}
}