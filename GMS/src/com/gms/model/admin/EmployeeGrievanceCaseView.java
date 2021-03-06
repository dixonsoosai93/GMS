package com.gms.model.admin;

import java.sql.Date;
import com.gms.commons.Common;
import com.monitorjbl.xlsx.exceptions.ParseException;

public class EmployeeGrievanceCaseView {
	
	String EMP_TYPE;
	String STATUSID;
	String BRANCH_CODE;
	int REGION_ID;
	String ZONE_CODE;
	int INVESTIGATOR_ID;
	int INVESTIGATOR_EMPLOYEE_ID;
	String INVESTIGATOR_EMPLOYEE_NAME;
	String HIERCODE;
	String DEPARTMENT;
	String REGION_NAME;
	String ZONE_NAME;
	String IS_ACTIVE;
	int GRVID;
	String GRVDATE;
	String GRVNUMBER;
	int COMPLIANT_EMPLOYEE_ID;
	String NAME;
	String EMPLOYEE_TYPE;
	String GROUP_COMPLIANT;
	String EmployeeID;
	java.util.Date GrvDate;
	
	

	public EmployeeGrievanceCaseView(int iNVESTIGATOR_ID, int iNVESTIGATOR_EMPLOYEE_ID,
			String iNVESTIGATOR_EMPLOYEE_NAME, String hIERCODE, String dEPARTMENT, String rEGION_NAME, String zONE_NAME,
			String iS_ACTIVE) {
		super();
		INVESTIGATOR_ID = iNVESTIGATOR_ID;
		INVESTIGATOR_EMPLOYEE_ID = iNVESTIGATOR_EMPLOYEE_ID;
		INVESTIGATOR_EMPLOYEE_NAME = iNVESTIGATOR_EMPLOYEE_NAME;
		HIERCODE = hIERCODE;
		DEPARTMENT = dEPARTMENT;
		REGION_NAME = rEGION_NAME;
		ZONE_NAME = zONE_NAME;
		IS_ACTIVE = iS_ACTIVE;
	}
	
	
	public EmployeeGrievanceCaseView( int gRVID, Date gRVDATE, String gRVNUMBER,
			int cOMPLIANT_EMPLOYEE_ID, String nAME, String eMPLOYEE_TYPE, String gROUP_COMPLIANT,String iS_ACTIVE) throws ParseException, java.text.ParseException {
		super();
		
		GRVID = gRVID;
		GRVDATE = Common.StringToDate(gRVDATE.toString());
		GRVNUMBER = gRVNUMBER;
		COMPLIANT_EMPLOYEE_ID = cOMPLIANT_EMPLOYEE_ID;
		NAME = nAME;
		EMPLOYEE_TYPE = eMPLOYEE_TYPE;
		GROUP_COMPLIANT = gROUP_COMPLIANT;
		IS_ACTIVE = iS_ACTIVE;
	}

	public int getGRVID() {
		return GRVID;
	}

	public void setGRVID(int gRVID) {
		GRVID = gRVID;
	}

	public String getGRVDATE() {
		return GRVDATE;
	}

	public void setGRVDATE(String gRVDATE) {
		GRVDATE = gRVDATE;
	}

	public String getGRVNUMBER() {
		return GRVNUMBER;
	}

