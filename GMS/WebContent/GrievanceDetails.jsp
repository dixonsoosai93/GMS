<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
                                <form style="margin-top: 20px;">     
									<div class="row mb-4">
										<div class="col-md-6 ">
											<div class="form-group">
			                                    <label for=GRVDETID class="col-form-label">Grievance Reference Number</label>
			                                    <div class="d-flex">
			                                        <input class="form-control" type="text" id="GRVDETID" name="GRVDETID"  placeholder="Enter Grievance Reference Number" >
				                                    <span style="color: indianred; float: right;"> *</span>
				                                    <div class="flex-fill">
							  						      <button type="button" id="search" class="btn btn-inverse-secondary ml-3"><i class="fa fa-search"></i></button>
							  						</div>
			                                    </div>
			                                </div>
			                                <div class="form-group">
			                                    <label for="GRVID" class="col-form-label">Grievance HD ID</label>
			                                    <input class="form-control" type="text" id="GRVID" disabled>
			                                </div>
			                                <div class="form-group">
			                                    <label for="CASEID" class="col-form-label">Case ID	</label>
			                                    <input class="form-control" type="text" id="CASEID" disabled>
			                                </div>
			                                <div class="form-group">
			                                    <label  for="CASENO" class="col-form-label">TALIC Case No</label>
			                                    <input class="form-control" type="text" id="CASENO" disabled>
			                                </div>
			                                <div class="form-group">
			                                    <label for="MAIN_CATEGORY_CODE"  class="col-form-label">Main Category Code</label>
			                                    <input class="form-control" type="text"  id="MAIN_CATEGORY_CODE"disabled>
			                                </div>
			                                <div class="form-group">
			                                    <label for="MAIN_CATEGORY_NAME" class="col-form-label">Main Category Name</label>
			                                    <input class="form-control" type="text" id="MAIN_CATEGORY_NAME" disabled>
			                                </div>
			                                <div class="form-group">
			                                    <label for="SUB_CATEGORY_CODE" class="col-form-label">Sub Category Code</label>
			                                    <input class="form-control" type="text" id="SUB_CATEGORY_CODE" disabled>
			                                </div>
			                                <div class="form-group">
			                                    <label for="SUB_CATEGORY_NAME" class="col-form-label">Sub Category Name</label>
			                                    <input class="form-control" type="text" id="SUB_CATEGORY_NAME" disabled>
			                                </div>
										</div>
										<div class="col-md-6" > 
											<div class="form-group">
			                                	<label  for="COMPLIANT_EMPLOYEE_ID" class="col-form-label">Aggrieved Employees ID</label>
			                                	<input class="form-control" id="COMPLIANT_EMPLOYEE_ID" type="text" disabled>
			                                </div>
			                                <div class="form-group">
			                                	<label for="NAME" class="col-form-label">Aggrieved Employees Name</label>
			                                	<input class="form-control" id="NAME" type="text" disabled>
			                                </div>
			                                <div class="form-group">
			                                	<label for="GROUP_COMPLIANT" class="col-form-label">Aggrieved Employees Type	</label>
			                                	<input class="form-control" type="text" id="GROUP_COMPLIANT" disabled>
			                                </div>
			                                <div class="form-group">
			                                	<label  for="RESPONDENT_EMPLOYEE_ID" class="col-form-label">Respondent ID</label>
			                                	<input class="form-control" type="text" id="RESPONDENT_EMPLOYEE_ID" disabled>
			                                </div>
			                                <div class="form-group">
			                                	<label for="RESPONDENT_EMPLOYEE_NAME" class="col-form-label">Respondent Name</label>
			                                	<input class="form-control" type="text" id="RESPONDENT_EMPLOYEE_NAME" disabled>
			                                </div>
			                                <div id="divDroppedFields">
				                                <div class="form-group">
				                                	<label for="Remark" class="col-form-label">Remark</label>
				                                	<textarea class="form-control" id="Remark" name="Remark" class="required" cols="80" rows="10"></textarea>
				                                	<div id="Remark-error" class="invalid-feedback" style="display: none">Please Enter Remark</div>
				                                </div>
				                                <span style="color: indianred; float: right;"> *</span>
			                                </div>
                                       </div>
									</div>	
									<div class="form-group">
	                                     <label class="col-form-label" for="COMPLAINT_DESC">Grievance Description</label>
	                                     <textarea class="form-control" id="COMPLAINT_DESC" disabled></textarea>
                                    </div>
								</form>
								                                
                                