package com.gms.model.masters;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.GsonBuilder;


public class GrievanceCategoryHierarchyModel {
	int FLOWID;
	String MAIN_CATEGORY_CODE;
	String MAIN_CATEGORY_NAME;
	String SUB_CATEGORY_CODE;
	String SUB_CATEGORY_NAME;
	int HIERID;
	String HIERCODE;
	String HIERNAME;
	int CATEGORY_ORDER;
	String IS_ACTIVE;
	String DATE_CREATED;
	Timestamp DATE_UPDATED;
	Timestamp DATE_DELETED;
	int CREATEDBY;
	int UPDATEDBY;
	int DELETEDBY;
	
	public GrievanceCategoryHierarchyModel(int FLOWID, String MAIN_CATEGORY_CODE, String MAIN_CATEGORY_NAME, String SUB_CATEGORY_CODE, String SUB_CATEGORY_NAME, int HIERID,
			String HIERCODE, int CATEGORY_ORDER, String IS_ACTIVE, String DATE_CREATED) {
		this.FLOWID=FLOWID;
		this.MAIN_CATEGORY_CODE=MAIN_CATEGORY_CODE;
		this.MAIN_CATEGORY_NAME=MAIN_CATEGORY_NAME;
		this.SUB_CATEGORY_CODE=SUB_CATEGORY_CODE;
		this.SUB_CATEGORY_NAME=SUB_CATEGORY_NAME;
		this.HIERID=HIERID;
		this.HIERCODE=HIERCODE;
		this.CATEGORY_ORDER=CATEGORY_ORDER;
		this.IS_ACTIVE=IS_ACTIVE;
		this.DATE_CREATED=DATE_CREATED;
	}
	public GrievanceCategoryHierarchyModel(int fLOWID, String mAIN_CATEGORY_CODE, String mAIN_CATEGORY_NAME,
			String sUB_CATEGORY_CODE, String sUB_CATEGORY_NAME, int hIERID, String hIERCODE, String hIERNAME,
			int cATEGORY_ORDER, String iS_ACTIVE, String dATE_CREATED) {
		super();
		FLOWID = fLOWID;
		MAIN_CATEGORY_CODE = mAIN_CATEGORY_CODE;
		MAIN_CATEGORY_NAME = mAIN_CATEGORY_NAME;
		SUB_CATEGORY_CODE = sUB_CATEGORY_CODE;
		SUB_CATEGORY_NAME = sUB_CATEGORY_NAME;
		HIERID = hIERID;
		HIERCODE = hIERCODE;
		HIERNAME = hIERNAME;
		CATEGORY_ORDER = cATEGORY_ORDER;
		IS_ACTIVE = iS_ACTIVE;
		DATE_CREATED = dATE_CREATED;
	}

	public GrievanceCategoryHierarchyModel(int fLOWID, String sUB_CATEGORY_CODE, String sUB_CATEGORY_NAME, int hIERID,
			String hIERCODE, String hIERNAME, int cATEGORY_ORDER, String iS_ACTIVE) {
		super();
		FLOWID = fLOWID;
		SUB_CATEGORY_CODE = sUB_CATEGORY_CODE;
		SUB_CATEGORY_NAME = sUB_CATEGORY_NAME;
		HIERID = hIERID;
		HIERCODE = hIERCODE;
		HIERNAME = hIERNAME;
		CATEGORY_ORDER = cATEGORY_ORDER;
		IS_ACTIVE = iS_ACTIVE;
	}
	public int getFLOWID() {
		return FLOWID;
	}
	public void setFLOWID(int fLOWID) {
		FLOWID = fLOWID;
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
	public String getSUB_CATEGORY_CODE() {
		return SUB_CATEGORY_CODE;
	}
	public void setSUB_CATEGORY_CODE(String sUB_CATEGORY_CODE) {
		SUB_CATEGORY_CODE = sUB_CATEGORY_CODE;
	}
	public String getSUB_CATEGORY_NAME() {
		return SUB_CATEGORY_NAME;
	}
	public void setSUB_CATEGORY_NAME(String sUB_CATEGORY_NAME) {
		SUB_CATEGORY_NAME = sUB_CATEGORY_NAME;
	}
	public int getHIERID() {
		return HIERID;
	}
	public void setHIERID(int hIERID) {
		HIERID = hIERID;
	}
	public String getHIERNAME() {
		return HIERNAME;
	}
	public void setHIERNAME(String hIERNAME) {
		HIERNAME = hIERNAME;
	}
	public String getHIERCODE() {
		return HIERCODE;
	}
	public void setHIERCODE(String hIERCODE) {
		HIERCODE = hIERCODE;
	}
	public int getCATEGORY_ORDER() {
		return CATEGORY_ORDER;
	}
	public void setCATEGORY_ORDER(int cATEGORY_ORDER) {
		CATEGORY_ORDER = cATEGORY_ORDER;
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

	public static GrievanceCategoryHierarchyModel socketObject(String user){
        if(user!=null){
            return new GsonBuilder().create().fromJson(user, GrievanceCategoryHierarchyModel.class);
        }
        return null;
    }

    public String socketString(){
        return new GsonBuilder().create().toJson(this, GrievanceCategoryHierarchyModel.class);
    }
	
    public static GrievanceCategorySubCatgeoryAddUpdateModel getAllArrayList(String data){
    	ArrayList<GrievanceCategoryHierarchyModel> add = new ArrayList<>();
    	ArrayList<GrievanceCategoryHierarchyModel> edit = new ArrayList<>();
    	GrievanceCategorySubCatgeoryAddUpdateModel returnClass = new GrievanceCategorySubCatgeoryAddUpdateModel();
    	
    	JSONArray newData = new JSONArray(data);
    	for(int i=0;i<newData.length();i++) {
    		JSONObject obj = newData.getJSONObject(i);
    		if(obj.length()!=0)
    		{
	    		GrievanceCategoryHierarchyModel a = GrievanceCategoryHierarchyModel.socketObject(obj.toString());
	    		if(a.getFLOWID()!=0){
	        		 edit.add(a);
	 	    		}
	    		else
	    		{
	    			add.add(a);
	    		}
    		}
    	}
    	returnClass.setAdd(add);
    	returnClass.setEdit(edit);
    	return returnClass;
    }
    
 }


