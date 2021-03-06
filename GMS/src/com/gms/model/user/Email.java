package com.gms.model.user;

public class Email {
	private int	EMAIL_LOG_SEQU;
	private int EMAIL_TEMPL_SEQU;
	private int SCHEDULAR_SEQU;
	private String MAIL_SENT_TO;
	private String MAIL_CC_TO;
	private String MAIL_BCC_TO;
	private String MAIL_SUBJECT;
	private String MAIL_CONTENT;
	
	public Email(int EMAIL_LOG_SEQU, int EMAIL_TEMPL_SEQU, int SCHEDULAR_SEQU, String MAIL_SENT_TO, String MAIL_CC_TO, String MAIL_BCC_TO, String MAIL_SUBJECT, String MAIL_CONTENT) {
		this.EMAIL_LOG_SEQU = EMAIL_LOG_SEQU;
		this.EMAIL_TEMPL_SEQU = EMAIL_TEMPL_SEQU;
		this.SCHEDULAR_SEQU = SCHEDULAR_SEQU;
		this.MAIL_SENT_TO = MAIL_SENT_TO;
		this.MAIL_CC_TO = MAIL_CC_TO;
		this.MAIL_BCC_TO = MAIL_BCC_TO;
		this.MAIL_SUBJECT = MAIL_SUBJECT;
		this.MAIL_CONTENT = MAIL_CONTENT;
	}
	
	public Email() {
	}
	
	public int getEMAIL_LOG_SEQU() {
		return this.EMAIL_LOG_SEQU;
	}
	
	public void setEMAIL_LOG_SEQU(int eMAIL_LOG_SEQU) {
		this.EMAIL_LOG_SEQU = eMAIL_LOG_SEQU;
	}
	
	public int getEMAIL_TEMPL_SEQU() {
		return this.EMAIL_TEMPL_SEQU;
	}
	
	public void setEMAIL_TEMPL_SEQU(int eMAIL_TEMPL_SEQU) {
		this.EMAIL_TEMPL_SEQU = eMAIL_TEMPL_SEQU;
	}
	
	public int getSCHEDULAR_SEQU() {
		return this.SCHEDULAR_SEQU;
	}
	
	public void setSCHEDULAR_SEQU(int sCHEDULAR_SEQU) {
		this.SCHEDULAR_SEQU = sCHEDULAR_SEQU;
	}
	
	public String getMAIL_SENT_TO() {
		return this.MAIL_SENT_TO;
	}
	
	public void setMAIL_SENT_TO(String mAIL_SENT_TO) {
		this.MAIL_SENT_TO = mAIL_SENT_TO;
	}

	public String getMAIL_SUBJECT() {
		return this.MAIL_SUBJECT;
	}

	public void setMAIL_SUBJECT(String mAIL_SUBJECT) {
		this.MAIL_SUBJECT = mAIL_SUBJECT;
	}

	public String getMAIL_CC_TO() {
		return this.MAIL_CC_TO;
	}

	public void setMAIL_CC_TO(String mAIL_CC_TO) {
		this.MAIL_CC_TO = mAIL_CC_TO;
	}

	public String getMAIL_BCC_TO() {
		return this.MAIL_BCC_TO;
	}

	public void setMAIL_BCC_TO(String mAIL_BCC_TO) {
		this.MAIL_BCC_TO = mAIL_BCC_TO;
	}

	public String getMAIL_CONTENT() {
		return this.MAIL_CONTENT;
	}

	public void setMAIL_CONTENT(String mAIL_CONTENT) {
		this.MAIL_CONTENT = mAIL_CONTENT;
	}
	
}

