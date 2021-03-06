package com.gms.model.investigator;

import java.sql.Timestamp;
import java.util.Date;

public class DtVerdict {
	int VERDICTID;
	int GRVDETID;
	int CASEID;
	int COMPLIANT_EMPLOYEE_ID;
	String CASENUMBER;
	String VERDICT_REPORT_DATE;
	String VERDICT_REPORT_CONTENT;
	String IS_ACTIVE;
	String DATE_CREATED;
	String NAME;
	Timestamp DATE_UPDATED;
	Timestamp DATE_DELETED;
	int CREATEDBY;
	int UPDATEDBY;
	int DELETEDBY;
	
	public DtVerdict() {
		
	}
	
	public String getCASENUMBER() {
		return CASENUMBER;
	}

	public void setCASENUMBER(String cASENUMBER) {
		CASENUMBER = cASENUMBER;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public int getVERDICTID() {
		return VERDICTID;
	}
	public void setVERDICTID(int vERDICTID) {
		VERDICTID = vERDICTID;
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
	public int getCOMPLIANT_EMPLOYEE_ID() {
		return COMPLIANT_EMPLOYEE_ID;
	}
	public void setCOMPLIANT_EMPLOYEE_ID(int cOMPLIANT_EMPLOYEE_ID) {
		COMPLIANT_EMPLOYEE_ID = cOMPLIANT_EMPLOYEE_ID;
	}
	public String getVERDICT_REPORT_DATE() {
		return VERDICT_REPORT_DATE;
	}
	public void setVERDICT_REPORT_DATE(String vERDICT_REPORT_DATE) {
		VERDICT_REPORT_DATE = vERDICT_REPORT_DATE;
	}
	public String getVERDICT_REPORT_CONTENT() {
		return VERDICT_REPORT_CONTENT;
	}
	public void setVERDICT_REPORT_CONTENT(String vERDICT_REPORT_CONTENT) {
		VERDICT_REPORT_CONTENT = vERDICT_REPORT_CONTENT;
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
	@Override
	public String toString() {
		return "DtVerdict [VERDICTID=" + VERDICTID + ", GRVDETID=" + GRVDETID + ", CASEID=" + CASEID
				+ ", COMPLIANT_EMPLOYEE_ID=" + COMPLIANT_EMPLOYEE_ID + ", VERDICT_REPORT_DATE=" + VERDICT_REPORT_DATE
				+ ", VERDICT_REPORT_CONTENT=" + VERDICT_REPORT_CONTENT + ", IS_ACTIVE=" + IS_ACTIVE + ", DATE_CREATED="
				+ DATE_CREATED + ", DATE_UPDATED=" + DATE_UPDATED + ", DATE_DELETED=" + DATE_DELETED + ", CREATEDBY="
				+ CREATEDBY + ", UPDATEDBY=" + UPDATEDBY + ", DELETEDBY=" + DELETEDBY + "]";
	}
}
