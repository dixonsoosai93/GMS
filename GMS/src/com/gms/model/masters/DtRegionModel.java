package com.gms.model.masters;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.GsonBuilder;

public class DtRegionModel {
	int REGION_DET_ID;
	int REGION_ID;
	String CITY_CODE;
	String CITY_NAME;
	String BRANCH_CODE;
	String BRANCH_NAME;
	String STATE_NAME;
	String ZONE_NAME;
	String IS_ACTIVE;
	String DATE_CREATED;
	Timestamp DATE_UPDATED;
	Timestamp DATE_DELETED;
	int CREATEDBY;
	int UPDATEDBY;
	int DELETEDBY;
	
	
	public String getCITY_NAME() {
		return CITY_NAME;
	}
	public void setCITY_NAME(String cITY_NAME) {
		CITY_NAME = cITY_NAME;
	}
	public String getBRANCH_NAME() {
		return BRANCH_NAME;
	}
	public void setBRANCH_NAME(String bRANCH_NAME) {
		BRANCH_NAME = bRANCH_NAME;
	}
	public String getSTATE_NAME() {
		return STATE_NAME;
	}
	public void setSTATE_NAME(String sTATE_NAME) {
		STATE_NAME = sTATE_NAME;
	}
	public String getZONE_NAME() {
		return ZONE_NAME;
	}
	public void setZONE_NAME(String zONE_NAME) {
		ZONE_NAME = zONE_NAME;
	}
	public int getREGION_DET_ID() {
		return REGION_DET_ID;
	}
	public void setREGION_DET_ID(int rEGION_DET_ID) {
		REGION_DET_ID = rEGION_DET_ID;
	}
	public int getREGION_ID() {
		return REGION_ID;
	}
	public void setREGION_ID(int rEGION_ID) {
		REGION_ID = rEGION_ID;
	}
	public String getCITY_CODE() {
		return CITY_CODE;
	}
	public void setCITY_CODE(String cITY_CODE) {
		CITY_CODE = cITY_CODE;
	}
	public String getBRANCH_CODE() {
		return BRANCH_CODE;
	}
	public void setBRANCH_CODE(String bRANCH_CODE) {
		BRANCH_CODE = bRANCH_CODE;
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
	
	public static DtRegionModel socketObject(String user){
        if(user!=null){
            return new GsonBuilder().create().fromJson(user, DtRegionModel.class);
        }
        return null;
    }

    public String socketString(){
        return new GsonBuilder().create().toJson(this, DtRegionModel.class);
    }
	
    public static ArrayList<DtRegionModel> getAllArrayList(String data){
    	ArrayList<DtRegionModel> DtGrievance = new ArrayList<>();
    	JSONArray newData = new JSONArray(data);
    	for(int i=0;i<newData.length();i++) {
    		JSONObject obj = newData.getJSONObject(i);
    		if(obj.length()!=0)
    		{
    			DtRegionModel a = DtRegionModel.socketObject(obj.toString());
    			DtGrievance.add(a);
                
    		}    		
    	}
    	return DtGrievance;
    }
	@Override
	public String toString() {
		return "DtRegionModel [REGION_DET_ID=" + REGION_DET_ID + ", REGION_ID=" + REGION_ID + ", CITY_CODE=" + CITY_CODE
				+ ", CITY_NAME=" + CITY_NAME + ", BRANCH_CODE=" + BRANCH_CODE + ", BRANCH_NAME=" + BRANCH_NAME
				+ ", STATE_NAME=" + STATE_NAME + ", ZONE_NAME=" + ZONE_NAME + ", IS_ACTIVE=" + IS_ACTIVE
				+ ", DATE_CREATED=" + DATE_CREATED + ", DATE_UPDATED=" + DATE_UPDATED + ", DATE_DELETED=" + DATE_DELETED
				+ ", CREATEDBY=" + CREATEDBY + ", UPDATEDBY=" + UPDATEDBY + ", DELETEDBY=" + DELETEDBY + "]";
	}
	

}