	public void setGRVNUMBER(String gRVNUMBER) {
		GRVNUMBER = gRVNUMBER;
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

	public String getEMPLOYEE_TYPE() {
		return EMPLOYEE_TYPE;
	}

	public void setEMPLOYEE_TYPE(String eMPLOYEE_TYPE) {
		EMPLOYEE_TYPE = eMPLOYEE_TYPE;
	}

	public String getGROUP_COMPLIANT() {
		return GROUP_COMPLIANT;
	}

	public void setGROUP_COMPLIANT(String gROUP_COMPLIANT) {
		GROUP_COMPLIANT = gROUP_COMPLIANT;
	}

	public String getEMP_TYPE() {
		return EMP_TYPE;
	}
	public void setEMP_TYPE(String eMP_TYPE) {
		EMP_TYPE = eMP_TYPE;
	}
	public String getSTATUSID() {
		return STATUSID;
	}
	public void setSTATUSID(String sTATUSID) {
		STATUSID = sTATUSID;
	}
	public String getBRANCH_CODE() {
		return BRANCH_CODE;
	}
	public void setBRANCH_CODE(String bRANCH_CODE) {
		BRANCH_CODE = bRANCH_CODE;
	}
	public int getREGION_ID() {
		return REGION_ID;
	}
	public void setREGION_ID(int rEGION_ID) {
		REGION_ID = rEGION_ID;
	}
	public String getZONE_CODE() {
		return ZONE_CODE;
	}
	public void setZONE_CODE(String zONE_CODE) {
		ZONE_CODE = zONE_CODE;
	}
	public int getINVESTIGATOR_ID() {
		return INVESTIGATOR_ID;
	}
	public void setINVESTIGATOR_ID(int iNVESTIGATOR_ID) {
		INVESTIGATOR_ID = iNVESTIGATOR_ID;
	}
	public int getINVESTIGATOR_EMPLOYEE_ID() {
		return INVESTIGATOR_EMPLOYEE_ID;
	}
	public void setINVESTIGATOR_EMPLOYEE_ID(int iNVESTIGATOR_EMPLOYEE_ID) {
		INVESTIGATOR_EMPLOYEE_ID = iNVESTIGATOR_EMPLOYEE_ID;
	}
	public String getINVESTIGATOR_EMPLOYEE_NAME() {
		return INVESTIGATOR_EMPLOYEE_NAME;
	}
	public void setINVESTIGATOR_EMPLOYEE_NAME(String iNVESTIGATOR_EMPLOYEE_NAME) {
		INVESTIGATOR_EMPLOYEE_NAME = iNVESTIGATOR_EMPLOYEE_NAME;
	}
	public String getHIERCODE() {
		return HIERCODE;
	}
	public void setHIERCODE(String hIERCODE) {
		HIERCODE = hIERCODE;
	}
	public String getDEPARTMENT() {
		return DEPARTMENT;
	}
	public void setDEPARTMENT(String dEPARTMENT) {
		DEPARTMENT = dEPARTMENT;
	}
	public String getREGION_NAME() {
		return REGION_NAME;
	}
	public void setREGION_NAME(String rEGION_NAME) {
		REGION_NAME = rEGION_NAME;
	}
	public String getZONE_NAME() {
		return ZONE_NAME;
	}
	public void setZONE_NAME(String zONE_NAME) {
		ZONE_NAME = zONE_NAME;
	}
	public String getIS_ACTIVE() {
		return IS_ACTIVE;
	}
	public void setIS_ACTIVE(String iS_ACTIVE) {
		IS_ACTIVE = iS_ACTIVE;
	}
	public String getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(String employeeID) {
		EmployeeID = employeeID;
	}
	public EmployeeGrievanceCaseView() {
		
	}
	public java.util.Date getGrvDate() {
		return GrvDate;
	}
	public void setGrvDate(java.util.Date grvDate) {
		GrvDate = grvDate;
	}

	@Override
	public String toString() {
		return "EmployeeGrievanceCaseView [EMP_TYPE=" + EMP_TYPE + ", STATUSID=" + STATUSID + ", BRANCH_CODE="
				+ BRANCH_CODE + ", REGION_ID=" + REGION_ID + ", ZONE_CODE=" + ZONE_CODE + ", INVESTIGATOR_ID="
				+ INVESTIGATOR_ID + ", INVESTIGATOR_EMPLOYEE_ID=" + INVESTIGATOR_EMPLOYEE_ID
				+ ", INVESTIGATOR_EMPLOYEE_NAME=" + INVESTIGATOR_EMPLOYEE_NAME + ", HIERCODE=" + HIERCODE
				+ ", DEPARTMENT=" + DEPARTMENT + ", REGION_NAME=" + REGION_NAME + ", ZONE_NAME=" + ZONE_NAME
				+ ", IS_ACTIVE=" + IS_ACTIVE + ", GRVID=" + GRVID + ", GRVDATE=" + GRVDATE + ", GRVNUMBER=" + GRVNUMBER
				+ ", COMPLIANT_EMPLOYEE_ID=" + COMPLIANT_EMPLOYEE_ID + ", NAME=" + NAME + ", EMPLOYEE_TYPE="
				+ EMPLOYEE_TYPE + ", GROUP_COMPLIANT=" + GROUP_COMPLIANT + ", EmployeeID=" + EmployeeID + ", GrvDate="
				+ GrvDate + "]";
	}

}
