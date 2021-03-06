package com.gms.model.grievance;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.GsonBuilder;

public class DtGrievanceModel {
	
	int GRVDETID;
	int GRVID;
	int RESPONDENT_EMPLOYEE_ID;
	String RESPONDENT_EMPLOYEE_NAME;
	String CASENUMBER;
	String MAIN_CATEGORY_CODE;
	String SUB_CATEGORY_CODE;
	String COMPLAINT_DESC;
	String DEFAULT_HIERCODE;
	String START_HIERCODE;
	String STATUSID;
	String STATUSNAME;
	String EMPLOYEETYPE;
	String IS_ACTIVE;
	String DATE_CREATED;
	Timestamp DATE_UPDATED;
	Timestamp DATE_DELETED;
	int CREATEDBY;
	int UPDATEDBY;
	int DELETEDBY;
	String REOPEN_FLAG;
	String mainCategoryName;
	String subCategoryName;
	
	public DtGrievanceModel() {
		
	}
	
	public DtGrievanceModel(int gRVID, int gRVDETID, String mAIN_CATEGORY_CODE, String sUB_CATEGORY_CODE,
			String eMPLOYEETYPE, int rESPONDENT_EMPLOYEE_ID, String rESPONDENT_EMPLOYEE_NAME, String cOMPLAINT_DESC,
			String cASENUMBER,String dEFAULT_HIERCODE, String sTART_HIERCODE, String sTATUSID, String rEOPEN_FLAG, 
			String MainCategoryName, String SubCategoryName) {
		super();
		GRVDETID = gRVDETID;
		GRVID = gRVID;
		RESPONDENT_EMPLOYEE_ID = rESPONDENT_EMPLOYEE_ID;
		RESPONDENT_EMPLOYEE_NAME = rESPONDENT_EMPLOYEE_NAME;
		CASENUMBER = cASENUMBER;
		MAIN_CATEGORY_CODE = mAIN_CATEGORY_CODE;
		SUB_CATEGORY_CODE = sUB_CATEGORY_CODE;
		COMPLAINT_DESC = cOMPLAINT_DESC;
		DEFAULT_HIERCODE = dEFAULT_HIERCODE;
		START_HIERCODE = sTART_HIERCODE;
		STATUSID = sTATUSID;
		EMPLOYEETYPE = eMPLOYEETYPE;
		REOPEN_FLAG = rEOPEN_FLAG;
		mainCategoryName = MainCategoryName;
		subCategoryName = SubCategoryName;
	}
	
