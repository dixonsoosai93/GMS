package com.gms.model.investigator;


public class DailyDairyProof {
	int GRVID;
	String GRVNUMBER;
	String GRVDATE;
	int COMPLIANT_EMPLOYEE_ID;
	String NAME;
	String EMP_TYPE;
	int GRVDETID;
	int RESPONDENT_EMPLOYEE_ID;
	String RESPONDENT_EMPLOYEE_NAME;
	String COMPLAINT_DESC;
	String TAT_START_DATE;
	String TAT_END_DATE;
	int CASEID;
	String HIRECODE;
	String reportType;
	String FLAG;
	String isCompleted;
	String decisionReportFlag;
	
	public DailyDairyProof() {}

	public int getGRVID() {
		return GRVID;
	}

	public void setGRVID(int gRVID) {
		GRVID = gRVID;
	}

	public String getGRVNUMBER() {
		return GRVNUMBER;
	}

	public void setGRVNUMBER(String gRVNUMBER) {
		GRVNUMBER = gRVNUMBER;
	}

	public String getGRVDATE() {
		return GRVDATE;
	}

	public void setGRVDATE(String gRVDATE) {
		GRVDATE = gRVDATE;
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

	public String getEMP_TYPE() {
		return EMP_TYPE;
	}

	public void setEMP_TYPE(String eMP_TYPE) {
		EMP_TYPE = eMP_TYPE;
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

	public String getCOMPLAINT_DESC() {
		return COMPLAINT_DESC;
	}

	public void setCOMPLAINT_DESC(String cOMPLAINT_DESC) {
		COMPLAINT_DESC = cOMPLAINT_DESC;
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

	public int getCASEID() {
		return CASEID;
	}

	public void setCASEID(int cASEID) {
		CASEID = cASEID;
	}

	public String getHIRECODE() {
		return HIRECODE;
	}

	public void setHIRECODE(String hIRECODE) {
		HIRECODE = hIRECODE;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getFLAG() {
		return FLAG;
	}

	public void setFLAG(String fLAG) {
		FLAG = fLAG;
	}

	public String getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(String isCompleted) {
		this.isCompleted = isCompleted;
	}

	public String getDecisionReportFlag() {
		return decisionReportFlag;
	}

	public void setDecisionReportFlag(String decisionReportFlag) {
		this.decisionReportFlag = decisionReportFlag;
	}

	@Override
	public String toString() {
		return "DailyDairyProof [GRVID=" + GRVID + ", GRVNUMBER=" + GRVNUMBER + ", GRVDATE=" + GRVDATE
				+ ", COMPLIANT_EMPLOYEE_ID=" + COMPLIANT_EMPLOYEE_ID + ", NAME=" + NAME + ", EMP_TYPE=" + EMP_TYPE
				+ ", GRVDETID=" + GRVDETID + ", RESPONDENT_EMPLOYEE_ID=" + RESPONDENT_EMPLOYEE_ID
				+ ", RESPONDENT_EMPLOYEE_NAME=" + RESPONDENT_EMPLOYEE_NAME + ", COMPLAINT_DESC=" + COMPLAINT_DESC
				+ ", TAT_START_DATE=" + TAT_START_DATE + ", TAT_END_DATE=" + TAT_END_DATE + ", CASEID=" + CASEID
				+ ", HIRECODE=" + HIRECODE + ", reportType=" + reportType + ", FLAG=" + FLAG + ", isCompleted="
				+ isCompleted + ", decisionReportFlag=" + decisionReportFlag + "]";
	}
	
	
}
