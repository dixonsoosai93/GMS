package com.gms.model.masters;

import java.sql.Timestamp;

public class RhrInvestigatorMasterModel {
	private int RHRID;
	private String REGION_CODE;
	private String REGION_ID;
	private String REGION_NAME;
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
	
	public RhrInvestigatorMasterModel() {
		
	}
	public RhrInvestigatorMasterModel(int rHRID, String rEGION_CODE,String rEGION_NAME, int iNVESTIGATOR_EMPLOYEE_ID, String nAME,
			String dESIGNATION, String dEPARTMENT, String iS_HR, String iS_ACTIVE, String dATE_CREATED) {
		super();
		RHRID = rHRID;
		REGION_CODE = rEGION_CODE;
		REGION_NAME=rEGION_NAME;
		INVESTIGATOR_EMPLOYEE_ID = iNVESTIGATOR_EMPLOYEE_ID;
		NAME = nAME;
		DESIGNATION = dESIGNATION;
		DEPARTMENT = dEPARTMENT;
		IS_HR = iS_HR;
		IS_ACTIVE = iS_ACTIVE;
		DATE_CREATED = dATE_CREATED;
	}
	
	
	public RhrInvestigatorMasterModel(int rHRID, String rEGION_CODE, String rEGION_ID, String rEGION_NAME,
			int iNVESTIGATOR_EMPLOYEE_ID, String nAME, String dESIGNATION, String dEPARTMENT, String iS_HR) {
		super();
		RHRID = rHRID;
		REGION_CODE = rEGION_CODE;
		REGION_ID = rEGION_ID;
		REGION_NAME = rEGION_NAME;
		INVESTIGATOR_EMPLOYEE_ID = iNVESTIGATOR_EMPLOYEE_ID;
		NAME = nAME;
		DESIGNATION = dESIGNATION;
		DEPARTMENT = dEPARTMENT;
		IS_HR = iS_HR;
	}
	public String getREGION_ID() {
		return REGION_ID;
	}
	public void setREGION_ID(String rEGION_ID) {
		REGION_ID = rEGION_ID;
	}
	public int getRHRID() {
		return RHRID;
	}
	public void setRHRID(int rHRID) {
		RHRID = rHRID;
	}
	public String getREGION_CODE() {
		return REGION_CODE;
	}
	public void setREGION_CODE(String rEGION_CODE) {
		REGION_CODE = rEGION_CODE;
	}
	public String getREGION_NAME() {
		return REGION_NAME;
	}
	public void setREGION_NAME(String rEGION_NAME) {
		REGION_NAME = rEGION_NAME;
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
	public String getDEPARTMENT() {
		return DEPARTMENT;
	}
	public void setDEPARTMENT(String dEPARTMENT) {
		DEPARTMENT = dEPARTMENT;
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

	@Override
	public String toString() {
		return "RhrInvestigatorMasterModel [RHRID=" + RHRID + ", REGION_CODE=" + REGION_CODE + ", REGION_NAME="
				+ REGION_NAME + ", INVESTIGATOR_EMPLOYEE_ID=" + INVESTIGATOR_EMPLOYEE_ID + ", NAME=" + NAME
				+ ", DESIGNATION=" + DESIGNATION + ", DEPARTMENT=" + DEPARTMENT + ", IS_HR=" + IS_HR + ", IS_ACTIVE="
				+ IS_ACTIVE + ", DATE_CREATED=" + DATE_CREATED + ", DATE_UPDATED=" + DATE_UPDATED + ", DATE_DELETED="
				+ DATE_DELETED + ", CREATEDBY=" + CREATEDBY + ", UPDATEDBY=" + UPDATEDBY + ", DELETEDBY=" + DELETEDBY
				+ "]";
	}

}
