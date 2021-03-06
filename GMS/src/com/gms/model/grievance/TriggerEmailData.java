package com.gms.model.grievance;

public class TriggerEmailData {
	
	public String sendTo; 
	public String sendCC; 
	public String message;
	public String subject;
	
	public String getSendTo() {
		return sendTo;
	}
	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}
	public String getSendCC() {
		return sendCC;
	}
	public void setSendCC(String sendCC) {
		this.sendCC = sendCC;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Override
	public String toString() {
		return "TriggerEmailData [sendTo=" + sendTo + ", sendCC=" + sendCC + ", message=" + message + ", subject="
				+ subject + "]";
	} 
}
