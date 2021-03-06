package com.gms.model.grievance;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class HdGrievanceModel {
	int GRVID;
	String GRVNUMBER;
	String GRVDATE;
	int COMPLIANT_EMPLOYEE_ID;
	String COMPLIANT_EMPLOYEE_TYPE;
	String COMPLIANT_EX_EMPLOYEE_ID;
	String COMPLIANT_EMPLOYEE_NAME;
	String GRIEVANCE_TYPE;
	int ACCEPT_CASES_COUNT;
	int REJECT_CASES_COUNT;
	String IS_ACTIVE;
	String DATE_CREATED;
	String GROUP_COMPLAINT;
	Timestamp DATE_UPDATED;
	Timestamp DATE_DELETED;
	int CREATEDBY;
	int UPDATEDBY;
	int DELETEDBY;
	public HdGrievanceModel()
	{
		super();
	}
	public HdGrievanceModel(int GRVID, Date GRVDATE, String GRVNUMBER, int COMPLIANT_EMPLOYEE_ID, String GRIEVANCE_TYPE,
			String EMPLOYEE_TYPE, int ACCEPT_CASES_COUNT,int REJECT_CASES_COUNT, String IS_ACTIVE, String DATE_CREATED, String NAME) {
		this.GRVID = GRVID;
		this.GRVDATE = GRVDATE.toString();
		this.GRVNUMBER = GRVNUMBER;
		this.COMPLIANT_EMPLOYEE_ID = COMPLIANT_EMPLOYEE_ID;
		this.COMPLIANT_EMPLOYEE_TYPE = EMPLOYEE_TYPE;
		this.ACCEPT_CASES_COUNT = ACCEPT_CASES_COUNT;
		this.REJECT_CASES_COUNT = REJECT_CASES_COUNT;
		this.IS_ACTIVE = IS_ACTIVE;
		this.DATE_CREATED = DATE_CREATED;
		this.COMPLIANT_EMPLOYEE_NAME=NAME;
		this.GRIEVANCE_TYPE=GRIEVANCE_TYPE;
	
	}

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
//	public java.util.Date getGRVDATE() {
//		return GRVDATE;
//	}
//	public void setGRVDATE(java.util.Date gRVDATE) {
//		GRVDATE = gRVDATE;
//	}
	public int getCOMPLIANT_EMPLOYEE_ID() {
		return COMPLIANT_EMPLOYEE_ID;
	}
	public void setCOMPLIANT_EMPLOYEE_ID(int cOMPLIANT_EMPLOYEE_ID) {
		COMPLIANT_EMPLOYEE_ID = cOMPLIANT_EMPLOYEE_ID;
	}
	public String getCOMPLIANT_EX_EMPLOYEE_ID() {
		return COMPLIANT_EX_EMPLOYEE_ID;
	}
	public void setCOMPLIANT_EX_EMPLOYEE_ID(String cOMPLIANT_EX_EMPLOYEE_ID) {
		COMPLIANT_EX_EMPLOYEE_ID = cOMPLIANT_EX_EMPLOYEE_ID;
	}
	public int getACCEPT_CASES_COUNT() {
		return ACCEPT_CASES_COUNT;
	}
	public void setACCEPT_CASES_COUNT(int aCCEPT_CASES_COUNT) {
		ACCEPT_CASES_COUNT = aCCEPT_CASES_COUNT;
	}
	public int getREJECT_CASES_COUNT() {
		return REJECT_CASES_COUNT;
	}
	public void setREJECT_CASES_COUNT(int rEJECT_CASES_COUNT) {
		REJECT_CASES_COUNT = rEJECT_CASES_COUNT;
	}
	public String getCOMPLIANT_EMPLOYEE_TYPE() {
		return COMPLIANT_EMPLOYEE_TYPE;
	}
	public void setCOMPLIANT_EMPLOYEE_TYPE(String cOMPLIANT_EMPLOYEE_TYPE) {
		COMPLIANT_EMPLOYEE_TYPE = cOMPLIANT_EMPLOYEE_TYPE;
	}
	public String getGROUP_COMPLAINT() {
		return GROUP_COMPLAINT;
	}
	public void setGROUP_COMPLAINT(String gROUP_COMPLAINT) {
		GROUP_COMPLAINT = gROUP_COMPLAINT;
	}
	
	public String getCOMPLIANT_EMPLOYEE_NAME() {
		return COMPLIANT_EMPLOYEE_NAME;
	}
	public void setCOMPLIANT_EMPLOYEE_NAME(String cOMPLIANT_EMPLOYEE_NAME) {
		COMPLIANT_EMPLOYEE_NAME = cOMPLIANT_EMPLOYEE_NAME;
	}
	
	public String getGRIEVANCE_TYPE() {
		return GRIEVANCE_TYPE;
	}
	public void setGRIEVANCE_TYPE(String gRIEVANCE_TYPE) {
		GRIEVANCE_TYPE = gRIEVANCE_TYPE;
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
	public static String toDate(Date date){
		Date utilDate = new Date(date.getTime());
		DateFormat df = new SimpleDateFormat("dd/MM/YYYY");
		return df.format(utilDate);
	}

	@Override
	public String toString() {
		return "HdGrievanceModel [GRVID=" + GRVID + ", GRVNUMBER=" + GRVNUMBER + ", GRVDATE=" + GRVDATE
				+ ", COMPLIANT_EMPLOYEE_ID=" + COMPLIANT_EMPLOYEE_ID + ", COMPLIANT_EMPLOYEE_TYPE="
				+ COMPLIANT_EMPLOYEE_TYPE + ", COMPLIANT_EX_EMPLOYEE_ID=" + COMPLIANT_EX_EMPLOYEE_ID
				+ ", COMPLIANT_EMPLOYEE_NAME=" + COMPLIANT_EMPLOYEE_NAME + ", GRIEVANCE_TYPE=" + GRIEVANCE_TYPE
				+ ", ACCEPT_CASES_COUNT=" + ACCEPT_CASES_COUNT + ", REJECT_CASES_COUNT=" + REJECT_CASES_COUNT
				+ ", IS_ACTIVE=" + IS_ACTIVE + ", DATE_CREATED=" + DATE_CREATED + ", GROUP_COMPLAINT=" + GROUP_COMPLAINT
				+ ", DATE_UPDATED=" + DATE_UPDATED + ", DATE_DELETED=" + DATE_DELETED + ", CREATEDBY=" + CREATEDBY
				+ ", UPDATEDBY=" + UPDATEDBY + ", DELETEDBY=" + DELETEDBY + "]";
	}

}
