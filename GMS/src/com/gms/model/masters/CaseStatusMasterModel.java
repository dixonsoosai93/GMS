package com.gms.model.masters;

import java.sql.Timestamp;

public class CaseStatusMasterModel {

	String STATUSID;
	String STATUSNAME;
	String IS_ACTIVE;
	String DATE_CREATED;
	Timestamp DATE_UPDATED;
	Timestamp DATE_DELETED;
	int CREATEDBY;
	int UPDATEDBY;
	int DELETEDBY;
	
	public CaseStatusMasterModel() {
		super();
	}

	public CaseStatusMasterModel(String sTATUSID, String sTATUSNAME, String iS_ACTIVE, String dATE_CREATED,
			Timestamp dATE_UPDATED, Timestamp dATE_DELETED, int cREATEDBY, int uPDATEDBY, int dELETEDBY) {
		super();
		STATUSID = sTATUSID;
		STATUSNAME = sTATUSNAME;
		IS_ACTIVE = iS_ACTIVE;
		DATE_CREATED = dATE_CREATED;
		DATE_UPDATED = dATE_UPDATED;
		DATE_DELETED = dATE_DELETED;
		CREATEDBY = cREATEDBY;
		UPDATEDBY = uPDATEDBY;
		DELETEDBY = dELETEDBY;
	}
	//GridList Constructor
	public CaseStatusMasterModel(String sTATUSID, String sTATUSNAME, String iS_ACTIVE, String dATE_CREATED) {
		super();
		STATUSID = sTATUSID;
		STATUSNAME = sTATUSNAME;
		IS_ACTIVE = iS_ACTIVE;
		DATE_CREATED = dATE_CREATED;
	}
	
	public CaseStatusMasterModel(String sTATUSID, String sTATUSNAME) {
		STATUSID = sTATUSID;
		STATUSNAME = sTATUSNAME;
	}

	public String getSTATUSID() {
		return STATUSID;
	}
	public void setSTATUSID(String sTATUSID) {
		STATUSID = sTATUSID;
	}
	public String getSTATUSNAME() {
		return STATUSNAME;
	}
	public void setSTATUSNAME(String sTATUSNAME) {
		STATUSNAME = sTATUSNAME;
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
		return "CaseStatusMasterModel [STATUSID=" + STATUSID + ", STATUSNAME=" + STATUSNAME + ", IS_ACTIVE=" + IS_ACTIVE
				+ ", DATE_CREATED=" + DATE_CREATED + ", DATE_UPDATED=" + DATE_UPDATED + ", DATE_DELETED=" + DATE_DELETED
				+ ", CREATEDBY=" + CREATEDBY + ", UPDATEDBY=" + UPDATEDBY + ", DELETEDBY=" + DELETEDBY + "]";
	}
	
}
