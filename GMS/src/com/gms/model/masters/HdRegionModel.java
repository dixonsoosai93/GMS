package com.gms.model.masters;

import java.sql.Timestamp;

public class HdRegionModel {
	int REGION_ID;
	String REGION_CODE;
	String REGION_NAME;
	String REGION_DESC;
	String EMPLOYEE_ID;
	String NAME;
	String IS_ACTIVE;
	String DATE_CREATED;
	Timestamp DATE_UPDATED;
	Timestamp DATE_DELETED;
	int CREATEDBY;
	int UPDATEDBY;
	int DELETEDBY;
	
	public int getREGION_ID() {
		return REGION_ID;
	}
	public void setREGION_ID(int rEGION_ID) {
		REGION_ID = rEGION_ID;
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
	public String getREGION_DESC() {
		return REGION_DESC;
	}
	public void setREGION_DESC(String rEGION_DESC) {
		REGION_DESC = rEGION_DESC;
	}
	public String getEMPLOYEE_ID() {
		return EMPLOYEE_ID;
	}
	public void setEMPLOYEE_ID(String eMPLOYEE_ID) {
		EMPLOYEE_ID = eMPLOYEE_ID;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
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
