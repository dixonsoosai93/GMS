package com.gms.model.admin;

public class GrievanceDesc {
	
	int GRVDETID;
	int CASEID;
	String NAME;
	String CASENUMBER;
	String MAIN_CATEGORY_CODE;
	String MAIN_CATEGORY_NAME;
	String SUB_CATEGORY_CODE;
	String SUB_CATEGORY_NAME;
	String COMPLAINT_DESC;
	int RESPONDENT_EMPLOYEE_ID;
	String RESPONDENT_EMPLOYEE_NAME;
	int GRVID;
    int COMPLIANT_EMPLOYEE_ID;
    String GROUP_COMPLIANT;
    int STATUSID;
    String STATUSNAME;
    String ZONE_CODE;
    String REGION_CODE;

	public String getSTATUSNAME() {
		return STATUSNAME;
	}
	public void setSTATUSNAME(String sTATUSNAME) {
		STATUSNAME = sTATUSNAME;
	}
	public int getSTATUSID() {
		return STATUSID;
	}
	public void setSTATUSID(int sTATUSID) {
		STATUSID = sTATUSID;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getMAIN_CATEGORY_NAME() {
		return MAIN_CATEGORY_NAME;
	}
	public void setMAIN_CATEGORY_NAME(String mAIN_CATEGORY_NAME) {
		MAIN_CATEGORY_NAME = mAIN_CATEGORY_NAME;
	}
	public String getSUB_CATEGORY_NAME() {
		return SUB_CATEGORY_NAME;
	}
	public void setSUB_CATEGORY_NAME(String sUB_CATEGORY_NAME) {
		SUB_CATEGORY_NAME = sUB_CATEGORY_NAME;
	}
	public int getGRVDETID() {
		return GRVDETID;
	}
	public void setGRVDETID(int gRVDETID) {
		GRVDETID = gRVDETID;
	}
	public int getCASEID() {
		return CASEID;
	}
	public void setCASEID(int cASEID) {
		CASEID = cASEID;
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
	public int getGRVID() {
		return GRVID;
	}
	public void setGRVID(int gRVID) {
		GRVID = gRVID;
	}
	public int getCOMPLIANT_EMPLOYEE_ID() {
		return COMPLIANT_EMPLOYEE_ID;
	}
	public void setCOMPLIANT_EMPLOYEE_ID(int cOMPLIANT_EMPLOYEE_ID) {
		COMPLIANT_EMPLOYEE_ID = cOMPLIANT_EMPLOYEE_ID;
	}
	public String getGROUP_COMPLIANT() {
		return GROUP_COMPLIANT;
	}
	public void setGROUP_COMPLIANT(String gROUP_COMPLIANT) {
		GROUP_COMPLIANT = gROUP_COMPLIANT;
	}
	
	public String getZONE_CODE() {
		return ZONE_CODE;
	}
	public void setZONE_CODE(String zONE_CODE) {
		ZONE_CODE = zONE_CODE;
	}
	public String getREGION_CODE() {
		return REGION_CODE;
	}
	public void setREGION_CODE(String rEGION_CODE) {
		REGION_CODE = rEGION_CODE;
	}
	@Override
	public String toString() {
		return "GrievanceDesc [GRVDETID=" + GRVDETID + ", CASEID=" + CASEID + ", NAME=" + NAME + ", CASENUMBER="
				+ CASENUMBER + ", MAIN_CATEGORY_CODE=" + MAIN_CATEGORY_CODE + ", MAIN_CATEGORY_NAME="
				+ MAIN_CATEGORY_NAME + ", SUB_CATEGORY_CODE=" + SUB_CATEGORY_CODE + ", SUB_CATEGORY_NAME="
				+ SUB_CATEGORY_NAME + ", COMPLAINT_DESC=" + COMPLAINT_DESC + ", RESPONDENT_EMPLOYEE_ID="
				+ RESPONDENT_EMPLOYEE_ID + ", RESPONDENT_EMPLOYEE_NAME=" + RESPONDENT_EMPLOYEE_NAME + ", GRVID=" + GRVID
				+ ", COMPLIANT_EMPLOYEE_ID=" + COMPLIANT_EMPLOYEE_ID + ", GROUP_COMPLIANT=" + GROUP_COMPLIANT
				+ ", STATUSID=" + STATUSID + ", STATUSNAME=" + STATUSNAME + ", ZONE_CODE=" + ZONE_CODE
				+ ", REGION_CODE=" + REGION_CODE + "]";
	}
	
    
}
