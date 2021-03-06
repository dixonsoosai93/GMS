package com.gms.model.investigator;

import java.sql.Date;
import java.sql.Timestamp;

public class DtDailyDairy {
	
	int ATTACHID;
	int DAIRYID;
	int GRVDETID;
	int CASEID;
	int EMPLOYEE_ID;
	int ENTRY_EMPLOYEE_ID;
	String FILEPATH;
	String FILENAME;
	String NAME;
	String NAME1;
	String HIRECODE;
	String DAIRY_DATE;
	String DAIRY_DETAILS;
	String IS_ACTIVE;
	String DATE_CREATED;
	Timestamp DATE_UPDATED;
	Timestamp DATE_DELETED;
	int CREATEDBY;
	int UPDATEDBY;
	int DELETEDBY;
	String fileNameXtn;
	int fileLength;
	
	public DtDailyDairy() {
		
	}
	
	public DtDailyDairy( int cASEID, int eMPLOYEE_ID, String nAME, String hIRECODE,int dAIRYID, Date dAIRY_DATE,
			String dAIRY_DETAILS, int eNTRY_EMPLOYEE_ID,String nAME1) {
		super();
		CASEID = cASEID;
		EMPLOYEE_ID = eMPLOYEE_ID;
		NAME = nAME;
		HIRECODE = hIRECODE;
		DAIRYID = dAIRYID;
		DAIRY_DATE = dAIRY_DATE.toString();
		DAIRY_DETAILS = dAIRY_DETAILS;
		ENTRY_EMPLOYEE_ID=eNTRY_EMPLOYEE_ID;
		NAME1 = nAME1;
	}
	
	public DtDailyDairy( int cASEID, int eMPLOYEE_ID, String nAME, String hIRECODE,int dAIRYID, String dAIRY_DATE,
			String dAIRY_DETAILS, String iS_ACTIVE) {
		super();
		CASEID = cASEID;
		EMPLOYEE_ID = eMPLOYEE_ID;
		NAME = nAME;
		HIRECODE = hIRECODE;
		DAIRYID = dAIRYID;
		DAIRY_DATE = dAIRY_DATE;
		DAIRY_DETAILS = dAIRY_DETAILS;
		IS_ACTIVE = iS_ACTIVE;
	}
	
	public DtDailyDairy(int aTTACHID, int dAIRYID, int cASEID, int eMPLOYEE_ID, String fILEPATH, String fILENAME,
			String nAME, String iS_ACTIVE) {
		super();
		ATTACHID = aTTACHID;
		DAIRYID = dAIRYID;
		CASEID = cASEID;
		EMPLOYEE_ID = eMPLOYEE_ID;
		FILEPATH = fILEPATH;
		FILENAME = fILENAME;
		NAME = nAME;
		IS_ACTIVE = iS_ACTIVE;
	}

	public String getFILEPATH() {
		return FILEPATH;
	}
	public void setFILEPATH(String fILEPATH) {
		FILEPATH = fILEPATH;
	}
	public String getFILENAME() {
		return FILENAME;
	}
	public void setFILENAME(String fILENAME) {
		FILENAME = fILENAME;
	}
	public int getENTRY_EMPLOYEE_ID() {
		return ENTRY_EMPLOYEE_ID;
	}
	public void setENTRY_EMPLOYEE_ID(int eNTRY_EMPLOYEE_ID) {
		ENTRY_EMPLOYEE_ID = eNTRY_EMPLOYEE_ID;
	}
	public String getNAME1() {
		return NAME1;
	}
	public void setNAME1(String nAME1) {
		NAME1 = nAME1;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getHIRECODE() {
		return HIRECODE;
	}
	public void setHIRECODE(String hIRECODE) {
		HIRECODE = hIRECODE;
	}
	public int getDAIRYID() {
		return DAIRYID;
	}
	public void setDAIRYID(int dAIRYID) {
		DAIRYID = dAIRYID;
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
	public String getDAIRY_DATE() {
		return DAIRY_DATE;
	}
	public void setDAIRY_DATE(String dAIRY_DATE) {
		DAIRY_DATE = dAIRY_DATE;
	}
	public String getDAIRY_DETAILS() {
		return DAIRY_DETAILS;
	}
	public void setDAIRY_DETAILS(String dAIRY_DETAILS) {
		DAIRY_DETAILS = dAIRY_DETAILS;
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
	public int getATTACHID() {
		return ATTACHID;
	}
	public void setATTACHID(int aTTACHID) {
		ATTACHID = aTTACHID;
	}
	public String getFileNameXtn() {
		return fileNameXtn;
	}
	public void setFileNameXtn(String fileNameXtn) {
		this.fileNameXtn = fileNameXtn;
	}
	public int getFileLength() {
		return fileLength;
	}
	public void setFileLength(int fileLength) {
		this.fileLength = fileLength;
	}

	@Override
	public String toString() {
		return "DtDailyDairy [ATTACHID=" + ATTACHID + ", DAIRYID=" + DAIRYID + ", GRVDETID=" + GRVDETID + ", CASEID="
				+ CASEID + ", EMPLOYEE_ID=" + EMPLOYEE_ID + ", ENTRY_EMPLOYEE_ID=" + ENTRY_EMPLOYEE_ID + ", FILEPATH="
				+ FILEPATH + ", FILENAME=" + FILENAME + ", NAME=" + NAME + ", NAME1=" + NAME1 + ", HIRECODE=" + HIRECODE
				+ ", DAIRY_DATE=" + DAIRY_DATE + ", DAIRY_DETAILS=" + DAIRY_DETAILS + ", IS_ACTIVE=" + IS_ACTIVE
				+ ", DATE_CREATED=" + DATE_CREATED + ", DATE_UPDATED=" + DATE_UPDATED + ", DATE_DELETED=" + DATE_DELETED
				+ ", CREATEDBY=" + CREATEDBY + ", UPDATEDBY=" + UPDATEDBY + ", DELETEDBY=" + DELETEDBY
				+ ", fileNameXtn=" + fileNameXtn + ", fileLength=" + fileLength + "]";
	}

	
}
