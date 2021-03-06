package com.gms.model.masters;

import java.sql.Date;
import java.sql.Timestamp;

public class HolidayMasterModel {
	int HOLIDAY_ID;
	String STATE_CODE;
	String STATE_NAME;
	String HOLIDAYDATE;
	String HOLIDAY;
	String HOLIDAYNAME;
	String IS_ACTIVE;
	String DATE_CREATED	;
	Timestamp DATE_UPDATED;
	Timestamp DATE_DELETED;
	int CREATEDBY;
	int UPDATEDBY;
	int DELETEDBY;
	
	public HolidayMasterModel(){
	}
	public HolidayMasterModel(String sTATE_CODE, String sTATE_NAME) {
		super();
		STATE_CODE = sTATE_CODE;
		STATE_NAME = sTATE_NAME;
	}
	
	public HolidayMasterModel(int hOLIDAY_ID, String sTATE_CODE, String sTATE_NAME, Date hOLIDAYDATE, String hOLIDAY,
			String hOLIDAYNAME, String iS_ACTIVE, String dATE_CREATED) throws java.text.ParseException {
		super();
		HOLIDAY_ID = hOLIDAY_ID;
		STATE_CODE = sTATE_CODE;
		STATE_NAME = sTATE_NAME;
		HOLIDAYDATE =hOLIDAYDATE.toString();
		HOLIDAY = hOLIDAY;
		HOLIDAYNAME = hOLIDAYNAME;
		IS_ACTIVE = iS_ACTIVE;
		DATE_CREATED = dATE_CREATED;
	}
	public int getHOLIDAY_ID() {
		return HOLIDAY_ID;
	}
	public void setHOLIDAY_ID(int hOLIDAY_ID) {
		HOLIDAY_ID = hOLIDAY_ID;
	}
	public String getSTATE_CODE() {
		return STATE_CODE;
	}
	public void setSTATE_CODE(String sTATE_CODE) {
		STATE_CODE = sTATE_CODE;
	}
	public String getHOLIDAYDATE() {
		return HOLIDAYDATE;
	}
	public String getSTATE_NAME() {
		return STATE_NAME;
	}
	public void setSTATE_NAME(String sTATE_NAME) {
		STATE_NAME = sTATE_NAME;
	}
	public void setHOLIDAYDATE(String hOLIDAYDATE) {
		HOLIDAYDATE = hOLIDAYDATE;
	}
	public String getHOLIDAY() {
		return HOLIDAY;
	}
	public void setHOLIDAY(String hOLIDAY) {
		HOLIDAY = hOLIDAY;
	}
	public String getHOLIDAYNAME() {
		return HOLIDAYNAME;
	}
	public void setHOLIDAYNAME(String hOLIDAYNAME) {
		HOLIDAYNAME = hOLIDAYNAME;
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
	public Timestamp getDATE_UPDATED() {
		return DATE_UPDATED;
	}
	public void setDATE_UPDATED(Timestamp dATE_UPDATED) {
		DATE_UPDATED = dATE_UPDATED;
	}
	public Timestamp getDATE_DELETED() {
		return DATE_DELETED;
	}
	public void setDATE_DELETED(Timestamp dATE_DELETED) {
		DATE_DELETED = dATE_DELETED;
	}
	public int getCREATEDBY() {
		return CREATEDBY;
	}
	public void setCREATEDBY(int cREATEDBY) {
		CREATEDBY = cREATEDBY;
	}
	public int getUPDATEDBY() {
		return UPDATEDBY;
	}
	public void setUPDATEDBY(int uPDATEDBY) {
		UPDATEDBY = uPDATEDBY;
	}
	public int getDELETEDBY() {
		return DELETEDBY;
	}
	public void setDELETEDBY(int dELETEDBY) {
		DELETEDBY = dELETEDBY;
	}
	@Override
	public String toString() {
		return "HolidayMasterModel [HOLIDAY_ID="+HOLIDAY_ID+"STATE_CODE=" + STATE_CODE + ", HOLIDAYDATE=" + HOLIDAYDATE + ", HOLIDAYNAME=" + HOLIDAYNAME +", IS_ACTIVE=" + IS_ACTIVE
				+ ", DATE_CREATED=" + DATE_CREATED + ", DATE_UPDATED=" + DATE_UPDATED + ", DATE_DELETED=" + DATE_DELETED
				+ ", CREATEDBY=" + CREATEDBY + ", UPDATEDBY=" + UPDATEDBY + ", DELETEDBY=" + DELETEDBY + "]";
	}
	   
}
