package com.gms.model.masters;

import java.sql.Timestamp;

public class MainCategoryModel {
	String MAIN_CATEGORY_CODE;
	String MAIN_CATEGORY_NAME;
	String IS_ACTIVE;
	String DATE_CREATED;
	Timestamp DATE_UPDATED;
	Timestamp DATE_DELETED;
	int CREATEDBY;	
	int UPDATEDBY;	
	int DELETEDBY;	
	public MainCategoryModel(){
		
	}
	public MainCategoryModel(String mAIN_CATEGORY_CODE, String mAIN_CATEGORY_NAME, String iS_ACTIVE,
			String dATE_CREATED) {
		super();
		MAIN_CATEGORY_CODE = mAIN_CATEGORY_CODE;
		MAIN_CATEGORY_NAME = mAIN_CATEGORY_NAME;
		IS_ACTIVE = iS_ACTIVE;
		DATE_CREATED = dATE_CREATED;
	}
	public String getMAIN_CATEGORY_CODE() {
		return MAIN_CATEGORY_CODE;
	}
	public void setMAIN_CATEGORY_CODE(String mAIN_CATEGORY_CODE) {
		MAIN_CATEGORY_CODE = mAIN_CATEGORY_CODE;
	}
	public String getMAIN_CATEGORY_NAME() {
		return MAIN_CATEGORY_NAME;
	}
	public void setMAIN_CATEGORY_NAME(String mAIN_CATEGORY_NAME) {
		MAIN_CATEGORY_NAME = mAIN_CATEGORY_NAME;
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
