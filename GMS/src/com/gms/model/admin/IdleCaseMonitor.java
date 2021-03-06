package com.gms.model.admin;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IdleCaseMonitor {
	
	int CASEID;
	int GRVDETID;
	String CASENUMBER;
	String MAIN_CATEGORY_CODE;
	String SUB_CATEGORY_CODE;
	String HIERCODE;
	int HIERORDER;
	String TAT_START_DATE;
	String TAT_ACTUAL_END_DATE;
	String CURRENT_ROW_COMPLETED;
	String CURRENT_ROW_ACTIVE;
	String IS_ACTIVE;
	int INVESTIGATOR_EMPLOYEE_ID;
	String NAME;
	String DESIGNATION;
	String TAT;
	String COUNT_DAIRYID;
	String noOfDaysFromDtartDate;
	String noOfDailyDairyRecords;
	
	public IdleCaseMonitor(int cASEID, int gRVDETID, String cASENUMBER, String mAIN_CATEGORY_CODE,
			String sUB_CATEGORY_CODE, String hIERCODE, int hIERORDER, String tAT_START_DATE, String tAT_ACTUAL_END_DATE,
			String cURRENT_ROW_COMPLETED, String cURRENT_ROW_ACTIVE, String iS_ACTIVE, int iNVESTIGATOR_EMPLOYEE_ID,
			String nAME, String dESIGNATION, String tAT, String cOUNT_DAIRYID, String NoOfDaysFromDtartDate, String NoOfDailyDairyRecords) {
		super();
		CASEID = cASEID;
		GRVDETID = gRVDETID;
		CASENUMBER = cASENUMBER;
		MAIN_CATEGORY_CODE = mAIN_CATEGORY_CODE;
		SUB_CATEGORY_CODE = sUB_CATEGORY_CODE;
		HIERCODE = hIERCODE;
		HIERORDER = hIERORDER;
		TAT_START_DATE = tAT_START_DATE;
		TAT_ACTUAL_END_DATE = tAT_ACTUAL_END_DATE;
		CURRENT_ROW_COMPLETED = cURRENT_ROW_COMPLETED;
		CURRENT_ROW_ACTIVE = cURRENT_ROW_ACTIVE;
		IS_ACTIVE = iS_ACTIVE;
		INVESTIGATOR_EMPLOYEE_ID = iNVESTIGATOR_EMPLOYEE_ID;
		NAME = nAME;
		DESIGNATION = dESIGNATION;
		TAT = tAT;
		COUNT_DAIRYID = cOUNT_DAIRYID;
		noOfDaysFromDtartDate = NoOfDaysFromDtartDate;
		noOfDailyDairyRecords = NoOfDailyDairyRecords;
	}
	public int getCASEID() {
		return CASEID;
	}
	public void setCASEID(int cASEID) {
		CASEID = cASEID;
	}
	public int getGRVDETID() {
		return GRVDETID;
	}
	public void setGRVDETID(int gRVDETID) {
		GRVDETID = gRVDETID;
	}
	public String getCASENUMBER() {
		return CASENUMBER;
	}
	public void setCASENUMBER(String cASENUMBER) {
		CASENUMBER = cASENUMBER;
	}
	public String getMAIN_CATEGORY_CODE() {
		return MAIN_CATEGORY_CODE;
	}
	public void setMAIN_CATEGORY_CODE(String mAIN_CATEGORY_CODE) {
		MAIN_CATEGORY_CODE = mAIN_CATEGORY_CODE;
	}
	public String getSUB_CATEGORY_CODE() {
		return SUB_CATEGORY_CODE;
	}
	public void setSUB_CATEGORY_CODE(String sUB_CATEGORY_CODE) {
		SUB_CATEGORY_CODE = sUB_CATEGORY_CODE;
	}
	public String getHIERCODE() {
		return HIERCODE;
	}
	public void setHIERCODE(String hIERCODE) {
		HIERCODE = hIERCODE;
	}
	public int getHIERORDER() {
		return HIERORDER;
	}
	public void setHIERORDER(int hIERORDER) {
		HIERORDER = hIERORDER;
	}
	public String getTAT_START_DATE() {
		return TAT_START_DATE;
	}
	public void setTAT_START_DATE(String tAT_START_DATE) {
		TAT_START_DATE = tAT_START_DATE;
	}
	public String getTAT_ACTUAL_END_DATE() {
		return TAT_ACTUAL_END_DATE;
	}
	public void setTAT_ACTUAL_END_DATE(String tAT_ACTUAL_END_DATE) {
		TAT_ACTUAL_END_DATE = tAT_ACTUAL_END_DATE;
	}
	public String getCURRENT_ROW_COMPLETED() {
		return CURRENT_ROW_COMPLETED;
	}
	public void setCURRENT_ROW_COMPLETED(String cURRENT_ROW_COMPLETED) {
		CURRENT_ROW_COMPLETED = cURRENT_ROW_COMPLETED;
	}
	public String getCURRENT_ROW_ACTIVE() {
		return CURRENT_ROW_ACTIVE;
	}
	public void setCURRENT_ROW_ACTIVE(String cURRENT_ROW_ACTIVE) {
		CURRENT_ROW_ACTIVE = cURRENT_ROW_ACTIVE;
	}
	public String getIS_ACTIVE() {
		return IS_ACTIVE;
	}
	public void setIS_ACTIVE(String iS_ACTIVE) {
		IS_ACTIVE = iS_ACTIVE;
	}
	public int getINVESTIGATOR_EMPLOYEE_ID() {
		return INVESTIGATOR_EMPLOYEE_ID;
	}
	public void setINVESTIGATOR_EMPLOYEE_ID(int iNVESTIGATOR_EMPLOYEE_ID) {
		INVESTIGATOR_EMPLOYEE_ID = iNVESTIGATOR_EMPLOYEE_ID;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getDESIGNATION() {
		return DESIGNATION;
	}
	public void setDESIGNATION(String dESIGNATION) {
		DESIGNATION = dESIGNATION;
	}
	public String getTAT() {
		return TAT;
	}
	public void setTAT(String tAT) {
		TAT = tAT;
	}
	public String getCOUNT_DAIRYID() {
		return COUNT_DAIRYID;
	}
	public void setCOUNT_DAIRYID(String cOUNT_DAIRYID) {
		COUNT_DAIRYID = cOUNT_DAIRYID;
	}
	@Override
	public String toString() {
		return "IdleCaseMonitor [CASEID=" + CASEID + ", GRVDETID=" + GRVDETID + ", CASENUMBER=" + CASENUMBER
				+ ", MAIN_CATEGORY_CODE=" + MAIN_CATEGORY_CODE + ", SUB_CATEGORY_CODE=" + SUB_CATEGORY_CODE
				+ ", HIERCODE=" + HIERCODE + ", HIERORDER=" + HIERORDER + ", TAT_START_DATE=" + TAT_START_DATE
				+ ", TAT_ACTUAL_END_DATE=" + TAT_ACTUAL_END_DATE + ", CURRENT_ROW_COMPLETED=" + CURRENT_ROW_COMPLETED
				+ ", CURRENT_ROW_ACTIVE=" + CURRENT_ROW_ACTIVE + ", IS_ACTIVE=" + IS_ACTIVE
				+ ", INVESTIGATOR_EMPLOYEE_ID=" + INVESTIGATOR_EMPLOYEE_ID + ", NAME=" + NAME + ", DESIGNATION="
				+ DESIGNATION + ", TAT=" + TAT + ", COUNT_DAIRYID=" + COUNT_DAIRYID + "]";
	}
	
	public String getNoOfDaysFromDtartDate() {
		return noOfDaysFromDtartDate;
	}
	public void setNoOfDaysFromDtartDate(String noOfDaysFromDtartDate) {
		this.noOfDaysFromDtartDate = noOfDaysFromDtartDate;
	}
	public String getNoOfDailyDairyRecords() {
		return noOfDailyDairyRecords;
	}
	public void setNoOfDailyDairyRecords(String noOfDailyDairyRecords) {
		this.noOfDailyDairyRecords = noOfDailyDairyRecords;
	}
}

