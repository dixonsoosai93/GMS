package com.gms.model.grievance;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.GsonBuilder;

public class DtCaseEmpModel {
	int CASEEMPID;
	int GRVID;
	int EMPLOYEE_ID;
	String IS_LEAD;
	String IS_ACTIVE;
	String DATE_CREATED;
	Timestamp DATE_UPDATED;
	Timestamp DATE_DELETED;
	int CREATEDBY;
	int UPDATEDBY;
	int DELETEDBY;
	
	public int getCASEEMPID() {
		return CASEEMPID;
	}
	public void setCASEEMPID(int cASEEMPID) {
		CASEEMPID = cASEEMPID;
	}
	public int getGRVID() {
		return GRVID;
	}
	public void setGRVID(int gRVID) {
		GRVID = gRVID;
	}
	public int getEMPLOYEE_ID() {
		return EMPLOYEE_ID;
	}
	public void setEMPLOYEE_ID(int eMPLOYEE_ID) {
		EMPLOYEE_ID = eMPLOYEE_ID;
	}
	public String getIS_LEAD() {
		return IS_LEAD;
	}
	public void setIS_LEAD(String iS_LEAD) {
		IS_LEAD = iS_LEAD;
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
	public static DtCaseEmpModel socketObject(String user){
        if(user!=null){
            return new GsonBuilder().create().fromJson(user, DtCaseEmpModel.class);
        }
        return null;
    }

    public String socketString(){
        return new GsonBuilder().create().toJson(this, DtGrievanceModel.class);
    }
	
    public static ArrayList<DtCaseEmpModel> getAllArrayList(String data){
    	ArrayList<DtCaseEmpModel> DtCaseEmp = new ArrayList<>();
    	JSONArray newData = new JSONArray(data);
    	for(int i=0;i<newData.length();i++) {
    		JSONObject obj = newData.getJSONObject(i);
    		if(obj.length()!=0)
    		{
    			DtCaseEmpModel a = DtCaseEmpModel.socketObject(obj.toString());
    			DtCaseEmp.add(a);
                
    		}    		
    	}
    	return DtCaseEmp;
    }
	@Override
	public String toString() {
		return "DtCaseEmpModel [CASEEMPID=" + CASEEMPID + ", GRVID=" + GRVID + ", EMPLOYEE_ID=" + EMPLOYEE_ID
				+ ", IS_LEAD=" + IS_LEAD + ", IS_ACTIVE=" + IS_ACTIVE + ", DATE_CREATED=" + DATE_CREATED
				+ ", DATE_UPDATED=" + DATE_UPDATED + ", DATE_DELETED=" + DATE_DELETED + ", CREATEDBY=" + CREATEDBY
				+ ", UPDATEDBY=" + UPDATEDBY + ", DELETEDBY=" + DELETEDBY + "]";
	}


}
