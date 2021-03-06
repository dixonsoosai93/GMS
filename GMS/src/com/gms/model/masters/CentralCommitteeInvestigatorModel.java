package com.gms.model.masters;

import java.sql.Timestamp;

public class CentralCommitteeInvestigatorModel {
	int CENTRALID;
	int INVESTIGATOR_EMPLOYEE_ID;
	String NAME;
    String DESIGNATION;
    String DEPARTMENT;
	String IS_HR;
	String IS_ACTIVE;
	String DATE_CREATED;
	Timestamp DATE_UPDATED;
	Timestamp DATE_DELETED;
	int CREATEDBY;
	int UPDATEDBY;
	int DELETEDBY;
	
	public CentralCommitteeInvestigatorModel() {
		
	}
    public CentralCommitteeInvestigatorModel(int cENTRALID, int iNVESTIGATOR_EMPLOYEE_ID, String nAME,
			String dESIGNATION, String dEPARTMENT, String iS_HR, String iS_ACTIVE, String dATE_CREATED) {
		super();
		CENTRALID = cENTRALID;
		INVESTIGATOR_EMPLOYEE_ID = iNVESTIGATOR_EMPLOYEE_ID;
		NAME = nAME;
		DESIGNATION = dESIGNATION;
		DEPARTMENT = dEPARTMENT;
		IS_HR = iS_HR;
		IS_ACTIVE = iS_ACTIVE;
		DATE_CREATED = dATE_CREATED;
	}
    public CentralCommitteeInvestigatorModel(int cENTRALID, int iNVESTIGATOR_EMPLOYEE_ID, String nAME,
			String dESIGNATION, String dEPARTMENT, String iS_HR) {
		super();
		CENTRALID = cENTRALID;
		INVESTIGATOR_EMPLOYEE_ID = iNVESTIGATOR_EMPLOYEE_ID;
		NAME = nAME;
		DESIGNATION = dESIGNATION;
		DEPARTMENT = dEPARTMENT;
		IS_HR = iS_HR;
	}
    
	public CentralCommitteeInvestigatorModel(int cENTRALID, int iNVESTIGATOR_EMPLOYEE_ID, String nAME,
			String dESIGNATION, String dEPARTMENT, String iS_HR, String iS_ACTIVE, String dATE_CREATED,
			Timestamp dATE_UPDATED, Timestamp dATE_DELETED, int cREATEDBY, int uPDATEDBY, int dELETEDBY) {
		super();
		CENTRALID = cENTRALID;
		INVESTIGATOR_EMPLOYEE_ID = iNVESTIGATOR_EMPLOYEE_ID;
		NAME = nAME;
		DESIGNATION = dESIGNATION;
		DEPARTMENT = dEPARTMENT;
		IS_HR = iS_HR;
		IS_ACTIVE = iS_ACTIVE;
		DATE_CREATED = dATE_CREATED;
		DATE_UPDATED = dATE_UPDATED;
		DATE_DELETED = dATE_DELETED;
		CREATEDBY = cREATEDBY;
		UPDATEDBY = uPDATEDBY;
		DELETEDBY = dELETEDBY;
	}
	public int getCENTRALID() {
		return CENTRALID;
	}
	public void setCENTRALID(int cENTRALID) {
		CENTRALID = cENTRALID;
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


}