	public String getSTATUSNAME() {
		return STATUSNAME;
	}
	public void setSTATUSNAME(String sTATUSNAME) {
		STATUSNAME = sTATUSNAME;
	}
	public int getGRVDETID() {
		return GRVDETID;
	}
	public void setGRVDETID(int gRVDETID) {
		GRVDETID = gRVDETID;
	}
	public int getGRVID() {
		return GRVID;
	}
	public void setGRVID(int gRVID) {
		GRVID = gRVID;
	}
	public int getRESPONDENT_EMPLOYEE_ID() {
		return RESPONDENT_EMPLOYEE_ID;
	}
	public void setRESPONDENT_EMPLOYEE_ID(int rESPONDENT_EMPLOYEE_ID) {
		RESPONDENT_EMPLOYEE_ID = rESPONDENT_EMPLOYEE_ID;
	}
	public String getRESPONDENT_EMPLOYEE_NAME() {
		return RESPONDENT_EMPLOYEE_NAME;
	}
	public void setRESPONDENT_EMPLOYEE_NAME(String rESPONDENT_EMPLOYEE_NAME) {
		RESPONDENT_EMPLOYEE_NAME = rESPONDENT_EMPLOYEE_NAME;
	}
	public String getCASENUMBER() {
		return CASENUMBER;
	}
	public void setCASENUMBER(String cASENUMBER) {
		CASENUMBER = cASENUMBER;
	}
	public String getMAIN_CATEGORY_CODE() {
		return MAIN_CATEGORY_CODE;
	}
	public void setMAIN_CATEGORY_CODE(String mAIN_CATEGORY_CODE) {
		MAIN_CATEGORY_CODE = mAIN_CATEGORY_CODE;
	}
	public String getSUB_CATEGORY_CODE() {
		return SUB_CATEGORY_CODE;
	}
	public void setSUB_CATEGORY_CODE(String sUB_CATEGORY_CODE) {
		SUB_CATEGORY_CODE = sUB_CATEGORY_CODE;
	}
	public String getCOMPLAINT_DESC() {
		return COMPLAINT_DESC;
	}
	public void setCOMPLAINT_DESC(String cOMPLAINT_DESC) {
		COMPLAINT_DESC = cOMPLAINT_DESC;
	}
	public String getDEFAULT_HIERCODE() {
		return DEFAULT_HIERCODE;
	}
	public void setDEFAULT_HIERCODE(String dEFAULT_HIERCODE) {
		DEFAULT_HIERCODE = dEFAULT_HIERCODE;
	}
	public String getSTART_HIERCODE() {
		return START_HIERCODE;
	}
	public void setSTART_HIERCODE(String sTART_HIERCODE) {
		START_HIERCODE = sTART_HIERCODE;
	}
	public String getSTATUSID() {
		return STATUSID;
	}
	public void setSTATUSID(String sTATUSID) {
		STATUSID = sTATUSID;
	}
	public String getEMPLOYEETYPE() {
		return EMPLOYEETYPE;
	}
	public void setEMPLOYEETYPE(String eMPLOYEETYPE) {
		EMPLOYEETYPE = eMPLOYEETYPE;
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
	public String getREOPEN_FLAG() {
		return REOPEN_FLAG;
	}
	public void setREOPEN_FLAG(String rEOPEN_FLAG) {
		REOPEN_FLAG = rEOPEN_FLAG;
	}
	public String getMainCategoryName() {
		return mainCategoryName;
	}
	public void setMainCategoryName(String mainCategoryName) {
		this.mainCategoryName = mainCategoryName;
	}
	public String getSubCategoryName() {
		return subCategoryName;
	}
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	public static DtGrievanceModel socketObject(String user){
        //if(user!=null){
            return new GsonBuilder().create().fromJson(user, DtGrievanceModel.class);
        //}
       // return null;
    }

    public String socketString(){
        return new GsonBuilder().create().toJson(this, DtGrievanceModel.class);
    }
	
    public static ArrayList<DtGrievanceModel> getAllArrayList(String data){
    	ArrayList<DtGrievanceModel> DtGrievance = new ArrayList<>();
    	JSONArray newData = new JSONArray(data);
    	for(int i=0;i<newData.length();i++) {
    		JSONObject obj = newData.getJSONObject(i);
    		if(obj.length()!=0)
    		{
    			DtGrievanceModel a = DtGrievanceModel.socketObject(obj.toString());
    			DtGrievance.add(a);
                
    		}    		
    	}
    	return DtGrievance;
    }
	@Override
	public String toString() {
		return "DtGrievanceModel [GRVDETID=" + GRVDETID + ", GRVID=" + GRVID + ", RESPONDENT_EMPLOYEE_ID="
				+ RESPONDENT_EMPLOYEE_ID + ", RESPONDENT_EMPLOYEE_NAME=" + RESPONDENT_EMPLOYEE_NAME + ", CASENUMBER="
				+ CASENUMBER + ", MAIN_CATEGORY_CODE=" + MAIN_CATEGORY_CODE + ", SUB_CATEGORY_CODE=" + SUB_CATEGORY_CODE
				+ ", COMPLAINT_DESC=" + COMPLAINT_DESC + ", DEFAULT_HIERCODE=" + DEFAULT_HIERCODE + ", START_HIERCODE="
				+ START_HIERCODE + ", STATUSID=" + STATUSID + ", STATUSNAME=" + STATUSNAME + ", EMPLOYEETYPE="
				+ EMPLOYEETYPE + ", IS_ACTIVE=" + IS_ACTIVE + ", DATE_CREATED=" + DATE_CREATED + ", DATE_UPDATED="
				+ DATE_UPDATED + ", DATE_DELETED=" + DATE_DELETED + ", CREATEDBY=" + CREATEDBY + ", UPDATEDBY="
				+ UPDATEDBY + ", DELETEDBY=" + DELETEDBY + ", REOPEN_FLAG=" + REOPEN_FLAG + "]";
	}
	
}
