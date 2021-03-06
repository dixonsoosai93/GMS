package com.gms.model.masters;

import java.sql.Timestamp;

public class OrganisationHierarchyMasterModel {
	int HIERID;
	String HIERCODE;
	String CLIENTCAPTION;
	String HIERNAME;
	String HIERDESIGNATIONID;
	String HIERDESIGNATIONNAME;
	int HIERORDER;
	int HIERCAP;
	String INVESTIGATOR_NEEDED;
	String IS_ACTIVE;
	String DATE_CREATED;
	Timestamp DATE_UPDATED;
	Timestamp DATE_DELETED;
	int CREATEDBY;
	int UPDATEDBY;
	int DELETEDBY;	
	
	public OrganisationHierarchyMasterModel() {
		super();
	}
	public OrganisationHierarchyMasterModel(int HIERID, String HIERCODE, String CLIENTCAPTION, String HIERNAME, String HIERDESIGNATIONID,
			int HIERORDER, int HIERCAP, String INVESTIGATOR_NEEDED, String IS_ACTIVE, String DATE_CREATED) {
		super();
		this.HIERID=HIERID;
		this.HIERCODE=HIERCODE;
		this.CLIENTCAPTION=CLIENTCAPTION;
		this.HIERNAME=HIERNAME;
		this.HIERDESIGNATIONID=HIERDESIGNATIONID;
		this.HIERORDER=HIERORDER;
		this.HIERCAP=HIERCAP;
		this.INVESTIGATOR_NEEDED=INVESTIGATOR_NEEDED;
		this.IS_ACTIVE=IS_ACTIVE;
		this.DATE_CREATED=DATE_CREATED;
		
	}
	public OrganisationHierarchyMasterModel(int HIERID, String HIERCODE, String CLIENTCAPTION, String HIERNAME, String HIERDESIGNATIONID,
			int HIERORDER, int HIERCAP, String INVESTIGATOR_NEEDED, String IS_ACTIVE, String DATE_CREATED,String HIERDESIGNATIONNAME) {
		super();
		this.HIERID=HIERID;
		this.HIERCODE=HIERCODE;
		this.CLIENTCAPTION=CLIENTCAPTION;
		this.HIERNAME=HIERNAME;
		this.HIERDESIGNATIONID=HIERDESIGNATIONID;
		this.HIERORDER=HIERORDER;
		this.HIERCAP=HIERCAP;
		this.INVESTIGATOR_NEEDED=INVESTIGATOR_NEEDED;
		this.IS_ACTIVE=IS_ACTIVE;
		this.DATE_CREATED=DATE_CREATED;
		this.HIERDESIGNATIONNAME=HIERDESIGNATIONNAME;
		
	}
	public int getHIERID() {
		return HIERID;
	}
	public void setHIERID(int hIERID) {
		HIERID = hIERID;
	}
	public String getHIERCODE() {
		return HIERCODE;
	}
	public void setHIERCODE(String hIERCODE) {
		HIERCODE = hIERCODE;
	}
	public String getCLIENTCAPTION() {
		return CLIENTCAPTION;
	}
	public void setCLIENTCAPTION(String cLIENTCAPTION) {
		CLIENTCAPTION = cLIENTCAPTION;
	}
	public String getHIERNAME() {
		return HIERNAME;
	}
	public void setHIERNAME(String hIERNAME) {
		HIERNAME = hIERNAME;
	}
	public String getHIERDESIGNATIONID() {
		return HIERDESIGNATIONID;
	}
	public void setHIERDESIGNATIONID(String hIERDESIGNATIONID) {
		HIERDESIGNATIONID = hIERDESIGNATIONID;
	}
	public String getHIERDESIGNATIONNAME() {
		return HIERDESIGNATIONNAME;
	}
	public void setHIERDESIGNATIONNAME(String hIERDESIGNATIONNAME) {
		HIERDESIGNATIONNAME = hIERDESIGNATIONNAME;
	}
	public int getHIERORDER() {
		return HIERORDER;
	}
	public void setHIERORDER(int hIERORDER) {
		HIERORDER = hIERORDER;
	}
	public int getHIERCAP() {
		return HIERCAP;
	}
	public void setHIERCAP(int hIERCAP) {
		HIERCAP = hIERCAP;
	}
	public String getINVESTIGATOR_NEEDED() {
		return INVESTIGATOR_NEEDED;
	}
	public void setINVESTIGATOR_NEEDED(String iNVESTIGATOR_NEEDED) {
		INVESTIGATOR_NEEDED = iNVESTIGATOR_NEEDED;
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
		return "OrganisationHierarchyMasterModel [HIERID=" + HIERID + ", HIERCODE=" + HIERCODE + ", CLIENTCAPTION=" + CLIENTCAPTION
				+ ", HIERNAME=" + HIERNAME + ", HIERDESIGNATIONID=" + HIERDESIGNATIONID + ", HIERORDER=" + HIERORDER
				+ ", HIERCAP=" + HIERCAP + ", INVESTIGATOR_NEEDED=" + INVESTIGATOR_NEEDED + ", IS_ACTIVE=" + IS_ACTIVE + ", DATE_CREATED=" + DATE_CREATED + ",DATE_UPDATED=" + DATE_UPDATED +",DATE_DELETED=" + DATE_DELETED +",CREATEDBY=" + CREATEDBY +",UPDATEDBY=" + UPDATEDBY +",DELETEDBY=" + DELETEDBY +"]";
	}

}
