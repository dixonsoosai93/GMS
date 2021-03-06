package com.gms.model.investigator;



public class DecisionReport {
	
	int GRVDETID;
	int CASEID;
	int EMPLOYEE_ID;
	String NAME;
	String DECISION_REPORT_DATE;
	String DECISION_REPORT_CONTENT;
	
	
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public int getGRVDETID() {
		return GRVDETID;
	}
	public void setGRVDETID(int gRVDETID) {
		GRVDETID = gRVDETID;
	}
	public int getCASEID() {
		return CASEID;
	}
	public void setCASEID(int cASEID) {
		CASEID = cASEID;
	}
	public int getEMPLOYEE_ID() {
		return EMPLOYEE_ID;
	}
	public void setEMPLOYEE_ID(int eMPLOYEE_ID) {
		EMPLOYEE_ID = eMPLOYEE_ID;
	}
	public String getDECISION_REPORT_DATE() {
		return DECISION_REPORT_DATE;
	}
	public void setDECISION_REPORT_DATE(String dECISION_REPORT_DATE) {
		DECISION_REPORT_DATE = dECISION_REPORT_DATE;
	}
	public String getDECISION_REPORT_CONTENT() {
		return DECISION_REPORT_CONTENT;
	}
	public void setDECISION_REPORT_CONTENT(String dECISION_REPORT_CONTENT) {
		DECISION_REPORT_CONTENT = dECISION_REPORT_CONTENT;
	}

    
	
}
