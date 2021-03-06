package com.gms.model.admin;

public class ReopenAttachment {
	
	private int ATTACHID;
	private int GRVDETID;
	private int GRVID;
	private String ATTACH_REMARKS;
	private String FILEPATH;
	private String FILENAME;
	private String IS_ACTIVE;
	private String DATE;
	private String COMPLIANT_EMPLOYEE_ID;
	private String NAME;
	private String fileNameExtns;
	private int fileLength;
	
	public int getATTACHID() {
		return ATTACHID;
	}
	public void setATTACHID(int aTTACHID) {
		ATTACHID = aTTACHID;
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
	public String getATTACH_REMARKS() {
		return ATTACH_REMARKS;
	}
	public void setATTACH_REMARKS(String aTTACH_REMARKS) {
		ATTACH_REMARKS = aTTACH_REMARKS;
	}
	public String getFILEPATH() {
		return FILEPATH;
	}
	public void setFILEPATH(String fILEPATH) {
		FILEPATH = fILEPATH;
	}
	public String getFILENAME() {
		return FILENAME;
	}
	public void setFILENAME(String fILENAME) {
		FILENAME = fILENAME;
	}
	public String getIS_ACTIVE() {
		return IS_ACTIVE;
	}
	public void setIS_ACTIVE(String iS_ACTIVE) {
		IS_ACTIVE = iS_ACTIVE;
	}
	public String getDATE() {
		return DATE;
	}
	public void setDATE(String dATE) {
		DATE = dATE;
	}
	public String getCOMPLIANT_EMPLOYEE_ID() {
		return COMPLIANT_EMPLOYEE_ID;
	}
	public void setCOMPLIANT_EMPLOYEE_ID(String cOMPLIANT_EMPLOYEE_ID) {
		COMPLIANT_EMPLOYEE_ID = cOMPLIANT_EMPLOYEE_ID;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public int getFileLength() {
		return fileLength;
	}
	public void setFileLength(int fileLength) {
		this.fileLength = fileLength;
	}
	public String getFileNameExtns() {
		return fileNameExtns;
	}
	public void setFileNameExtns(String fileNameExtns) {
		this.fileNameExtns = fileNameExtns;
	}
	@Override
	public String toString() {
		return "ReopenAttachment [ATTACHID=" + ATTACHID + ", GRVDETID=" + GRVDETID + ", GRVID=" + GRVID
				+ ", ATTACH_REMARKS=" + ATTACH_REMARKS + ", FILEPATH=" + FILEPATH + ", FILENAME=" + FILENAME
				+ ", IS_ACTIVE=" + IS_ACTIVE + ", DATE=" + DATE + ", COMPLIANT_EMPLOYEE_ID=" + COMPLIANT_EMPLOYEE_ID
				+ ", NAME=" + NAME + ", fileNameExtns=" + fileNameExtns + ", fileLength=" + fileLength + "]";
	}
	
}
