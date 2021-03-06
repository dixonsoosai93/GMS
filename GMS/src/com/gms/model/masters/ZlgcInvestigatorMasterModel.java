package com.gms.model.masters;

import java.sql.Timestamp;

public class ZlgcInvestigatorMasterModel {
	private int ZLGCID;
	private String ZONE_CODE;
	private String ZONE_NAME;
	private int INVESTIGATOR_EMPLOYEE_ID;
	private String NAME;
	private String DESIGNATION;
	private String DEPARTMENT;
	private String IS_HR;
	private String IS_ACTIVE;
	private String DATE_CREATED;
	private Timestamp DATE_UPDATED;
	private Timestamp DATE_DELETED;
	private int CREATEDBY;
	private int UPDATEDBY;
	private int DELETEDBY;
	
	
	public ZlgcInvestigatorMasterModel() {
		
	}
	public ZlgcInvestigatorMasterModel(int ZLGCID, String ZONE_CODE, String ZONE_NAME, int INVESTIGATOR_EMPLOYEE_ID, String NAME,
			String DESIGNATION, String DEPARTMENT, String IS_HR, String IS_ACTIVE, String DATE_CREATED) {
		this.ZLGCID=ZLGCID;
		this.ZONE_CODE=ZONE_CODE;
		this.ZONE_NAME=ZONE_NAME;
		this.INVESTIGATOR_EMPLOYEE_ID=INVESTIGATOR_EMPLOYEE_ID;
		this.NAME=NAME;
		this.DESIGNATION=DESIGNATION;
		this.DEPARTMENT=DEPARTMENT;
		this.DATE_CREATED=DATE_CREATED;
		this.IS_HR=IS_HR;
		this.IS_ACTIVE=IS_ACTIVE;
	} 
	public ZlgcInvestigatorMasterModel(int ZLGCID, String ZONE_CODE, String ZONE_NAME, int INVESTIGATOR_EMPLOYEE_ID, String NAME,
			String DESIGNATION, String DEPARTMENT, String IS_HR) {
		this.ZLGCID=ZLGCID;
		this.ZONE_CODE=ZONE_CODE;
		this.ZONE_NAME=ZONE_NAME;
		this.INVESTIGATOR_EMPLOYEE_ID=INVESTIGATOR_EMPLOYEE_ID;
		this.NAME=NAME;
		this.DESIGNATION=DESIGNATION;
		this.DEPARTMENT=DEPARTMENT;
		this.IS_HR=IS_HR;
	}
	
	public ZlgcInvestigatorMasterModel(int ZLGCID, String ZONE_CODE, String ZONE_NAME, int INVESTIGATOR_EMPLOYEE_ID, String NAME,
			String DESIGNATION, String DEPARTMENT, String IS_HR, String IS_ACTIVE, String DATE_CREATED,
			Timestamp DATE_UPDATED,Timestamp DATE_DELETED,int CREATEDBY,int UPDATEDBY,int DELETEDBY) 
	   {    
		this.ZLGCID=ZLGCID;
		this.ZONE_CODE=ZONE_CODE;
		this.ZONE_NAME=ZONE_NAME;
		this.INVESTIGATOR_EMPLOYEE_ID=INVESTIGATOR_EMPLOYEE_ID;
		this.NAME=NAME;
		this.DESIGNATION=DESIGNATION;
		this.DEPARTMENT=DEPARTMENT;
		this.IS_HR=IS_HR;
		this.IS_ACTIVE=IS_ACTIVE;
		this.DATE_CREATED=DATE_CREATED;
		this.DATE_UPDATED=DATE_UPDATED;
		this.DATE_DELETED=DATE_DELETED;
		this.CREATEDBY=CREATEDBY;
		this.UPDATEDBY=UPDATEDBY;
		this.DELETEDBY=DELETEDBY;
	}
	public int getZLGCID() {
		return ZLGCID;
	}
	public void setZLGCID(int zLGCID) {
		ZLGCID = zLGCID;
	}
	public String getZONE_CODE() {
		return ZONE_CODE;
	}
	public void setZONE_CODE(String zONE_CODE) {
		ZONE_CODE = zONE_CODE;
	}
	public int getINVESTIGATOR_EMPLOYEE_ID() {
		return INVESTIGATOR_EMPLOYEE_ID;
	}
	public void setINVESTIGATOR_EMPLOYEE_ID(int iNVESTIGATOR_EMPLOYEE_ID) {
		INVESTIGATOR_EMPLOYEE_ID = iNVESTIGATOR_EMPLOYEE_ID;
	}
	public String getIS_HR() {
		return IS_HR;
	}
	public void setIS_HR(String iS_HR) {
		IS_HR = iS_HR;
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
	public String getZONE_NAME() {
		return ZONE_NAME;
	}
	public void setZONE_NAME(String zONE_NAME) {
		ZONE_NAME = zONE_NAME;
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
	public String getDEPARTMENT() {
		return DEPARTMENT;
	}
	public void setDEPARTMENT(String dEPARTMENT) {
		DEPARTMENT = dEPARTMENT;
	}

}
