package com.gms.model.masters;

import java.util.ArrayList;
import com.gms.model.masters.ALBranch;
import com.gms.model.masters.ALDepartment;
import com.gms.model.masters.ALDesignation;
import com.gms.model.masters.ALJobFunction;

public class ComplaintEmpSelect {

	ArrayList<ALBranch> tBranch;
	ArrayList<ALJobFunction> tJobFUnction;
	ArrayList<ALDepartment> tDepartment;
	ArrayList<ALDesignation> tDesignation;
	
	
	public ComplaintEmpSelect() {}
	
	public ArrayList<ALBranch> gettBranch() {
		return tBranch;
	}

	public void settBranch(ArrayList<ALBranch> tBranch) {
		this.tBranch = tBranch;
	}

	public ArrayList<ALJobFunction> gettJobFUnction() {
		return tJobFUnction;
	}

	public void settJobFUnction(ArrayList<ALJobFunction> tJobFUnction) {
		this.tJobFUnction = tJobFUnction;
	}

	public ArrayList<ALDepartment> gettDepartment() {
		return tDepartment;
	}

	public void settDepartment(ArrayList<ALDepartment> tDepartment) {
		this.tDepartment = tDepartment;
	}

	public ArrayList<ALDesignation> gettDesignation() {
		return tDesignation;
	}

	public void settDesignation(ArrayList<ALDesignation> tDesignation) {
		this.tDesignation = tDesignation;
	}

	@Override
	public String toString() {
		return "ComplaintEmpSelect [tBranch=" + tBranch + ", tJobFUnction=" + tJobFUnction + ", tDepartment="
				+ tDepartment + ", tDesignation=" + tDesignation + "]";
	}

	
	
	
}
