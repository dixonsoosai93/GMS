package com.gms.model.masters;

import java.util.ArrayList;

public class GrievanceCategorySubCatgeoryAddUpdateModel {
	 ArrayList<GrievanceCategoryHierarchyModel> add;
	 ArrayList<GrievanceCategoryHierarchyModel> edit;
	 public ArrayList<GrievanceCategoryHierarchyModel> getAdd() {
		return add;
	}
	public void setAdd(ArrayList<GrievanceCategoryHierarchyModel> add) {
		this.add = add;
	}
	public ArrayList<GrievanceCategoryHierarchyModel> getEdit() {
		return edit;
	}
	public void setEdit(ArrayList<GrievanceCategoryHierarchyModel> edit) {
		this.edit = edit;
	}


}