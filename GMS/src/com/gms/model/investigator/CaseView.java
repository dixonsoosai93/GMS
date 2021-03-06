package com.gms.model.investigator;



  public class CaseView {
	int GRVID;
	int COMPLIANT_EMPLOYEE_ID;
	String NAME;
	String COMPLAINT_DESC;
	int GRVDETID;
	int RESPONDENT_EMPLOYEE_ID;
	String RESPONDENT_EMPLOYEE_NAME ;
	int CASEID;
	String CASENUMBER;
	String MAIN_CATEGORY_CODE;
	String SUB_CATEGORY_CODE;
	int INVESTIGATOR_EMPLOYEE_ID;
	String HIERCODE;
	String HIERORDER;
	String TAT_START_DATE;
	String TAT_END_DATE;
	String IS_ACTIVE;
	String INVESTIGATOR_TYPE;
	String SUB_CATEGORY_NAME;
	String MAIN_CATEGORY_NAME;
	//VAREMP
	int CASEEMPID;
	int EMPLOYEE_ID;
	String EMPLOYEE_NAME;
	String IS_LEAD;
	String DESIGNATION;
	String DEPARTMENT_CODE;
	String DEPARTMENT;
	
	public CaseView() {
		
	}
	
	public CaseView(int eMPLOYEE_ID, String eMPLOYEE_NAME) {
		super();
		EMPLOYEE_ID = eMPLOYEE_ID;
		EMPLOYEE_NAME = eMPLOYEE_NAME;
	}

	public CaseView(int gRVID, int cOMPLIANT_EMPLOYEE_ID, String nAME, String cOMPLAINT_DESC, int gRVDETID,
			int rESPONDENT_EMPLOYEE_ID, String rESPONDENT_EMPLOYEE_NAME, int cASEID, String cASENUMBER,
			String mAIN_CATEGORY_CODE, String sUB_CATEGORY_CODE, int iNVESTIGATOR_EMPLOYEE_ID, String hIERCODE,
			String hIERORDER, String tAT_START_DATE, String tAT_END_DATE, String iS_ACTIVE ,String mAIN_CATEGORY_NAME,String sUB_CATEGORY_NAME,String iNVESTIGATOR_TYPE) {
		super();
		GRVID = gRVID;
		COMPLIANT_EMPLOYEE_ID = cOMPLIANT_EMPLOYEE_ID;
		NAME = nAME;
		COMPLAINT_DESC = cOMPLAINT_DESC;
		GRVDETID = gRVDETID;
		RESPONDENT_EMPLOYEE_ID = rESPONDENT_EMPLOYEE_ID;
		RESPONDENT_EMPLOYEE_NAME = rESPONDENT_EMPLOYEE_NAME;
		CASEID = cASEID;
		CASENUMBER = cASENUMBER;
		MAIN_CATEGORY_CODE = mAIN_CATEGORY_CODE;
		SUB_CATEGORY_CODE = sUB_CATEGORY_CODE;
		INVESTIGATOR_EMPLOYEE_ID = iNVESTIGATOR_EMPLOYEE_ID;
		HIERCODE = hIERCODE;
		HIERORDER = hIERORDER;
		TAT_START_DATE = tAT_START_DATE;
		TAT_END_DATE = tAT_END_DATE;
		IS_ACTIVE = iS_ACTIVE;
		MAIN_CATEGORY_NAME=mAIN_CATEGORY_NAME;
		SUB_CATEGORY_NAME=sUB_CATEGORY_NAME;
		INVESTIGATOR_TYPE=iNVESTIGATOR_TYPE;
	}
	
	public String getEMPLOYEE_NAME() {
		return EMPLOYEE_NAME;
	}

	public void setEMPLOYEE_NAME(String eMPLOYEE_NAME) {
		EMPLOYEE_NAME = eMPLOYEE_NAME;
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
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getCOMPLAINT_DESC() {
		return COMPLAINT_DESC;
	}
	public void setCOMPLAINT_DESC(String cOMPLAINT_DESC) {
		COMPLAINT_DESC = cOMPLAINT_DESC;
	}
	public int getGRVDETID() {
		return GRVDETID;
	}
	public void setGRVDETID(int gRVDETID) {
		GRVDETID = gRVDETID;
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
	public int getINVESTIGATOR_EMPLOYEE_ID() {
		return INVESTIGATOR_EMPLOYEE_ID;
	}
	public void setINVESTIGATOR_EMPLOYEE_ID(int iNVESTIGATOR_EMPLOYEE_ID) {
		INVESTIGATOR_EMPLOYEE_ID = iNVESTIGATOR_EMPLOYEE_ID;
	}
	public String getHIERCODE() {
		return HIERCODE;
	}
	public void setHIERCODE(String hIERCODE) {
		HIERCODE = hIERCODE;
	}
	public String getHIERORDER() {
		return HIERORDER;
	}
	public void setHIERORDER(String hIERORDER) {
		HIERORDER = hIERORDER;
	}
	public String getTAT_START_DATE() {
		return TAT_START_DATE;
	}
	public void setTAT_START_DATE(String tAT_START_DATE) {
		TAT_START_DATE = tAT_START_DATE;
	}
	public String getTAT_END_DATE() {
		return TAT_END_DATE;
	}
	public void setTAT_END_DATE(String tAT_END_DATE) {
		TAT_END_DATE = tAT_END_DATE;
	}
	public String getIS_ACTIVE() {
		return IS_ACTIVE;
	}
	public void setIS_ACTIVE(String iS_ACTIVE) {
		IS_ACTIVE = iS_ACTIVE;
	}
	public int getCASEEMPID() {
		return CASEEMPID;
	}
	public void setCASEEMPID(int cASEEMPID) {
		CASEEMPID = cASEEMPID;
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
	public String getDESIGNATION() {
		return DESIGNATION;
	}
	public void setDESIGNATION(String dESIGNATION) {
		DESIGNATION = dESIGNATION;
	}
	public String getDEPARTMENT_CODE() {
		return DEPARTMENT_CODE;
	}
	public void setDEPARTMENT_CODE(String dEPARTMENT_CODE) {
		DEPARTMENT_CODE = dEPARTMENT_CODE;
	}
	public String getDEPARTMENT() {
		return DEPARTMENT;
	}
	public void setDEPARTMENT(String dEPARTMENT) {
		DEPARTMENT = dEPARTMENT;
	}
	
	public String getINVESTIGATOR_TYPE() {
		return INVESTIGATOR_TYPE;
	}

	public void setINVESTIGATOR_TYPE(String iNVESTIGATOR_TYPE) {
		INVESTIGATOR_TYPE = iNVESTIGATOR_TYPE;
	}

	public String getSUB_CATEGORY_NAME() {
		return SUB_CATEGORY_NAME;
	}

	public void setSUB_CATEGORY_NAME(String sUB_CATEGORY_NAME) {
		SUB_CATEGORY_NAME = sUB_CATEGORY_NAME;
	}

	public String getMAIN_CATEGORY_NAME() {
		return MAIN_CATEGORY_NAME;
	}

	public void setMAIN_CATEGORY_NAME(String mAIN_CATEGORY_NAME) {
		MAIN_CATEGORY_NAME = mAIN_CATEGORY_NAME;
	}

	@Override
	public String toString() {
		return "CaseView [GRVID=" + GRVID + ", COMPLIANT_EMPLOYEE_ID=" + COMPLIANT_EMPLOYEE_ID + ", NAME=" + NAME
				+ ", COMPLAINT_DESC=" + COMPLAINT_DESC + ", GRVDETID=" + GRVDETID + ", RESPONDENT_EMPLOYEE_ID="
				+ RESPONDENT_EMPLOYEE_ID + ", RESPONDENT_EMPLOYEE_NAME=" + RESPONDENT_EMPLOYEE_NAME + ", CASEID="
				+ CASEID + ", CASENUMBER=" + CASENUMBER + ", MAIN_CATEGORY_CODE=" + MAIN_CATEGORY_CODE
				+ ", SUB_CATEGORY_CODE=" + SUB_CATEGORY_CODE + ", INVESTIGATOR_EMPLOYEE_ID=" + INVESTIGATOR_EMPLOYEE_ID
				+ ", HIERCODE=" + HIERCODE + ", HIERORDER=" + HIERORDER + ", TAT_START_DATE=" + TAT_START_DATE
				+ ", TAT_END_DATE=" + TAT_END_DATE + ", IS_ACTIVE=" + IS_ACTIVE + ", CASEEMPID=" + CASEEMPID
				+ ", EMPLOYEE_ID=" + EMPLOYEE_ID + ", IS_LEAD=" + IS_LEAD + ", DESIGNATION=" + DESIGNATION
				+ ", DEPARTMENT_CODE=" + DEPARTMENT_CODE + ", DEPARTMENT=" + DEPARTMENT + "]";
	}
	

}