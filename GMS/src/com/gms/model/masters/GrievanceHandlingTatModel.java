package com.gms.model.masters;

import java.sql.Timestamp;
public class GrievanceHandlingTatModel {
	int TATID;
	int HIERID;
	String HIERCODE;
	String HIERNAME;
	int TATDAYS;
	int BUFFERDAYS;
	String IS_ACTIVE;
	String DATE_CREATED;
	Timestamp DATE_UPDATED;
	Timestamp DATE_DELETED;
	int CREATEDBY;
	int UPDATEDBY;
	int DELETEDBY;
	
	public GrievanceHandlingTatModel()
	{
		super();
	}
	public GrievanceHandlingTatModel(int TATID,int HIERID,String HIERCODE,String HIERNAME, int TATDAYS, int BUFFERDAYS, String IS_ACTIVE, String DATE_CREATED) {
		super();
		this.TATID=TATID;
		this.HIERID=HIERID;
		this.HIERCODE=HIERCODE;
		this.HIERNAME=HIERNAME;
		this.TATDAYS=TATDAYS;
		this.BUFFERDAYS=BUFFERDAYS;
		this.IS_ACTIVE=IS_ACTIVE;
		this.DATE_CREATED=DATE_CREATED;
		
	}
	public int getTATID() {
		return TATID;
	}
	public void setTATID(int tATID) {
		TATID = tATID;
	}
	public int getHIERID() {
		return HIERID;
	}
	public void setHIERID(int hIERID) {
		HIERID = hIERID;
	}
	public int getTATDAYS() {
		return TATDAYS;
	}
	public void setTATDAYS(int tATDAYS) {
		TATDAYS = tATDAYS;
	}
	public int getBUFFERDAYS() {
		return BUFFERDAYS;
	}
	public void setBUFFERDAYS(int bUFFERDAYS) {
		BUFFERDAYS = bUFFERDAYS;
	}
	public String getIS_ACTIVE() {
		return IS_ACTIVE;
	}
	public void setIS_ACTIVE(String iS_ACTIVE) {
		IS_ACTIVE = iS_ACTIVE;
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
	public String getHIERCODE() {
		return HIERCODE;
	}
	public void setHIERCODE(String hIERCODE) {
		HIERCODE = hIERCODE;
	}
	public String getDATE_CREATED() {
		return DATE_CREATED;
	}
	public void setDATE_CREATED(String dATE_CREATED) {
		DATE_CREATED = dATE_CREATED;
	}
	public String getHIERNAME() {
		return HIERNAME;
	}
	public void setHIERNAME(String hIERNAME) {
		HIERNAME = hIERNAME;
	}
	

}
