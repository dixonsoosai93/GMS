package com.gms.model.masters;

public class ALBranch {
		
	private String branchCode;
	private String branchName;
	
	public ALBranch() {}
	
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	@Override
	public String toString() {
		return "ALBranch [branchCode=" + branchCode + ", branchName=" + branchName + "]";
	}
	
	
}
