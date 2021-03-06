package com.gms.model.masters;

import com.google.gson.GsonBuilder;

public class ManpowerModel {
	private String EMPLOYEE_ID;
	private String TITLE;
	private String NAME;
	private String DESIGNATION;
	private String DESIGNATION_CODE;
	private String BRANCH_CODE;
	private String BRANCH_NAME;
	private String STAFF_TYPE;
	private String DOJ;
	private String DOB;
	private String GENDER;
	private String ZONE_CODE;
	private String STATE_CODE;
	private String CITY_CODE;
	private String JOB_CODE;
	private String JOB_FUNCTION_CODE;
	private String JOB_FUNCTION;
	private String DEPARTMENT_CODE;
	private String COST_CENTER;
	private String DEPARTMENT;
	private String SUPERVISIOR_ID;
	private String IS_ACTIVE;       
	private String  DATE_CREATED;
	
	public ManpowerModel() {
		super();
	}
	public ManpowerModel(String eMPLOYEE_ID, String nAME, String dESIGNATION, String dEPARTMENT) {
		super();
		EMPLOYEE_ID = eMPLOYEE_ID;
		NAME = nAME;
		DESIGNATION = dESIGNATION;
		DEPARTMENT = dEPARTMENT;
	}
    public ManpowerModel(String eMPLOYEE_ID, String nAME, String dESIGNATION, String dEPARTMENT_CODE,
			String dEPARTMENT) {
		super();
		EMPLOYEE_ID = eMPLOYEE_ID;
		NAME = nAME;
		DESIGNATION = dESIGNATION;
		DEPARTMENT_CODE = dEPARTMENT_CODE;
		DEPARTMENT = dEPARTMENT;
	}
	public ManpowerModel(String EMPLOYEE_ID, String TITLE, String NAME, String DESIGNATION, String BRANCH_NAME, String STAFF_TYPE,
			String DOJ, String DOB, String GENDER, String ZONE_CODE, String STATE_CODE, String CITY_CODE,
			String JOB_CODE, String JOB_FUNCTION_CODE, String JOB_FUNCTION, String DEPARTMENT, String COST_CENTER, String SUPERVISIOR_ID,
			String IS_ACTIVE, String DATE_CREATED) {
    	this.EMPLOYEE_ID=EMPLOYEE_ID;
    	this.TITLE=TITLE;
    	this.NAME=NAME;
    	this.DESIGNATION=DESIGNATION;
    	this.BRANCH_NAME=BRANCH_NAME;
    	this.STAFF_TYPE=STAFF_TYPE;
    	this.DOJ=DOJ;
    	this.DOB=DOB;
    	this.GENDER=GENDER;
    	this.ZONE_CODE=ZONE_CODE;
    	this.STATE_CODE=STATE_CODE;
    	this.CITY_CODE=CITY_CODE;
    	this.JOB_CODE=JOB_CODE;
    	this.JOB_FUNCTION_CODE=JOB_FUNCTION_CODE;
    	this.JOB_FUNCTION=JOB_FUNCTION;
    	this.DEPARTMENT=DEPARTMENT;
    	this.COST_CENTER=COST_CENTER;
    	this.SUPERVISIOR_ID=SUPERVISIOR_ID;
    	this.IS_ACTIVE=IS_ACTIVE;
    	this.DATE_CREATED=DATE_CREATED;
	}
	public ManpowerModel(String eMPLOYEE_ID, String nAME) {
		super();
		EMPLOYEE_ID = eMPLOYEE_ID;
		NAME = nAME;
	}
	public String getDEPARTMENT() {
		return DEPARTMENT;
	}
	public void setDEPARTMENT(String dEPARTMENT) {
		DEPARTMENT = dEPARTMENT;
	}
	public String getEMPLOYEE_ID() {
		return EMPLOYEE_ID;
	}
	public void setEMPLOYEE_ID(String eMPLOYEE_ID) {
		EMPLOYEE_ID = eMPLOYEE_ID;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
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
	
	public String getDESIGNATION_CODE() {
		return DESIGNATION_CODE;
	}
	public void setDESIGNATION_CODE(String dESIGNATION_CODE) {
		DESIGNATION_CODE = dESIGNATION_CODE;
	}
	public String getBRANCH_CODE() {
		return BRANCH_CODE;
	}
	public void setBRANCH_CODE(String bRANCH_CODE) {
		BRANCH_CODE = bRANCH_CODE;
	}
	public String getSTAFF_TYPE() {
		return STAFF_TYPE;
	}
	public void setSTAFF_TYPE(String sTAFF_TYPE) {
		STAFF_TYPE = sTAFF_TYPE;
	}
	public String getDOJ() {
		return DOJ;
	}
	public void setDOJ(String dOJ) {
		DOJ = dOJ;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getGENDER() {
		return GENDER;
	}
	public void setGENDER(String gENDER) {
		GENDER = gENDER;
	}
	public String getZONE_CODE() {
		return ZONE_CODE;
	}
	public void setZONE_CODE(String zONE_CODE) {
		ZONE_CODE = zONE_CODE;
	}
	public String getSTATE_CODE() {
		return STATE_CODE;
	}
	public void setSTATE_CODE(String sTATE_CODE) {
		STATE_CODE = sTATE_CODE;
	}
	public String getCITY_CODE() {
		return CITY_CODE;
	}
	public void setCITY_CODE(String cITY_CODE) {
		CITY_CODE = cITY_CODE;
	}
	public String getJOB_CODE() {
		return JOB_CODE;
	}
	public void setJOB_CODE(String jOB_CODE) {
		JOB_CODE = jOB_CODE;
	}
	public String getJOB_FUNCTION_CODE() {
		return JOB_FUNCTION_CODE;
	}
	public void setJOB_FUNCTION_CODE(String jOB_FUNCTION_CODE) {
		JOB_FUNCTION_CODE = jOB_FUNCTION_CODE;
	}
	public String getJOB_FUNCTION() {
		return JOB_FUNCTION;
	}
	public void setJOB_FUNCTION(String jOB_FUNCTION) {
		JOB_FUNCTION = jOB_FUNCTION;
	}
	public String getDEPARTMENT_CODE() {
		return DEPARTMENT_CODE;
	}
	public void setDEPARTMENT_CODE(String dEPARTMENT_CODE) {
		DEPARTMENT_CODE = dEPARTMENT_CODE;
	}
	public String getCOST_CENTER() {
		return COST_CENTER;
	}
	public void setCOST_CENTER(String cOST_CENTER) {
		COST_CENTER = cOST_CENTER;
	}
	public String getSUPERVISIOR_ID() {
		return SUPERVISIOR_ID;
	}
	public void setSUPERVISIOR_ID(String sUPERVISIOR_ID) {
		SUPERVISIOR_ID = sUPERVISIOR_ID;
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
	public String getBRANCH_NAME() {
		return BRANCH_NAME;
	}
	public void setBRANCH_NAME(String bRANCH_NAME) {
		BRANCH_NAME = bRANCH_NAME;
	}
	public static ManpowerModel socketObject(String user){
        if(user!=null){
            return new GsonBuilder().create().fromJson(user, ManpowerModel.class);
        }
        return null;
    }

    public String socketString(){
        return new GsonBuilder().create().toJson(this, ManpowerModel.class);
    }
	@Override
	public String toString() {
		return "ManpowerModel [EMPLOYEE_ID=" + EMPLOYEE_ID + ", TITLE=" + TITLE + ", NAME=" + NAME + ", DESIGNATION="
				+ DESIGNATION + ", DESIGNATION_CODE=" + DESIGNATION_CODE + ", BRANCH_CODE=" + BRANCH_CODE
				+ ", BRANCH_NAME=" + BRANCH_NAME + ", STAFF_TYPE=" + STAFF_TYPE + ", DOJ=" + DOJ + ", DOB=" + DOB
				+ ", GENDER=" + GENDER + ", ZONE_CODE=" + ZONE_CODE + ", STATE_CODE=" + STATE_CODE + ", CITY_CODE="
				+ CITY_CODE + ", JOB_CODE=" + JOB_CODE + ", JOB_FUNCTION_CODE=" + JOB_FUNCTION_CODE + ", JOB_FUNCTION="
				+ JOB_FUNCTION + ", DEPARTMENT_CODE=" + DEPARTMENT_CODE + ", COST_CENTER=" + COST_CENTER
				+ ", DEPARTMENT=" + DEPARTMENT + ", SUPERVISIOR_ID=" + SUPERVISIOR_ID + ", IS_ACTIVE=" + IS_ACTIVE
				+ ", DATE_CREATED=" + DATE_CREATED + "]";
	}
    
	

}
